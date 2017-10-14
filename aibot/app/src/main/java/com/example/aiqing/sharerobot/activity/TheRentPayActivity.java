package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.TheRentPayAdapter;
import com.example.aiqing.sharerobot.bean.RentPayBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 租金支付
 */
public class TheRentPayActivity extends AppCompatActivity implements View.OnClickListener {

    private MapView mMapViewRentPay;
    private AMapLocationClient mLocationClient;
    private AMap aMap;
    private AMapLocationClientOption mLocationClientOption;
    private RecyclerView mRecyclerviewRent;
    private LinearLayoutManager mLinearLayoutManager;
    private ImageView mIvRentpayReturn;
    private ImageView mIvMenuRight;
    private TextView mTvZhekou;
    private TextView mTvDikou;
    private TextView mTvShifu;
    private RelativeLayout mRlRentpayZhifubao;
    private RelativeLayout mRlRentpayWeixin;
    private ImageView mIvRentpayWeixin;
    private ImageView mIvRentpatZhifubao;
    private Button mBtnPaySure;
    private HttpTool mHttpTool;
    private String mSid;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_rent_pay);

        mMapViewRentPay = (MapView) findViewById(R.id.mapview_rent_pay);
        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mMapViewRentPay.onCreate(savedInstanceState);

        initAMap();
        initFindId();
        initData();
    }

    private void initData() {

//        Intent intent = getIntent();
//        Bundle bundle = intent.getExtras();
//        String productId = bundle.getString("productId");

        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerviewRent.setLayoutManager(mLinearLayoutManager);

        mIvRentpayReturn.setOnClickListener(this);
        mIvMenuRight.setOnClickListener(this);
        mRlRentpayZhifubao.setOnClickListener(this);
        mRlRentpayWeixin.setOnClickListener(this);
        mBtnPaySure.setOnClickListener(this);

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        //请求服务器接口
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/cust/payRent.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<RentPayBean> call = apiService.payZuJin(mSid, "1");
        call.enqueue(new Callback<RentPayBean>() {
            @Override
            public void onResponse(Response<RentPayBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                mTvDikou.setText("-￥" + response.body().getBalance());
                final List<RentPayBean.FeeSetListBean> feeSetList = response.body().getFeeSetList();
                TheRentPayAdapter theRentPayAdapter = new TheRentPayAdapter(TheRentPayActivity.this, feeSetList);
                mRecyclerviewRent.setAdapter(theRentPayAdapter);
                

                theRentPayAdapter.setOnItemClickListener(new TheRentPayAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String feeSetId = feeSetList.get(position).getId();

                        //Toast.makeText(TheRentPayActivity.this, "点击了"+position, Toast.LENGTH_SHORT).show();
                        TextView money = (TextView)view.findViewById(R.id.tv_rent_money);
                        Toast.makeText(TheRentPayActivity.this, money.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_rentpay_return:
                //返回
                finish();
                break;
            case R.id.iv_menu_right:
                //右上

                break;
            case R.id.rl_rentpay_zhifubao:
                //支付宝
                mIvRentpatZhifubao.setVisibility(View.VISIBLE);
                mIvRentpayWeixin.setVisibility(View.GONE);
                break;
            case R.id.rl_rentpay_weixin:
                //微信支付
                mIvRentpatZhifubao.setVisibility(View.GONE);
                mIvRentpayWeixin.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_pay_sure:
                //确认支付

                initWxHttp();
                break;
        }
    }


    //微信支付
    private void initWxHttp() {
        //获取distributorid
        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        String distributorid = spDis.getString("distributorid", "");

        final IWXAPI wxapi = WXAPIFactory.createWXAPI(this, "wx7458b61d79664e24", true);
        wxapi.registerApp("wx7458b61d79664e24");

//        final PayReq request = new PayReq();
//        request.appId = "wx201708071110190e742615b10493262692";
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
//        Retrofit builder = new Retrofit.Builder()
//                .client(mHttpTool.client())
//                .baseUrl("http://shared.aqcome.com/pay/depositBCAPPPay.shtml")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiService apiService = builder.create(ApiService.class);
//        Call<WeChatPayBean> call = apiService.wxPay(mSid, distributorid,"1", "1", "1", "0.02", "0.02", "1", "3");
//        call.enqueue(new Callback<WeChatPayBean>() {
//            @Override
//            public void onResponse(Response<WeChatPayBean> response,Retrofit retrofit) {
//                DialogUtil.closeDialog(mLoadingDialog);
//                String appid = response.body().getAppid();
//                String partnerid = response.body().getPartnerid();
//                String noncestr = response.body().getNoncestr();
//                String signtype = response.body().getSigntype();
//                String timestamp = response.body().getTimestamp();
//                String sign = response.body().getSign();
//                String paId = response.body().getPaId();
//                String prepayid = response.body().getPrepayid();
//
//                Log.e("微信支付", "onResponse: "+"狼1"+appid+"狼2"+partnerid+"狼3"+noncestr+"狼4"+signtype+"狼5"+timestamp+"狼6"+sign+"狼7"+paId );
//
//                PayReq payReq = new PayReq();
//                payReq.appId=appid;
//                payReq.partnerId=partnerid;
//                payReq.prepayId=prepayid;
//                payReq.packageValue="Sign=WXPay";
//                payReq.nonceStr=noncestr;
//                payReq.signType=signtype;
//                payReq.timeStamp=timestamp;
//                payReq.sign=sign;
//                wxapi.sendReq(payReq);
//
//                String paySuccess = response.body().getPaySuccess();
//                Log.e("支付成功", "onResponse: "+paySuccess );
//
//                Log.e("成功", "onResponse: " + "6666");
//
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                DialogUtil.closeDialog(mLoadingDialog);
//                Log.e("失败", "onFailure: " + "77777");
//            }
//        });


    }

    private void initFindId() {
        mRecyclerviewRent = (RecyclerView) findViewById(R.id.recyclerview_rent);
        mIvRentpayReturn = (ImageView) findViewById(R.id.iv_rentpay_return);
        mIvMenuRight = (ImageView) findViewById(R.id.iv_menu_right);
        mTvZhekou = (TextView) findViewById(R.id.tv_zhekou);
        mTvDikou = (TextView) findViewById(R.id.tv_dikou);
        mTvShifu = (TextView) findViewById(R.id.tv_shifu);
        mRlRentpayZhifubao = (RelativeLayout) findViewById(R.id.rl_rentpay_zhifubao);
        mRlRentpayWeixin = (RelativeLayout) findViewById(R.id.rl_rentpay_weixin);
        mIvRentpatZhifubao = (ImageView) findViewById(R.id.iv_rentpat_zhifubao);
        mIvRentpayWeixin = (ImageView) findViewById(R.id.iv_rentpay_weixin);
        mBtnPaySure = (Button) findViewById(R.id.btn_pay_sure);
    }

    private void initAMap() {
        if (aMap == null) {
            aMap = mMapViewRentPay.getMap();
        }
        setUpMap();
    }

    private void setUpMap() {
        mLocationClientOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        ///设置定位模式为AMapLocationMode.Battery_Saving，低功耗模式。
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);

        //获取一次定位结果：
        mLocationClientOption.setOnceLocation(true);

        //设置是否返回地址信息（默认返回地址信息）
        mLocationClientOption.setNeedAddress(true);

        //设置是否只定位一次,默认为false
        mLocationClientOption.setOnceLocation(true);

        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationClientOption.setWifiActiveScan(true);

        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationClientOption.setMockEnable(false);

        mLocationClientOption.setHttpTimeOut(20000);

        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationClientOption);
        //启动定位
        mLocationClient.startLocation();


    }

    private double lat;
    private double lon;
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                    amapLocation.getLatitude();//获取纬度
                    amapLocation.getLongitude();//获取经度
                    amapLocation.getAccuracy();//获取精度信息
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(amapLocation.getTime());
                    df.format(date);//定位时间
                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    amapLocation.getCountry();//国家信息
                    amapLocation.getProvince();//省信息
                    amapLocation.getCity();//城市信息
                    amapLocation.getDistrict();//城区信息
                    amapLocation.getStreet();//街道信息
                    amapLocation.getStreetNum();//街道门牌号信息
                    amapLocation.getCityCode();//城市编码
                    amapLocation.getAdCode();//地区编码
                    amapLocation.getAoiName();//获取当前定位点的AOI信息
                    lat = amapLocation.getLatitude();
                    lon = amapLocation.getLongitude();
                    Log.v("pcw", "lat : " + lat + " lon : " + lon);
                    Log.v("pcw", "Country : " + amapLocation.getCountry() + " province : " + amapLocation.getProvince() + " City : " + amapLocation.getCity() + " District : " + amapLocation.getDistrict());
                    //清空缓存位置
                    aMap.clear();
                    // 设置当前地图显示为当前位置
                    aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 19));
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(new LatLng(lat, lon));
                    markerOptions.title("当前位置");
                    markerOptions.visible(true);
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.shop));
                    markerOptions.icon(bitmapDescriptor);
                    aMap.addMarker(markerOptions);

                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapViewRentPay.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapViewRentPay.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapViewRentPay.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapViewRentPay.onSaveInstanceState(outState);
    }

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }


}

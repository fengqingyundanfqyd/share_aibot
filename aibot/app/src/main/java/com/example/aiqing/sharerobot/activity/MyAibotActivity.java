package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
import com.example.aiqing.sharerobot.adapter.MyAibotAdapter;
import com.example.aiqing.sharerobot.bean.MyAibotBean;
import com.example.aiqing.sharerobot.fragment.LowmenuFragment;
import com.example.aiqing.sharerobot.fragment.MenuItemOnClickListener;
import com.example.aiqing.sharerobot.fragment.MenuItems;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MyAibotActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVpMyAibot;
    private List<View> mViewMyaibotList;
    private LinearLayout mLinearlayoutVp;
    private List<ImageView> mImgdots;
    private Button mBtnPay;
    private View mView1;
    private View mView2;
    private View mView3;
    private LinearLayout mLlOvered;
    private LinearLayout mLlNormal;
    private LinearLayout mLlReturn;
    private MapView mMapviewReturn;
    private AMapLocationClient mLocationClient;
    private AMap aMap;
    private AMapLocationClientOption mLocationClientOption;
    private LinearLayout mLlVp;
    private ImageView mIvNodata;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        setContentView(R.layout.activity_my_aibot);

        initFindId();

        initDots();

        initHttp();

        initData();

        mMapviewReturn = (MapView) mView1.findViewById(R.id.mapview_return);
        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mMapviewReturn.onCreate(savedInstanceState);
    }

    private void initHttp() {
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/payRent/orderInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<MyAibotBean> call = apiService.myRobot(cookie, "1", "5");
        call.enqueue(new Callback<MyAibotBean>() {
            @Override
            public void onResponse(Response<MyAibotBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);

                if (response.body() == null) {
                    //没有小宝
                    mLlVp.setVisibility(View.GONE);
                    mLinearlayoutVp.setVisibility(View.GONE);
                    mIvNodata.setVisibility(View.VISIBLE);
                }else {
                    List<MyAibotBean.ObjBean.ResultBean> result = response.body().getObj().getResult();

//                    for (int i = 0; i < result.size(); i++) {
//                        mViewMyaibotList.add(i,);
//                    }
                    MyAibotAdapter myAibotAdapter = new MyAibotAdapter(MyAibotActivity.this, mViewMyaibotList);
                    mVpMyAibot.setAdapter(myAibotAdapter);
                   // Log.e("我的小宝", "onResponse: "+result.size() );
                }

            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(MyAibotActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //加载数据
    private void initData() {
        //适配器
//        MyAibotAdapter myAibotAdapter = new MyAibotAdapter(this, mViewMyaibotList);
//        mVpMyAibot.setAdapter(myAibotAdapter);

        Button btnChangeRobot = (Button) mView1.findViewById(R.id.btn_changerobot);
        btnChangeRobot.setOnClickListener(this);

        Button btnOvered = (Button) mView1.findViewById(R.id.btn_overed);
        btnOvered.setOnClickListener(this);
        //结束
        mLlOvered = (LinearLayout) mView1.findViewById(R.id.ll_overed);
        mLlNormal = (LinearLayout) mView1.findViewById(R.id.ll_normal);

        //归还
        Button btnOverReturn = (Button) mView1.findViewById(R.id.btn_overed_return);
        btnOverReturn.setOnClickListener(this);

        mLlReturn = (LinearLayout) mView1.findViewById(R.id.ll_returning);

        Button btnChange = (Button) mView1.findViewById(R.id.btn_change);
        Button btnFinish = (Button) mView1.findViewById(R.id.btn_finish);
        btnChange.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

    }

    private void initFindId() {
        LayoutInflater inflater = getLayoutInflater();
        mViewMyaibotList = new ArrayList<>();
        mView1 = inflater.inflate(R.layout.vp_myaibot1, null);
        mView2 = inflater.inflate(R.layout.vp_myaibot2, null);
        mView3 = inflater.inflate(R.layout.vp_myaibot3, null);


        mVpMyAibot = (ViewPager) findViewById(R.id.viewpager_myaibot);
        mLinearlayoutVp = (LinearLayout) findViewById(R.id.viewpager_linerlayout);
        ImageView ivLeftrobot = (ImageView) findViewById(R.id.iv_left_myaibot);
        mLlVp = (LinearLayout) findViewById(R.id.ll_vp);
        mIvNodata = (ImageView) findViewById(R.id.iv_nodata);
        ivLeftrobot.setOnClickListener(this);


        mViewMyaibotList.add(mView1);
        mViewMyaibotList.add(mView2);
        mViewMyaibotList.add(mView3);

        ImageView ivHistory = (ImageView) findViewById(R.id.iv_lease_history);
        ivHistory.setOnClickListener(this);

        RelativeLayout rlApplyZhuanzu = (RelativeLayout) findViewById(R.id.rl_apply_zhuanzu);
        rlApplyZhuanzu.setOnClickListener(this);
    }

    /**
     * 底部导航原点
     */
    private void initDots() {
        mImgdots = new ArrayList<>();
        for (int i = 0; i < mViewMyaibotList.size(); i++) {
            ImageView imageview = new ImageView(this);
            imageview.setLayoutParams(new ViewGroup.LayoutParams(35, 35));//设置ImageView的宽度和高度
            imageview.setPadding(5, 5, 5, 5);//设置圆点的Padding，与周围的距离
            imageview.setImageResource(R.mipmap.dot_b);
            mImgdots.add(imageview);
            mLinearlayoutVp.addView(imageview);
        }
        mImgdots.get(0).setImageResource(R.mipmap.dot_o);
        mVpMyAibot.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mViewMyaibotList.size(); i++) {
                    //将所有的圆点设置为为选中时候的图片
                    mImgdots.get(i).setImageResource(R.mipmap.dot_o);
                }
                //将被选中的图片中的圆点设置为被选中的时候的图片
                mImgdots.get(position).setImageResource(R.mipmap.dot_b);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //点击事件处理
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            //换小宝
            case R.id.btn_changerobot:
                intent.setClass(MyAibotActivity.this, ChangeRobotActivity.class);
                startActivity(intent);
                break;
            //结束
            case R.id.btn_overed:
                mLlNormal.setVisibility(View.GONE);
                mLlOvered.setVisibility(View.VISIBLE);
                //TODO 底部弹出菜单
                LowmenuFragment lowmenuFragment = new LowmenuFragment();
                List<MenuItems> menuItemsList = new ArrayList<>();
                MenuItems menuItems1 = new MenuItems();
                menuItems1.setText("支付宝支付");
                MenuItems menuItems2 = new MenuItems();
                menuItems2.setText("微信支付");

                menuItems1.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Toast.makeText(MyAibotActivity.this, "支付宝支付", Toast.LENGTH_SHORT).show();
                    }
                });
                menuItems2.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems2) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Toast.makeText(MyAibotActivity.this, "微信支付", Toast.LENGTH_SHORT).show();
                    }
                });
                menuItemsList.add(menuItems1);
                menuItemsList.add(menuItems2);
                lowmenuFragment.setMenuItemses(menuItemsList);
                lowmenuFragment.show(getFragmentManager(), "LowmenuFragment");
                break;
            //归还
            case R.id.btn_overed_return:
                //TODO 弹出提示对话框 继续后跳转至归还网点选择  选择归还网点后显示地图
                intent.setClass(MyAibotActivity.this, InternetSelectActivity.class);
                startActivityForResult(intent, 110);
                break;
            case R.id.iv_lease_history:
                //订单管理--我的小宝
                intent.setClass(MyAibotActivity.this, MyAibotOMActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_apply_zhuanzu:
                //TODO 跳转到SubletReleaseActivity 申请转租界面
                Log.e("申请转租", "onClick: " + "申请转租");

                break;
            case R.id.iv_left_myaibot:
                finish();
                break;
            case R.id.btn_change:
              //换货
                intent.setClass(MyAibotActivity.this, SubletReleaseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_finish:
               //结束
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //加载地图
        if (requestCode == 110 && data!=null) {
            //initMap();
            initAMap();
            mLlReturn.setVisibility(View.VISIBLE);
            mLlOvered.setVisibility(View.GONE);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //归还结束后  显示地图页面
    private void initMap() {

    }

    private void initAMap() {
        if (aMap == null) {
            aMap = mMapviewReturn.getMap();

        }
        setUpMap();
    }

    private void setUpMap() {
        mLocationClientOption = new AMapLocationClientOption();
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClientOption.setNeedAddress(true);
        mLocationClientOption.setOnceLocation(false);
        mLocationClientOption.setWifiActiveScan(true);
        mLocationClientOption.setMockEnable(false);
        mLocationClientOption.setInterval(2000);
        mLocationClient.setLocationOption(mLocationClientOption);
        mLocationClient.startLocation();
    }


    private double lat;
    private double lon;
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
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
                    Log.e("888888", "onLocationChanged: " + "街道" + amapLocation.getStreet() + "街道门牌号" + amapLocation.getStreetNum());
                    Log.e("11111111", "onLocationChanged: " + amapLocation.getAoiName() + " " + amapLocation.getAddress());
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
        mMapviewReturn.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapviewReturn.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapviewReturn.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapviewReturn.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}

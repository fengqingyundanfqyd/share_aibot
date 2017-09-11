package com.example.aiqing.sharerobot.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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
import com.example.aiqing.sharerobot.bean.MyAibotBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**归还中
 * Created by aiqing on 2017/8/28.
 */

public class ReturningNoRentFragment extends Fragment {

    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean returnNobean;
    private MapView mReturnmapview;
    private AMap aMap;
    private AMapLocationClient mLocationClient;
    private AMapLocationClientOption mLocationClientOption;
    @SuppressLint({"NewApi", "ValidFragment"})
    public ReturningNoRentFragment(Context context, MyAibotBean.ObjBean.ResultBean returnNobean) {
        this.context=context;
        this.returnNobean=returnNobean;
    }
    public ReturningNoRentFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_retruning,container,false);
        mReturnmapview = (MapView) view.findViewById(R.id.return_mapview);
        //初始化定位
        mLocationClient = new AMapLocationClient(context.getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mReturnmapview.onCreate(savedInstanceState);

        initAMap();
        initId(view);

        return view;
    }

    private void initId(View view) {
        TextView tvReturnId = (TextView) view.findViewById(R.id.tv_return_id);
        TextView tvLend = (TextView) view.findViewById(R.id.tv_lend_return);
        TextView tvRepay = (TextView) view.findViewById(R.id.tv_repay_return);
        Button btnRepay = (Button) view.findViewById(R.id.btn_repay_return);
        tvLend.setText(returnNobean.getLeaseFrom2()+"");
        tvRepay.setText(returnNobean.getLeaseTo2()+"");
        tvReturnId.setText(returnNobean.getProductId()+"");
    }

    private void initAMap() {

        if (aMap == null) {
            aMap = mReturnmapview.getMap();
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

    private double mLatitude;
    private double mLongitude;
    private String mProvince;
    private String mCity;
    private String mDistrict;
    private String mStreet;
    private String mStreetNum;
    public AMapLocationListener mLocationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                if (amapLocation.getErrorCode() == 0) {
                    //定位成功回调信息，设置相关消息
                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表

                    //获取纬度
                    mLatitude = amapLocation.getLatitude();
                    mLongitude = amapLocation.getLongitude();


                    amapLocation.getAccuracy();//获取精度信息
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date(amapLocation.getTime());
                    df.format(date);//定位时间
                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                    amapLocation.getCountry();//国家信息
                    //省信息
                    mProvince = amapLocation.getProvince();
                    //城市信息
                    mCity = amapLocation.getCity();
                    //城区信息
                    mDistrict = amapLocation.getDistrict();
                    //街道信息
                    mStreet = amapLocation.getStreet();
                    //街道门牌号信息
                    mStreetNum = amapLocation.getStreetNum();

                    amapLocation.getCityCode();//城市编码
                    amapLocation.getAdCode();//地区编码
                    amapLocation.getAoiName();//获取当前定位点的AOI信息

                    Log.e("888888", "onLocationChanged: " + "街道" + amapLocation.getStreet() + "街道门牌号" + amapLocation.getStreetNum());
                    Log.e("11111111", "onLocationChanged: " + amapLocation.getAoiName() + " " + amapLocation.getAddress());
                    lat = mLatitude;
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

//                    amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                    amapLocation.getLatitude();//获取纬度
//                    amapLocation.getLongitude();//获取经度
//                    amapLocation.getAccuracy();//获取精度信息
//                    amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                    amapLocation.getCountry();//国家信息
//                    amapLocation.getProvince();//省信息
//                    amapLocation.getCity();//城市信息
//                    amapLocation.getDistrict();//城区信息
//                    amapLocation.getStreet();//街道信息
//                    amapLocation.getStreetNum();//街道门牌号信息
//                    amapLocation.getCityCode();//城市编码
//                    amapLocation.getAdCode();//地区编码
//                    amapLocation.getAoiName();//获取当前定位点的AOI信息
//                    amapLocation.getBuildingId();//获取当前室内定位的建筑物Id
//                    amapLocation.getFloor();//获取当前室内定位的楼层
//                    amapLocation.getGpsStatus();//获取GPS的当前状态
//                    //获取定位时间
//                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date date = new Date(amapLocation.getTime());
//                    df.format(date);
                } else {
                    //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + amapLocation.getErrorCode() + ", errInfo:"
                            + amapLocation.getErrorInfo());
                }
            }
        }
    };

    //一下方法必须重写
    @Override
    public void onResume() {
        super.onResume();
        mReturnmapview.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mReturnmapview.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mReturnmapview.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mReturnmapview.onSaveInstanceState(outState);
    }
}

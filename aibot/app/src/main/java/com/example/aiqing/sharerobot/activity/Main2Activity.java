package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.amap.api.maps.model.animation.TranslateAnimation;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AibotNumBean;
import com.example.aiqing.sharerobot.bean.PersonalInfoBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.overlay.WalkRouteOverlay;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.aiqing.sharerobot.R.id.iv_quesion;
import static com.example.aiqing.sharerobot.R.id.iv_refresh;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, AMap.OnMarkerClickListener, RouteSearch.OnRouteSearchListener {

    private LinearLayout mMain;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ImageView mRefresh;
    private ImageView mPerson;
    private ImageView mQuesion;
    private LinearLayout mScan;
    private ImageView mRobot;
    private DrawerLayout mDrawlayout;
    private Dialog mDialog;
    private MapView mMapView;
    private AMapLocationClient mLocationClient;
    private AMap aMap;
    private AMapLocationClientOption mLocationClientOption;
    private TextView mTvBalance;
    private LinearLayout mLl_nav_trip;
    private LinearLayout mLlDailiManager;
    private LinearLayout mLlToufangManager;
    private TextView mTvNick;
    private BitmapDescriptor moveBitmap;//定位圆点、可移动、所有标识（车）
    private Marker mPositionMark, tempMark;
    private Marker mScreenMarker;
    private DriveRouteResult mDriveRouteResult;
    private LatLng mRecordPositon;
    private Marker mPosition;
    private final int ROUTE_TYPE_WALK = 3;
    private LatLonPoint mStartPoint = null;
    private LatLonPoint mEndPoint = null;
    private RouteSearch mRouteSearch;
    private boolean isClickIdentification = false;


    private double lat;
    private double lon;

    private double mLatitude;
    private double mLongitude;
    private String mProvince;
    private String mCity;
    private String mDistrict;
    private String mStreet;
    private String mStreetNum;
    private Marker mMarker1;
    private Marker mMarker2;

    private List<AibotNumBean.MdListBean> mMdList;
    private List<AibotNumBean.ZzListBean> mZzList;
    private String mDistributorId;
    private WalkRouteResult mWalkRouteResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map_view);

        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mMapView.onCreate(savedInstanceState);

        initId();
        initAMap();
        initToolbar();
        initDrawerLayout();
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void initId() {

        mMain = (LinearLayout) findViewById(R.id.include_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRefresh = (ImageView) findViewById(iv_refresh);
        mPerson = (ImageView) findViewById(R.id.iv_person);
        mQuesion = (ImageView) findViewById(iv_quesion);
        mScan = (LinearLayout) findViewById(R.id.ll_scan);
        mRobot = (ImageView) findViewById(R.id.iv_robot);
        mDrawlayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        mRefresh.setOnClickListener(this);
        mPerson.setOnClickListener(this);
        mQuesion.setOnClickListener(this);
        mScan.setOnClickListener(this);
        mRobot.setOnClickListener(this);

    }

    private void initAMap() {
        if (aMap == null) {
            aMap = mMapView.getMap();

            mRouteSearch = new RouteSearch(this);

            mRouteSearch.setRouteSearchListener(this);

        }
        setUpMap();


        aMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
            @Override
            public void onMapLoaded() {

                addMarkersToMap();
            }
        });
        // 设置可视范围变化时的回调的接口方法
        aMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {
//                //设置地图缩放比例
//                aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
                //  addMarkersToMap();
                if (!isClickIdentification) {
                    mRecordPositon = cameraPosition.target;
                    Log.e("记录经纬度", "onCameraChangeFinish: " + mRecordPositon.longitude + mRecordPositon.latitude);
                }

                //屏幕中心的Marker跳动
                startJumpAnimation();

                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(new LatLng(lat, lon));
                // markerOptions.title("当前位置");
                markerOptions.visible(true);
                BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.now));
                markerOptions.icon(bitmapDescriptor);
                mPosition = aMap.addMarker(markerOptions);

                //小宝初始化点
                addEmulateData();

            }
        });
    }


    //小宝初始化点
    private void addEmulateData() {
        String lat = String.valueOf(mLatitude);
        String lgt = String.valueOf(mLongitude);
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://120.132.117.157:8083/comm/getAgentInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AibotNumBean> call = apiService.getAibot(lat, lgt, "10");
        call.enqueue(new Callback<AibotNumBean>() {
            @Override
            public void onResponse(Response<AibotNumBean> response, Retrofit retrofit) {

                if (response.body() != null) {
                    //投放
                    mMdList = response.body().getMdList();

                    ArrayList<MarkerOptions> markerOptionsList1 = new ArrayList<>();
                    for (int i = 0; i < mMdList.size(); i++) {

                        String lat = mMdList.get(i).getLat();
                        String lgt = mMdList.get(i).getLgt();
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(new LatLng(Double.valueOf(lat), Double.valueOf(lgt)));
                        markerOptions.visible(true);
                        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_tou));
                        markerOptions.icon(bitmapDescriptor);
                        markerOptions.title("dis");

                        mMarker1 = aMap.addMarker(markerOptions);

//                        HashMap<String,AibotNumBean> zzBean=new HashMap<String, AibotNumBean>();
//                        zzBean.put(mMarker1.getId(), (AibotNumBean) mMdList);

                    }
                    aMap.addMarkers(markerOptionsList1, true);
                    //转租
                    ArrayList<MarkerOptions> markerOptionsList2 = new ArrayList<>();
                    mZzList = response.body().getZzList();

                    for (int j = 0; j < mZzList.size(); j++) {
                        String lat1 = mZzList.get(j).getLat();
                        String lgt1 = mZzList.get(j).getLgt();


                        MarkerOptions markerOptions1 = new MarkerOptions();
                        markerOptions1.position(new LatLng(Double.valueOf(lat1), Double.valueOf(lgt1)));
                        markerOptions1.visible(true);
                        BitmapDescriptor bitmapDescriptor1 = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.icon_zhuan));
                        markerOptions1.icon(bitmapDescriptor1);
                        markerOptions1.title("sub");


                        mMarker2 = aMap.addMarker(markerOptions1);

                        //    HashMap<String,AibotNumBean> zzBean=new HashMap<String, AibotNumBean>();
//                        zzBean.put(mMarker1.getId(), (AibotNumBean) mMdList);

                    }
                    aMap.addMarkers(markerOptionsList2, true);


                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    //在地图上添加marker
    private void addMarkersToMap() {

        addMarkerInScreenCenter();
    }

    //在屏幕中心添加一个Marker
    private void addMarkerInScreenCenter() {
        LatLng latLng = aMap.getCameraPosition().target;
        Point screenLocation = aMap.getProjection().toScreenLocation(latLng);
        MarkerOptions markerOptions = new MarkerOptions();
        mScreenMarker = aMap.addMarker(markerOptions.anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_move)));
        //设置Marker在屏幕上,不跟随地图移动
        mScreenMarker.setPositionByPixels(screenLocation.x, screenLocation.y);

           // mPositionMark = aMap.addMarker(markerOptions);

    }

    //屏幕中心的Marker跳动
    private void startJumpAnimation() {
        if (mScreenMarker != null) {
            //根据屏幕距离计算需要移动的目标点
            LatLng latLng = mScreenMarker.getPosition();
            Point point = aMap.getProjection().toScreenLocation(latLng);
            point.y -= dip2px(this, 125);
            LatLng target = aMap.getProjection().fromScreenLocation(point);
            //使用TranslateAnimation,填写一个需要移动的目标点
            TranslateAnimation animation = new TranslateAnimation(target);
            animation.setInterpolator(new Interpolator() {
                @Override
                public float getInterpolation(float input) {
                    // 模拟重加速度的interpolator
                    if (input <= 0.5) {
                        return (float) (0.5f - 2 * (0.5 - input) * (0.5 - input));
                    } else {
                        return (float) (0.5f - Math.sqrt((input - 0.5f) * (1.5f - input)));
                    }

                }
            });
            //整个移动所需要的时间
            animation.setDuration(600);
            //设置动画
            mScreenMarker.setAnimation(animation);
            //开始动画
            mScreenMarker.startAnimation();

        }
    }


    //dip和px转换
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
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

        //设置marker点击监听
        aMap.setOnMarkerClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.iv_refresh:
                clickRefresh();
                break;
            case R.id.iv_person:
                initLogin();
                break;
            case R.id.iv_quesion:
                Toast.makeText(this, "用户指南", Toast.LENGTH_SHORT).show();
                mQuesion.setImageResource(R.mipmap.icon_guide_pressed);

                intent.setClass(this, DistributorManagerActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_scan:
                //扫描二维码
                if (getSharedPreferences("COOKIE", MODE_PRIVATE).getString("mCookie", "").equals("")) {
                    intent.setClass(Main2Activity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    intent.setClass(this, ScanActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.iv_robot:
                mRobot.setImageResource(R.mipmap.icon_aibot_pressed);
                //intent.setClass(this, MyAibotActivity.class);
                if (getSharedPreferences("COOKIE", MODE_PRIVATE).getString("mCookie", "").equals("")) {
                    intent.setClass(Main2Activity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    intent.setClass(this, ViewpagerActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.iv_erweima:
                //生成普通用户二维码
                intent.setClass(this, TobeErweimaActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.iv_avatar:
                intent.setClass(this, PersonalInfoActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_toufangmanager:
                //投放商管理
                intent.setClass(this, PutManagerActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_daili_manager:
                //代理商管理
                intent.setClass(this, AgentyActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_nav_trip:
                //我的钱包
                intent.setClass(this, MyWalletActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_nav_guide:
                //设置
                intent.setClass(this, SettingActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void initDrawerLayout() {
        mNavigationView.inflateHeaderView(R.layout.nav_header_main);
        View headerView = mNavigationView.getHeaderView(0);
        mLl_nav_trip = (LinearLayout) headerView.findViewById(R.id.ll_nav_trip);
        LinearLayout ll_nav_money = (LinearLayout) headerView.findViewById(R.id.ll_nav_money);
        LinearLayout ll_nav_message = (LinearLayout) headerView.findViewById(R.id.ll_nav_message);
        LinearLayout ll_nav_guide = (LinearLayout) headerView.findViewById(R.id.ll_nav_guide);
        ImageView ivAcatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
        mLlDailiManager = (LinearLayout) headerView.findViewById(R.id.ll_daili_manager);
        mLlToufangManager = (LinearLayout) headerView.findViewById(R.id.ll_toufangmanager);
        mTvBalance = (TextView) headerView.findViewById(R.id.tv_balance);
        mTvNick = (TextView) headerView.findViewById(R.id.tv_nick);

        ImageView ivErwema = (ImageView) headerView.findViewById(R.id.iv_erweima);

        if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            mLlDailiManager.setVisibility(View.GONE);
            mLlToufangManager.setVisibility(View.GONE);
        } else if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && !getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            mLlDailiManager.setVisibility(View.VISIBLE);
            mLlToufangManager.setVisibility(View.GONE);
        } else if (!getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            mLlDailiManager.setVisibility(View.GONE);
            mLlToufangManager.setVisibility(View.VISIBLE);
        } else if (!getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && !getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            mLlDailiManager.setVisibility(View.VISIBLE);
            mLlToufangManager.setVisibility(View.VISIBLE);
        }


        mLl_nav_trip.setOnClickListener(this);
        ll_nav_money.setOnClickListener(this);
        ll_nav_message.setOnClickListener(this);
        ll_nav_guide.setOnClickListener(this);
        ivErwema.setOnClickListener(this);
        ivAcatar.setOnClickListener(this);
        mLlDailiManager.setOnClickListener(this);
        mLlToufangManager.setOnClickListener(this);
        mLl_nav_trip.setOnClickListener(this);
        ll_nav_guide.setOnClickListener(this);

    }

    //判断是否登录
    private void initLogin() {
        if (getSharedPreferences("COOKIE", MODE_PRIVATE).getString("mCookie", "").equals("")) {
            Intent intent = new Intent();
            intent.setClass(Main2Activity.this, LoginActivity.class);
            startActivity(intent);
        } else {
            SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
            String cookie = preferences.getString("mCookie", "");
            HttpTool httpTool = new HttpTool(this);
            Retrofit builder = new Retrofit.Builder()
                    .client(httpTool.client())
                    .baseUrl("http://120.132.117.157:8083/account/getCustInfo.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<PersonalInfoBean> call = apiService.getPersonsInfo(cookie);

            call.enqueue(new Callback<PersonalInfoBean>() {
                @Override
                public void onResponse(Response<PersonalInfoBean> response, Retrofit retrofit) {
                    if (response.body() != null) {
                        mTvBalance.setText(response.body().getObj().getBalance() + "");
                        mTvNick.setText(response.body().getObj().getNickname());
                    } else {
                        mTvBalance.setText(0.00 + "");
                        mTvNick.setText("昵称");
                    }
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
            mDrawlayout.openDrawer(GravityCompat.START);
        }

    }


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

                    Log.e("经纬度", "onLocationChanged: " + "经度" + lat + "纬度" + lon);

                    Log.v("pcw", "Country : " + amapLocation.getCountry() + " province : " + amapLocation.getProvince() + " City : " + amapLocation.getCity() + " District : " + amapLocation.getDistrict());
                    //清空缓存位置
                    aMap.clear();
                    // 设置当前地图显示为当前位置
                    aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 15));
//                    MarkerOptions markerOptions = new MarkerOptions();
//                    markerOptions.position(new LatLng(lat, lon));
//                   // markerOptions.title("当前位置");
//                    markerOptions.visible(true);
//                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.shop));
//                    markerOptions.icon(bitmapDescriptor);
                    addMarkersToMap();


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

    private void clickRefresh() {
        mLocationClient.startLocation();

    }

    //点击marker
    @Override
    public boolean onMarkerClick(Marker marker) {
        if (aMap != null) {
            LatLng position = marker.getPosition();
            Log.e("676666666", "onMarkerClick: " + position);

            String id = marker.getId();
            Log.e("8888888", "onMarkerClick: " + id);

            if (marker.getOptions().getTitle().equals("sub")) {

                setSubletData(mZzList, marker);

            } else if (marker.getOptions().getTitle().equals("dis")) {

                setDialogData(mMdList, marker);

            }
            //点击marker动画
            startAnim(marker);
            //路线
            start(marker);

        }

        return false;
    }

    private void start(final Marker marker) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            Thread.sleep(300);
//                            tempMark = marker;
//                            mStartPoint = new LatLonPoint(mRecordPositon.latitude, mRecordPositon.longitude);
//                             mPosition.setPosition(mRecordPositon);
//                            mEndPoint = new LatLonPoint(marker.getPosition().latitude, marker.getPosition().longitude);
//                             marker.setPosition(marker.getPosition());
//                            searchRouteResultNew(ROUTE_TYPE_WALK, RouteSearch.WalkDefault);

                            Thread.sleep(300);
                            tempMark = marker;
                            mStartPoint = new LatLonPoint(mRecordPositon.latitude, mRecordPositon.longitude);
                            mScreenMarker.setPosition(mRecordPositon);
                            mEndPoint = new LatLonPoint(marker.getPosition().latitude, marker.getPosition().longitude);
                            marker.setPosition(marker.getPosition());
                            searchRouteResultNew(ROUTE_TYPE_WALK, RouteSearch.WalkDefault);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();
    }

    private void startAnim(Marker marker) {
        ScaleAnimation anim = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f);
        anim.setDuration(300);
        marker.setAnimation(anim);
        marker.startAnimation();
    }

    private void searchRouteResultNew(int routeType, int mode) {
        if (mStartPoint == null) {
            Toast.makeText(this, "定位中，稍后再试...", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mEndPoint == null) {
            Toast.makeText(this, "终点未设置", Toast.LENGTH_SHORT).show();
        }
        final RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(
                mStartPoint, mEndPoint);
        if (routeType == ROUTE_TYPE_WALK) {// 步行路径规划
            RouteSearch.WalkRouteQuery query = new RouteSearch.WalkRouteQuery(fromAndTo, mode);
            mRouteSearch.calculateWalkRouteAsyn(query);// 异步路径规划步行模式查询
        }
    }

    //设置转租信息
    private void setSubletData(List<AibotNumBean.ZzListBean> zzList, Marker marker) {
        mDialog = new Dialog(Main2Activity.this, R.style.DialogStyle);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_layout);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

        lp.y = 150; // 新位置Y坐标
        lp.width = 800; // 宽度
        lp.height = 400; // 高度
        dialogWindow.setAttributes(lp);
        TextView tvName = (TextView) mDialog.findViewById(R.id.tv_main_name);
        TextView tvAddress = (TextView) mDialog.findViewById(R.id.tv_main_address);
        TextView tvNum = (TextView) mDialog.findViewById(R.id.tv_canrent_num);
        TextView tvDistance = (TextView) mDialog.findViewById(R.id.tv_distance);
        LinearLayout dialog = (LinearLayout) mDialog.findViewById(R.id.ll_dialog_all);


        for (int i = 0; i < mZzList.size(); i++) {
            if (marker.getPosition().latitude == Double.valueOf(mZzList.get(i).getLat()) && marker.getPosition().longitude == Double.valueOf(mZzList.get(i).getLgt())) {
                tvName.setText(mZzList.get(i).getNickName());
                tvAddress.setText(mZzList.get(i).getAddress());
                final String craId = mZzList.get(i).getCraId();

                dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (getSharedPreferences("COOKIE", MODE_PRIVATE).getString("mCookie", "").equals("")) {
                            Intent intent = new Intent();
                            intent.setClass(Main2Activity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {

                            Intent intent = new Intent();
                            intent.putExtra("craId", craId);
                            intent.setClass(Main2Activity.this, SubletMessageActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        }
        mDialog.show();
    }


    //设置投放商信息
    private void setDialogData(List<AibotNumBean.MdListBean> mdList, Marker marker) {
        mDialog = new Dialog(Main2Activity.this, R.style.DialogStyle);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_layout);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);

        lp.y = 150; // 新位置Y坐标
        lp.width = 800; // 宽度
        lp.height = 400; // 高度
        dialogWindow.setAttributes(lp);
        TextView tvName = (TextView) mDialog.findViewById(R.id.tv_main_name);
        TextView tvAddress = (TextView) mDialog.findViewById(R.id.tv_main_address);
        TextView tvNum = (TextView) mDialog.findViewById(R.id.tv_canrent_num);
        TextView tvDistance = (TextView) mDialog.findViewById(R.id.tv_distance);
        LinearLayout dialog2 = (LinearLayout) mDialog.findViewById(R.id.ll_dialog_all);

        for (int i = 0; i < mdList.size(); i++) {
            if (marker.getPosition().latitude == Double.valueOf(mdList.get(i).getLat()) && marker.getPosition().longitude == Double.valueOf(mdList.get(i).getLgt())) {

                tvName.setText(mdList.get(i).getName());
                tvAddress.setText(mdList.get(i).getAddress());
                mDistributorId = mdList.get(i).getDistributorId();

            }
        }
        dialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getSharedPreferences("COOKIE", MODE_PRIVATE).getString("mCookie", "").equals("")) {
                    Intent intent = new Intent();
                    intent.setClass(Main2Activity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("mDistributorId", mDistributorId);
                    intent.setClass(Main2Activity.this, BusinessInfoActivity.class);
                    startActivity(intent);
                }
            }
        });
        mDialog.show();

    }


    @Override
    public void onBusRouteSearched(BusRouteResult result, int errorCode) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult result, int errorCode) {

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult result, int errorCode) {
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mWalkRouteResult = result;
                    final WalkPath walkPath = mWalkRouteResult.getPaths().get(0);
                    WalkRouteOverlay walkRouteOverlay = new WalkRouteOverlay(this, aMap, walkPath, mWalkRouteResult.getStartPos(), mWalkRouteResult.getTargetPos());
                    walkRouteOverlay.removeFromMap();
                    walkRouteOverlay.addToMap();
                    walkRouteOverlay.zoomToSpan();

                    int dis = (int) walkPath.getDistance();
                    int dur = (int) walkPath.getDuration();
//                    String[] time = AMapUtil.getFriendlyTimeArray(dur);
//                    String distance = AMapUtil.getFriendlyLength(dis);
//                    String des = AMapUtil.getFriendlyTime(dur) + "(" + AMapUtil.getFriendlyLength(dis) + ")";
//                    tempMark.setTitle(des);
                 //   tempMark.showInfoWindow();
                    Log.e("距离", "onWalkRouteSearched: "+dis );
                }
            }
        }
    }

    @Override
    public void onRideRouteSearched(RideRouteResult result, int errorCode) {

    }
}

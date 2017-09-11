package com.example.aiqing.sharerobot;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.ScaleAnimation;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.example.aiqing.sharerobot.activity.AgentyActivity;
import com.example.aiqing.sharerobot.activity.BusinessInfoActivity;
import com.example.aiqing.sharerobot.activity.ErweimaActivity;
import com.example.aiqing.sharerobot.activity.LoginActivity;
import com.example.aiqing.sharerobot.activity.MyAibotActivity;
import com.example.aiqing.sharerobot.activity.MyWalletActivity;
import com.example.aiqing.sharerobot.activity.PersonalInfoActivity;
import com.example.aiqing.sharerobot.activity.PutManagerActivity;
import com.example.aiqing.sharerobot.activity.TobeErweimaActivity;
import com.example.aiqing.sharerobot.dialog.LoadDialog;
import com.example.aiqing.sharerobot.fragment.LowmenuFragment;
import com.example.aiqing.sharerobot.fragment.MenuItemOnClickListener;
import com.example.aiqing.sharerobot.fragment.MenuItems;
import com.example.aiqing.sharerobot.lib.LocationTask;
import com.example.aiqing.sharerobot.lib.OnLocationGetListener;
import com.example.aiqing.sharerobot.lib.PositionEntity;
import com.example.aiqing.sharerobot.lib.RegeocodeTask;
import com.example.aiqing.sharerobot.lib.RouteTask;
import com.example.aiqing.sharerobot.lib.Utils;
import com.example.aiqing.sharerobot.overlay.WalkRouteOverlay;
import com.example.aiqing.sharerobot.utils.AMapUtil;

import java.util.ArrayList;
import java.util.List;

import static com.amap.api.maps.model.BitmapDescriptorFactory.fromResource;
import static com.example.aiqing.sharerobot.R.id.iv_quesion;

public class MainActivity extends AppCompatActivity implements AMap.OnMapTouchListener, AMap.OnMapLoadedListener, AMap.OnMapClickListener, OnLocationGetListener, AMap.OnCameraChangeListener, AMapLocationListener, View.OnClickListener, RouteSearch.OnRouteSearchListener, AMap.InfoWindowAdapter, RouteTask.OnRouteCalculateListener {
    public static final String TAG = "MainActivity";
    public static final int REQUEST_CODE = 1;
    //地图view
    MapView mMapView = null;
    //初始化地图控制器对象
    AMap aMap;
    //刷新定位
    ImageView iv_refresh, iv_scan_code;

    //定位
    private LocationTask mLocationTask;
    //逆地理编码功能
    private RegeocodeTask mRegeocodeTask;
    //绘制点标记
    private Marker mPositionMark, mInitialMark, tempMark;//可移动、圆点、点击
    //初始坐标、移动记录坐标
    private LatLng mStartPosition, mRecordPositon;
    //默认添加一次
    private boolean mIsFirst = true;
    //就第一次显示位置
    private boolean mIsFirstShow = true;

    private LatLng initLocation;

    private ValueAnimator animator = null;//坐标动画
    private BitmapDescriptor initBitmap, moveBitmap, smallIdentificationBitmap, bigIdentificationBitmap;//定位圆点、可移动、所有标识（车）
    private RouteSearch mRouteSearch;

    private LatLonPoint mStartPoint = null;//起点，116.335891,39.942295
    private LatLonPoint mEndPoint = null;//终点，116.481288,39.995576
    private final int ROUTE_TYPE_WALK = 3;
    private boolean isClickIdentification = false;
    WalkRouteOverlay walkRouteOverlay;//路线
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ImageView mRefresh;
    private ImageView mPerson;
    private ImageView mQuesion;
    private LinearLayout mScan;
    private ImageView mRobot;
    private DrawerLayout mDrawlayout;
    private WalkRouteResult mWalkRouteResult;
    private String[] time;
    private String distance;
    private Dialog mDialog;
    private LinearLayout mLlDailiManager;
    private LinearLayout mLlToufangManager;
    private LinearLayout mLl_nav_trip;
    private AMapLocationClient mAMapLocationClient;
    private LinearLayout mLogin;
    private LinearLayout mMain;
    private TextView mTvBalance;
    private TextView mTvNick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        initToolbar();
        initDrawerLayout();
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.map_view);
       // iv_refresh = (ImageView) findViewById(R.id.iv_refresh);
       // iv_refresh.setOnClickListener(this);
//        iv_scan_code = (ImageView) findViewById(R.id.iv_scan_code);
//        iv_scan_code.setOnClickListener(this);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
        initBitmap();
        initAMap();
        aMap.setMyLocationEnabled(true);
        initLocation();

        initLocationNew();

        RouteTask.getInstance(getApplicationContext())
                .addRouteCalculateListener(this);
        //  Log.e(TAG, "sha1" + Sha1.sHA1(this));
    }

    private void initLocationNew() {
        mAMapLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        //设置定位参数
        mAMapLocationClient.setLocationOption(aMapLocationClientOption);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);

        //获取一次定位结果：
        aMapLocationClientOption.setOnceLocation(true);

        //设置是否返回地址信息（默认返回地址信息）
        aMapLocationClientOption.setNeedAddress(true);

        //设置是否只定位一次,默认为false
        aMapLocationClientOption.setOnceLocation(true);

        //设置是否强制刷新WIFI，默认为强制刷新
        aMapLocationClientOption.setWifiActiveScan(true);

        //设置是否允许模拟位置,默认为false，不允许模拟位置
        aMapLocationClientOption.setMockEnable(false);

        aMapLocationClientOption.setHttpTimeOut(20000);

        //给定位客户端对象设置定位参数
        mAMapLocationClient.setLocationOption(aMapLocationClientOption);

        //启动定位
        mAMapLocationClient.startLocation();

        mAMapLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
//                        //定位成功回调信息，设置相关消息
//                        aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                        double latitude = aMapLocation.getLatitude();//获取纬度
//                        double longitude = aMapLocation.getLongitude();//获取经度
//                        Log.d("获取当前经纬度", "onLocationChanged: "+longitude+" "+latitude);
//                        aMapLocation.getAccuracy();//获取精度信息
//                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                        Date date = new Date(aMapLocation.getTime());
//                        df.format(date);//定位时间

                    } else {
                    }
                }

            }
        });
    }

    private void initBitmap() {
        initBitmap = fromResource(R.mipmap.now);
        moveBitmap = fromResource(R.mipmap.icon_move);
        smallIdentificationBitmap = fromResource(R.mipmap.shop);
        bigIdentificationBitmap = fromResource(R.mipmap.shop);
    }

    @Override
    protected void onRestart() {
        mRobot.setImageResource(R.mipmap.icon_aibot);
        super.onRestart();
    }

    private void initId() {

        mMain = (LinearLayout) findViewById(R.id.include_main);
        mLogin = (LinearLayout) findViewById(R.id.include_login);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRefresh = (ImageView) findViewById(R.id.iv_refresh);
        mPerson = (ImageView) findViewById(R.id.iv_person);
        mQuesion = (ImageView) findViewById(iv_quesion);
        mScan = (LinearLayout) findViewById(R.id.ll_scan);
        mRobot = (ImageView) findViewById(R.id.iv_robot);
        FrameLayout framelayout = (FrameLayout) findViewById(R.id.framelayout);
        mDrawlayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        mRefresh.setOnClickListener(this);
        mPerson.setOnClickListener(this);
        mQuesion.setOnClickListener(this);
        mScan.setOnClickListener(this);
        mRobot.setOnClickListener(this);

        mDialog = new Dialog(MainActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.dialog_layout);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        lp.y = 150; // 新位置Y坐标
        lp.width = 900; // 宽度
        lp.height = 400; // 高度
        dialogWindow.setAttributes(lp);
        LinearLayout relativeLayout = (LinearLayout) mDialog.findViewById(R.id.relativelayout);
        LinearLayout llDaohang = (LinearLayout) mDialog.findViewById(R.id.ll_daohang);
       // TextView tvDetail = (TextView) mDialog.findViewById(R.id.tv_detail);
        ImageView ivDaoHang= (ImageView) mDialog.findViewById(R.id.iv_daohang);
        llDaohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, BusinessInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        ivDaoHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this, SelectPicPopupWindow.class));
                //TODO 底部导航
                LowmenuFragment lowmenuFragment = new LowmenuFragment();
                List<MenuItems> menuItemsList =new ArrayList<>();

                MenuItems menuItems = new MenuItems();
                MenuItems menuItems1 = new MenuItems();
                MenuItems menuItems2 = new MenuItems();
                menuItems.setText("高德地图");
                menuItems1.setText("百度地图");
                menuItems2.setText("腾讯地图");

                menuItems.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment,menuItems) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItem) {
                        Toast.makeText(MainActivity.this, "高德地图", Toast.LENGTH_SHORT).show();
                    }
                });
                menuItems1.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment,menuItems1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItem) {
                        Toast.makeText(MainActivity.this, "百度地图", Toast.LENGTH_SHORT).show();
                    }
                });

                menuItemsList.add(menuItems);
                menuItemsList.add(menuItems1);
                lowmenuFragment.setMenuItemses(menuItemsList);
                lowmenuFragment.show(getFragmentManager(),"LowmenuFragment");
            }
        });

    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //去除默认Title显示
            actionBar.setDisplayShowTitleEnabled(false);
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

        if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")){
            mLlDailiManager.setVisibility(View.GONE);
            mLlToufangManager.setVisibility(View.GONE);
        }else if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && !getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")){
            mLlDailiManager.setVisibility(View.VISIBLE);
            mLlToufangManager.setVisibility(View.GONE);
        }else if (!getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")){
            mLlDailiManager.setVisibility(View.GONE);
            mLlToufangManager.setVisibility(View.VISIBLE);
        }else if (!getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && !getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")){
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //点击跳到信息界面
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_search:
//                Toast.makeText(this, "信息", Toast.LENGTH_SHORT).show();
//                //startActivity(new Intent(MainActivity.this, PopwindowActivity.class));
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    /**
     * 初始化地图控制器对象
     */
    private void initAMap() {
        if (aMap == null) {
            aMap = mMapView.getMap();
            mRouteSearch = new RouteSearch(this);
            mRouteSearch.setRouteSearchListener(this);
            aMap.getUiSettings().setZoomControlsEnabled(false);
            aMap.getUiSettings().setGestureScaleByMapCenter(true);
//            aMap.getUiSettings().setScrollGesturesEnabled(false);
            aMap.setOnMapTouchListener(this);
            aMap.setOnMapLoadedListener(this);
            aMap.setOnCameraChangeListener(this);
            aMap.setOnMapClickListener(this);
            // 绑定 Marker 被点击事件
            aMap.setOnMarkerClickListener(markerClickListener);
            aMap.setInfoWindowAdapter(this);// 设置自定义InfoWindow样式
        }
    }

    /**
     * 初始化定位
     */
    private void initLocation() {
        mLocationTask = LocationTask.getInstance(getApplicationContext());
        mLocationTask.setOnLocationGetListener(this);
        mRegeocodeTask = new RegeocodeTask(getApplicationContext());

    }

    // 定义 Marker 点击事件监听
    AMap.OnMarkerClickListener markerClickListener = new AMap.OnMarkerClickListener() {

        // marker 对象被点击时回调的接口
        // 返回 true 则表示接口已响应事件，否则返回false
        @Override
        public boolean onMarkerClick(final Marker marker) {
            Log.e("666", "点击的Marker");
            Log.e(TAG, marker.getPosition() + "");
            isClickIdentification = true;
            if (tempMark != null) {
                tempMark.setIcon(smallIdentificationBitmap);
                Log.e("666", "remove");
                walkRouteOverlay.removeFromMap();
                tempMark = null;
            }

            mDialog.show();
            startAnim(marker);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(300);
//                        tempMark = marker;
//                        mStartPoint = new LatLonPoint(mRecordPositon.latitude, mRecordPositon.longitude);
//                        // mPositionMark.setPosition(mRecordPositon);
//                        mEndPoint = new LatLonPoint(marker.getPosition().latitude, marker.getPosition().longitude);
//                        marker.setIcon(bigIdentificationBitmap);
//                        marker.setPosition(marker.getPosition());
//                        searchRouteResult(ROUTE_TYPE_WALK, RouteSearch.WalkDefault);
////                        Intent intent = new Intent(MainActivity.this, RouteActivity.class);
////                        intent.putExtra("start_lat", mPositionMark.getPosition().latitude);
////                        intent.putExtra("start_lng", mPositionMark.getPosition().longitude);
////                        intent.putExtra("end_lat", marker.getPosition().latitude);
////                        intent.putExtra("end_lng", marker.getPosition().longitude);
////                        startActivity(intent);
//
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
            return false;
        }
    };

    private void startAnim(Marker marker) {
        ScaleAnimation anim = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f);
        anim.setDuration(300);
        marker.setAnimation(anim);
        marker.startAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        Utils.removeMarkers();
        mMapView.onDestroy();
        mLocationTask.onDestroy();
        RouteTask.getInstance(getApplicationContext()).removeRouteCalculateListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
        if (mInitialMark != null) {
            mInitialMark.setToTop();
        }
        if (mPositionMark != null) {
            mPositionMark.setToTop();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        switch (view.getId()) {
            case R.id.iv_refresh:
                clickRefresh();
                break;
            case R.id.iv_person:
                initLogin();

                break;
            case R.id.iv_quesion:
                Toast.makeText(this, "用户指南", Toast.LENGTH_SHORT).show();
                mQuesion.setImageResource(R.mipmap.icon_guide_pressed);

                intent.setClass(this,BusinessInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_scan:
                //扫描二维码
                intent.setClass(this,ErweimaActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_robot:
                mRobot.setImageResource(R.mipmap.icon_aibot_pressed);
                intent.setClass(this,MyAibotActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_erweima:
                //生成普通用户二维码
                intent.setClass(this,TobeErweimaActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_avatar:
                intent.setClass(this,PersonalInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_toufangmanager:
                //投放商管理
                intent.setClass(this,PutManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_daili_manager:
                //代理商管理
                intent.setClass(this,AgentyActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_nav_trip:
                //我的钱包
                intent.setClass(this,MyWalletActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_nav_guide:
                //设置
                intent.setClass(this,LoginActivity.class);
                startActivity(intent);
                break;
        }

    }
    //判断是否登录
    private void initLogin() {
        if (getSharedPreferences("COOKIE", MODE_PRIVATE)==null){
            mNavigationView.setVisibility(View.GONE);
            mMain.setVisibility(View.GONE);
            mLogin.setVisibility(View.VISIBLE);
        }else {
            SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
            long balance = spDis.getLong("balance", 0);//账户余额
            String nickname = spDis.getString("nickname", "");
            Log.e("首页昵称", "initLogin: "+nickname );
            mTvBalance.setText(balance+"");
            mTvNick.setText(nickname);
            mLogin.setVisibility(View.GONE);
            mMain.setVisibility(View.VISIBLE);
            mDrawlayout.openDrawer(GravityCompat.START);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //TODO 处理扫描结果（在界面上显示）
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
//            }
        }
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
    }

    @Override
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
//        Log.e(TAG, "onCameraChangeFinish" + cameraPosition.target);
        if (!isClickIdentification) {
            mRecordPositon = cameraPosition.target;
        }
        mStartPosition = cameraPosition.target;
        mRegeocodeTask.setOnLocationGetListener(this);
        mRegeocodeTask
                .search(mStartPosition.latitude, mStartPosition.longitude);
//        Utils.removeMarkers();
        if (mIsFirst) {
            Utils.addEmulateData(aMap, mStartPosition);//TODO 显示 marker
//            iv_refresh.setVisibility(View.VISIBLE);
//            //iv_scan_code.setVisibility(View.VISIBLE);
            createInitialPosition(cameraPosition.target.latitude, cameraPosition.target.longitude);
//            createMovingPosition();
            mIsFirst = false;
        }
        if (mInitialMark != null) {
            mInitialMark.setToTop();
        }
        if (mPositionMark != null) {
            mPositionMark.setToTop();
            if (!isClickIdentification) {
                animMarker();
            }
        }
    }

    /**
     * 地图加载完成
     */
    @Override
    public void onMapLoaded() {
        mLocationTask.startLocate();
    }

    /**
     * 创建初始位置图标
     */
    private void createInitialPosition(double lat, double lng) {
        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.setFlat(true);
        markerOptions.anchor(0.5f, 0.5f);
        markerOptions.position(new LatLng(lat, lng));
        markerOptions.icon(initBitmap);
        mInitialMark = aMap.addMarker(markerOptions);
        mInitialMark.setClickable(false);
    }

    /**
     * 创建移动位置图标
     */
    private void createMovingPosition() {
        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.setFlat(true);
//        markerOptions.anchor(0.5f, 0.5f);
        markerOptions.position(new LatLng(0, 0));
        markerOptions.icon(moveBitmap);
        mPositionMark = aMap.addMarker(markerOptions);
        mPositionMark.setPositionByPixels(mMapView.getWidth() / 2,
                mMapView.getHeight() / 2);
        mPositionMark.setClickable(false);
    }

    @Override
    public void onLocationGet(PositionEntity entity) {
        // todo 这里在网络定位时可以减少一个逆地理编码
        Log.e("onLocationGet", "onLocationGet" + entity.address);
        RouteTask.getInstance(getApplicationContext()).setStartPoint(entity);
        mStartPosition = new LatLng(entity.latitue, entity.longitude);
//        Log.d("666", "mlatitude:" + mStartPosition.latitude + "mlongitude:" + mStartPosition.longitude);
        if (mIsFirstShow) {
            CameraUpdate cameraUpate = CameraUpdateFactory.newLatLngZoom(
                    mStartPosition, 17);
            aMap.animateCamera(cameraUpate);
            mIsFirstShow = false;
        }
        mInitialMark.setPosition(mStartPosition);
        initLocation = mStartPosition;
//        Log.d("666", "latitude:" + initLocation.latitude + "longitude:" + initLocation.longitude);
//        Log.e("666", "onLocationGet" + mStartPosition);
    }

    @Override
    public void onRegecodeGet(PositionEntity entity) {
//        Log.e(TAG, "onRegecodeGet" + entity.address);
        entity.latitue = mStartPosition.latitude;
        entity.longitude = mStartPosition.longitude;
        RouteTask.getInstance(getApplicationContext()).setStartPoint(entity);
        RouteTask.getInstance(getApplicationContext()).search();
//        Log.e(TAG, "onRegecodeGet" + mStartPosition);
    }

    @Override
    public void onRouteCalculate(float cost, float distance, int duration) {
//        Log.e(TAG, "cost" + cost + "---" + "distance" + distance + "---" + "duration" + duration);
        PositionEntity endPoint = RouteTask.getInstance(getApplicationContext()).getEndPoint();
        mRecordPositon = new LatLng(endPoint.latitue, endPoint.longitude);
        clickMap();
        RouteTask.getInstance(getApplicationContext()).setEndPoint(null);
    }

    @Override
    public void onTouch(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            aMap.getUiSettings().setScrollGesturesEnabled(false);
        } else {
            aMap.getUiSettings().setScrollGesturesEnabled(true);
        }
    }

    private void animMarker() {
        if (animator != null) {
            animator.start();
            return;
        }
        animator = ValueAnimator.ofFloat(mMapView.getHeight() / 2, mMapView.getHeight() / 2 - 30);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(150);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                mPositionMark.setPositionByPixels(mMapView.getWidth() / 2, Math.round(value));
            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mPositionMark.setIcon(moveBitmap);
            }
        });
        animator.start();
    }

    private void endAnim() {
        if (animator != null && animator.isRunning())
            animator.end();
    }

    @Override
    public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult result, int errorCode) {
        LoadDialog.getInstance().dismiss();
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mWalkRouteResult = result;
                    final WalkPath walkPath = mWalkRouteResult.getPaths()
                            .get(0);
                    walkRouteOverlay = new WalkRouteOverlay(
                            this, aMap, walkPath,
                            mWalkRouteResult.getStartPos(),
                            mWalkRouteResult.getTargetPos());
                    walkRouteOverlay.removeFromMap();
                    walkRouteOverlay.addToMap();
                    walkRouteOverlay.zoomToSpan();
                    int dis = (int) walkPath.getDistance();
                    int dur = (int) walkPath.getDuration();
                  //  time = AMapUtil.getFriendlyTimeArray(dur);
                    distance = AMapUtil.getFriendlyLength(dis);
                    String des = AMapUtil.getFriendlyTime(dur) + "(" + AMapUtil.getFriendlyLength(dis) + ")";
                    tempMark.setTitle(des);
                    tempMark.showInfoWindow();
                } else if (result != null && result.getPaths() == null) {
                    Toast.makeText(this, "???", Toast.LENGTH_SHORT).show();
//                    ToastUtil.show(this, R.string.no_result);
                }
            } else {
                Toast.makeText(this, "???", Toast.LENGTH_SHORT).show();
//                ToastUtil.show(this, R.string.no_result);
            }
        } else {
            //ToastUtil.showerror(this.getApplicationContext(), errorCode);
        }
    }

    @Override
    public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

    }

    //开始搜索路径规划方案
    public void searchRouteResult(int routeType, int mode) {
        if (mStartPoint == null) {
            return;
        }
        if (mEndPoint == null) {
        }
      //  showDialog();
        final RouteSearch.FromAndTo fromAndTo = new RouteSearch.FromAndTo(
                mStartPoint, mEndPoint);
        if (routeType == ROUTE_TYPE_WALK) {// 步行路径规划
            RouteSearch.WalkRouteQuery query = new RouteSearch.WalkRouteQuery(fromAndTo, mode);
            mRouteSearch.calculateWalkRouteAsyn(query);// 异步路径规划步行模式查询
        }
    }

    private void showDialog() {
        LoadDialog loadDialog = LoadDialog.getInstance();
        loadDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Dialog);
        LoadDialog.getInstance().show(getSupportFragmentManager(), "");
    }

    @Override
    public void onMapClick(LatLng latLng) {
        clickMap();
    }

    private void clickRefresh() {
        clickInitInfo();
        if (initLocation != null) {
//            Log.d("666", "666");
            CameraUpdate cameraUpate = CameraUpdateFactory.newLatLngZoom(
                    initLocation, 17f);
            aMap.animateCamera(cameraUpate);
        }
    }

    private void clickMap() {
        clickInitInfo();
        if (mRecordPositon != null) {
            CameraUpdate cameraUpate = CameraUpdateFactory.newLatLngZoom(
                    mRecordPositon, 17f);
            aMap.animateCamera(cameraUpate);
        }
    }

    private void clickInitInfo() {
        isClickIdentification = false;
        if (null != tempMark) {
            tempMark.setIcon(smallIdentificationBitmap);
            tempMark.hideInfoWindow();
            tempMark = null;
        }
        if (null != walkRouteOverlay) {
            walkRouteOverlay.removeFromMap();
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
    }
}
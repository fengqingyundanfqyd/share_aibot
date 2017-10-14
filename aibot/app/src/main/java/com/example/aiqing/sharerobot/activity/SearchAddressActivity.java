package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.amap.api.maps.model.animation.TranslateAnimation;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.bumptech.glide.Glide;
import com.esaysidebar.EasySideBarBuilder;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.LocationAdapter;
import com.example.aiqing.sharerobot.adapter.SearchAdapter;
import com.example.aiqing.sharerobot.utils.AMapUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.aiqing.sharerobot.utils.ChString.address;
import static com.wx.wheelview.util.WheelUtils.dip2px;

/*
* 搜索地址界面
* */
public class SearchAddressActivity extends AppCompatActivity implements View.OnClickListener, Inputtips.InputtipsListener, GeocodeSearch.OnGeocodeSearchListener {
    private final String[] mIndexItems = {};//头部额外的索引
    private MapView mViewMap;
    private AMap aMap;
    private AMapLocationClientOption mLocationClientOption;
    private AMapLocationClient mLocationClient;
    private EditText mEtSearchLocation;
    private ListView mLvLocation;
    private ListView mLvLocationSearch;
    private PoiSearch.Query mQuery;
    private ArrayList<PoiItem> poiItems;
    private List<SuggestionCity> mSuggestionCities;
    private String mProvince;
    private String mCity;
    private String mDistrict;
    private String mStreet;
    private String mStreetNum;
    private PoiSearch mPoiSearch;
    private ImageView mSearch;
    private ArrayList<PoiItem> mPois;
    private GeocodeSearch geocoderSearch;

    private double mLatitude1;
    private double mLongitude1;
    private Marker regeoMarker;
    private TextView mTvCityName;
    private String mGetCity;
    private Marker mScreenMarker;
    private ImageView mIvFrash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_address);
        initFindId();
        queryAddress();

        mViewMap = (MapView) findViewById(R.id.view_map);

        //初始化定位
        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        mViewMap.onCreate(savedInstanceState);
        initAMap();
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("新增收获地址");
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        topMenu.topMenuRight.setVisibility(View.GONE);

        //地址列表
        InputtipsQuery inputtipsQuery = new InputtipsQuery(address, "杭州");
        inputtipsQuery.setCityLimit(true);
        Inputtips inputtips = new Inputtips(SearchAddressActivity.this, inputtipsQuery);
        inputtips.setInputtipsListener(SearchAddressActivity.this);
        inputtips.requestInputtipsAsyn();

        initData();

    }

    private void queryAddress() {
        String s = "190000|190700|190600|190500|190403|190402|190401|190400|190311|190310|190309|190308|190307|190306|190305|190304|190303|190302|190301|190300|190205|190204|190203|190202|190201|190200|190109|190108|190107|190106|190105|190104|190103|190102|190101|190100";
        PoiSearch.Query query = new PoiSearch.Query(s, "");
        query.setPageSize(15);// 设置每页最多返回多少条poiitem
        //  mQuery1.setPageNum(currentPage);//设置查询页码
        mPoiSearch = new PoiSearch(this, query);
        mPoiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(mLatitude, mLongitude), 1000));
        mPoiSearch.searchPOIAsyn();
        mPoiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() {
            @Override
            public void onPoiSearched(PoiResult poiResult, int i) {
                Log.e("检索", "onPoiSearched: " + poiResult.getPois().get(1).getCityName() + poiResult.getPois().get(1).getAdName());

                //mCityinfo = poiResult.getPois().get(i).getCityName() + poiResult.getPois().get(i).getAdName();

                Log.e("检索2", "onPoiSearched: " + poiResult.getPois().get(0).getAdName());


//                mPois = poiResult.getPois();
//                LocationAdapter locationAdapter = new LocationAdapter(SearchAddressActivity.this, mPois);
//                 mLvLocation.setAdapter(locationAdapter);

            }

            @Override
            public void onPoiItemSearched(PoiItem poiItem, int i) {

            }
        });
    }

    private void initData() {
        //条目点击监听
        mLvLocation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchAddressActivity.this, "你点击了" + position, Toast.LENGTH_SHORT).show();
                TextView tv = (TextView) view.findViewById(R.id.tv);
                TextView info = (TextView) view.findViewById(R.id.info);
                //   String mStreetNum = tv.getText().toString();
                String cityinfo = info.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("mLatitude", mLatitude + "");
                intent.putExtra("mLongitude", mLongitude + "");
                intent.putExtra("mProvince", mProvince);//省
                intent.putExtra("cityinfo", cityinfo);
                intent.putExtra("mCity", mCity);//城区信息
                intent.putExtra("mDistrict", mDistrict);//街道信息
                intent.putExtra("mStreetNum", mStreetNum);//街道门牌号信息
                intent.putExtra("mCity", mCity);
                Toast.makeText(SearchAddressActivity.this, "经纬度" + mLongitude, Toast.LENGTH_SHORT).show();
                // intent.setClass(SearchAddressActivity.this, AddAddressActivity.class);
                setResult(2, intent);


                //intent.setClass(SearchAddressActivity.this, SubletReleaseActivity.class);
                setResult(3, intent);

                setResult(9, intent);

                setResult(12, intent);
                finish();
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = mEtSearchLocation.getText().toString().trim();
                InputtipsQuery inputtipsQuery = new InputtipsQuery(address, mCity);
                inputtipsQuery.setCityLimit(true);
                Inputtips inputtips = new Inputtips(SearchAddressActivity.this, inputtipsQuery);
                inputtips.setInputtipsListener(SearchAddressActivity.this);
                inputtips.requestInputtipsAsyn();

            }
        });


    }


    private void initFindId() {
        mSearch = (ImageView) findViewById(R.id.iv_search);
        mEtSearchLocation = (EditText) findViewById(R.id.et_searchlocation);
        mLvLocation = (ListView) findViewById(R.id.lv_location);
        mLvLocationSearch = (ListView) findViewById(R.id.lv_location_search);
        mTvCityName = (TextView) findViewById(R.id.tv_hangzhou);
        LinearLayout llAllCity = (LinearLayout) findViewById(R.id.ll_allcity);
        mIvFrash = (ImageView) findViewById(R.id.iv_fresh);

        ImageView ivAllCity = (ImageView) findViewById(R.id.iv_allcity);
        llAllCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 显示全国城市列表
                ArrayList<String> hotCityList = new ArrayList<>();
//                hotCityList.add("北京");
//                hotCityList.add("上海");
//                hotCityList.add("广州");
//                hotCityList.add("深圳");
//                hotCityList.add("杭州");
//                hotCityList.add("成都");
//                hotCityList.add("厦门");
//                hotCityList.add("天津");
//                hotCityList.add("武汉");
//                hotCityList.add("长沙");

                new EasySideBarBuilder(SearchAddressActivity.this)
                        .setTitle("城市选择")
                        /*.setIndexColor(Color.BLUE)*/
                        .setIndexColor(0xFF0095EE)
                       /* .isLazyRespond(true) //懒加载模式*/
                        .setHotCityList(hotCityList)//热门城市列表
                        .setIndexItems(mIndexItems)//索引字母
                        .setLocationCity(mCity)//定位城市
                        .setMaxOffset(60)//索引的最大偏移量
                        .start();
            }
        });

//        LocationAdapter locationAdapter = new LocationAdapter(this);
//        mLvLocation.setAdapter(locationAdapter);


        //点击搜索框  搜索框往左边执行动画  后获取输入信息
        mEtSearchLocation.setOnClickListener(this);
        //监听回车键
        mEtSearchLocation.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(SearchAddressActivity.this, "确认", Toast.LENGTH_SHORT).show();
                    //TODO 点击输入法搜索  进行匹配  隐藏地图  显示地址列表
                    mViewMap.setVisibility(View.GONE);
                    mLvLocationSearch.setVisibility(View.VISIBLE);
//                    LocationAdapter locationAdapter = new LocationAdapter(SearchAddressActivity.this,mPois);
//                    mLvLocationSearch.setAdapter(locationAdapter);
                }
                return false;
            }
        });

        mIvFrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIvFrash.setSelected(true);
                //刷新定位
                clickRefresh();
            }
        });

    }
    //刷新定位
    private void clickRefresh() {
        mLocationClient.startLocation();
        Glide.with(this).load(R.drawable.loading).into(mIvFrash);
    }

    @Override
    public void onClick(View v) {
        mViewMap.setVisibility(View.GONE);

    }

    private void initAMap() {
        if (aMap == null) {
            aMap = mViewMap.getMap();
            regeoMarker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        }
        setUpMap();
        //去掉高德地图右下角隐藏的缩放按钮
        aMap.getUiSettings().setZoomControlsEnabled(false);

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

        aMap.setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
            @Override
            public void onMapLoaded() {
                addMarkersToMap();
            }
        });
        aMap.setOnCameraChangeListener(new AMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {

            }

            @Override
            public void onCameraChangeFinish(CameraPosition cameraPosition) {
                addMarkersToMap();
                //屏幕中心的Marker跳动
                startJumpAnimation();

                if (mIvFrash.isSelected()) {
                    //加载菊花结束
                    mIvFrash.setImageResource(R.mipmap.icon_refresh);
                }
            }
        });

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

    //在地图上添加marker
    private void addMarkersToMap() {
        addMarkerInScreenCenter();
    }

    private void addMarkerInScreenCenter() {
        LatLng latLng = aMap.getCameraPosition().target;
        Point screenLocation = aMap.getProjection().toScreenLocation(latLng);
        MarkerOptions markerOptions = new MarkerOptions();
        mScreenMarker = aMap.addMarker(markerOptions.anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_move)));
        //设置Marker在屏幕上,不跟随地图移动
        mScreenMarker.setPositionByPixels(screenLocation.x, screenLocation.y);
    }

    private double lat;
    private double lon;

    private double mLatitude;
    private double mLongitude;
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
                    Log.e("杭州市", "onLocationChanged: " + mCity);
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
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.now));
                    markerOptions.icon(bitmapDescriptor);
                    aMap.addMarker(markerOptions);
                    initData();
                    queryAddress();
                    //添加marker
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewMap.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mViewMap.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mViewMap.onSaveInstanceState(outState);
    }


    @Override
    public void onGetInputtips(List<Tip> list, int i) {
        SearchAdapter searchAdapter = new SearchAdapter(this, list);
        mLvLocation.setAdapter(searchAdapter);
        LocationAdapter locationAdapter = new LocationAdapter(SearchAddressActivity.this, list);
        mLvLocationSearch.setAdapter(locationAdapter);
    }

    //数据回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case EasySideBarBuilder.CODE_SIDEREQUEST:
                if (data != null) {
                    mGetCity = data.getStringExtra("selected");
                    Toast.makeText(this, "选择的城市：" + mGetCity, Toast.LENGTH_SHORT).show();
                    getLatlgt(mGetCity);
                }
                break;

            default:
                break;
        }

    }
        //根据城市名获取经纬度
    private void getLatlgt(String mGetCity) {
        geocoderSearch = new GeocodeSearch(this);
        geocoderSearch.setOnGeocodeSearchListener(this);
        GeocodeQuery query = new GeocodeQuery(mGetCity.trim(), "29");
        geocoderSearch.getFromLocationNameAsyn(query);
    }

    //逆地理编码回调
    @Override
    public void onRegeocodeSearched(RegeocodeResult result, int rCode) {
        LatLonPoint latLonPoint = new LatLonPoint(mLatitude1, mLongitude1);
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getRegeocodeAddress() != null
                    && result.getRegeocodeAddress().getFormatAddress() != null) {
              String  addressName = result.getRegeocodeAddress().getFormatAddress()
                        + "附近";
                aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                        AMapUtil.convertToLatLng(latLonPoint), 15));
                regeoMarker.setPosition(AMapUtil.convertToLatLng(latLonPoint));
                Toast.makeText(SearchAddressActivity.this, addressName, Toast.LENGTH_SHORT).show();
                mTvCityName.setText(mGetCity);
            } else {
                Toast.makeText(SearchAddressActivity.this, "没有结果", Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(SearchAddressActivity.this, rCode, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        if (i == 1000) {
            if (geocodeResult != null) {
                if (geocodeResult.getGeocodeAddressList() != null) {
                    if (geocodeResult.getGeocodeAddressList().size() > 0) {
                        GeocodeAddress geocodeAddress = geocodeResult.getGeocodeAddressList().get(0);
                        mLatitude1 = geocodeAddress.getLatLonPoint().getLatitude();
                        mLongitude1 = geocodeAddress.getLatLonPoint().getLongitude();
                       Log.e("武汉市", "onGeocodeSearched: " + mLatitude1 + "   " + mLongitude1);
                        LatLonPoint latLonPoint = new LatLonPoint(mLatitude1, mLongitude1);
                        getAddress(latLonPoint);
                    }
                }
            }
        }
    }

    private void getAddress(LatLonPoint latLonPoint) {
        RegeocodeQuery query = new RegeocodeQuery(latLonPoint, 200,
                GeocodeSearch.AMAP);// 第一个参数表示一个Latlng，第二参数表示范围多少米，第三个参数表示是火系坐标系还是GPS原生坐标系
        geocoderSearch.getFromLocationAsyn(query);// 设置异步逆地理编码请求
    }
}

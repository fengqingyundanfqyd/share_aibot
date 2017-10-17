package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AddAddressBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
/*
*
* 新增地址
* */

public class AddAddressActivity extends AppCompatActivity implements View.OnClickListener, GeocodeSearch.OnGeocodeSearchListener {

    private EditText mEtName;
    private EditText mEtNumber;
    private String mName;
    private String mNumber;
    private LinearLayout mLlDetailAddress;
    private Intent mIntent;
    private LinearLayout mLlName;
    private LinearLayout mLlNumber;
    private ImageView mIvSwitch;
    private EditText mEtDetailAdd;
    private String mName1;
    private String mNum;
    private String mDeadd;
    private String mMLatitude;
    private String mMLongitude;
    private String mMProvince;
    private String mMCity;
    private String mMDistrict;
    private String mMStreetNum;
    private String mAddressName;
    private TextView mTvGetDetail;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_address);

        getData();
        initFindId();

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        final String sid = spcookie.getString("mCookie", "");
        final HttpTool httpTool = new HttpTool(this);

        mIvSwitch.setTag("0");
        mIvSwitch.setImageResource(R.mipmap.switch_off);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("新增收获地址");
        topMenu.topMenuRight.setText("保存");
        topMenu.topMenuRight.setVisibility(View.VISIBLE);
        topMenu.topMenuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoadingDialog = DialogUtil.createLoadingDialog(AddAddressActivity.this, "加载中...");
                if (mEtName != null && mEtNumber != null) {
                    mName1 = mEtName.getText().toString().trim();
                    mNum = mEtNumber.getText().toString().trim();
                    mDeadd = mEtDetailAdd.getText().toString().trim();

                    Retrofit builder = new Retrofit.Builder()
                            .client(httpTool.client())
                            .baseUrl("http://120.132.117.157:8083/account/saveCustAddInfo.shtml")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ApiService apiService = builder.create(ApiService.class);

                    Call<AddAddressBean> call = apiService.saveaddress(sid, mName1, mNum, mMProvince, mMCity, mMDistrict, "", "", "", mDeadd, mDeadd, mIvSwitch.getTag().toString(), mMLongitude, mMLatitude, mMStreetNum);
                    call.enqueue(new Callback<AddAddressBean>() {
                        @Override
                        public void onResponse(Response<AddAddressBean> response, Retrofit retrofit) {
                            DialogUtil.closeDialog(mLoadingDialog);
                        //    Log.e("测试", "onResponse: " + response.body().isSuccess());
//                            Intent intent=new Intent(AddAddressActivity.this,PersonalInfoActivity.class);
//                            startActivity(intent);
                            if (response.body().getCoder().equals("0000")){
                                Toast.makeText(AddAddressActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(AddAddressActivity.this, response.body().getErrorMsg()+"", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("测试", "onFailure: " + "666");
                            Toast.makeText(AddAddressActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mIntent = new Intent();
                    // mIntent.setClass(AddAddressActivity.this, ApplyRentActivity.class);

                    mIntent.putExtra("name", mEtName.getText().toString().trim());
                    mIntent.putExtra("number", mEtNumber.getText().toString().trim());
                    mIntent.putExtra("detaadd", mEtDetailAdd.getText().toString().trim());

                    setResult(250, mIntent);

                }
            }
        });
        //点击地址跳转到SearchAddressActicity
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddAddressActivity.this, ApplyRentActivity.class);
                startActivity(intent);
                AddAddressActivity.this.finish();
            }
        });

        setOnClick();
    }

    private void getData() {
        GeocodeSearch geocodeSearch = new GeocodeSearch(this);
        geocodeSearch.setOnGeocodeSearchListener(this);

    }

    private void setOnClick() {
        mLlDetailAddress.setOnClickListener(this);
    }

    private void initFindId() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtNumber = (EditText) findViewById(R.id.et_number);
        mLlDetailAddress = (LinearLayout) findViewById(R.id.ll_detailaddress);
        mLlName = (LinearLayout) findViewById(R.id.ll_name);
        mLlNumber = (LinearLayout) findViewById(R.id.ll_nunber);
        mIvSwitch = (ImageView) findViewById(R.id.iv_switch);
        mEtDetailAdd = (EditText) findViewById(R.id.et_detailadd);
        mTvGetDetail = (TextView) findViewById(R.id.tv_getdetailadd);
        mLlName.setOnClickListener(this);
        mLlNumber.setOnClickListener(this);
        mIvSwitch.setOnClickListener(this);
        //设置开关状态  默认
        mIvSwitch.setImageResource(R.mipmap.switch_off);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 2 && data != null) {
            Bundle bundle = data.getExtras();
            mMLatitude = bundle.getString("mLatitude");
            mMLongitude = bundle.getString("mLongitude");
            mMProvince = bundle.getString("mProvince");
            mMCity = bundle.getString("mCity");
            mMDistrict = bundle.getString("mDistrict");//街道信息
            mMStreetNum = bundle.getString("mStreetNum");//街道门牌号信息
            String mCity = bundle.getString("mCity");
            String cityinfo = bundle.getString("cityinfo");
            Toast.makeText(this, mCity, Toast.LENGTH_SHORT).show();
            // Toast.makeText(this, "收到999"+ mMCity, Toast.LENGTH_SHORT).show();

            mLlDetailAddress.setVisibility(View.GONE);
            mTvGetDetail.setVisibility(View.VISIBLE);
            mTvGetDetail.setText(mMProvince + mMCity + mMDistrict + cityinfo);
            Log.e("姓名", "onActivityResult: " + mMLatitude + mMLongitude);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_detailaddress:
                Intent intent = new Intent();
                intent.setClass(AddAddressActivity.this, SearchAddressActivity.class);
                startActivityForResult(intent, 2);
                break;
            case R.id.ll_name:

                break;
            case R.id.ll_nunber:

                break;
            case R.id.iv_switch:
                if (mIvSwitch.getTag().equals("0")) {
                    mIvSwitch.setTag("1");
                    mIvSwitch.setImageResource(R.mipmap.switch_on);
                } else {
                    mIvSwitch.setTag("0");
                    mIvSwitch.setImageResource(R.mipmap.switch_off);
                }

                break;
        }
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int rCode) {
        if (rCode == AMapException.CODE_AMAP_SUCCESS) {
            if (geocodeResult != null && geocodeResult.getGeocodeAddressList() != null && geocodeResult.getGeocodeAddressList().size() > 0) {
                GeocodeAddress address = geocodeResult.getGeocodeAddressList().get(0);
                mAddressName = "经纬度值:" + address.getLatLonPoint() + "\n位置描述:" + address.getFormatAddress();
                Log.e("位置描述", "onGeocodeSearched: " + mAddressName);
            }
        }

    }
}

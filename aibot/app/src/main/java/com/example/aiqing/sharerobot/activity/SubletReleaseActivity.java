package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.MainActivity;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ChangeRentReleaseBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 转租发布
 */
public class SubletReleaseActivity extends AppCompatActivity implements View.OnClickListener {

    private String mNumber;
    private String mBeizhu;
    private String mProductId;
    private EditText mEtChangePhone;
    private EditText mEtZhuanBei;
    private String mLatitude;
    private String mLongitude;
    private String mProvince;
    private String mCity;
    private String mStreetNum;
    private String mAddress;
    private LinearLayout mLlAddress;
    private TextView mTvAddress;
    private TextView mTvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sublet_release);

        initId();

    }

    private void initId() {
        RelativeLayout rlServiceAddress = (RelativeLayout) findViewById(R.id.rl_serviceaddress);
        mEtChangePhone = (EditText) findViewById(R.id.et_changephone);

        mEtZhuanBei = (EditText) findViewById(R.id.et_zhuanzu);

        Button btnSaveReleast = (Button) findViewById(R.id.btn_save_release);
        ImageView ivZhuanzuRelease = (ImageView) findViewById(R.id.top_zhuanzu_release);

        mLlAddress = (LinearLayout) findViewById(R.id.ll_sublet_address);
        mTvAddress = (TextView) findViewById(R.id.tv_s_address);
        mTvProduct = (TextView) findViewById(R.id.tv_product);

        ivZhuanzuRelease.setOnClickListener(this);

        rlServiceAddress.setOnClickListener(this);
        btnSaveReleast.setOnClickListener(this);

        Intent intent = getIntent();
        mProductId = intent.getStringExtra("productId");
        mTvProduct.setText(mProductId);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_save_release:
                // 保存  跳转到转租界面
//                intent.setClass(SubletReleaseActivity.this,SubletActivity.class);
//                startActivity(intent);
//                finish();
                toSave();
                break;
            case R.id.top_zhuanzu_release:
                //返回
                finish();
                break;
            case R.id.rl_serviceaddress:
                //服务地址 跳到搜索地址界面  返回地址信息
                intent.setClass(SubletReleaseActivity.this, SearchAddressActivity.class);
                startActivityForResult(intent, 3);
                break;

        }
    }

    private void toSave() {
        mNumber = mEtChangePhone.getText().toString().trim();
        mBeizhu = mEtZhuanBei.getText().toString();
        if (!mNumber.equals("") && !mBeizhu.equals("")) {
            initHttp();
        } else if (mNumber.equals("")) {
            Toast.makeText(this, "请填写手机号码", Toast.LENGTH_SHORT).show();
        } else if (mBeizhu.equals("")) {
            Toast.makeText(this, "请填写备注信息", Toast.LENGTH_SHORT).show();
        }

    }

    private void initHttp() {
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/custReletApply/updateOrSave.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ChangeRentReleaseBean> call = apiService.changeRent(cookie, mProductId, "1", mAddress, mNumber, mLongitude, mLatitude, mBeizhu);
        call.enqueue(new Callback<ChangeRentReleaseBean>() {
            @Override
            public void onResponse(Response<ChangeRentReleaseBean> response, Retrofit retrofit) {
                Object obj = response.body().getObj();
                String s = String.valueOf(obj);
                if (s.equals("1.0")) {
                    Toast.makeText(SubletReleaseActivity.this, "转租发布成功。", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(SubletReleaseActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(SubletReleaseActivity.this, "请您检查网络...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 3 && data != null) {
            Bundle bundle = data.getExtras();
            mLatitude = bundle.getString("mLatitude");
            mLongitude = bundle.getString("mLongitude");
            mProvince = bundle.getString("mProvince");
            mCity = bundle.getString("mCity");
            String district = bundle.getString("mDistrict");//街道信息
            //街道门牌号信息
            mStreetNum = bundle.getString("mStreetNum");
            mAddress = mProvince + mCity + mStreetNum;

            mLlAddress.setVisibility(View.GONE);
            mTvAddress.setVisibility(View.VISIBLE);
            mTvAddress.setText(mAddress);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}

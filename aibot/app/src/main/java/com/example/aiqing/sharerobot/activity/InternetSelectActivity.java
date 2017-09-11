package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ReturnAibotBean;
import com.example.aiqing.sharerobot.bean.SelectShopBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 网点选择  退货
 */
public class InternetSelectActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnReturn;
    private TextView mTvName;
    private TextView mTvBuild;
    private TextView mTvPhone;
    private TextView mTvAddress;
    private TextView mTvDistance;
    private TextView mTvOpenTime;
    private TextView mTvCloseTime;
    private ImageView mIvClose;
    private String mCookie;
    private HttpTool mHttpTool;
    private String mProductId;
    private String mDistributorId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_select);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("网点选择");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        initId();

        initHttp();

    }

    private void initHttp() {

        Intent intent = getIntent();
        mProductId = intent.getStringExtra("productId");

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/dotSelection.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<SelectShopBean> call = apiService.selectshop(mCookie, mProductId, "120.176088", "30.327277", "1", "5");
        call.enqueue(new Callback<SelectShopBean>() {
            @Override
            public void onResponse(Response<SelectShopBean> response, Retrofit retrofit) {

                if (response.body().getDefaultDot() != null) {
                    mTvName.setText(response.body().getDefaultDot().getName());
                    mTvBuild.setText(response.body().getDefaultDot().getBuilding());
                    mTvPhone.setText(response.body().getDefaultDot().getContact1() + "");
                    mTvAddress.setText(response.body().getDefaultDot().getAddress());
                    mTvDistance.setText(response.body().getDefaultDot().getDistance() + "米");
                    mTvOpenTime.setText(response.body().getDefaultDot().getOpenTime() + "");
                    mTvCloseTime.setText(response.body().getDefaultDot().getClosedTime() + "");
                    String isClosed = response.body().getDefaultDot().getIsClosed();
                    if (isClosed.equals("0")) {
                        mIvClose.setVisibility(View.VISIBLE);
                    } else if (isClosed.equals("1")) {
                        mIvClose.setVisibility(View.GONE);
                    }

                    mDistributorId = response.body().getDefaultDot().getDistributorId();

                }
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(InternetSelectActivity.this, "连接网络失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initId() {
        mBtnReturn = (Button) findViewById(R.id.btn_apply_return);
        mTvName = (TextView) findViewById(R.id.tv_chenge_shopname);
        mTvBuild = (TextView) findViewById(R.id.tv_building_name);
        mTvPhone = (TextView) findViewById(R.id.tv_change_shopphone);
        mTvAddress = (TextView) findViewById(R.id.tv_change_shopaddress);
        mTvDistance = (TextView) findViewById(R.id.tv_shop_distance);
        mTvOpenTime = (TextView) findViewById(R.id.tv_shop_time_open);
        mTvCloseTime = (TextView) findViewById(R.id.tv_shop_time_close);
        mIvClose = (ImageView) findViewById(R.id.iv_isclose);

        mBtnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String test = "123";//测试用
        switch (v.getId()) {
            //申请还
            case R.id.btn_apply_return:
                returnRobot();
//                Intent intent=new Intent();
//                intent.setClass(InternetSelectActivity.this,MyAibotActivity.class);
//                intent.putExtra("test",test);
//                setResult(110,intent);
//                finish();
                break;
        }
    }

    private void returnRobot() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/returnMyRobot/return.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ReturnAibotBean> call = apiService.returnRobot(mCookie, mProductId, mDistributorId);
        call.enqueue(new Callback<ReturnAibotBean>() {
            @Override
            public void onResponse(Response<ReturnAibotBean> response, Retrofit retrofit) {
                int obj = response.body().getObj();
                if (obj == 1) {
                    Toast.makeText(InternetSelectActivity.this, "申请成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(InternetSelectActivity.this, Main2Activity.class);
                    startActivity(intent);
                } else if (obj == 0) {
                    Toast.makeText(InternetSelectActivity.this, "申请失败！", Toast.LENGTH_SHORT).show();
                    finish();
                }
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(InternetSelectActivity.this, "连接网络失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

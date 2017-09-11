package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.TouOrderBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
//投放商订单租赁明细
public class LeaseDetailActivity extends AppCompatActivity {

    private String mCookie;
    private HttpTool mHttpTool;
    private String mMPaId;
    private TextView mTvPhone;
    private TextView mTvStatus;
    private TextView mTvTime;
    private TextView mTvBei;
    private Dialog mLoadingDialog;
    private TextView mTvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lease_detail);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("租赁明细");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        Intent intent = getIntent();
        mMPaId = intent.getStringExtra("mPaId");

        initId();

        initDataHttp();

    }

    private void initId() {
        mTvPhone = (TextView) findViewById(R.id.tv_order_phone);
        mTvStatus = (TextView) findViewById(R.id.tv_order_status);
        mTvTime = (TextView) findViewById(R.id.tv_order_creattime);
        mTvBei = (TextView) findViewById(R.id.tv_orderbei);
        mTvId = (TextView) findViewById(R.id.tv_aibot_id);

    }

    private void initDataHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/rentMessage.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<TouOrderBean> call = apiService.touOrder(mCookie, mMPaId);
        call.enqueue(new Callback<TouOrderBean>() {
            @Override
            public void onResponse(Response<TouOrderBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null){

                    mTvPhone.setText(response.body().getApply().getMobile()+"");
                    mTvStatus.setText(response.body().getApply().getStatus());
                    mTvTime.setText(response.body().getApply().getCreateTime()+"");
                    mTvBei.setText(response.body().getApply().getRemark());

                }
            }
            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(LeaseDetailActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

}

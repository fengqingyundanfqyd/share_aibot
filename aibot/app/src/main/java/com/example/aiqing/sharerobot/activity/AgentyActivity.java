package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AngentyBean;
import com.example.aiqing.sharerobot.bean.DaiInfoBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 代理商管理
 */
public class AgentyActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvHaveSend;
    private TextView mTvDaisend;
    private TextView mTvMytotal;
    private TextView mTvKucun;
    private LinearLayout mLlJinhuo;

    private String mSid;
    private TextView mTvRealname;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activit_agenty);
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");

        initFindId();
        initHttp();

    }

    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = data.getString("agencyId", "");
        HttpTool httpTool=new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/orderByApply.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AngentyBean> call = apiService.orderManager(mSid, agencyId);

        call.enqueue(new Callback<AngentyBean>() {
            @Override
            public void onResponse(Response<AngentyBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                mTvHaveSend.setText(response.body().getShipmentNum() + "");
                mTvDaisend.setText(response.body().getToDeliveNum() + "");
                mTvMytotal.setText(response.body().getTotal() + "");
                mTvKucun.setText(response.body().getStock() + "");
                //TODO 代理商名称从本地获取
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(AgentyActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });


        Retrofit builderN = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/agencyInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiServiceN = builderN.create(ApiService.class);
        Call<DaiInfoBean> callN = apiServiceN.getDaiInfo(mSid, agencyId);
        callN.enqueue(new Callback<DaiInfoBean>() {
            @Override
            public void onResponse(Response<DaiInfoBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    String realName = response.body().getObj().getRealName();
                    String headImg = (String) response.body().getObj().getHeadImg();
                    mTvRealname.setText(realName);
                }else {
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    private void initFindId() {
        RelativeLayout rlOrderManager = (RelativeLayout) findViewById(R.id.rl_ordermanager);
        RelativeLayout rlKucum = (RelativeLayout) findViewById(R.id.rl_kucun);
        mTvHaveSend = (TextView) findViewById(R.id.tv_have_send);
        mTvDaisend = (TextView) findViewById(R.id.tv_daisend);
        mTvMytotal = (TextView) findViewById(R.id.tv_mytotal);
        mTvKucun = (TextView) findViewById(R.id.tv_kucun);
        mLlJinhuo = (LinearLayout) findViewById(R.id.ll_jinhuo_daili);
        ImageView ivLeftD = (ImageView) findViewById(R.id.iv_left_daim);
        mTvRealname = (TextView) findViewById(R.id.tv_realname);

        //点击查看订单详情
        rlOrderManager.setOnClickListener(this);
        rlKucum.setOnClickListener(this);
        mLlJinhuo.setOnClickListener(this);
        ivLeftD.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.rl_ordermanager:
                //跳转到订单管理
                intent.setClass(AgentyActivity.this, OrderManagerActivity.class);
                startActivity(intent);
                AgentyActivity.this.finish();
                break;
            case R.id.rl_kucun:
                //跳转到库存
                intent.setClass(AgentyActivity.this, StockActivity.class);
                startActivity(intent);
                AgentyActivity.this.finish();
                break;
            case R.id.ll_jinhuo_daili:
                //我要进货
                intent.setClass(AgentyActivity.this, GetGoodsActivity.class);
                startActivity(intent);
                AgentyActivity.this.finish();
                break;
            case R.id.iv_left_daim:
                finish();
                break;
        }

    }

}

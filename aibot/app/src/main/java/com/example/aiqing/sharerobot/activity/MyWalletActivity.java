package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AccountInfoBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 我的钱包
 */
public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvBalance;
    private TextView mTvCdeposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initId();
        getData();
    }

    private void getData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
       String cookie = spcookie.getString("mCookie", "");
        HttpTool  httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getAccInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AccountInfoBean> call = apiService.getAccountinfo(cookie);
        call.enqueue(new Callback<AccountInfoBean>() {
            @Override
            public void onResponse(Response<AccountInfoBean> response, Retrofit retrofit) {
                if (response.body().getCoder().equals("0000")){
                    DialogUtil.closeDialog(loadingDialog);
                    double balance = response.body().getObj().getBalance();//余额
                    mTvBalance.setText(balance+"");
                    double cDeposit = response.body().getObj().getCDeposit();//用户押金
                    mTvCdeposit.setText(cDeposit+"");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(loadingDialog);
                Toast.makeText(MyWalletActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initId() {
        ImageView iv_mywallet_return = (ImageView) findViewById(R.id.iv_mywallet_return);
        Button btnDetaile = (Button) findViewById(R.id.btn_detaile);
        Button btn_putin = (Button) findViewById(R.id.btn_putin);
        Button btn_getout = (Button) findViewById(R.id.btn_getout);
        RelativeLayout rl_mymoney = (RelativeLayout) findViewById(R.id.rl_mymoney);
        RelativeLayout rl_myfress = (RelativeLayout) findViewById(R.id.rl_myfress);
        mTvBalance = (TextView) findViewById(R.id.tv_balance_mine);
        mTvCdeposit = (TextView) findViewById(R.id.tv_cdeposit);

        btnDetaile.setOnClickListener(this);
        btn_putin.setOnClickListener(this);
        btn_getout.setOnClickListener(this);
        iv_mywallet_return.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_detaile:
                //明细
                intent.setClass(this, MoneyDetailingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_putin:
                //充值
                intent.setClass(this, RechargeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_getout:
                //提现
                intent.setClass(this, WithdrawalsActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_mywallet_return:
//                intent.setClass(this, Main2Activity.class);
//                startActivity(intent);
                finish();
                break;
        }
    }
}

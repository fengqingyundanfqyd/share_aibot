package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aiqing.sharerobot.R;

/**
 * 我的钱包
 */
public class MyWalletActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        initId();
    }

    private void initId() {
        ImageView iv_mywallet_return = (ImageView) findViewById(R.id.iv_mywallet_return);
        Button btnDetaile = (Button) findViewById(R.id.btn_detaile);
        Button btn_putin = (Button) findViewById(R.id.btn_putin);
        Button btn_getout = (Button) findViewById(R.id.btn_getout);
        RelativeLayout rl_mymoney = (RelativeLayout) findViewById(R.id.rl_mymoney);
        RelativeLayout rl_myfress = (RelativeLayout) findViewById(R.id.rl_myfress);
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

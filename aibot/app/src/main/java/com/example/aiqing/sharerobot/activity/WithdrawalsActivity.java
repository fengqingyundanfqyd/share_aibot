package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * 提现
 */
public class WithdrawalsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawals);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("提现");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        initId();
    }

    private void initId() {
        RelativeLayout rlAddCard = (RelativeLayout) findViewById(R.id.rl_add_ic_card);
        EditText etWithdrawals = (EditText) findViewById(R.id.et_withdrawals);
        Button btnWithdrawals = (Button) findViewById(R.id.btn_sure_withdrawals);

        rlAddCard.setOnClickListener(this);
        btnWithdrawals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_add_ic_card:
                //选择银行卡
                Intent intent=new Intent();
                intent.setClass(WithdrawalsActivity.this,SelectCardActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sure_withdrawals:
                break;
        }
    }
}

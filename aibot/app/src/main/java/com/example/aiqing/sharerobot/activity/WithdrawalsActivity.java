package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DoCashApplyBean;
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
 * 提现
 */
public class WithdrawalsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtWithdrawals;
    private String mCardId;

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
        mEtWithdrawals = (EditText) findViewById(R.id.et_withdrawals);
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
                String account = mEtWithdrawals.getText().toString().trim();
                doCash(account);
                break;
        }
    }

    private void doCash(String account) {
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        final  String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/bank/bankType.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DoCashApplyBean> call = apiService.doCashApply(cookie, account, mCardId);
        call.enqueue(new Callback<DoCashApplyBean>() {
            @Override
            public void onResponse(Response<DoCashApplyBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")){
                    Toast.makeText(WithdrawalsActivity.this, "申请体现成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(WithdrawalsActivity.this, response.body().getErrorMsg().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==15){
            Bundle bundle = data.getExtras();
            mCardId = bundle.getString("cardId");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

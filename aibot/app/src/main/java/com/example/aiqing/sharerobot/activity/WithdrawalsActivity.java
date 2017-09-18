package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.BankListBean;
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
    private LinearLayout mLlBankinfo;
    private TextView mTvAddbankcard;
    private TextView mTvCardnum;
    private TextView mTvBankname;
    private String mCookie;
    private HttpTool mHttpTool;
    private String oldcardid;
    private String cardId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawals);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("提现");
        topMenu.topMenuRight.setText("历史");
        topMenu.topMenuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(WithdrawalsActivity.this,DoCashRecordActivity.class);
                startActivity(intent);
            }
        });
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initId();
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        getData();
    }

    private void getData() {

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/bank/bankList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<BankListBean> call = apiService.getBanklist(mCookie);
        call.enqueue(new Callback<BankListBean>() {

            @Override
            public void onResponse(Response<BankListBean> response, Retrofit retrofit) {
                if (response.body().getObj().size()>=0){
                 
                    String accountName = response.body().getObj().get(0).getAccountName();
                    String cardNo = response.body().getObj().get(0).getCardNo();
                    String num = cardNo.substring(cardNo.length() - 4, cardNo.length());
                    mLlBankinfo.setVisibility(View.VISIBLE);
                    mTvAddbankcard.setVisibility(View.GONE);
                    mTvBankname.setText(accountName);
                    mTvCardnum.setText("尾号"+num);
                    oldcardid = response.body().getObj().get(0).getCardId();
                    Log.e("银行卡id", "onResponse: "+ oldcardid);
                    mLlBankinfo.setSelected(true);
                }else {
                    mLlBankinfo.setVisibility(View.GONE);
                    mTvAddbankcard.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void initId() {
        RelativeLayout rlAddCard = (RelativeLayout) findViewById(R.id.rl_add_ic_card);
        mEtWithdrawals = (EditText) findViewById(R.id.et_withdrawals);
        Button btnWithdrawals = (Button) findViewById(R.id.btn_sure_withdrawals);
        ImageView ivClean = (ImageView) findViewById(R.id.iv_clean);
        mTvBankname = (TextView) findViewById(R.id.tv_bankname);
        mTvCardnum = (TextView) findViewById(R.id.tv_cardnum);
        mTvAddbankcard = (TextView) findViewById(R.id.tv_addbankcard);
        mLlBankinfo = (LinearLayout) findViewById(R.id.ll_bankinfo);

        rlAddCard.setOnClickListener(this);
        btnWithdrawals.setOnClickListener(this);
        ivClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_add_ic_card:
                //选择银行卡
                Intent intent = new Intent();
                intent.setClass(WithdrawalsActivity.this, SelectCardActivity.class);
                startActivityForResult(intent,15);
                break;
            case R.id.btn_sure_withdrawals:
                String account = mEtWithdrawals.getText().toString().trim();
                doCash(account);
                break;
            case R.id.iv_clean:
                mEtWithdrawals.setFocusable(true);
                mEtWithdrawals.setFocusableInTouchMode(true);
                mEtWithdrawals.requestFocus();
                mEtWithdrawals.setText("");
                break;
        }
    }

    private void doCash(String account) {

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

        if (mLlBankinfo.isSelected()) {
            cardId =oldcardid;
        }else {
            cardId=mCardId;
        }
            Retrofit builder = new Retrofit.Builder()
                    .client(mHttpTool.client())
                    .baseUrl("http://120.132.117.157:8083/bank/bankType.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<DoCashApplyBean> call = apiService.doCashApply(mCookie, account, cardId);
            call.enqueue(new Callback<DoCashApplyBean>() {
                @Override
                public void onResponse(Response<DoCashApplyBean> response, Retrofit retrofit) {
                    DialogUtil.closeDialog(loadingDialog);
                    if (response.body().getCoder().equals("0000")) {
                        Toast.makeText(WithdrawalsActivity.this, "申请提现成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(WithdrawalsActivity.this, response.body().getErrorMsg().toString(), Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 15) {
            Bundle bundle = data.getExtras();
            mCardId = bundle.getString("cardId");
            String banknum = bundle.getString("banknum");
            String bankname = bundle.getString("bankname");
            mLlBankinfo.setVisibility(View.VISIBLE);
            mTvAddbankcard.setVisibility(View.GONE);
            mTvBankname.setText(bankname);
            mTvCardnum.setText(banknum);
            Log.e("银行卡信息", "onActivityResult: "+ bankname+banknum);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

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
import com.example.aiqing.sharerobot.bean.AccountInfoBean;
import com.example.aiqing.sharerobot.bean.BankListBean;
import com.example.aiqing.sharerobot.bean.DoCashApplyBean;
import com.example.aiqing.sharerobot.bean.GetSystemTimeBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.aiqing.sharerobot.R.id.tv_docash_detail_time;

/**
 * 提现
 */
public class WithdrawalsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtWithdrawals;
    private LinearLayout mLlBankinfo;
    private TextView mTvAddbankcard;
    private TextView mTvCardnum;
    private TextView mTvBankname;
    private String mCookie;
    private HttpTool mHttpTool;
    private String cardId;
    private TextView mTvToday;
    private TextView mTvDocashData;
    private TextView mTvDocashDetailTime;
    private TextView mTvLessday;
    private TextView mTvBalance;
    private String bCardId=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdrawals);

        initId();
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        getData();
        getDoCashTime();
        initBalance();
    }

    private void initBalance() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getAccInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AccountInfoBean> call = apiService.getAccountinfo(mCookie);
        call.enqueue(new Callback<AccountInfoBean>() {
            @Override
            public void onResponse(Response<AccountInfoBean> response, Retrofit retrofit) {
                if (response.body().getCoder().equals("0000")){
                    DialogUtil.closeDialog(loadingDialog);
                    double balance = response.body().getObj().getBalance();//余额
                    mTvBalance.setText(balance+"");

                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(loadingDialog);
                Toast.makeText(WithdrawalsActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDoCashTime() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/comm/dictionaryGeneric.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<GetSystemTimeBean> call = apiService.getTime(mCookie, "withdraw_cash");
        call.enqueue(new Callback<GetSystemTimeBean>() {
            @Override
            public void onResponse(Response<GetSystemTimeBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                String systemTime = response.body().getObj().getSystemTime();
                String paramValue = response.body().getObj().getParamValue();
                Log.e("提现日期", "onResponse: "+ systemTime+paramValue);
                //2017-09-19 11:06:15
                //6,13,19,20,28
                String[] split = systemTime.split(" ");
                String data = split[0];
                String[] split1 = data.split("-");
                String time = split1[1] + "-" + split1[2];
                Log.e("今天日期", "onResponse: "+time );
                mTvToday.setText("今日"+time+":");
                String[] split2 = time.split("-");
                String last = split2[1];
                if (paramValue.contains(last)){
                    mTvDocashData.setText("提现日");
                }else {
                    mTvDocashData.setText("非提现日");
                }
                mTvDocashDetailTime.setText("提现日:分别为每月的 "+paramValue+" 号");

                String[] split3 = paramValue.split(",");

                for (int i = 0; i <split3.length ; i++) {

                if (Integer.parseInt(split3[0])-Integer.parseInt(last)>0){
                        mTvLessday.setText((Integer.parseInt(split3[0])-Integer.parseInt(last))+"天");
                    }else  if (Integer.parseInt(split3[1])-Integer.parseInt(last)>0){
                        mTvLessday.setText((Integer.parseInt(split3[1])-Integer.parseInt(last))+"天");
                    }else if (Integer.parseInt(split3[2])-Integer.parseInt(last)>0){
                        mTvLessday.setText((Integer.parseInt(split3[2])-Integer.parseInt(last))+"天");
                    } else if (Integer.parseInt(split3[3])-Integer.parseInt(last)>0){
                        mTvLessday.setText((Integer.parseInt(split3[3])-Integer.parseInt(last))+"天");
                    }else  if (Integer.parseInt(split3[4])-Integer.parseInt(last)>0){
                        mTvLessday.setText((Integer.parseInt(split3[4])-Integer.parseInt(last))+"天");
                    }
                    //当前日期大于提现日期
                    String month = split1[1];
                    if (month.equals("01")||month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12")&&Integer.parseInt(last)-Integer.parseInt(split3[0])>0){
                        mTvLessday.setText((31-Integer.parseInt(last)+Integer.parseInt(split3[0])+""));
                    }else if (month.equals("02")&&Integer.parseInt(last)-Integer.parseInt(split3[0])>0){
                        mTvLessday.setText((28-Integer.parseInt(last)+Integer.parseInt(split3[0])+""));
                    }
                    if (month.equals("01")||month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12")&&Integer.parseInt(last)-Integer.parseInt(split3[1])>0){
                        mTvLessday.setText((31-Integer.parseInt(last)+Integer.parseInt(split3[1])+""));
                    }else if (month.equals("02")&&Integer.parseInt(last)-Integer.parseInt(split3[1])>0){
                        mTvLessday.setText((28-Integer.parseInt(last)+Integer.parseInt(split3[1])+""));
                    }
                    if (month.equals("01")||month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12")&&Integer.parseInt(last)-Integer.parseInt(split3[2])>0){
                        mTvLessday.setText((31-Integer.parseInt(last)+Integer.parseInt(split3[2])+""));
                    }else if (month.equals("02")&&Integer.parseInt(last)-Integer.parseInt(split3[2])>0){
                        mTvLessday.setText((28-Integer.parseInt(last)+Integer.parseInt(split3[2])+""));
                    }
                    if (month.equals("01")||month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12")&&Integer.parseInt(last)-Integer.parseInt(split3[3])>0){
                        mTvLessday.setText((31-Integer.parseInt(last)+Integer.parseInt(split3[3])+""));
                    }else if (month.equals("02")&&Integer.parseInt(last)-Integer.parseInt(split3[3])>0){
                        mTvLessday.setText((28-Integer.parseInt(last)+Integer.parseInt(split3[3])+""));
                    }
                    if (month.equals("01")||month.equals("03")||month.equals("05")||month.equals("07")||month.equals("08")||month.equals("10")||month.equals("12")&&Integer.parseInt(last)-Integer.parseInt(split3[4])>0){
                        mTvLessday.setText((31-Integer.parseInt(last)+Integer.parseInt(split3[4])+""));
                    }else if (month.equals("02")&&Integer.parseInt(last)-Integer.parseInt(split3[4])>0){
                        mTvLessday.setText((28-Integer.parseInt(last)+Integer.parseInt(split3[4])+""));
                    }


                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void getData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
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
                DialogUtil.closeDialog(loadingDialog);

                if (response.body().getObj().size()>0){
                    String accountName = response.body().getObj().get(0).getAccountName();
                    String cardNo = response.body().getObj().get(0).getCardNo();
                    String num = cardNo.substring(cardNo.length() - 4, cardNo.length());
                    mLlBankinfo.setVisibility(View.VISIBLE);
                    mTvAddbankcard.setVisibility(View.GONE);
                    mTvBankname.setText(accountName);
                    mTvCardnum.setText("尾号"+num);
                   String oldcardid = response.body().getObj().get(0).getCardId();
                    Log.e("银行卡id", "onResponse: "+ oldcardid);
                    bCardId=oldcardid;
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
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_withdrawal_return);
        Button btnHistory = (Button) findViewById(R.id.btn_history);
        mTvToday = (TextView) findViewById(R.id.tv_today);
        mTvDocashData = (TextView) findViewById(R.id.tv_docash_data);
        mTvLessday = (TextView) findViewById(R.id.tv_lessday);
        mTvDocashDetailTime = (TextView) findViewById(tv_docash_detail_time);
        mTvBalance = (TextView) findViewById(R.id.tv_balance_docash);

        rlAddCard.setOnClickListener(this);
        btnWithdrawals.setOnClickListener(this);
        ivClean.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.rl_add_ic_card:
                //选择银行卡
               // Intent intent = new Intent();
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
            case R.id.iv_withdrawal_return:
                finish();
                break;
            case R.id.btn_history:
               //历史
                intent.setClass(WithdrawalsActivity.this,DoCashRecordActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void doCash(String account) {

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

            Retrofit builder = new Retrofit.Builder()
                    .client(mHttpTool.client())
                    .baseUrl("http://120.132.117.157:8083/bank/bankType.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<DoCashApplyBean> call = apiService.doCashApply(mCookie, account, bCardId);
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
        if (requestCode == 15&&data!=null) {

                Bundle bundle = data.getExtras();
                String banknum = bundle.getString("banknum");
            String bankname = bundle.getString("bankname");
          // String mCardId = bundle.getString("cardId");
            mLlBankinfo.setVisibility(View.VISIBLE);
                mTvAddbankcard.setVisibility(View.GONE);
                mTvBankname.setText(bankname);
                mTvCardnum.setText(banknum);
                Log.e("银行卡信息", "onActivityResult: " + bankname + banknum);
            BankListBean.ObjBean bean = (BankListBean.ObjBean) bundle.getSerializable("bean");
            String cardId = bean.getCardId();
            bCardId=cardId;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

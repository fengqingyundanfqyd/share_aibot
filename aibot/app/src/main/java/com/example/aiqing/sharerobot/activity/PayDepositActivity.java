package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ApplyBean;
import com.example.aiqing.sharerobot.bean.WeChatPayBean;
import com.example.aiqing.sharerobot.bean.ZhifubaoB2CBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.PayResult;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/*
* 支付押金
* */
public class PayDepositActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnConfirm;
    private ImageView mTopLeft;
    private TextView mTvMoney;
    private ImageView mIvLess;
    private ImageView mIvAdd;
    private TextView mTvNumTai;
    private TextView mTvNumCen;
    private TextView mTvShiji;
    private TextView mTvYue;
    // private int mNum;
    private RelativeLayout mRelativeLayoutZhifubao;
    private RelativeLayout mRelativeLayoutWeixin;
    private ImageView mIvZhifubao;
    private ImageView mIvWeixin;
    private TextView mTvYuedikou;
    static int num1 = 1;
    private double mBalance;
    private int mShiji2;
    private String mMAddressId;
    private String mSid;
    private HttpTool mHttpTool;
    private String mPTypeId;
    private IWXAPI mWxapi;
    private RelativeLayout mRlAccountbalance;
    private ImageView mIvAccountbalance;
    private Dialog mLoadingDialog;
    private String mDeposit;
    private double mD;
    private String mDistributorId;
    private String orderInfo;


    private static final int SDK_PAY_FLAG = 1;

    // static int meney=999;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG:
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        Toast.makeText(PayDepositActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(PayDepositActivity.this, CompleteActivity.class);
                        startActivity(intent);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(PayDepositActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pay_deposit);

        mWxapi = WXAPIFactory.createWXAPI(PayDepositActivity.this, "wx7458b61d79664e24", true);
        mWxapi.registerApp("wx7458b61d79664e24");

        initFindId();
        Intent intent = getIntent();
        mMAddressId = intent.getStringExtra("mAddressId");
        mDistributorId = intent.getStringExtra("mDistributorId");

        Log.e("地址id", "onCreate: " + mMAddressId);
        Log.e("投放商id", "onCreate: " + mDistributorId);


        mRelativeLayoutZhifubao.setSelected(true);


        initData();
        String yue = mTvYue.getText().toString();
        mBalance = Integer.parseInt(yue);

    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getAccountInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ApplyBean> call = apiService.getApplyData(mSid);
        call.enqueue(new Callback<ApplyBean>() {
            @Override
            public void onResponse(Response<ApplyBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    //租金
                    mD = response.body().getObj().getDeposit();
                    mDeposit = String.valueOf(mD);
                    Log.e("租金id", "onResponse: " + mDeposit);

                    //活动资金
                    mBalance = response.body().getObj().getBalance();
                    mTvYue.setText(String.valueOf(mBalance));
                    mTvMoney.setText(String.valueOf(mDeposit));
                    mTvYuedikou.setText(String.valueOf(mBalance));

                    mPTypeId = response.body().getObj().getPTypeId();

                    Log.e("类型id", "onResponse: " + mPTypeId);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(PayDepositActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    private void initFindId() {
        mBtnConfirm = (Button) findViewById(R.id.btn_pay);
        mTopLeft = (ImageView) findViewById(R.id.iv_return_sure);
        mTvMoney = (TextView) findViewById(R.id.tv_money);
        mIvLess = (ImageView) findViewById(R.id.iv_less);
        mIvAdd = (ImageView) findViewById(R.id.iv_add);
        mTvNumTai = (TextView) findViewById(R.id.tv_number_tai);
        mTvNumCen = (TextView) findViewById(R.id.tv_money_center);
        mTvShiji = (TextView) findViewById(R.id.tv_shiji);
        mTvYue = (TextView) findViewById(R.id.tv_num_yue);
        mTvYuedikou = (TextView) findViewById(R.id.tv_yuedikou);
        mRelativeLayoutZhifubao = (RelativeLayout) findViewById(R.id.relativelayout_zhifubao);
        mRelativeLayoutWeixin = (RelativeLayout) findViewById(R.id.relativelayout_weixin);
        mIvZhifubao = (ImageView) findViewById(R.id.iv_zhifubao);
        mIvWeixin = (ImageView) findViewById(R.id.iv_weixin);
        ImageView ivRetrun = (ImageView) findViewById(R.id.iv_return_sure);
        mRlAccountbalance = (RelativeLayout) findViewById(R.id.rl_accountbalance);
        mIvAccountbalance = (ImageView) findViewById(R.id.iv_accountbalance);

        mIvWeixin.setVisibility(View.GONE);
        mIvZhifubao.setVisibility(View.VISIBLE);
        int i = Integer.parseInt(mTvNumCen.getText().toString());
        double v = i - mBalance;
        mTvShiji.setText(v + "");

        mBtnConfirm.setOnClickListener(this);
        mTopLeft.setOnClickListener(this);
        mIvLess.setOnClickListener(this);
        mIvAdd.setOnClickListener(this);
        mRelativeLayoutZhifubao.setOnClickListener(this);
        mRelativeLayoutWeixin.setOnClickListener(this);
        ivRetrun.setOnClickListener(this);
        mRlAccountbalance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

//        String text = mTvNumTai.getText().toString();
//        int num1 = Integer.valueOf(text).intValue();
//        String number = String.valueOf(num1);
//        String money = mTvNumCen.getText().toString();
//        int money2 = Integer.valueOf(money).intValue();
        Intent intent = new Intent();
        switch (v.getId()) {

            case R.id.btn_pay:
                //确认支付
                if (mRelativeLayoutZhifubao.isSelected()) {
                    Toast.makeText(this, "支付宝", Toast.LENGTH_SHORT).show();
                    zhifubaoPay();
                } else if (mRelativeLayoutWeixin.isSelected()) {
                    Toast.makeText(this, "微信", Toast.LENGTH_SHORT).show();
                    initPay();
                } else if (mRlAccountbalance.isSelected()) {
                    Toast.makeText(this, "余额", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.top_menu_left:
                intent.setClass(this, ApplyRentActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_less:
                //减法
                num1 -= 1;
                if (num1 <= 0) {
                    num1 = 1;
                }
                mTvNumTai.setText(num1 + "");
                int money3 = (int) (num1 * mD);
                mTvNumCen.setText(money3 + "");

                int shiji = (int) (money3 - mBalance);
                mTvShiji.setText(shiji + "");
                break;
            case R.id.iv_add:
                num1 += 1;
                mTvNumTai.setText(num1 + "");
                mTvNumCen.setText(num1 * mD + "");

                mShiji2 = (int) (num1 * mD - mBalance);
                mTvShiji.setText(mShiji2 + "");
                break;
            case R.id.relativelayout_zhifubao:

                //支付宝支付
                mIvWeixin.setVisibility(View.GONE);
                mIvZhifubao.setVisibility(View.VISIBLE);
                mIvAccountbalance.setVisibility(View.GONE);
                mRelativeLayoutZhifubao.setSelected(true);
                mRelativeLayoutWeixin.setSelected(false);
                mRlAccountbalance.setSelected(false);

                break;
            case R.id.relativelayout_weixin:
                //微信支付
                mIvWeixin.setVisibility(View.VISIBLE);
                mIvZhifubao.setVisibility(View.GONE);
                mIvAccountbalance.setVisibility(View.GONE);
                mRelativeLayoutWeixin.setSelected(true);
                mRelativeLayoutZhifubao.setSelected(false);
                mRlAccountbalance.setSelected(false);

                break;
            case R.id.iv_return_sure:
                finish();
                break;
            case R.id.rl_accountbalance:
                //余额支付
                mIvWeixin.setVisibility(View.GONE);
                mIvZhifubao.setVisibility(View.GONE);
                mIvAccountbalance.setVisibility(View.VISIBLE);
                mRlAccountbalance.setSelected(true);
                mRelativeLayoutWeixin.setSelected(false);
                mRelativeLayoutZhifubao.setSelected(false);
                break;
        }
    }

    //支付宝支付
    private void zhifubaoPay() {
        //mLoadingDialog = DialogUtil.createLoadingDialog(PayDepositActivity.this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://relay.aqcome.com/pay/depositBCAPPPay.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ZhifubaoB2CBean> call = apiService.zhifubaoPay(mSid, "170814203827496019", "1", "170906142537979116", "2", "2", "0.03", "0.03", "1", "3", "0");
        call.enqueue(new Callback<ZhifubaoB2CBean>() {
            @Override
            public void onResponse(Response<ZhifubaoB2CBean> response, Retrofit retrofit) {
                String coder = response.body().getCoder();
                Log.e("支付宝", "onResponse: " + coder);
                String body = response.body().getBody();
                Log.e("支付宝1", "onResponse: " + body);

                orderInfo = body;

//                String[] s1 = body.split("&");
//                orderInfo = s1[1] + s1[2] + s1[3] + s1[4] + s1[5] + s1[6];
                new AliPayThread().start();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });


    }

    private class AliPayThread extends Thread {
        @Override
        public void run() {
            PayTask payTask = new PayTask(PayDepositActivity.this);
            Map<String, String> result = payTask.payV2(orderInfo, true);
            Message message = new Message();
            message.what = SDK_PAY_FLAG;
            message.obj = result;
            mHandler.sendMessage(message);

            super.run();
        }
    }

    private void initPay() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/pay/depositBCAPPPay.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<WeChatPayBean> call = apiService.wxPay(mSid, mDistributorId, "1", mMAddressId, "2", "1", mDeposit, mDeposit, "1", "3");
        call.enqueue(new Callback<WeChatPayBean>() {
            @Override
            public void onResponse(Response<WeChatPayBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                String appid = response.body().getAppid();
                String partnerid = response.body().getPartnerid();
                String prepayid = response.body().getPrepayid();
                String noncestr = response.body().getNoncestr();
                String signtype = response.body().getSigntype();
                String timestamp = response.body().getTimestamp();
                String sign = response.body().getSign();

                Log.e("星期五", "onResponse: " + "  " + appid + "  " + partnerid + "  " + prepayid + "  " + noncestr + "  " + signtype + "  " + timestamp + "  " + sign);


                PayReq payReq = new PayReq();
                payReq.appId = appid;
                payReq.nonceStr = noncestr;
                payReq.packageValue = "Sign=WXPay";
                payReq.partnerId = partnerid;
                payReq.prepayId = prepayid;
                payReq.signType = signtype;
                payReq.timeStamp = timestamp;
                payReq.sign = sign;

                Toast.makeText(PayDepositActivity.this, "  " + appid + "  " + partnerid + "  " + prepayid + "  " + noncestr + "  " + signtype + "  " + timestamp + "  " + sign, Toast.LENGTH_SHORT).show();

//                payReq.appId="wx7458b61d79664e24";
//                payReq.partnerId="1485489132";
//                payReq.prepayId="wx20170810114938114797cdee0027604909";
//                payReq.packageValue="Sign=WXPay";
//                payReq.nonceStr="r9i2oi55qxxgv32r";
//                payReq.signType="MD5";
//                payReq.timeStamp="1502336742";
//                payReq.sign="1A1DC8578E86249E991A2AB5489D74BB";

                mWxapi.sendReq(payReq);

                Log.e("成功", "onResponse: " + "成功");
//                mWxapi.openWXApp();
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(PayDepositActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });

    }
}

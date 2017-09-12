package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.RecharPagerAdapter;
import com.example.aiqing.sharerobot.bean.advanceWxEBean;
import com.example.aiqing.sharerobot.bean.advanceYuEBean;
import com.example.aiqing.sharerobot.bean.advanceZfbBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.PayResult;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//充值 预发量
public class RecharActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int SDK_PAY_FLAG = 1;
    private View viewOnline;
    private View viewChange;
    private TabLayout mTabRechar;
    private ViewPager mVpRechar;
    private EditText mEtNum;
    private int mRecharNum;
    private TextView mTvMoney;
    private int mMoney;
    private String mCookie;
    private HttpTool mHttpTool;
    private String mDistributorid;
    private String orderinfo;
    private IWXAPI mWxapi;
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
                        Toast.makeText(RecharActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(RecharActivity.this, CompleteActivity.class);
                        startActivity(intent);
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        Toast.makeText(RecharActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private int mTransfer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechar);

        mWxapi = WXAPIFactory.createWXAPI(RecharActivity.this, "wx7458b61d79664e24", true);
        mWxapi.registerApp("wx7458b61d79664e24");

        initId();

        initUi();

    }

    private void initUi() {
        LayoutInflater inflater = getLayoutInflater();
        viewOnline = inflater.inflate(R.layout.item_rechar_online, null);
        viewChange = inflater.inflate(R.layout.item_rechar_transfer, null);
        List<View> mViewsList = new ArrayList<>();
        mViewsList.add(viewOnline);
        mViewsList.add(viewChange);
        RecharPagerAdapter recharPagerAdapter = new RecharPagerAdapter(this, mViewsList);
        mVpRechar.setAdapter(recharPagerAdapter);
        mTabRechar.setupWithViewPager(mVpRechar);
        mTabRechar.getTabAt(0).setText("在线充值");
        mTabRechar.getTabAt(1).setText("转账充值");

        RelativeLayout rlOnline = (RelativeLayout) viewOnline.findViewById(R.id.rl_reduce);
        RelativeLayout rlAddRechar = (RelativeLayout) viewOnline.findViewById(R.id.rl_add_rechar);
        mEtNum = (EditText) viewOnline.findViewById(R.id.et_rechar_num);
        mTvMoney = (TextView) viewOnline.findViewById(R.id.tv_rechar_money);
        Button btnSure = (Button) viewOnline.findViewById(R.id.btn_sure_rechar);

        rlOnline.setOnClickListener(this);
        rlAddRechar.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        String num = mEtNum.getText().toString().trim();
        mRecharNum = Integer.parseInt(num);

        String mon = mTvMoney.getText().toString();
        mMoney = Integer.parseInt(mon);

        RelativeLayout rlReduceTransfer = (RelativeLayout) viewChange.findViewById(R.id.rl_reduce_transfer);
        RelativeLayout rlAddTransfer = (RelativeLayout) viewChange.findViewById(R.id.rl_add_rechar_transfer);
        final EditText etTransfer = (EditText) viewChange.findViewById(R.id.et_rechar_num_transfer);
        final TextView tvTransferMoney = (TextView) viewChange.findViewById(R.id.tv_rechar_transfer);
        ImageView ivProof = (ImageView) viewChange.findViewById(R.id.iv_proof);
        Button btnUpload= (Button) viewChange.findViewById(R.id.btn_upload_rechar);


        String etTransferMoney = etTransfer.getText().toString();
        mTransfer = Integer.parseInt(etTransferMoney);
        String transfermoney = tvTransferMoney.getText().toString();
        final int tranmoney = Integer.parseInt(transfermoney);

        rlReduceTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //减
                if (mTransfer - 1 > 0) {
                    mTransfer -= 1;
                    etTransfer.setText(mTransfer + "");
                    tvTransferMoney.setText(tranmoney * mTransfer + "");
                } else {
                    return;
                }
            }
        });
        rlAddTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTransfer += 1;
                etTransfer.setText(mTransfer + "");
                tvTransferMoney.setText(tranmoney * mTransfer + "");
            }
        });

    }

    private void initId() {
        mTabRechar = (TabLayout) findViewById(R.id.tab_rechar);
        mVpRechar = (ViewPager) findViewById(R.id.vp_rechar);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = spDis.getString("distributorid", "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_reduce:
                //减
                if (mRecharNum - 1 > 0) {
                    mRecharNum -= 1;
                    mEtNum.setText(mRecharNum + "");
                    mTvMoney.setText(mMoney * mRecharNum + "");
                } else {
                    return;
                }
                break;
            case R.id.rl_add_rechar:
                //加
                mRecharNum += 1;
                mEtNum.setText(mRecharNum + "");
                mTvMoney.setText(mMoney * mRecharNum + "");

                break;
            case R.id.btn_sure_rechar:
                //确认支付
                showPopwindow();
                break;
        }
    }

    private void showPopwindow() {
        View popupView = View.inflate(this, R.layout.item_change_icon, null);
        final PopupWindow popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        ImageView ivClose = (ImageView) popupView.findViewById(R.id.iv_close_rechar);
        final RelativeLayout rlZfbpay = (RelativeLayout) popupView.findViewById(R.id.rl_zfbpay);
        final ImageView ivZfbStatus = (ImageView) popupView.findViewById(R.id.iv_zfb_status);
        final RelativeLayout rlWxpay = (RelativeLayout) popupView.findViewById(R.id.rl_wxpay);
        final ImageView ivWxStatus = (ImageView) popupView.findViewById(R.id.iv_wx_status);
        final RelativeLayout rlYepay = (RelativeLayout) popupView.findViewById(R.id.rl_yepay);
        final ImageView ivYeStatus = (ImageView) popupView.findViewById(R.id.iv_ye_status);
        TextView tvPaynum = (TextView) popupView.findViewById(R.id.tv_paynum);
        Button btnPaynow = (Button) popupView.findViewById(R.id.btn_paynow);
        rlZfbpay.setSelected(true);
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        rlZfbpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivZfbStatus.setVisibility(View.VISIBLE);
                ivWxStatus.setVisibility(View.GONE);
                ivYeStatus.setVisibility(View.GONE);
                rlZfbpay.setSelected(true);
                rlWxpay.setSelected(false);
                rlYepay.setSelected(false);
            }
        });
        rlWxpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ivZfbStatus.setVisibility(View.GONE);
                ivWxStatus.setVisibility(View.VISIBLE);
                ivYeStatus.setVisibility(View.GONE);
                rlWxpay.setSelected(true);
                rlYepay.setSelected(false);
                rlZfbpay.setSelected(false);
            }
        });
        rlYepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivZfbStatus.setVisibility(View.GONE);
                ivWxStatus.setVisibility(View.GONE);
                ivYeStatus.setVisibility(View.VISIBLE);
                rlYepay.setSelected(true);
                rlWxpay.setSelected(false);
                rlZfbpay.setSelected(false);
            }
        });
        tvPaynum.setText(mMoney * mRecharNum + "");

        btnPaynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rlZfbpay.isSelected()) {
                    zhifubaoPay(view);
                } else if (rlWxpay.isSelected()) {
                    Toast.makeText(RecharActivity.this, "微信", Toast.LENGTH_SHORT).show();
                    wxPay(view);
                } else if (rlYepay.isSelected()) {
                    yePay(view);
                }
            }
        });

        // 在点击之后设置popupwindow的销毁
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
            lighton();
        }

        // 设置背景图片， 必须设置，不然动画没作用
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setFocusable(true);

        // 设置点击popupwindow外屏幕其它地方消失
        popupWindow.setOutsideTouchable(true);
        // 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
        popupWindow.showAtLocation(this.findViewById(R.id.rechar), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        // popupView.startAnimation(animation);
    }


    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }

    //支付宝支付
    private void zhifubaoPay(View view) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/rentAll.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<advanceZfbBean> call = apiService.advanceZfb(mCookie, mDistributorid, "1", "3", "2", mTvMoney.getText().toString(), "");
        call.enqueue(new Callback<advanceZfbBean>() {
            @Override
            public void onResponse(Response<advanceZfbBean> response, Retrofit retrofit) {
                String body = response.body().getBody();
                orderinfo = body;
                new AliPayThread().start();
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(loadingDialog);
                Toast.makeText(RecharActivity.this, "网络连接失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class AliPayThread extends Thread {
        @Override
        public void run() {
            PayTask payTask = new PayTask(RecharActivity.this);
            Map<String, String> result = payTask.payV2(orderinfo, true);
            Message message = new Message();
            message.what = SDK_PAY_FLAG;
            message.obj = result;
            mHandler.sendMessage(message);
            super.run();
        }
    }

    //余额支付
    private void yePay(View view) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/rentAll.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<advanceYuEBean> call = apiService.advanceYuE(mCookie, mDistributorid, "1", "1", "2", mTvMoney.getText().toString(), "");
        call.enqueue(new Callback<advanceYuEBean>() {
            @Override
            public void onResponse(Response<advanceYuEBean> response, Retrofit retrofit) {
                if (response.body() != null) {
                    DialogUtil.closeDialog(loadingDialog);
                    if (response.body().getCoder().equals("0000")) {
                        Toast.makeText(RecharActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(RecharActivity.this, DistributorManagerActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RecharActivity.this, response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(loadingDialog);
                Toast.makeText(RecharActivity.this, "网络连接失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //微信支付
    private void wxPay(View view) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/rentAll.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<advanceWxEBean> call = apiService.advanceWx(mCookie, mDistributorid, "1", "2", "2", mTvMoney.getText().toString(), "");
        call.enqueue(new Callback<advanceWxEBean>() {
            @Override
            public void onResponse(Response<advanceWxEBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                String appid = response.body().getAppid();
                String partnerid = response.body().getPartnerid();
                String prepayid = response.body().getPrepayid();
                String noncestr = response.body().getNoncestr();
                String signtype = response.body().getSigntype();
                String timestamp = response.body().getTimestamp();
                String sign = response.body().getSign();

                PayReq payReq = new PayReq();
                payReq.appId = appid;
                payReq.nonceStr = noncestr;
                payReq.packageValue = "Sign=WXPay";
                payReq.partnerId = partnerid;
                payReq.prepayId = prepayid;
                payReq.signType = signtype;
                payReq.timeStamp = timestamp;
                payReq.sign = sign;
                // mWxapi.sendReq(payReq);
                mWxapi.openWXApp();
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(loadingDialog);
                Toast.makeText(RecharActivity.this, "网络连接失败，请检查网络", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

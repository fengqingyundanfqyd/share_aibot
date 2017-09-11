package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.TouDetailBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//投放商进出货详情
public class DetailingActivity extends AppCompatActivity {

    private TextView mTvNickName;
    private ImageView mIvDetailTou;
    private TextView mTvNumDt;
    private TextView mTvDetouStatus;
    private TextView mTvPdStyle;
    private TextView mTvZhanghu;
    private TextView mTvPayStyle;
    private TextView mTvMoneyD;
    private TextView mTName;
    private TextView mTvnum;
    private TextView mTvAddress;
    private TextView mTvBei;
    private TextView mTvCreatTime;
    private TextView mTvDingDanNum;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detailing);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("详情");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DetailingActivity.this.finish();
                Log.d("返回", "onClick: " + "返回");
            }
        });
        initId();
        initData();
    }

    private void initId() {
        mTvNickName = (TextView) findViewById(R.id.tv_nickname_dt);
        mIvDetailTou = (ImageView) findViewById(R.id.iv_detailtou);
        mTvNumDt = (TextView) findViewById(R.id.tv_num_dt);
        mTvDetouStatus = (TextView) findViewById(R.id.tv_detou_status);
        mTvPdStyle = (TextView) findViewById(R.id.tv_pd_style);
        mTvZhanghu = (TextView) findViewById(R.id.tv_zhanghu);
        mTvPayStyle = (TextView) findViewById(R.id.tv_paystyle);
        mTvMoneyD = (TextView) findViewById(R.id.tv_money_d);
        mTName = (TextView) findViewById(R.id.tv_name);
        mTvnum = (TextView) findViewById(R.id.tv_num);
        mTvAddress = (TextView) findViewById(R.id.tv_address);
        mTvBei = (TextView) findViewById(R.id.tv_bei);
        mTvCreatTime = (TextView) findViewById(R.id.tv_creat_time);
        mTvDingDanNum = (TextView) findViewById(R.id.tv_dingdannum);
    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Intent intent = getIntent();
        String paId = intent.getStringExtra("paId");

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = preferences.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder=new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/distributorOrderDetails.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = builder.create(ApiService.class);
        Call<TouDetailBean> call = apiService.touDetail(cookie, paId);
        call.enqueue(new Callback<TouDetailBean>() {
            @Override
            public void onResponse(Response<TouDetailBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    mTvNickName.setText(response.body().getObj().getNickname() + "");//昵称
                    mTvNumDt.setText(response.body().getObj().getApplyNum() + "");//数量
                    String sendType = response.body().getObj().getSendType();
                    if (sendType.equals("1")) {
                        mTvDetouStatus.setText("发货(审核中/物流中/交易成功)");
                    } else if (sendType.equals("2")) {
                        mTvDetouStatus.setText("退货(审核中/物流中/交易成功)");
                    } else if (sendType.equals("3")) {
                        mTvDetouStatus.setText("换货(审核中/物流中/交易成功)");
                    }
                    mTvPdStyle.setText(response.body().getObj().getPtypeName());//产品类型
                    mTvZhanghu.setText(response.body().getObj().getNickname() + "");//账户
                    //mTvPayStyle.setText(response.body().getObj().get);//支付方式
                    mTvMoneyD.setText(response.body().getObj().getMoney() + "");
                    mTName.setText(response.body().getObj().getName());//姓名
                    mTvnum.setText(response.body().getObj().getMobile() + "");//手机号
                    mTvAddress.setText(response.body().getObj().getAddress());
                    mTvBei.setText(response.body().getObj().getRemark1() + "");
                    mTvCreatTime.setText(response.body().getObj().getCreateTime() + "");
                    mTvDingDanNum.setText(response.body().getObj().getPaId() + "");
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}

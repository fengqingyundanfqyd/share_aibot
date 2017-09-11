package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.MyaibotHistoryAdapter;
import com.example.aiqing.sharerobot.bean.MyAibotOrderBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//我的小宝  订单管理
public class MyAibotOMActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvTotal;
    private TextView mTvNosendnum;
    private TextView mTvNolease;
    private TextView mTvHavelease;
    private ListView mListviewOrder;
    private LinearLayout mLlBottomScan;
    private LinearLayout mLlNoSend;
    private RelativeLayout mRlNolease;
    private LinearLayout mLlHavelease;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_aibot_om);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("订单管理");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        initId();
        initHttp();
        initData();
    }

    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String  cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/robotOrder/orderManage.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<MyAibotOrderBean> call = apiService.myOrder(cookie, "1", "5");
        call.enqueue(new Callback<MyAibotOrderBean>() {
            @Override
            public void onResponse(Response<MyAibotOrderBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    int all = response.body().getAll();
                    int notSend = response.body().getNotSend();//未发货
                    int notUse = response.body().getNotUse();//为租用
                    int hasUse = response.body().getHasUse();//已租用
                    mTvTotal.setText(all + "");
                    mTvNosendnum.setText(notSend + "");
                    mTvNolease.setText(notUse + "");
                    mTvHavelease.setText(hasUse + "");
                    List<MyAibotOrderBean.UseHistoryBean.ResultBean> result = response.body().getUseHistory().getResult();
                    MyaibotHistoryAdapter myaibotHistoryAdapter = new MyaibotHistoryAdapter(MyAibotOMActivity.this, result);
                    mListviewOrder.setAdapter(myaibotHistoryAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    private void initData() {

        mLlNoSend.setOnClickListener(this);
        mRlNolease.setOnClickListener(this);
        mLlHavelease.setOnClickListener(this);
    }

    private void initId() {
        mTvTotal = (TextView) findViewById(R.id.tv_total_myaibot);
        mTvNosendnum = (TextView) findViewById(R.id.tv_nosendnum);
        mTvNolease = (TextView) findViewById(R.id.tv_nolease);
        mTvHavelease = (TextView) findViewById(R.id.tv_havelease);
        mListviewOrder = (ListView) findViewById(R.id.listview_ordermanager_myaibot);
        mLlBottomScan = (LinearLayout) findViewById(R.id.ll_bottom_scan);
        mLlNoSend = (LinearLayout) findViewById(R.id.ll_nosend);
        mRlNolease = (RelativeLayout) findViewById(R.id.rl_nolease);
        mLlHavelease = (LinearLayout) findViewById(R.id.ll_havelease);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.ll_nosend:
                //未发货
                intent.setClass(MyAibotOMActivity.this,NoSendGoodActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.rl_nolease:
                //未租用
                intent.setClass(MyAibotOMActivity.this,NoLeaseActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_havelease:
                //已租用
                break;
        }
    }
}

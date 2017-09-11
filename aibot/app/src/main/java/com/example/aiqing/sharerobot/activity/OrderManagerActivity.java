package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.ApplySendAdapger;
import com.example.aiqing.sharerobot.adapter.HaveSendAdapger;
import com.example.aiqing.sharerobot.adapter.OrderManagerVPAdapter;
import com.example.aiqing.sharerobot.bean.DaiOrderBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 代理商管理--》订单管理
 */
public class OrderManagerActivity extends AppCompatActivity {

    private View view1;
    private View view2;
    private TabLayout mTabOrdermanager;
    private ViewPager mVpOrdermanager;
    private TextView mTvKcOrder;
    private TextView mTvHavaSend;
    private TextView mTvShouyi;
    private ListView mLvApply;
    private ListView mLvHaveSend;
    private HttpTool mHttpTool;
    private String mNewCookie;
    private String mAgencyId;
    private List<DaiOrderBean.ProListBean.ResultBean> mResult;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_manager);
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("订单管理");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mNewCookie = preferences.getString("mCookie", "");

        mHttpTool = new HttpTool(this);
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        mAgencyId = data.getString("agencyId", "");

        initFindId();
        initData();
        initApplySend();
        initHavaSend();


    }

    private void initHavaSend() {

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/arrangeOrderList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DaiOrderBean> call = apiService.applysendgoods(mNewCookie, mAgencyId, "2", "1", "5");

        call.enqueue(new Callback<DaiOrderBean>() {
            @Override
            public void onResponse(Response<DaiOrderBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    List<DaiOrderBean.ProListBean.ResultBean> havasend = response.body().getProList().getResult();
                    HaveSendAdapger haveSendAdapger = new HaveSendAdapger(OrderManagerActivity.this, havasend);
                    mLvHaveSend.setAdapter(haveSendAdapger);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Log.e("666", "onFailure: " + "网络连接失败");
                Toast.makeText(OrderManagerActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initFindId() {
        mTabOrdermanager = (TabLayout) findViewById(R.id.tab_ordermanager);
        mVpOrdermanager = (ViewPager) findViewById(R.id.vp_ordermanager);
        mTvKcOrder = (TextView) findViewById(R.id.tv_kc_order);
        mTvHavaSend = (TextView) findViewById(R.id.tv_hava_send_order);
        mTvShouyi = (TextView) findViewById(R.id.tv_shouyi_order);
    }

    private void initData() {
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.vp_ordermanger, null);
        view2 = inflater.inflate(R.layout.vp_havasend, null);
        List<View> mViewsList = new ArrayList<>();
        mViewsList.add(view1);
        mViewsList.add(view2);

        OrderManagerVPAdapter orderManagerVPAdapter = new OrderManagerVPAdapter(this, mViewsList);
        mVpOrdermanager.setAdapter(orderManagerVPAdapter);
        mTabOrdermanager.setupWithViewPager(mVpOrdermanager);
        mTabOrdermanager.getTabAt(0).setText("申请发货");
        mTabOrdermanager.getTabAt(1).setText("已发货");

        mLvApply = (ListView) view1.findViewById(R.id.listview_applygetobj);

        mLvHaveSend = (ListView) view2.findViewById(R.id.listview_havesend);


    }

    private void initApplySend() {

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/arrangeOrderList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DaiOrderBean> call = apiService.applysendgoods(mNewCookie, mAgencyId, "1", "1", "5");

        call.enqueue(new Callback<DaiOrderBean>() {
            @Override
            public void onResponse(Response<DaiOrderBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    mTvKcOrder.setText(response.body().getTotal() + "");
                    mTvHavaSend.setText(response.body().getInitnum() + "");
                    mTvShouyi.setText(response.body().getMoney() + "");

                    mResult = response.body().getProList().getResult();
                    ApplySendAdapger applySendAdapger = new ApplySendAdapger(OrderManagerActivity.this, mResult);
                    mLvApply.setAdapter(applySendAdapger);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Log.e("666", "onFailure: " + "网络连接失败");
                Toast.makeText(OrderManagerActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }
}

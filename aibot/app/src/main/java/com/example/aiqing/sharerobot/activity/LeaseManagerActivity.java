package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.NewOrderAdapter;
import com.example.aiqing.sharerobot.adapter.OveredAdapter;
import com.example.aiqing.sharerobot.adapter.RenttingAdapter;
import com.example.aiqing.sharerobot.adapter.ViewPagerAdapter;
import com.example.aiqing.sharerobot.bean.HavaLeaseBean;
import com.example.aiqing.sharerobot.bean.LeaseManagerDaiBean;
import com.example.aiqing.sharerobot.bean.OrderBean;
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
 * 租赁管理
 */
public class LeaseManagerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private View view1, view2, view3;
    private ViewPager mViewpagerLease;
    private TabLayout mTablayoutLease;
    private ListView mMListviewOvered;
    private ListView mMListviewZuyongzhong;
    private ListView mMListviewNeworder;
    private List<OrderBean.OrderListBean.ResultBean> mResult3;
    private String mPaId;
    private String mCookie;
    private HttpTool mHttpTool;
    private String mDistributorid;
    private String mProductId;
    private Dialog mLoadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        setContentView(R.layout.activity_lease_manager);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("租赁管理");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        SharedPreferences dis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = dis.getString("distributorid", "");
        Log.e("投放商码", "onCreate: "+mDistributorid );
        initFindId();

        initData();

        //订单
        initOrderHttp();

        //已租
        initHavaLeaseHttp();

        //待租
        initHttpDaiLeased();

    }
    //订单
    private void initOrderHttp() {

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/selectOrder.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<OrderBean> call = apiService.newOrder(mCookie,mDistributorid);
        call.enqueue(new Callback<OrderBean>() {
            @Override
            public void onResponse(Response<OrderBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    mResult3 = response.body().getOrderList().getResult();
                    for (int i = 0; i < mResult3.size(); i++) {
                        OrderBean.OrderListBean.ResultBean resultBean = mResult3.get(i);
                        mPaId = (String) resultBean.getPaId();
                        // Log.e("7777777", "onResponse: "+mPaId );
                    }
                    NewOrderAdapter newOrderAdapter = new NewOrderAdapter(LeaseManagerActivity.this, mResult3);
                    mMListviewNeworder.setAdapter(newOrderAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LeaseManagerActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //已租
    private void initHavaLeaseHttp() {
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/selectProduct.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<HavaLeaseBean> call = apiService.havelease(mCookie,mDistributorid);
        call.enqueue(new Callback<HavaLeaseBean>() {
            @Override
            public void onResponse(Response<HavaLeaseBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    List<HavaLeaseBean.OrderListBean.ResultBean> result1 = response.body().getOrderList().getResult();
                    for (int i = 0; i < result1.size(); i++) {
                        HavaLeaseBean.OrderListBean.ResultBean resultBean = result1.get(i);
                        mProductId = resultBean.getProductId();
                    }
                    RenttingAdapter renttingAdapter = new RenttingAdapter(LeaseManagerActivity.this, result1);
                    mMListviewZuyongzhong.setAdapter(renttingAdapter);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LeaseManagerActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });


    }

    //租赁管理—待租
    private void initHttpDaiLeased() {
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/selectProductwait.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);

        Call<LeaseManagerDaiBean> call = apiService.daizu(mCookie,mDistributorid);
        call.enqueue(new Callback<LeaseManagerDaiBean>() {
            @Override
            public void onResponse(Response<LeaseManagerDaiBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    List<LeaseManagerDaiBean.ObjBean.ResultBean> result = response.body().getObj().getResult();

                    OveredAdapter overedAdapter = new OveredAdapter(LeaseManagerActivity.this, result);
                    mMListviewOvered.setAdapter(overedAdapter);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LeaseManagerActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.vp_leasemanager1, null);
        view2 = inflater.inflate(R.layout.vp_leasemanager2, null);
        view3 = inflater.inflate(R.layout.vp_leasemanager3, null);
        List<View> mViewsList = new ArrayList<>();
        mViewsList.add(view1);
        mViewsList.add(view2);
        mViewsList.add(view3);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, mViewsList);
        mViewpagerLease.setAdapter(adapter);
        mTablayoutLease.setupWithViewPager(mViewpagerLease);

        mTablayoutLease.getTabAt(0).setText("订单");
        mTablayoutLease.getTabAt(1).setText("已租");
        mTablayoutLease.getTabAt(2).setText("待租");

        mMListviewNeworder = (ListView) view1.findViewById(R.id.listview_neworder);
        mMListviewZuyongzhong = (ListView) view2.findViewById(R.id.listview_zuyongzhong);
        mMListviewOvered = (ListView) view3.findViewById(R.id.listview_overed);

        //订单页设置条目点击监听
        mMListviewNeworder.setOnItemClickListener(this);
        //已租
        mMListviewZuyongzhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(LeaseManagerActivity.this, LeaseDetailOrderActivity.class);
                intent.putExtra("mProductId",mProductId);
                startActivity(intent);
                finish();
            }
        });
        //待租
        mMListviewOvered.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void initFindId() {
        mViewpagerLease = (ViewPager) findViewById(R.id.viewpager_lease_manager);
        mTablayoutLease = (TabLayout) findViewById(R.id.tablayout_leasemanager);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //订单明细
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent();
        intent.setClass(LeaseManagerActivity.this, LeaseDetailActivity.class);
        intent.putExtra("mPaId",mPaId);
        startActivity(intent);
        finish();

    }
}


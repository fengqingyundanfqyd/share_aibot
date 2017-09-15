package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.AgencePagerAdapter;
import com.example.aiqing.sharerobot.adapter.AgencyIncomeAdapter;
import com.example.aiqing.sharerobot.adapter.AgencyNextDisAdapter;
import com.example.aiqing.sharerobot.bean.AgencyDisBean;
import com.example.aiqing.sharerobot.bean.AgencyIncomeBaen;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//新代理商
public class AgencyManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private View view1;
    private View view2;
    private ViewPager mVpAgence;
    private TabLayout mTabAgence;
    private ListView mLvAgenceDis;
    private String mCookie;
    private HttpTool mHttpTool;
    private TextView mTvTotalNum;
    private ListView mLvIncome;
    private String mAgencyId;
    private TextView mTvNowmoney;
    private TextView mTvHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency_manager);
        initId();
        initUi();

        initData();
        getIncomeData();
    }

    //收益流水
    private void getIncomeData() {

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/selectAgencyAccount.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AgencyIncomeBaen> call = apiService.agenceIncome(mCookie, mAgencyId, "1", "5");
        call.enqueue(new Callback<AgencyIncomeBaen>() {
            @Override
            public void onResponse(Response<AgencyIncomeBaen> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getResult().getResult() != null) {
                    double balance = response.body().getBalance();
                    mTvNowmoney.setText(balance + "");
                    String changeMoney = response.body().getChangeMoney();
                    mTvHistory.setText(changeMoney + "");
                    List<AgencyIncomeBaen.ResultBeanX.ResultBean> beanList = response.body().getResult().getResult();
                    AgencyIncomeAdapter incomeAdapter = new AgencyIncomeAdapter(AgencyManagerActivity.this, beanList);
                    mLvIncome.setAdapter(incomeAdapter);
                } else {
                    Toast.makeText(AgencyManagerActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(AgencyManagerActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {


        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/selectAgencyJunior.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<AgencyDisBean> call = apiService.agenceNext(mCookie, mAgencyId, "1", "5");
        call.enqueue(new Callback<AgencyDisBean>() {
            @Override
            public void onResponse(Response<AgencyDisBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                int count = response.body().getCount();

                mTvTotalNum.setText(count + "");
                List<AgencyDisBean.ResultBeanX.ResultBean> result = response.body().getResult().getResult();
                AgencyNextDisAdapter nextDisAdapter = new AgencyNextDisAdapter(AgencyManagerActivity.this, result);
                mLvAgenceDis.setAdapter(nextDisAdapter);

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(AgencyManagerActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initUi() {
        final LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.item_agence_dis, null);
        view2 = inflater.inflate(R.layout.item_agence_money, null);
        List<View> viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        AgencePagerAdapter agencePagerAdapter = new AgencePagerAdapter(this, viewList);
        mVpAgence.setAdapter(agencePagerAdapter);
        mTabAgence.setupWithViewPager(mVpAgence);
        mTabAgence.getTabAt(0).setText("下级投放商");
        mTabAgence.getTabAt(1).setText("收益流水");

        LinearLayout llTotalNum = (LinearLayout) view1.findViewById(R.id.ll_dis_totalnum);
        LinearLayout llGetdis = (LinearLayout) view1.findViewById(R.id.ll_getdis);
        LinearLayout llTobedis = (LinearLayout) view1.findViewById(R.id.ll_tobedis);
        mLvAgenceDis = (ListView) view1.findViewById(R.id.lv_agence_dis);
        mTvTotalNum = (TextView) view1.findViewById(R.id.tv_tatal_num);
        llGetdis.setOnClickListener(this);
        llTobedis.setOnClickListener(this);

        mTvNowmoney = (TextView) view2.findViewById(R.id.tv_nowmoney);
        mTvHistory = (TextView) view2.findViewById(R.id.tv_income_history);
        mLvIncome = (ListView) view2.findViewById(R.id.lv_income);

    }

    private void initId() {
        LinearLayout llReturn = (LinearLayout) findViewById(R.id.ll_return_agence);
        mTabAgence = (TabLayout) findViewById(R.id.tab_agence);
        mVpAgence = (ViewPager) findViewById(R.id.vp_agence);
        llReturn.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mAgencyId = spDis.getString("agencyId", "");

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ll_return_agence:
//                intent.setClass(AgencyManagerActivity.this, Main2Activity.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.ll_getdis:
                intent.setClass(AgencyManagerActivity.this, PutInActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_tobedis:
                intent.setClass(AgencyManagerActivity.this, TojoininApplyActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.PutManagerBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 投放商管理
 */
public class PutManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLinearlayoutNeworder;
    private LinearLayout mLinearlayoutRentting;
    private LinearLayout mLinearlayoutOvered;
    private ImageView mIvPutManagereHeader;
    private LinearLayout mLinearlayoutJinhuo;
    private TextView mTvToufangname;
    private TextView mTvCzrentting;
    private TextView mTvcrentting;
    private TextView mTv_dzrentting;
    private TextView mTv_zjshouyi;
    private TextView mTv_djyajin;
    private RelativeLayout mRlKuncunManager;
    private String mCookie;
    private TextView mTvRentting;
    private TextView mTvDai;
    private TextView mTvDaiShou;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_manager);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        initFindId();
        initData();
    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        String distributorid = data.getString("distributorid", "");

        HttpTool httpTool=new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/cust/getAccountRec.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<PutManagerBean> call = apiService.PutManager(mCookie,distributorid);
        call.enqueue(new Callback<PutManagerBean>() {
            @Override
            public void onResponse(Response<PutManagerBean> response, Retrofit retrofit) {
                if (response.body()!=null){
                    mTvToufangname.setText(response.body().getObj().getName());
                    mTvRentting.setText(response.body().getObj().getUsedNum()+"");
                    mTvDai.setText(response.body().getObj().getNeedSendNum()+"");
                    mTvDaiShou.setText(response.body().getObj().getNeedReciveNum()+"");
                    mTvcrentting.setText(response.body().getObj().getKcNum()+"");
                    mTv_dzrentting.setText(response.body().getObj().getResetNum()+"");
                    mTv_zjshouyi.setText(response.body().getObj().getZjMoney()+"");
                    mTv_djyajin.setText(response.body().getObj().getBDeposit()+"");

                }

                DialogUtil.closeDialog(mLoadingDialog);
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(PutManagerActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    private void initFindId() {
        RelativeLayout relativelayoutLeastMa = (RelativeLayout) findViewById(R.id.relativelayout_leastmanager);
        mLinearlayoutNeworder = (LinearLayout) findViewById(R.id.linearlayout_neworder);
        mLinearlayoutRentting = (LinearLayout) findViewById(R.id.linearlayout_rentting);
        mLinearlayoutOvered = (LinearLayout) findViewById(R.id.linearlayout_overed);
        mIvPutManagereHeader = (ImageView) findViewById(R.id.iv_put_manager_header);
        mLinearlayoutJinhuo = (LinearLayout) findViewById(R.id.linearlayout_jinhuo);
        mRlKuncunManager = (RelativeLayout) findViewById(R.id.rl_kucun_manager);
        ImageView ivLeftTou = (ImageView) findViewById(R.id.iv_left_tou);

        //名称
        mTvToufangname = (TextView) findViewById(R.id.tv_toufangname);
//        //出租中上
//        mTvCzrentting = (TextView) findViewById(R.id.tv_czrentting);
        //库存
        mTvcrentting = (TextView) findViewById(R.id.tv_kcrentting);
        //未初始化
        mTv_dzrentting = (TextView) findViewById(R.id.tv_dzrentting);
        //收益
        mTv_zjshouyi = (TextView) findViewById(R.id.tv_zjshouyi);
        //冻结
        mTv_djyajin = (TextView) findViewById(R.id.tv_djyajin);

        //租用中
        mTvRentting = (TextView) findViewById(R.id.tv_rentting);
        //待发货审核
        mTvDai = (TextView) findViewById(R.id.tv_dai);
        //待收货审核
        mTvDaiShou = (TextView) findViewById(R.id.tv_daishou);


        relativelayoutLeastMa.setOnClickListener(this);
        mLinearlayoutNeworder.setOnClickListener(this);
        mLinearlayoutRentting.setOnClickListener(this);
        mLinearlayoutOvered.setOnClickListener(this);
        mIvPutManagereHeader.setOnClickListener(this);
        mLinearlayoutJinhuo.setOnClickListener(this);
        mRlKuncunManager.setOnClickListener(this);
        ivLeftTou.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.relativelayout_leastmanager:
                //租赁管理
                intent.setClass(PutManagerActivity.this,LeaseManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.linearlayout_neworder:
                //TODO 跳到新订单
                intent.setClass(PutManagerActivity.this,LeaseManagerActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.linearlayout_rentting:
                //TODO 跳到新订单
                break;
            case R.id.linearlayout_overed:
                //TODO 跳到新订单
                break;
            case R.id.iv_put_manager_header:
                intent.setClass(PutManagerActivity.this,ShopDataActivity.class);
                startActivity(intent);
                break;
            case R.id.linearlayout_jinhuo:
                //我要进货
                intent.setClass(PutManagerActivity.this,GetGoodsActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_kucun_manager:
                //库存管理
                intent.setClass(PutManagerActivity.this,InventoryActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_left_tou:
                finish();
                break;
        }
    }

}

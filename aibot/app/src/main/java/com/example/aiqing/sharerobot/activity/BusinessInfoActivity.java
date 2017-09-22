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
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.MainBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/*
* 商家信息
*
* */
public class BusinessInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvApplyRent;
    private ImageView mIvReturn;
    private TextView mTvYizu;
    private TextView mTvKezu;
    private TextView mTvBussAddress;
    private TextView mTvStart;
    private TextView mTvClose;
    private TextView mBussNum;
    private String mCookie;
    private Dialog mLoadingDialog;
    private String mDistributorId;
    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_businessinfo);
        initFindId();

        initData();

    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        HttpTool httpTool=new HttpTool(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mDistributorId = bundle.getString("mDistributorId");
       // Log.e("投放商id", "initData: "+ mDistributorId);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://relay.aqcome.com/comm/getDistributorInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<MainBean> call = apiService.getMessage(mCookie, mDistributorId);
        call.enqueue(new Callback<MainBean>() {
            @Override
            public void onResponse(Response<MainBean> response, Retrofit retrofit) {
                    DialogUtil.closeDialog(mLoadingDialog);
                if (response.body().getObj()!=null){
                    mTvName.setText(response.body().getObj().getName());
                    mTvYizu.setText(response.body().getObj().getYzNum());
                    mTvKezu.setText(response.body().getObj().getDzNum());
                    mTvBussAddress.setText(response.body().getObj().getAddress());
                    mBussNum.setText(response.body().getObj().getContact1());
                    mTvStart.setText(response.body().getObj().getOpenTime2());
                    mTvClose.setText(response.body().getObj().getClosedTime2());
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(BusinessInfoActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    private void initFindId() {
        mTvName = (TextView) findViewById(R.id.tv_distributorname);
        mTvApplyRent = (TextView) findViewById(R.id.tv_apply_rent);
        mIvReturn = (ImageView) findViewById(R.id.iv_return);
        mTvYizu = (TextView) findViewById(R.id.tv_yizu);
        mTvKezu = (TextView) findViewById(R.id.tv_kezu);
        mBussNum = (TextView) findViewById(R.id.tv_bussphonenum);
        mTvBussAddress = (TextView) findViewById(R.id.tv_bussaddress);
        mTvStart = (TextView) findViewById(R.id.tv_starttime);
        mTvClose = (TextView) findViewById(R.id.tv_closetime);
        mTvApplyRent.setOnClickListener(this);
        mIvReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.tv_apply_rent:
                intent.setClass(BusinessInfoActivity.this,ApplyRentActivity.class);
                intent.putExtra("distributorId",mDistributorId);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_return:

                finish();
                break;
        }

    }
}

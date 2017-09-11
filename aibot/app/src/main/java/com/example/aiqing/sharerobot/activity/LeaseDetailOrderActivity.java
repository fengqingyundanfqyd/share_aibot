package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.LeaseDetailOrderAdapter;
import com.example.aiqing.sharerobot.bean.LeaseDetailBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//投放商  已租  明细
public class LeaseDetailOrderActivity extends AppCompatActivity {

    private String mCookie;
    private String mMProductId;
    private String mDistributorid;
    private TextView mTvPhone;
    private TextView mTvRentedNumber;
    private TextView mTvStatus;
    private ListView mLvDetailRented;
    private HttpTool mHttpTool;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lease_detail_hadrented);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("租赁明细");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        mMProductId = intent.getStringExtra("mProductId");

        SharedPreferences dis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = dis.getString("distributorid", "");
        mHttpTool = new HttpTool(this);
        initId();
        initDataHttp();
    }

    private void initId() {
        mLvDetailRented = (ListView) findViewById(R.id.listview_detail_hadrent);

        mTvPhone = (TextView) findViewById(R.id.tv_had_phone);
        mTvRentedNumber = (TextView) findViewById(R.id.tv_num_rented);
        mTvStatus = (TextView) findViewById(R.id.tv_status_hadrent);

    }

    private void initDataHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");

        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/rentMessage.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<LeaseDetailBean> call = apiService.leasedetail(mCookie,"M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W",mDistributorid);
        call.enqueue(new Callback<LeaseDetailBean>() {
            @Override
            public void onResponse(Response<LeaseDetailBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body().getProduct()==null){
                    return;
                }else {
                    mTvPhone.setText(response.body().getProduct().getMobile() + "");
                    mTvStatus.setText(response.body().getProduct().getRemark());

                    LeaseDetailBean body = response.body();

                    LeaseDetailOrderAdapter adapter = new LeaseDetailOrderAdapter(LeaseDetailOrderActivity.this, body);
                    mLvDetailRented.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(LeaseDetailOrderActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

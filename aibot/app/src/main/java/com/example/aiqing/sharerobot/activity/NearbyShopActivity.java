package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.NearbyAdapter;
import com.example.aiqing.sharerobot.bean.NearbyShopBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class NearbyShopActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvReturn;
    private LinearLayout mLlNearby;
    private ImageView mIvNearby;
    private ListView mLvNearbyShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_shop);
        initId();
        initData();
    }

    private void initData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Intent intent = getIntent();
        String lattuide = intent.getStringExtra("lattuide");
        String longtitid = intent.getStringExtra("longtitid");

            Log.e("附近", "initData: "+ lattuide+longtitid);


            Retrofit builder = new Retrofit.Builder()
                    .baseUrl("http://120.132.117.157:8083/comm/lbsSearch.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<NearbyShopBean> call = apiService.nearbyData(longtitid,lattuide,"10","1","10");
            call.enqueue(new Callback<NearbyShopBean>() {
                @Override
                public void onResponse(Response<NearbyShopBean> response, Retrofit retrofit) {
                    DialogUtil.closeDialog(loadingDialog);
                    List<NearbyShopBean.DistributorBean.ResultBean> result = response.body().getDistributor().getResult();
                    NearbyAdapter adapter = new NearbyAdapter(NearbyShopActivity.this, result);
                    mLvNearbyShop.setAdapter(adapter);

                }

                @Override
                public void onFailure(Throwable t) {

                }
            });

    }

    private void initId() {
        mIvReturn = (ImageView) findViewById(R.id.iv_nearby_return);
        mLlNearby = (LinearLayout) findViewById(R.id.ll_nearby);
        mIvNearby = (ImageView) findViewById(R.id.iv_nearby);
        mLvNearbyShop = (ListView) findViewById(R.id.lv_nearby_shop);

        mIvReturn.setOnClickListener(this);
        mLlNearby.setOnClickListener(this);
        mIvNearby.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_nearby_return:
                finish();
                break;
            case R.id.ll_nearby:
                Intent intent=new Intent();
                intent.setClass(NearbyShopActivity.this,SearchAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_nearby:
                finish();
                break;
        }
    }
}

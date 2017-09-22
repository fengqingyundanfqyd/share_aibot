package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
    private List<NearbyShopBean.DistributorBean.ResultBean> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_shop);
        initId();
        initData();
    }

    private void initData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        final Intent intent = getIntent();
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
                    mResult = response.body().getDistributor().getResult();
                    NearbyAdapter adapter = new NearbyAdapter(NearbyShopActivity.this, mResult);
                    mLvNearbyShop.setAdapter(adapter);

                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        //条目点击监听 跳转到申请租
        mLvNearbyShop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mDistributorId = mResult.get(position).getDistributorId();
                Intent intent1=new Intent();
                intent1.putExtra("mDistributorId",mDistributorId);
                intent1.setClass(NearbyShopActivity.this,BusinessInfoActivity.class);
                startActivity(intent1);
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

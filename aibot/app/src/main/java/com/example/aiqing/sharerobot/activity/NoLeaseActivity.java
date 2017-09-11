package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.NoLeaseAdapter;
import com.example.aiqing.sharerobot.bean.NotUsedBean;
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

//未租用
public class NoLeaseActivity extends AppCompatActivity {

    private Dialog mLoadingDialog;
    private TextView mTvNousenum;
    private ListView mLvNolease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_no_lease);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("未租用");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initData();

    }

    private void initData() {

        mTvNousenum = (TextView) findViewById(R.id.tv_nousenum);
        mLvNolease = (ListView) findViewById(R.id.listview_nolease);


        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = preferences.getString("mCookie", "");

        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/robotOrder/notUsedList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<NotUsedBean> call = apiService.notUsedlist(cookie,"1","5");
        call.enqueue(new Callback<NotUsedBean>() {
            @Override
            public void onResponse(Response<NotUsedBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                    if (response.body()!=null) {
                        mTvNousenum.setText(response.body().getCountNum() + "");

                        List<NotUsedBean.ObjBean.ResultBean> result = response.body().getObj().getResult();
                        NoLeaseAdapter noLeaseAdapter = new NoLeaseAdapter(NoLeaseActivity.this, result);
                        mLvNolease.setAdapter(noLeaseAdapter);
                    }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
            }
        });

    }
}

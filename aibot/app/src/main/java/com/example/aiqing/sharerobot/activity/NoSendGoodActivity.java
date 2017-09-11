package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.NoSendGoodsAdapter;
import com.example.aiqing.sharerobot.bean.NoSendBean;
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
//小宝未发货
public class NoSendGoodActivity extends AppCompatActivity {

    private Dialog mLoadingDialog;
    private ListView mLvNoSendGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_send_good);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("未发货");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initData();
        mLvNoSendGoods = (ListView) findViewById(R.id.listview_nosendgoods);


    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String  cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/robotOrder/notSendList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<NoSendBean> call = apiService.nosend(cookie, "1", "5");
        call.enqueue(new Callback<NoSendBean>() {
            @Override
            public void onResponse(Response<NoSendBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null){

                    List<NoSendBean.ObjBean.ResultBean> result = response.body().getObj().getResult();
                    NoSendGoodsAdapter goodsAdapter = new NoSendGoodsAdapter(NoSendGoodActivity.this,result);
                    mLvNoSendGoods.setAdapter(goodsAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(NoSendGoodActivity.this, "请检查您的网络连接", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

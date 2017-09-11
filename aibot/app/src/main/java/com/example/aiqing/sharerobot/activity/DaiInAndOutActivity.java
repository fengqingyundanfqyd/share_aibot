package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.DaiInAndOutAdapter;
import com.example.aiqing.sharerobot.bean.InAndOutBean;
import com.example.aiqing.sharerobot.bean.InAndOutBeanDai;
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

//代理商进出货
public class DaiInAndOutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mLvInandon;
    private List<InAndOutBean.DistributorListBean.ResultBean> mResultBeanList;
    private List<InAndOutBeanDai.AgencyListBean.ResultBean> mBeanList;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_in_and_out_dai);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("进出货");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initFindId();

        initData();
    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = preferences.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = spDis.getString("agencyId", "");

        Retrofit builder=new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/agencyByInOrOut.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = builder.create(ApiService.class);
        Call<InAndOutBeanDai> call = apiService.getGoodsDai(cookie, agencyId, "1", "5");
        call.enqueue(new Callback<InAndOutBeanDai>() {
            @Override
            public void onResponse(Response<InAndOutBeanDai> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null){

                    mBeanList = response.body().getAgencyList().getResult();

                    DaiInAndOutAdapter inAndOutAdapter = new DaiInAndOutAdapter(DaiInAndOutActivity.this, mBeanList);
                    mLvInandon.setAdapter(inAndOutAdapter);
                    mLvInandon.setOnItemClickListener(DaiInAndOutActivity.this);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(DaiInAndOutActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });

    }

    private void initFindId() {
        mLvInandon = (ListView) findViewById(R.id.listview_in_out_dai);
    }

    //条目点击监听
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        InAndOutBeanDai.AgencyListBean.ResultBean bean = mBeanList.get(position);
        String paId = bean.getPaId();

        Log.e("代理商paid", "onItemClick: "+paId );

        //详情
        Intent intent=new Intent();
        intent.setClass(DaiInAndOutActivity.this,DaiDetailingActivity.class);
        intent.putExtra("paId",paId);
        startActivity(intent);
        finish();
    }
}

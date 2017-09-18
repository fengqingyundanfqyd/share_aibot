package com.example.aiqing.sharerobot.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.DoCashRecordAdapter;
import com.example.aiqing.sharerobot.bean.DoCashDetailBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//提现记录
public class DoCashRecordActivity extends AppCompatActivity {

        private ImageView mIvReturn;
    private ListView mLvDocashRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_cash_record);
            mIvReturn = (ImageView) findViewById(R.id.iv_docash_return);
        mLvDocashRecord = (ListView) findViewById(R.id.lv_docash_recode);
        setData();
    }

        private void setData() {
            mIvReturn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
            String  cookie = spcookie.getString("mCookie", "");
            HttpTool httpTool = new HttpTool(this);
            Retrofit builder = new Retrofit.Builder()
                    .client(httpTool.client())
                    .baseUrl("http://120.132.117.157:8083/cust/getwithdrawRec.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<DoCashDetailBean> call = apiService.doCashDetail(cookie, "1", "10");
            call.enqueue(new Callback<DoCashDetailBean>() {
                @Override
                public void onResponse(Response<DoCashDetailBean> response, Retrofit retrofit) {
                    List<DoCashDetailBean.CashApplyListBean.ResultBean> result = response.body().getCashApplyList().getResult();
                    DoCashRecordAdapter adapter=new DoCashRecordAdapter(DoCashRecordActivity.this,result);
                    mLvDocashRecord.setAdapter(adapter);
                }

                @Override
                public void onFailure(Throwable t) {

                }
            });
        }
    }

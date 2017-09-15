package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.BankCardAdapter;
import com.example.aiqing.sharerobot.bean.BankListBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 选择银行卡
 */
public class SelectCardActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mLvCard;
    private ImageView mIvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);
        initId();
        getData();

    }

    private void getData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/bank/bankList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<BankListBean> call = apiService.getBanklist(cookie);
        call.enqueue(new Callback<BankListBean>() {
            @Override
            public void onResponse(Response<BankListBean> response, Retrofit retrofit) {
                if (response.body().getCoder().equals("0000")){
                    List<?> obj = response.body().getObj();
                }

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void initId() {
        Button btnAddcard = (Button) findViewById(R.id.btn_add_card);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_select_card);
        mLvCard = (ListView) findViewById(R.id.listview_card);

        BankCardAdapter bankCardAdapter = new BankCardAdapter(this);
        mLvCard.setAdapter(bankCardAdapter);

        btnAddcard.setOnClickListener(this);
        ivReturn.setOnClickListener(this);

        mLvCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mIvStatus = (ImageView) view.findViewById(R.id.iv_bank_status);
                mIvStatus.setTag("0");
                if (mIvStatus.getTag().equals("0")){
                    mIvStatus.setTag("1");
                    mIvStatus.setVisibility(View.VISIBLE);
                }else {
                    mIvStatus.setTag("0");
                    mIvStatus.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_card:
                //添加银行卡
                Intent intent=new Intent();
                intent.setClass(SelectCardActivity.this,AddCardActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_select_card:
               finish();
                break;
        }
    }
}

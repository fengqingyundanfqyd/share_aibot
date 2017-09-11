package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ChangeRentBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//转租信息  图片111
public class SubletMessageActivity extends AppCompatActivity {

    private TextView mTvName;
    private TextView mTvCanNum;
    private TextView mTvTotalNum;
    private TextView mTvPhone;
    private TextView mTvAddress;
    private TextView mTvBei;
    private String mCarId;
    private Button mBtnRent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sublet_message);
        initId();
        initData();
    }

    private void initData() {

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/custReletApply/custReletApplyInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ChangeRentBean> call = apiService.chengerent(cookie,mCarId);
        call.enqueue(new Callback<ChangeRentBean>() {
            @Override
            public void onResponse(Response<ChangeRentBean> response, Retrofit retrofit) {
              //  Log.e("转租信息", "onResponse: "+response.body().getObj().getAddress());
                if (response.body().getObj()!=null) {

                    mTvName.setText(response.body().getObj().getNickName()+"");
                    mTvCanNum.setText(response.body().getObj().getDzNum()+"台可租");

                    mTvTotalNum.setText("共"+response.body().getObj().getNum()+"台");
                    mTvPhone.setText(response.body().getObj().getMobile()+"");
                    mTvAddress.setText(response.body().getObj().getAddress());
                    mTvBei.setText(response.body().getObj().getRemark());
                }
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(SubletMessageActivity.this, "网络错误，请检查您的网络是否连接", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }

    private void initId() {
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_return_message);
        ImageView ivHeader = (ImageView) findViewById(R.id.iv_header_message);
        mTvName = (TextView) findViewById(R.id.tv_name_message);
        mTvCanNum = (TextView) findViewById(R.id.tv_can_num);
        mTvTotalNum = (TextView) findViewById(R.id.tv_total_num);
        mTvPhone = (TextView) findViewById(R.id.tv_phone);
        mTvAddress = (TextView) findViewById(R.id.tv_address_message);
        mTvBei = (TextView) findViewById(R.id.tv_message_bei);
        mBtnRent = (Button) findViewById(R.id.btn_rent);

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mCarId = bundle.getString("craId");

        Log.e("1111111111", "initId: "+ this.mCarId);

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBtnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SubletMessageActivity.this,ApplyRentActivity.class);
                startActivity(intent1);
            }
        });
    }
}

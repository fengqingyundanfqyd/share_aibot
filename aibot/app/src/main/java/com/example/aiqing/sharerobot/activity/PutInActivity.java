package com.example.aiqing.sharerobot.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.PersonalInfoBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.QRCodeUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/*
* 代理商码
* */
public class PutInActivity extends AppCompatActivity {

    private TextView mTvName;
    private String mNewCookie;
    private HttpTool mHttpTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_in);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("投放商邀请码");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        initFindId();
        getData();
    }

    private void getData() {
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mNewCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getCustInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<PersonalInfoBean> call = apiService.getPersonsInfo(mNewCookie);
        call.enqueue(new Callback<PersonalInfoBean>() {
            @Override
            public void onResponse(Response<PersonalInfoBean> response, Retrofit retrofit) {
                String nickname = response.body().getObj().getNickname();
                mTvName.setText(nickname);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void initFindId() {

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = spDis.getString("agencyId", "");

        ImageView ivPutIn = (ImageView) findViewById(R.id.iv_putin);
        mTvName = (TextView) findViewById(R.id.tv_nameagence);
        ivPutIn.setImageBitmap(QRCodeUtil.createQRCode("https://shared.aqcome.com/?a="+agencyId));
    }
}

package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.aiqing.sharerobot.MainActivity;
import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * 申请成功
 */
public class ApplySuccessActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_success);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("申请成功");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
//        initHttp();
        Button btnSure = (Button) findViewById(R.id.btn_sure);
        btnSure.setOnClickListener(this);

    }

//    private void initHttp() {
//        Retrofit builder = new Retrofit.Builder()
//                .baseUrl("http://192.168.1.56:8083/distributor/disributorPurchase.shtml")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ApiService apiService = builder.create(ApiService.class);
//        Call<PersonalInfoBean> call = apiService.getPersonsInfo("1");
//        call.enqueue(new Callback<PersonalInfoBean>() {
//            @Override
//            public void onResponse(Response<PersonalInfoBean> response, Retrofit retrofit) {
//
//            }
//            @Override
//            public void onFailure(Throwable t) {
//                Toast.makeText(ApplySuccessActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
//                Log.e("失败", "失败" + t.getMessage());
//            }
//        });
//    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        intent.setClass(ApplySuccessActivity.this, Main2Activity.class);
        startActivity(intent);
        ApplySuccessActivity.this.finish();
    }
}

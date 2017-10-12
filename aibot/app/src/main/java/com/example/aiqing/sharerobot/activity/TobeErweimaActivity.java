package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

/**
 * 生成二维码界面
 */
public class TobeErweimaActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mRelativelayouYajin;
    private RelativeLayout mRelativelayouPutin;
    private String mNewCookie;
    private HttpTool mHttpTool;
    private TextView mTvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tobe_erweima);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("我的二维码");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        String custId = spDis.getString("custId", "");
        initFindId();

        ImageView ivQrcode = (ImageView) findViewById(R.id.iv_qrcode);
        ivQrcode.setImageBitmap(QRCodeUtil.createQRCode("https://shared.aqcome.com/?c="+custId));

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
        mRelativelayouYajin = (RelativeLayout) findViewById(R.id.relativelayout_yajin);
        mRelativelayouPutin = (RelativeLayout) findViewById(R.id.relativelayout_putin);
        mTvName = (TextView) findViewById(R.id.tv_name_erweima);


        mRelativelayouYajin.setOnClickListener(this);
        mRelativelayouPutin.setOnClickListener(this);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.relativelayout_yajin:
                //生成投放商码
                intent.setClass(this,YajinActivity.class);
                startActivity(intent);
                break;
            case R.id.relativelayout_putin:
                //生成代理商码
                intent.setClass(this,PutInActivity.class);
                startActivity(intent);
                break;
        }
    }
}

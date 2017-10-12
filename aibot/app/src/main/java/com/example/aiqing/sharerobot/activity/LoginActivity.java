package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.GetYanzhengmaBean;
import com.example.aiqing.sharerobot.bean.ToLoginBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtLoginPhoneNum;
    private EditText mEtYanzhengma;
    private TextView mTvYanzhengma;
    private Button mBtnLogin;
    private String mPhoneNumber;
    private int countSeconds = 60;//倒计时
    private String mMsg;
    private String mSubstring;
    private String mCookie;
    private String mNewCookie;
    private Dialog mLoadingDialog;
    private Dialog mLoadingDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initFindId();
    }

    //获取验证码
    private void initData(String number) {

        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");

        if (TextUtils.isEmpty(number)) {
            Toast.makeText(this, "您输入的手机号有误，请重新输入。", Toast.LENGTH_SHORT).show();
        } else {
            Retrofit builder = new Retrofit.Builder()
                    .baseUrl("http://120.132.117.157:8083/comm/sendPhoneCode.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<GetYanzhengmaBean> call = apiService.getYanzhengma(number, "registerTemplate", "1");
            call.enqueue(new Callback<GetYanzhengmaBean>() {
                @Override
                public void onResponse(Response<GetYanzhengmaBean> response, Retrofit retrofit) {
                    Log.e("验证码", "onResponse: " + response.body().getRetMsg());
                    DialogUtil.closeDialog(mLoadingDialog);
                    if (countSeconds > 0) {
                        --countSeconds;
                        //获取到的验证码
                        mMsg = response.body().getRetMsg();

                        String shu = response.headers().newBuilder().get("Set-Cookie");
                        String[] split = shu.split(";");
                        String session = split[0];
                        String[] split1 = session.split("=");
                        mCookie = split1[split1.length - 1];


                        SharedPreferences sp = getSharedPreferences("COOKIE", MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("mCookie", mCookie);
                        edit.commit();
                        Log.e("11111111", "onResponse: " + mCookie);


                        mSubstring = mMsg.substring(0, 6);
                        mEtYanzhengma.setText(mSubstring);
                        mEtYanzhengma.setSelection(mEtYanzhengma.getText().length());

                        Toast.makeText(LoginActivity.this, "获取成功" + mMsg, Toast.LENGTH_SHORT).show();
                    } else {
                        countSeconds = 60;
                        Toast.makeText(LoginActivity.this, "请重新获取验证码！", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(LoginActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void initFindId() {
        mEtLoginPhoneNum = (EditText) findViewById(R.id.et_login_phonenum);
        mEtYanzhengma = (EditText) findViewById(R.id.et_yanzhengma);
        mTvYanzhengma = (TextView) findViewById(R.id.tv_send_yanzhengma);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        ImageView ivLeftClose = (ImageView) findViewById(R.id.iv_left_close);

        mTvYanzhengma.setOnClickListener(this);
        ivLeftClose.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_send_yanzhengma:
                mPhoneNumber = mEtLoginPhoneNum.getText().toString().trim();
                String number = mEtLoginPhoneNum.getText().toString();
                boolean mobile = isMobile(number);
                if (mobile==true){
                    initData(number);
                }else {
                    Toast.makeText(this, "手机号不合法！", Toast.LENGTH_SHORT).show();
                }


                break;
            case R.id.btn_login:
                //登录

//                String number = mEtLoginPhoneNum.getText().toString();
//                boolean mobile = isMobile(number);
//                if (mobile==true){
                    login();
//                }else {
//                    Toast.makeText(this, "手机号不合法！", Toast.LENGTH_SHORT).show();
//                }

//                if (mEtLoginPhoneNum.getText().toString().equals("")&&mEtYanzhengma.getText().toString().equals("")){
//                    Toast.makeText(this, "请输入正确的手机号和验证码。", Toast.LENGTH_SHORT).show();
//                }else {
//                    login();
//                }
                break;
            case R.id.iv_left_close:
                finish();
                break;
        }
    }

    //登录
    private void login() {

//        LinearLayout layout = new LinearLayout(this);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
//        lp.setMargins(10, 10, 10, 10);
//        GifView gifView = new GifView(this);
//        gifView.setGifResource(R.drawable.flower);
//        gifView.setLayoutParams(lp);
//        layout.setGravity(Gravity.CENTER);
//        layout.addView(gifView);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(layout);
//        builder.create().show();
        mLoadingDialog2 = DialogUtil.createLoadingDialog(this, "加载中...");

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new ReadCookiesInterceptor());
        okHttpClient.interceptors().add(new SaveCookiesInterceptor());
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mNewCookie = preferences.getString("mCookie", "");

        Retrofit builder1 = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://120.132.117.157:8083/comm/doLoginNew.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder1.create(ApiService.class);
        Call<ToLoginBean> call = apiService.login(mNewCookie, mPhoneNumber, mSubstring, "1");
        Log.e("999999", "login: " + mNewCookie);
        call.enqueue(new Callback<ToLoginBean>() {
            @Override
            public void onResponse(Response<ToLoginBean> response, Retrofit retrofit) {

                DialogUtil.closeDialog(mLoadingDialog2);
                if (response.body().isSuccess()) {
                    String distributorId = response.body().getResult().getBean().getDistributorId();
                    Log.e("机器人000", "onResponse: " + distributorId);

                    String agencyId = response.body().getResult().getBean().getAgencyId();
                    Log.e("机器人111", "onResponse: " + agencyId);

                    double balance = response.body().getResult().getBean().getBalance();
                    Log.e("余额", "onResponse: " + balance);

                    String nickname = response.body().getResult().getBean().getNickname();

                    String custId = response.body().getResult().getBean().getCustId();

                    //存储各类信息
                    SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
                    SharedPreferences.Editor edit = spDis.edit();
                    edit.putString("distributorid", distributorId);
                    edit.putString("agencyId", agencyId);
                    edit.putLong("balance", (long) balance);
                    edit.putString("nickname", nickname);
                    edit.putString("custId", custId);
                    edit.commit();

                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(LoginActivity.this, "登录失败，请重新登录", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //用来加入cookie
    public class ReadCookiesInterceptor implements Interceptor {

        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            builder.addHeader("Cookie", "JSESSIONID=" + mCookie);
            return chain.proceed(builder.build());
        }
    }

    //用来保存Cookies
    public class SaveCookiesInterceptor implements Interceptor {
        @Override
        public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
            com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());

            if (!originalResponse.headers("Set-Cookie").isEmpty()) {
                HashSet<String> cookies = new HashSet<>();

                for (String header : originalResponse.headers("Set-Cookie")) {
                    cookies.add(header);
                }

            }
            return originalResponse;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
}

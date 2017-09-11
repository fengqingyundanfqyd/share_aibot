package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.UpDataNickName;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
//修改用户昵称
public class UpdataNickNameActivity extends AppCompatActivity implements View.OnClickListener {

    private TopMenuHeader mTopMenuHeader;
    private EditText mEtNiname;
    private String mCookie;
    private HttpTool mHttpTool;
    private Button mBtnRight;
    private ImageView mIvLeft;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_nick_name);
        initView();
        initData();
    }

    private void initView() {
        mEtNiname = (EditText) findViewById(R.id.et_niname);
        mIvLeft = (ImageView) findViewById(R.id.top_menu_left);
        mBtnRight = (Button) findViewById(R.id.top_menu_right);

    }

    private void initData() {
        mIvLeft.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_menu_left:
                finish();
                break;
            case R.id.top_menu_right:
                mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
                SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
                mCookie = preferences.getString("mCookie", "");
                mHttpTool = new HttpTool(UpdataNickNameActivity.this);
                final String niName = mEtNiname.getText().toString();
                Retrofit builder = new Retrofit.Builder()
                        .client(mHttpTool.client())
                        .baseUrl("http://120.132.117.157:8083/account/updateNickname.shtml")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = builder.create(ApiService.class);
                Call<UpDataNickName> call = apiService.upDataNickName(mCookie, niName);
                call.enqueue(new Callback<UpDataNickName>() {
                    @Override
                    public void onResponse(Response<UpDataNickName> response, Retrofit retrofit) {

                    //    Log.e("修改昵称", "onResponse: "+response.body().isSuccess() );
//                        if (response.body().isSuccess()==true){
//                            SharedPreferences sp = getSharedPreferences("NickName", MODE_PRIVATE);
//                            SharedPreferences.Editor edit = sp.edit();
//                            edit.putString("niName",niName).commit();
//                        }
                        DialogUtil.closeDialog(mLoadingDialog);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        DialogUtil.closeDialog(mLoadingDialog);
                        Toast.makeText(UpdataNickNameActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                        Log.e("失败", "失败" + t.getMessage());
                    }
                });
                Intent intent = new Intent(UpdataNickNameActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

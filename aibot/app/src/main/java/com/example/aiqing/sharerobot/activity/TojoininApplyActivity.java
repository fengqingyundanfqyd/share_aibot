package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ApplyJoinBean;
import com.example.aiqing.sharerobot.bean.YaoqingManBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 加盟申请
 */
public class TojoininApplyActivity extends AppCompatActivity implements View.OnClickListener {

    private int minute;
    private LinearLayout mLlStartandEnd;
    private EditText mEtShopname;
    private RelativeLayout mRl_chooseaddress;
    private EditText mEt_detailadd;
    private Button mBtn_apply_join;
    private ImageView mIvYaoqingHeader;
    private TextView mTvYaoqingdetail;
    private Dialog mLoadingDialog;
    private String mAgencyid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_tojoinin_apply);

        initFindId();
        initData();

        initYaoqingzheData();
    }
    //邀请者信息
    private void initYaoqingzheData() {

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String sid = spcookie.getString("mCookie", "");

        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://120.132.117.157:8083/agency/agencyInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<YaoqingManBean> call = apiService.yaoqinzhe(sid,mAgencyid);

        call.enqueue(new Callback<YaoqingManBean>() {
            @Override
            public void onResponse(Response<YaoqingManBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null){

                    Log.e("邀请者", "onResponse: "+response.body().getObj().getHeadImg() );
                    Log.e("邀请者", "onResponse: "+response.body().getObj().getAgencyId() );
                    Log.e("邀请者", "onResponse: "+response.body().getObj().getRealName());
                    Bitmap bm = BitmapFactory.decodeFile(response.body().getObj().getHeadImg());
                    mIvYaoqingHeader.setImageBitmap(bm);
                    mTvYaoqingdetail.setText(response.body().getObj().getRealName());
                }

            }
            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(TojoininApplyActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String sid = spcookie.getString("sessionid", "");

        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://120.132.117.157:8083/account/scanCodeNew.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ApplyJoinBean> call = apiService.toJiameng(sid,"1","爱卿科技","18871579392","0","08：00","22：00","是","120.1751500000","30.3268900000","","中大银泰城");

        call.enqueue(new Callback<ApplyJoinBean>() {
            @Override
            public void onResponse(Response<ApplyJoinBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                Log.e("申请加盟", "onResponse: "+response.body().isSuccess() );
            }
            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(TojoininApplyActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initFindId() {
        RelativeLayout rlStartTime = (RelativeLayout) findViewById(R.id.rl_starttime);
        RelativeLayout rlEndTime = (RelativeLayout) findViewById(R.id.rl_endtime);
        mEtShopname = (EditText) findViewById(R.id.et_shopname);
        mRl_chooseaddress = (RelativeLayout) findViewById(R.id.rl_chooseaddress);
        mEt_detailadd = (EditText) findViewById(R.id.et_detailadd);
        mBtn_apply_join = (Button) findViewById(R.id.btn_apply_join);
        mIvYaoqingHeader = (ImageView) findViewById(R.id.iv_yaoqingheader);
        mTvYaoqingdetail = (TextView) findViewById(R.id.tv_yaoqingdetail);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_return_apply);

        Intent intent = getIntent();
        mAgencyid = intent.getStringExtra("agencyid");

        rlStartTime.setOnClickListener(this);
        rlEndTime.setOnClickListener(this);
        mRl_chooseaddress.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_starttime:
               // mLlStartandEnd.setVisibility(View.VISIBLE);
//                initHours();
//                initMinuts();
                break;
            case R.id.rl_endtime:
               // mLlStartandEnd.setVisibility(View.VISIBLE);
//                initHours();
//                initMinuts();
                break;
            case R.id.rl_chooseaddress:
               //选择地址  跳转我的地址
                Intent intent=new Intent();
                intent.setClass(TojoininApplyActivity.this,SearchAddressActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_return_apply:
              finish();
                break;
        }
    }

}

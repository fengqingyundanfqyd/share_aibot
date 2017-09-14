package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.aiqing.sharerobot.inf.HttpTool;
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
   // private String mAgencyid;
    private HttpTool mHttpTool;
    private String mAgencyId;
    private String mLatitude;
    private String mLongitude;
    private String mCookie;
    private String mProvince;
    private String mCity;
    private String mStreetNum;
    private String mAddress;
    private TextView mTvAddress;
    private String mPhone;
    private TextView tvNewadd;
    private LinearLayout mLlAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_tojoinin_apply);
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mAgencyId = spDis.getString("agencyId", "");
        mHttpTool = new HttpTool(this);
        initFindId();
       // initData();

        initYaoqingzheData();
    }
    //邀请者信息
    private void initYaoqingzheData() {



        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/agencyInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<YaoqingManBean> call = apiService.yaoqinzhe(mCookie,mAgencyId);

        call.enqueue(new Callback<YaoqingManBean>() {



            @Override
            public void onResponse(Response<YaoqingManBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null){
                    mPhone = response.body().getObj().getMobile().toString();
                    Log.e("电话", "onResponse: "+mPhone );
//                    Bitmap bm = BitmapFactory.decodeFile(response.body().getObj().getHeadImg());
//                    mIvYaoqingHeader.setImageBitmap(bm);
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
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/scanCodeNew.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ApplyJoinBean> call = apiService.toJiameng(mCookie,mAgencyId,mEtShopname.getText().toString(),mPhone,"0","08：00","21：00","",mLongitude,mLatitude,"","中大银泰城");

        call.enqueue(new Callback<ApplyJoinBean>() {
            @Override
            public void onResponse(Response<ApplyJoinBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                Log.e("申请投放商", "onResponse: "+response.body().getCoder() );
                if (response.body().getCoder().equals("0000")){
                    Toast.makeText(TojoininApplyActivity.this, "您已成功申请投放商。", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(TojoininApplyActivity.this, response.body().getErrorMsg().toString(), Toast.LENGTH_SHORT).show();
                    finish();
                }
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
        mTvAddress = (TextView) findViewById(R.id.tv_add_join);
        tvNewadd = (TextView) findViewById(R.id.tv_newadd);
        mLlAdd = (LinearLayout) findViewById(R.id.ll_add);

//        Intent intent = getIntent();
//        mAgencyid = intent.getStringExtra("agencyid");

        rlStartTime.setOnClickListener(this);
        rlEndTime.setOnClickListener(this);
        mRl_chooseaddress.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
        mBtn_apply_join.setOnClickListener(this);
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
                startActivityForResult(intent,9);
                break;
            case R.id.iv_return_apply:
              finish();
                break;
            case R.id.btn_apply_join:
                //申请加盟
                initData();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 9) {
            Bundle bundle = data.getExtras();
            mLatitude = bundle.getString("mLatitude");
            mLongitude = bundle.getString("mLongitude");
            mProvince = bundle.getString("mProvince");
            mCity = bundle.getString("mCity");
            String district = bundle.getString("mDistrict");//街道信息
            //街道门牌号信息
            mStreetNum = bundle.getString("mStreetNum");
            mAddress = mProvince+mCity+mStreetNum;
            Log.e("加盟地址", "onActivityResult: "+ mAddress);
            mLlAdd.setVisibility(View.GONE);
            tvNewadd.setVisibility(View.VISIBLE);
            tvNewadd.setText(mProvince+mCity);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

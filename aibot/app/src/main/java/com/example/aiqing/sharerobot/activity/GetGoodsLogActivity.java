package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.ProblemAdapter;
import com.example.aiqing.sharerobot.bean.CommitBean;
import com.example.aiqing.sharerobot.bean.ProblemBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//投放商收货日志
public class GetGoodsLogActivity extends AppCompatActivity implements View.OnClickListener {

    private String mCookie;
    private HttpTool mHttpTool;
    private String mDistributorid;
    private ImageView mIvReturn;
    private RelativeLayout mRlAllright;
    private ImageView mIvAllright;
    private RelativeLayout mRlHaveproblem;
    private LinearLayout mLlMuchproblem;
    private RelativeLayout mRlEmpty;
    private ImageView mIvEmpty;
    private RelativeLayout mRlMissed;
    private ImageView mIvMissed;
    private RelativeLayout mRlOthersproblem;
    private TextView mTvCustormoney;
    private ImageView mIvOtherproblem;
    private Button mBtnCommit;
    private ListView mLvProblem;
    private String mProductId;
    private List<ProblemBean.ObjBean> mObj;
    private String mPfiId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_goods_log);

        initId();
        initData();
    }

    private void initId() {
        mIvReturn = (ImageView) findViewById(R.id.iv_log_return);
        mRlAllright = (RelativeLayout) findViewById(R.id.rl_allright);
        mIvAllright = (ImageView) findViewById(R.id.iv_allright);
        mRlHaveproblem = (RelativeLayout) findViewById(R.id.rl_haveproblem);
        mLlMuchproblem = (LinearLayout) findViewById(R.id.ll_muchproblem);
        /*mRlEmpty = (RelativeLayout) findViewById(R.id.rl_empty);
        mIvEmpty = (ImageView) findViewById(R.id.iv_empty);
        mRlMissed = (RelativeLayout) findViewById(R.id.rl_missed);
        mIvMissed = (ImageView) findViewById(R.id.iv_missed);
        mRlOthersproblem = (RelativeLayout) findViewById(R.id.rl_othersproblem);
        mIvOtherproblem = (ImageView) findViewById(R.id.iv_otherproblem);*/
        mTvCustormoney = (TextView) findViewById(R.id.tv_custmer_money);
        mBtnCommit = (Button) findViewById(R.id.btn_commit);

        mLvProblem = (ListView) findViewById(R.id.lv_problem);
        mLvProblem.setVisibility(View.GONE);
    }

    private void initData() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mProductId = bundle.getString("productId");
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = spDis.getString("distributorid", "");

        mIvReturn.setOnClickListener(this);
        mRlAllright.setOnClickListener(this);
        mRlHaveproblem.setOnClickListener(this);
        /*mRlMissed.setOnClickListener(this);
        mRlMissed.setOnClickListener(this);
        mRlOthersproblem.setOnClickListener(this);*/

        getProblemData();

        mBtnCommit.setOnClickListener(this);


    }

    private void getProblemData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/product/forFeitList.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ProblemBean> call = apiService.problem(mCookie, mProductId);
        call.enqueue(new Callback<ProblemBean>() {
            @Override
            public void onResponse(Response<ProblemBean> response, Retrofit retrofit) {
                mObj = response.body().getObj();
                ProblemAdapter problemAdapter = new ProblemAdapter(GetGoodsLogActivity.this, mObj);
                mLvProblem.setAdapter(problemAdapter);
                mLvProblem.setVisibility(View.VISIBLE);
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(GetGoodsLogActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });

        mLvProblem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView ivProblem = (ImageView) view.findViewById(R.id.iv_empty);
                ivProblem.setVisibility(View.VISIBLE);
                mPfiId = mObj.get(position).getPfiId();
                double fee = mObj.get(position).getFee();
                String f = String.valueOf(fee);
                mBtnCommit.setBackgroundResource(R.drawable.shape_bg_chongzhi);
                Log.e("点击的问题", "onItemClick: " + mPfiId + "00" + fee);
                mTvCustormoney.setText("租客押金:-" + f + "元");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_log_return:
                finish();
                break;
            case R.id.rl_allright:
                mIvAllright.setVisibility(View.VISIBLE);
                mTvCustormoney.setText("租客押金:全部退还");
                mBtnCommit.setBackgroundResource(R.drawable.shape_bg_chongzhi);
                mLlMuchproblem.setVisibility(View.GONE);
                break;
            case R.id.rl_haveproblem:
                mIvAllright.setVisibility(View.GONE);
                mLlMuchproblem.setVisibility(View.VISIBLE);
                break;
           /* case R.id.rl_empty:
                mIvEmpty.setVisibility(View.VISIBLE);
                mIvMissed.setVisibility(View.GONE);
                mIvOtherproblem.setVisibility(View.GONE);
                break;
            case R.id.rl_missed:
                mIvEmpty.setVisibility(View.GONE);
                mIvMissed.setVisibility(View.VISIBLE);
                mIvOtherproblem.setVisibility(View.GONE);
                break;
            case R.id.rl_othersproblem:
                mIvEmpty.setVisibility(View.GONE);
                mIvMissed.setVisibility(View.GONE);
                mIvOtherproblem.setVisibility(View.VISIBLE);
                break;*/
            case R.id.btn_commit:
                commit();
                break;
        }
    }

    private void commit() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/receiptB2C.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<CommitBean> call = apiService.commit(mCookie, mProductId, mDistributorid, mPfiId);
        call.enqueue(new Callback<CommitBean>() {
            @Override
            public void onResponse(Response<CommitBean> response, Retrofit retrofit) {
                if (response.body().getCoder().equals("0000")) {
                    Toast.makeText(GetGoodsLogActivity.this, "归还申请提交成功", Toast.LENGTH_SHORT).show();
                    DialogUtil.closeDialog(loadingDialog);
                    finish();
                } else {
                    Toast.makeText(GetGoodsLogActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    DialogUtil.closeDialog(loadingDialog);
                    finish();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(GetGoodsLogActivity.this, "网络连接失败", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }
}

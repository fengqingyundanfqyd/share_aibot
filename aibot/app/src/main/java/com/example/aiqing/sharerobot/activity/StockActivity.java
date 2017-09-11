package com.example.aiqing.sharerobot.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.DaiKucunAdapter;
import com.example.aiqing.sharerobot.bean.DaiKucunBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


//代理商--库存
public class StockActivity extends AppCompatActivity implements View.OnClickListener {

    private String mCookie;
    private TextView mTvTotalNumDai;
    private TextView mTvHaveinitDai;
    private TextView mTvNoinitDai;
    private ListView mListviewChushiDai;
    private int mTapSlop;
    private float mDownY;
    private int direction;
    private LinearLayout mLlTopDai;
    private boolean mshop;
    private Animator mAnimator;
    private LinearLayout mLlHadInitNum;
    private Button mBtnJinhuoDai;
    private ImageView mIvInOutDai;
    private ImageView mIvKuCunDai;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stock);

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        initFindId();
        initHttp();
        initData();
    }

    private void initData() {
        mTapSlop = ViewConfiguration.get(this).getScaledDoubleTapSlop();
        //监听ls的滑动事件
        mListviewChushiDai.setOnTouchListener(new OnTaTouchListent());

        //点击监听
        mBtnJinhuoDai.setOnClickListener(this);
        mIvKuCunDai.setOnClickListener(this);
        mIvInOutDai.setOnClickListener(this);
        mLlHadInitNum.setOnClickListener(this);
    }

    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = data.getString("agencyId", "");

        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/agencyByApply.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DaiKucunBean> call = apiService.daiKucun(mCookie, agencyId, "1", "5");

        call.enqueue(new Callback<DaiKucunBean>() {
            @Override
            public void onResponse(Response<DaiKucunBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                mTvTotalNumDai.setText(response.body().getApplyNum() + "");
                mTvHaveinitDai.setText(response.body().getInitNum() + "");
                mTvNoinitDai.setText(response.body().getNoInitNum() + "");

                if (response.body().getProList().getObj()!=null){
                    List<DaiKucunBean.ProListBean.ObjBean.ResultBean> result = response.body().getProList().getObj().getResult();
                    DaiKucunAdapter daiKucunAdapter = new DaiKucunAdapter(StockActivity.this, result);
                    //设置适配器
                    mListviewChushiDai.setAdapter(daiKucunAdapter);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(StockActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFindId() {
        mIvKuCunDai = (ImageView) findViewById(R.id.iv_kucun_return_dai);
        mIvInOutDai = (ImageView) findViewById(R.id.iv_in_out_dai);
        mListviewChushiDai = (ListView) findViewById(R.id.listview_chushi_dai);

        mBtnJinhuoDai = (Button) findViewById(R.id.btn_jinhuo_dai);

        mLlTopDai = (LinearLayout) findViewById(R.id.linearlayout_top_dai);

        mTvTotalNumDai = (TextView) findViewById(R.id.tv_totalnum_dai);
        mTvHaveinitDai = (TextView) findViewById(R.id.tv_haveinit_dai);
        mTvNoinitDai = (TextView) findViewById(R.id.tv_noinit_dai);
        mLlHadInitNum = (LinearLayout) findViewById(R.id.ll_hadinitnum);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_jinhuo_dai:
                //跳转到进货界面
                intent.setClass(StockActivity.this, GetGoodsActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_kucun_return_dai:
                //返回
                finish();
                break;
            case R.id.iv_in_out_dai:
                //进出货
                intent.setClass(this, DaiInAndOutActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.ll_hadinitnum:
                //已初始化
//                intent.setClass(this, HadInitDaiActivity.class);
//                startActivity(intent);
//                finish();
                break;
        }
    }

    private class OnTaTouchListent implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //按下时的位置
                    mDownY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float moveY = event.getY();//滑动的位置
                    if (moveY - mDownY > mTapSlop) {
                        direction = 0;//向下滑动
                    } else if (mDownY - moveY > mTapSlop) {
                        direction = 1;//向上滑动
                        mLlTopDai.setVisibility(View.GONE);
                    }
                    if (direction == 1) {
                        if (mshop) {
                            topAnim(1);//向上滑动动画
                            mshop = !mshop;
                        }
                    } else if (direction == 0) {
                        if (!mshop) {
                            topAnim(0);//向下滑动动画
                            mshop = !mshop;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    }

    private void topAnim(int i) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();//如果执行了就关闭
        }
        if (i == 0) {
            mAnimator = ObjectAnimator.ofFloat(mLlTopDai, "translationY", mLlTopDai.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mLlTopDai, "translationY", -mLlTopDai.getHeight(), 0);
        }
        mAnimator.start();
    }
}

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
import com.example.aiqing.sharerobot.adapter.ChushiRobotAdapter;
import com.example.aiqing.sharerobot.bean.KucunBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 投放商--库存界面
 */
public class InventoryActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mListviewChushi;
    private int mTapSlop;
    private float mDownY;
    private int direction;
    private boolean mshop;
    private Animator mAnimator;
    private LinearLayout mLlTop;
    private TextView mTvTotalNum;
    private TextView mTvHaveinit;
    private TextView mTvNoinit;
    private String mSid;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inventory);
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");
        initFindId();
        initHttp();
        initData();

    }

    //请求服务器
    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences data = getSharedPreferences("DATA", MODE_PRIVATE);
        String distributorid = data.getString("distributorid", "");

        HttpTool httpTool=new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/distributorStock.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<KucunBean> call = apiService.getKuncun( mSid,distributorid, "1","5");

        call.enqueue(new Callback<KucunBean>() {
            @Override
            public void onResponse(Response<KucunBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body().getProList().getObj()!=null) {
                    mTvTotalNum.setText(response.body().getApplyNum() + "");
                    mTvHaveinit.setText(response.body().getInitNum() + "");
                    mTvNoinit.setText(response.body().getNotInitNum() + "");


                    List<KucunBean.ProListBean.ObjBean.ResultBean> result = response.body().getProList().getObj().getResult();
                    ChushiRobotAdapter chushiRobotAdapter = new ChushiRobotAdapter(InventoryActivity.this, result);
                    //设置适配器
                    mListviewChushi.setAdapter(chushiRobotAdapter);
                }

            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(InventoryActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initData() {

//        View header = View.inflate(InventoryActivity.this, R.layout.public_header, null);
//        mListviewChushi.addView(header);
        //获得小滑动的距离
        mTapSlop = ViewConfiguration.get(this).getScaledDoubleTapSlop();


        //监听ls的滑动事件
        mListviewChushi.setOnTouchListener(new OnTaTouchListent());
    }

    private void initFindId() {
        ImageView ivKuCun = (ImageView) findViewById(R.id.iv_kucun_return);
        ImageView ivInOut = (ImageView) findViewById(R.id.iv_in_out);
        mListviewChushi = (ListView) findViewById(R.id.listview_chushi);
        Button btnTuihuo = (Button) findViewById(R.id.btn_tuihuo);
        Button btnJinhuo = (Button) findViewById(R.id.btn_jinhuo);
        Button btnHuanhuo = (Button) findViewById(R.id.btn_huanhuo);
        mLlTop = (LinearLayout) findViewById(R.id.linearlayout_top);
        mTvTotalNum = (TextView) findViewById(R.id.tv_totalnum);
        mTvHaveinit = (TextView) findViewById(R.id.tv_haveinit);
        mTvNoinit = (TextView) findViewById(R.id.tv_noinit);

        btnJinhuo.setOnClickListener(this);
        btnTuihuo.setOnClickListener(this);
        btnHuanhuo.setOnClickListener(this);
        ivKuCun.setOnClickListener(this);
        ivInOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.btn_jinhuo:
                //跳转到进货界面
                intent.setClass(InventoryActivity.this, GetGoodsActivity.class);
                startActivity(intent);
                InventoryActivity.this.finish();
                break;
            case R.id.btn_tuihuo:
                break;
            case R.id.btn_huanhuo:
                break;
            case R.id.iv_kucun_return:
                //返回
                finish();
                break;
            case R.id.iv_in_out:
                //进出货
                intent.setClass(InventoryActivity.this, InAndOutActivity.class);
                startActivity(intent);
                finish();
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
                        mLlTop.setVisibility(View.GONE);
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
            mAnimator = ObjectAnimator.ofFloat(mLlTop, "translationY", mLlTop.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mLlTop, "translationY", -mLlTop.getHeight(), 0);
        }
        mAnimator.start();
    }
}

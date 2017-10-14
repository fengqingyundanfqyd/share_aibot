package com.example.aiqing.sharerobot.activity;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.MyAibotBean;
import com.example.aiqing.sharerobot.fragment.BuyOutFragment;
import com.example.aiqing.sharerobot.fragment.FinishRentFragment;
import com.example.aiqing.sharerobot.fragment.MyFragmentAdapter;
import com.example.aiqing.sharerobot.fragment.RenttingFragment;
import com.example.aiqing.sharerobot.fragment.ReturningFragment;
import com.example.aiqing.sharerobot.fragment.ReturningNoRentFragment;
import com.example.aiqing.sharerobot.fragment.SubletReleaseFragment;
import com.example.aiqing.sharerobot.fragment.SublettingFragment;
import com.example.aiqing.sharerobot.fragment.SublettingNoRentFragment;
import com.example.aiqing.sharerobot.fragment.WaitPayFragment;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class ViewpagerActivity extends AppCompatActivity implements View.OnClickListener {


    private FragmentManager mFm;
    private WaitPayFragment mWaitPayFragment;
    private RenttingFragment mRenttingFragment;
    private SubletReleaseFragment mSubletReleaseFragment;
    private ViewPager mVpnew;
    private BuyOutFragment mBuyOutFragment;
    private MyFragmentAdapter mMyFragmentAdapter;
    private LinearLayout mLinearLayout;
    private List<ImageView> mDots;
    private LinearLayout mLlVp;
    private LinearLayout mLinearlayoutVp;
    private ImageView mIvNodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        initId();

        initHttp();

    }

    private void initId() {
        mVpnew = (ViewPager) findViewById(R.id.vp_aibot_new);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_myaibot_return);
        ImageView ivHistory = (ImageView) findViewById(R.id.iv_myaibot_history);
        mLinearLayout = (LinearLayout) findViewById(R.id.linerlayout_dot);
        mLlVp = (LinearLayout) findViewById(R.id.ll_vp);
       // mLinearlayoutVp = (LinearLayout) findViewById(R.id.viewpager_linerlayout);
        mIvNodata = (ImageView) findViewById(R.id.iv_nodata_new);


        ivReturn.setOnClickListener(this);
        ivHistory.setOnClickListener(this);

    }

    private void initHttp() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(this);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/payRent/orderInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<MyAibotBean> call = apiService.myRobot(cookie, "1", "10");
        call.enqueue(new Callback<MyAibotBean>() {
            @Override
            public void onResponse(Response<MyAibotBean> response, Retrofit retrofit) {
                if (response.body() == null) {
                    //没有小宝
//                    mLlVp.setVisibility(View.GONE);
//                    mLlVp.setVisibility(View.GONE);
//                    mIvNodata.setVisibility(View.VISIBLE);

                    mLlVp.setVisibility(View.GONE);
                    mIvNodata.setVisibility(View.VISIBLE);
                } else {
                    List<MyAibotBean.ObjBean.ResultBean> result = response.body().getObj().getResult();

                    MyAibotBean.SystemBean system = response.body().getSystem();

                    //添加页面
                    List<Fragment> fragmentList = new ArrayList<>();

                    //添加底部导航点
                    mDots = new ArrayList<>();
                    for (int i = 0; i < result.size(); i++) {

                        ImageView imageView = new ImageView(ViewpagerActivity.this);
                        int width = Dp2Px(ViewpagerActivity.this, 7);
                        int heigth = Dp2Px(ViewpagerActivity.this, 7);
                        int margin = Dp2Px(ViewpagerActivity.this, 5);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, heigth);
                        params.setMargins(margin, margin, margin, margin);//设置margin,也就是外边距。
                        imageView.setLayoutParams(params);//传入参数params设置宽和高
                        imageView.setImageResource(R.mipmap.dot_b);//设置图片
                        mLinearLayout.addView(imageView);//将图片添加到布局中
                        //将dot添加到dots集合中
                        mDots.add(imageView);

                        String pStatus = result.get(i).getPStatus();
                        if (pStatus.equals("1")) {
                            //租金待付
                            MyAibotBean.ObjBean.ResultBean watipay = result.get(i);
                            mWaitPayFragment = new WaitPayFragment(ViewpagerActivity.this, watipay, system);
                            fragmentList.add(mWaitPayFragment);
                        } else if (pStatus.equals("2")) {
                            //租用中
                            MyAibotBean.ObjBean.ResultBean rentting = result.get(i);
                            mRenttingFragment = new RenttingFragment(ViewpagerActivity.this, rentting);
                            fragmentList.add(mRenttingFragment);

                        } else if (pStatus.equals("3")) {
                            //租赁结束
                            MyAibotBean.ObjBean.ResultBean finishbean = result.get(i);
                            FinishRentFragment finishRentFragment = new FinishRentFragment(ViewpagerActivity.this, finishbean);
                            fragmentList.add(finishRentFragment);
                        } else if (pStatus.equals("4")) {
                            //归还中（已租）
                            MyAibotBean.ObjBean.ResultBean returnbean = result.get(i);
                            ReturningFragment returningFragment = new ReturningFragment(ViewpagerActivity.this, returnbean);
                            fragmentList.add(returningFragment);
                        } else if (pStatus.equals("5")) {
                            //归还中（未租）
                            MyAibotBean.ObjBean.ResultBean returnNobean = result.get(i);
                            ReturningNoRentFragment returningNoFragment = new ReturningNoRentFragment(ViewpagerActivity.this, returnNobean);
                            fragmentList.add(returningNoFragment);
                        } else if (pStatus.equals("6")) {
                            //换货中

                        } else if (pStatus.equals("7")) {
                            //转租中（未租）
                            MyAibotBean.ObjBean.ResultBean noSublet = result.get(i);
                            SublettingNoRentFragment sublettingNoFragment = new SublettingNoRentFragment(ViewpagerActivity.this, noSublet);
                            fragmentList.add(sublettingNoFragment);
                        } else if (pStatus.equals("8")) {
                            //转租中（已租）
                            MyAibotBean.ObjBean.ResultBean sublet = result.get(i);
                            SublettingFragment sublettingFragment = new SublettingFragment(ViewpagerActivity.this, sublet);
                            fragmentList.add(sublettingFragment);
                        } else if (pStatus.equals("99")) {
                            //买断
                            MyAibotBean.ObjBean.ResultBean buyoutbean = result.get(i);
                            mBuyOutFragment = new BuyOutFragment(ViewpagerActivity.this, buyoutbean);
                            fragmentList.add(mBuyOutFragment);
                        } else if (pStatus.equals("9")) {
                            //转租发货中
                            MyAibotBean.ObjBean.ResultBean release = result.get(i);
                            mSubletReleaseFragment = new SubletReleaseFragment(ViewpagerActivity.this, release);
                            fragmentList.add(mSubletReleaseFragment);
                        }

                    }

                    if (mVpnew != null) {
                        mFm = getSupportFragmentManager();
                        mMyFragmentAdapter = new MyFragmentAdapter(getApplicationContext(), mFm, fragmentList);
                        mVpnew.setAdapter(mMyFragmentAdapter);
                    } else {

                    }
                    mVpnew.setCurrentItem(0);
                    if (mDots.size()>0) {
                        mDots.get(0).setImageResource(R.mipmap.dot_o);//设置启动后显示的第一个点
                    }
                    DialogUtil.closeDialog(loadingDialog);

                    // int subletNum = response.body().getSubletNum();//转租数量
                    setVpPageChangeListener();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ViewpagerActivity.this, "请求服务器失败，请检查网络。", Toast.LENGTH_SHORT).show();
           //     DialogUtil.closeDialog(loadingDialog);
            }
        });

    }

    private void setVpPageChangeListener() {
        mVpnew.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mDots.size(); i++) {
                    mDots.get(i).setImageResource(R.mipmap.dot_b);
                }
                mDots.get(position).setImageResource(R.mipmap.dot_o);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.iv_myaibot_return:
                finish();
                break;
            case R.id.iv_myaibot_history:
                //暂时先隐藏
//                intent.setClass(this, MyAibotOMActivity.class);
//                startActivity(intent);
                break;
        }
    }
    /*
   将dp转化为px
    */
    public int Dp2Px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}

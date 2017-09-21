package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ShopDataBean;
import com.example.aiqing.sharerobot.bean.UpdataShopDataBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.aiqing.sharerobot.R.mipmap.switch_off;


/**
 * 店铺资料
 */
public class ShopDataActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvShopHeader;
    private TextView mTv_shop_name_t;
    private TextView mTv_maplocation;
    private TextView mTv_detail_address;
    private TextView mTv_shop_phonenum;
    private TextView mTv_opentime;
    private TextView mTv_closetime_shop;
    private ImageView mIv_canzu;
    private ImageView mIv_accepte;
    private String mCookie;
    private RelativeLayout mRlOpentime;
    private RelativeLayout mRlClosetime;
    private WindowManager.LayoutParams mParams;
    private SetTimePopWin mSettimePhotoPopWin;
    private TextView mTvOpenHour;
    private TextView mTvOpenMinite;
    private Dialog mLoadingDialog;
    private String distributorid;
    private RelativeLayout mRlUpdataName;
    private RelativeLayout mRlLocationaddress;
    private RelativeLayout mRlDetailaddress;
    private RelativeLayout mRlPhone;
    private HttpTool mHttpTool;
    private String mLongitude;
    private String mLatitude;
    private String mDistrict;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shop_data);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        distributorid = spDis.getString("distributorid", "");

        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("店铺资料");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mTv_shop_name_t.getText()) && TextUtils.isEmpty(mTv_shop_phonenum.getText())) {
                    finish();
                } else {
                    Retrofit builder = new Retrofit.Builder()
                            .client(mHttpTool.client())
                            .baseUrl("http://120.132.117.157:8083/distributor/saveDistributorId.shtml")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ApiService apiService = builder.create(ApiService.class);
                    Call<UpdataShopDataBean> call = apiService.updatashopdata(mCookie, distributorid, mTv_shop_name_t.getText().toString(), mTv_detail_address.getText().toString(), mLongitude, mLatitude, mDistrict, mTv_shop_phonenum.getText().toString(), mIv_canzu.getTag().toString(), mIv_accepte.getTag().toString(), "", "");
                    call.enqueue(new Callback<UpdataShopDataBean>() {
                        @Override
                        public void onResponse(Response<UpdataShopDataBean> response, Retrofit retrofit) {
                            if (response.body().getCoder().equals("0000")) {

                            }
                        }
                        @Override
                        public void onFailure(Throwable t) {

                        }
                    });
                }
                finish();
            }
        });

        initId();

        mIv_canzu.setTag("0");
        mIv_accepte.setTag("0");

        initHttp();
        initData();

        setData();
    }

    private void initId() {
        mIvShopHeader = (ImageView) findViewById(R.id.iv_shop_header);
        mTv_shop_name_t = (TextView) findViewById(R.id.tv_shop_name_t);
        mTv_maplocation = (TextView) findViewById(R.id.tv_maplocation);
        mTv_detail_address = (TextView) findViewById(R.id.tv_detail_address);
        mTv_shop_phonenum = (TextView) findViewById(R.id.tv_shop_phonenum);
//        mTv_opentime = (TextView) findViewById(R.id.tv_opentime);
//        mTv_closetime_shop = (TextView) findViewById(R.id.tv_closetime_shop);
        mIv_canzu = (ImageView) findViewById(R.id.iv_canzu);
        mIv_accepte = (ImageView) findViewById(R.id.iv_accepte);
        mRlOpentime = (RelativeLayout) findViewById(R.id.rl_opentime);
        mRlClosetime = (RelativeLayout) findViewById(R.id.rl_closetime);


        mTvOpenHour = (TextView) findViewById(R.id.tv_opentime_hour);
        mTvOpenMinite = (TextView) findViewById(R.id.tv_opentime_minite);
        TextView tvCloseHour = (TextView) findViewById(R.id.tv_closetime_hour);
        TextView tvCloseMinite = (TextView) findViewById(R.id.tv_closetime_minite);

        mRlUpdataName = (RelativeLayout) findViewById(R.id.rl_updataname);
        mRlLocationaddress = (RelativeLayout) findViewById(R.id.rl_locationaddress);
        mRlDetailaddress = (RelativeLayout) findViewById(R.id.rl_detailaddress);
        mRlPhone = (RelativeLayout) findViewById(R.id.rl_phone);
    }

    private void setData() {
        mIv_canzu.setOnClickListener(this);
        mIv_accepte.setOnClickListener(this);
        mRlUpdataName.setOnClickListener(this);
        mRlLocationaddress.setOnClickListener(this);
        mRlDetailaddress.setOnClickListener(this);
        mRlPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            //运营租赁业务
            case R.id.iv_canzu:
                if (mIv_canzu.getTag().equals("0")) {
                    mIv_canzu.setTag("1");
                    mIv_canzu.setImageResource(R.mipmap.switch_off);
                } else {
                    mIv_canzu.setTag("0");
                    mIv_canzu.setImageResource(R.mipmap.switch_on);
                }
                break;
            //接受
            case R.id.iv_accepte:
                if (mIv_accepte.getTag().equals("0")) {
                    mIv_accepte.setTag("1");
                    mIv_accepte.setImageResource(R.mipmap.switch_off);
                } else {
                    mIv_accepte.setTag("0");
                    mIv_accepte.setImageResource(R.mipmap.switch_on);
                }
                break;
            case R.id.rl_updataname:
                //名称
                intent.setClass(ShopDataActivity.this, UpdataNameActivity.class);
                startActivityForResult(intent, 11);
                break;
            case R.id.rl_locationaddress:
                //地图定位
                intent.setClass(ShopDataActivity.this, SearchAddressActivity.class);
                startActivityForResult(intent, 12);
                break;
            case R.id.rl_detailaddress:
                //详细地址
                intent.setClass(ShopDataActivity.this, DisDetailAddressActivity.class);
                startActivityForResult(intent, 13);
                break;
            case R.id.rl_phone:
                //联系方式
                intent.setClass(ShopDataActivity.this, UpdataPhoneActivity.class);
                startActivityForResult(intent, 14);
                break;
        }
    }

    //wheelview
    private void initData() {
        mRlOpentime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetTimePopWin setTimePopWin = new SetTimePopWin(ShopDataActivity.this);
                setTimePopWin.showAtLocation(findViewById(R.id.ll_shopdata), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

            }
        });
    }

    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/selectDistributor.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ShopDataBean> call = apiService.getShopData(mCookie, distributorid);

        call.enqueue(new Callback<ShopDataBean>() {
            @Override
            public void onResponse(Response<ShopDataBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    Log.e("店铺资料", "onResponse: " + response.body().getObj().getName());
                    Log.e("店铺资料", "onResponse: " + response.body().getObj().getAddress());
                    //Bitmap bm = BitmapFactory.decodeFile(response.body().getObj().getHeadImg().toString());
                    // mIvShopHeader.setImageBitmap(bm);
                    mTv_shop_name_t.setText(response.body().getObj().getName());
                    mTv_maplocation.setText(response.body().getObj().getAddress());
                    mTv_shop_phonenum.setText(response.body().getObj().getContact1());
//                    mTv_opentime.setText(response.body().getObj().getOpenTime2() + "");
//                    mTv_closetime_shop.setText(response.body().getObj().getClosedTime2() + "");
                    String isStop = response.body().getObj().getIsStop();
                    if (isStop == "1") {
                        //关
                        mIv_canzu.setImageResource(switch_off);
                    } else if (isStop == "0") {
                        //开
                        mIv_canzu.setImageResource(R.mipmap.switch_on);
                    }
                    String isAllowed = response.body().getObj().getIsAllowed();
                    if (isAllowed == "0") {
                        //不接受
                        mIv_accepte.setImageResource(switch_off);
                    } else if (isAllowed == "1") {
                        //接受
                        mIv_accepte.setImageResource(R.mipmap.switch_on);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                DialogUtil.closeDialog(mLoadingDialog);
                Toast.makeText(ShopDataActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle = data.getExtras();
        if (requestCode == 11 && data!=null) {

            String name = bundle.getString("name");
            mTv_shop_name_t.setText(name);
        } else if (requestCode == 12) {
            mLatitude = bundle.getString("mLatitude");
            mLongitude = bundle.getString("mLongitude");
            mDistrict = bundle.getString("mDistrict");
            String province = bundle.getString("mProvince");
            String city = bundle.getString("mCity");
            mTv_maplocation.setText(mDistrict);
        } else if (requestCode == 13) {
            String address = bundle.getString("address");
            mTv_detail_address.setText(address);
        } else if (requestCode == 14) {
            String phone = bundle.getString("phone");
            mTv_shop_phonenum.setText(phone);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public class SetTimePopWin extends PopupWindow {

        private final WheelView mHour;
        private final WheelView mMinite;
        private final RelativeLayout mSettime;
        private final View mView;
        private final Context context;
        private WheelView hour;
        private WheelView minite;
        private ArrayList<String> mListHour;
        private ArrayList<String> mListMinutes;
        private String mMinute;
        private String mHour1;

        public SetTimePopWin(Context context) {
            this.context = context;
            this.mView = LayoutInflater.from(context).inflate(R.layout.settime, null);
            mHour = (WheelView) mView.findViewById(R.id.wheel_hour);
            mMinite = (WheelView) mView.findViewById(R.id.wheel_minite);
            mSettime = (RelativeLayout) mView.findViewById(R.id.tv_settime);

            initView();

            //外部可点击
            this.setOutsideTouchable(true);

            //确定
            mSettime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取时间
                    dismiss();
                }
            });

    /* 设置弹出窗口特征 */
            // 设置视图
            this.setContentView(this.mView);
            // 设置弹出窗体的宽和高
            this.setHeight(600);
            this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);

            // 设置弹出窗体可点击
            this.setFocusable(true);

            // 实例化一个ColorDrawable颜色为半透明
            //ColorDrawable dw = new ColorDrawable(0xb0000000);
            ColorDrawable dw = new ColorDrawable(0xffff0000);
            // 设置弹出窗体的背景
            this.setBackgroundDrawable(dw);

            // 设置弹出窗体显示时的动画，从底部向上弹出
            this.setAnimationStyle(R.style.popupwindow_anim_style);

        }

        private void initView() {
            hour = (WheelView) mView.findViewById(R.id.wheel_hour);
            minite = (WheelView) mView.findViewById(R.id.wheel_minite);

            mHour.setWheelAdapter(new ArrayWheelAdapter(context));
            mHour.setSkin(WheelView.Skin.Holo);
            mHour.setWheelData(createHours());
            WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
            style.selectedTextColor = Color.parseColor("#0288ce");
            style.textColor = Color.GRAY;
            style.selectedTextSize = 20;
            mHour.setStyle(style);
            mHour.setExtraText("时", Color.parseColor("#0288ce"), 40, 70);
            mHour.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
                @Override
                public void onItemSelected(int position, Object o) {
                    if (!mListHour.get(position).equals("00")) {
                        mHour1 = mListHour.get(position);
                        Log.e("时", "onItemSelected: " + mHour1);
                        mTvOpenHour.setText(mHour1);

                    }
                }
            });


            mMinite.setWheelAdapter(new ArrayWheelAdapter(context));
            mMinite.setSkin(WheelView.Skin.Holo);
            mMinite.setWheelData(createMinutes());
            mMinite.setStyle(style);
            mMinite.setExtraText("分", Color.parseColor("#0288ce"), 40, 70);
            mMinite.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
                @Override
                public void onItemSelected(int position, Object o) {
                    if (!mListMinutes.get(position).equals("00")) {
                        mMinute = mListMinutes.get(position);
                        Log.e("分", "onItemSelected: " + mMinute);
                        mTvOpenMinite.setText(mMinute);
                    }
                }
            });
        }

        private ArrayList<String> createHours() {
            mListHour = new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                if (i < 10) {
                    mListHour.add("0" + i);
                } else {
                    mListHour.add("" + i);
                }
            }
            return mListHour;
        }

        private ArrayList<String> createMinutes() {
            mListMinutes = new ArrayList<>();
            for (int i = 0; i < 60; i++) {
                if (i < 10) {
                    mListMinutes.add("0" + i);
                } else {
                    mListMinutes.add("" + i);
                }
            }
            return mListMinutes;
        }

    }

}

package com.example.aiqing.sharerobot.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.InternetSelectActivity;
import com.example.aiqing.sharerobot.activity.Main2Activity;
import com.example.aiqing.sharerobot.activity.SubletReleaseActivity;
import com.example.aiqing.sharerobot.activity.TheRentPayActivity;
import com.example.aiqing.sharerobot.bean.MyAibotBean;
import com.example.aiqing.sharerobot.bean.OverRentBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.Context.MODE_PRIVATE;

/**
 * 租用中
 * Created by aiqing on 2017/8/24.
 */

public class RenttingFragment extends Fragment implements View.OnClickListener {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean rentting;
    private TextView mTvRenttingId;
    private TextView mTvResttime;
    private TextView mTvLenddata;
    private TextView mTvLendtime;
    private TextView mTvRepaydata;
    private TextView mTvRepaytime;
    private Button mBtnRepay;
    private Button mBtnContinue;
    private TextView mTvName;
    private TextView mTvPhone;
    @SuppressLint({"NewApi", "ValidFragment"})
    public RenttingFragment(Context context, MyAibotBean.ObjBean.ResultBean rentting) {
        this.context = context;
        this.rentting = rentting;

    }
    public RenttingFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_rentting_myaibot, container, false);
        initId(view);
        initData();
        return view;
    }

    private void initId(View view) {
        mTvRenttingId = (TextView) view.findViewById(R.id.tv_renttingg_id);
        mTvResttime = (TextView) view.findViewById(R.id.tv_resttime);
        mTvLenddata = (TextView) view.findViewById(R.id.tv_lend_data);
        mTvLendtime = (TextView) view.findViewById(R.id.tv_lend_time);
        mTvRepaydata = (TextView) view.findViewById(R.id.tv_repay_data);
        mTvRepaytime = (TextView) view.findViewById(R.id.tv_repay_time);
        mBtnRepay = (Button) view.findViewById(R.id.btn_repay);
        mBtnContinue = (Button) view.findViewById(R.id.btn_continue);
        ImageView ivMore = (ImageView) view.findViewById(R.id.iv_more_rentting);


        mTvName = (TextView) view.findViewById(R.id.tv_rentting_name);
        mTvPhone = (TextView) view.findViewById(R.id.tv_rentting_phone);

        ivMore.setOnClickListener(this);
    }

    private void initData() {
        mTvRenttingId.setText(rentting.getProductId() + "");
        mTvLenddata.setText(rentting.getLeaseFrom2() + "");
        mTvRepaydata.setText(rentting.getLeaseTo2() + "");
        mTvName.setText(rentting.getName());
        mTvPhone.setText(rentting.getContact1() + "");

        mBtnRepay.setOnClickListener(this);
        mBtnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_repay:
                //还
                showDialog();
                break;
            case R.id.btn_continue:
                //续
                intent.setClass(context, TheRentPayActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_more_rentting:
                otherTodo();
                break;
        }
    }
    //显示全屏dialog
    private void otherTodo() {

        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(Gravity.CENTER);
        window.setContentView(R.layout.over_dialog);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);

//        LinearLayout llChangeRobot = (LinearLayout) dialog.findViewById(R.id.ll_change_aibot);
        LinearLayout llSubletRobot = (LinearLayout) dialog.findViewById(R.id.ll_sulet_aibot);
        LinearLayout llOverRobot = (LinearLayout) dialog.findViewById(R.id.ll_over_aibot);
//        llChangeRobot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(context, ChangeRobotActivity.class);
//                startActivity(intent);
//            }
//        });
        llSubletRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, SubletReleaseActivity.class);
                startActivity(intent);
            }
        });
        llOverRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overRent();
            }
        });

    }

    private void overRent() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("您的租赁时间将终止，小宝将重新进入锁定状态，是否继续进行此操作");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                overHttp();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }

    private void overHttp() {
        String productId = rentting.getProductId();
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(context, "加载中...");
        SharedPreferences spcookie = context.getSharedPreferences("COOKIE", MODE_PRIVATE);
        String cookie = spcookie.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(context);

        Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/payRent/endRental.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<OverRentBean> call = apiService.overRent(cookie, productId);
        call.enqueue(new Callback<OverRentBean>() {
            @Override
            public void onResponse(Response<OverRentBean> response, Retrofit retrofit) {
                int obj = response.body().getObj();
                Log.e("结束租赁", "onResponse: " + obj);
                if (obj == 1) {
                    Toast.makeText(context, "您已结束租赁", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(context, Main2Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                }
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("您的租赁时间将终止，小宝将重新进入锁定状态，是否继续进行此操作");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String productId = rentting.getProductId();
                Log.e("产品id", "onClick: " + productId);
                Intent intent = new Intent();
                intent.putExtra("productId", productId);
                intent.setClass(context, InternetSelectActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}

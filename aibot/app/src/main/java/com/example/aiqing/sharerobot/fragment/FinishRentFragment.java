package com.example.aiqing.sharerobot.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.InternetSelectActivity;
import com.example.aiqing.sharerobot.activity.SubletReleaseActivity;
import com.example.aiqing.sharerobot.activity.TheRentPayActivity;
import com.example.aiqing.sharerobot.bean.MyAibotBean;

/**
 * 结束租赁
 * Created by aiqing on 2017/8/28.
 */

public class FinishRentFragment extends Fragment implements View.OnClickListener {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean finishbean;
    @SuppressLint({"NewApi", "ValidFragment"})
    public FinishRentFragment(Context context, MyAibotBean.ObjBean.ResultBean finishbean) {
        this.context = context;
        this.finishbean = finishbean;
    }
    public FinishRentFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_finishrent, container, false);
        initId(view);
        return view;
    }

    private void initId(View view) {
        TextView tvFinishId = (TextView) view.findViewById(R.id.tv_finish_id);
        TextView tvLenddata = (TextView) view.findViewById(R.id.tv_lend_finish_data);
        TextView tvRepaydata = (TextView) view.findViewById(R.id.tv_repay_finish_data);
        TextView tvRepayTime = (TextView) view.findViewById(R.id.tv_repay_finish_time);
        Button btnRepay = (Button) view.findViewById(R.id.btn_finish_repay);
        Button btnContinue = (Button) view.findViewById(R.id.btn_finish_continue);
        TextView tvName = (TextView) view.findViewById(R.id.tv_finish_name);
        TextView tvPhone = (TextView) view.findViewById(R.id.tv_finish_phone);
        ImageView ivFinishMore = (ImageView) view.findViewById(R.id.iv_finish_more);

        tvFinishId.setText(finishbean.getProductId() + "");
        tvLenddata.setText(finishbean.getLeaseFrom2() + "");
        tvRepaydata.setText(finishbean.getLeaseTo2() + "");
        tvRepayTime.setText(finishbean.getLeaseTo2() + "");
        tvName.setText(finishbean.getName());
        tvPhone.setText(finishbean.getContact1() + "");
        btnRepay.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
        ivFinishMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_finish_repay:
                //还
                showDialog();

                break;
            case R.id.btn_finish_continue:
                //续
                intent.setClass(context, TheRentPayActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_finish_more:
                moreDialog();
                break;
        }
    }

    private void moreDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(context).create();
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.show();
        Window window = dialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setGravity(Gravity.CENTER);
        window.setContentView(R.layout.finish_dialog);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);

        LinearLayout llSublet = (LinearLayout) dialog.findViewById(R.id.ll_sulet);
        llSublet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productId = finishbean.getProductId();
                Intent intent = new Intent();
                intent.putExtra("productId",productId);
                intent.setClass(context, SubletReleaseActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("您的租赁时间将终止，小宝将重新进入锁定状态，是否继续进行此操作");
        builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
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

        builder.show();
    }
}

package com.example.aiqing.sharerobot.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.Main2Activity;
import com.example.aiqing.sharerobot.activity.TheRentPayActivity;
import com.example.aiqing.sharerobot.bean.MyAibotBean;

/**租金待付
 * Created by aiqing on 2017/8/24.
 */

public class WaitPayFragment extends Fragment implements View.OnClickListener {

    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean watipay;
    private  MyAibotBean.SystemBean system;
    @SuppressLint({"NewApi", "ValidFragment"})
    public WaitPayFragment(Context context, MyAibotBean.ObjBean.ResultBean watipay, MyAibotBean.SystemBean system) {
        this.context=context;
        this.watipay=watipay;
        this.system=system;
    }
    public WaitPayFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_waitpay,container,false);
        initId(view);
        getData(view);
        return view;
    }

    private void getData(View view) {
        String systemTime2 = system.getSystemTime2();
        String paramValue = system.getParamValue();
        Log.e("计时器", "getData: "+systemTime2+ "  88"+paramValue);

        CountDownTimer timer =new CountDownTimer(99000000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };

    }

    private void initId(View view) {
        TextView tvWaitpayId = (TextView) view.findViewById(R.id.tv_waitpay_id);
        Button btnRepay = (Button) view.findViewById(R.id.btn_waitpay_repay);
        Button btnContinue = (Button) view.findViewById(R.id.btn_waitpay_continue);
        tvWaitpayId.setText(watipay.getProductId()+"");
        btnRepay.setOnClickListener(this);
        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.btn_waitpay_repay:
                //取消
                intent.setClass(context, Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_waitpay_continue:
                //继续
                intent.setClass(context, TheRentPayActivity.class);
                startActivity(intent);
                break;
        }
    }
}

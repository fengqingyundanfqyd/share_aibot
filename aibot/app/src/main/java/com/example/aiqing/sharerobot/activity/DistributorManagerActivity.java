package com.example.aiqing.sharerobot.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.fragment.DisReturnFragment;
import com.example.aiqing.sharerobot.fragment.LendFragment;
import com.example.aiqing.sharerobot.fragment.MySelfFragment;

public class DistributorManagerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvLend;
    private TextView mTvReturn;
    private TextView mTvMyself;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_manager);
        initId();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        LendFragment lendFragment = new LendFragment();
        ft.replace(R.id.fl_distributor,lendFragment).commit();
    }

    private void initId() {
        LinearLayout llReturn = (LinearLayout) findViewById(R.id.ll_return);
        mTvLend = (TextView) findViewById(R.id.tv_lend);
        mTvReturn = (TextView) findViewById(R.id.tv_return);
        mTvMyself = (TextView) findViewById(R.id.tv_myself);
        FrameLayout framelayout = (FrameLayout) findViewById(R.id.fl_distributor);

        llReturn.setOnClickListener(this);
        mTvLend.setOnClickListener(this);
        mTvReturn.setOnClickListener(this);
        mTvMyself.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.ll_return:
//                Intent intent=new Intent();
//                intent.setClass(DistributorManagerActivity.this, Main2Activity.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.tv_lend:
                //出租
                mTvLend.setBackgroundResource(R.drawable.shape_left_bg);
                mTvLend.setTextColor(Color.parseColor("#ffffff"));
                mTvReturn.setBackgroundResource(R.drawable.shape_center_bg);
                mTvReturn.setTextColor(Color.parseColor("#ff824c"));
                mTvMyself.setBackgroundResource(R.drawable.shape_right_bg);
                mTvMyself.setTextColor(Color.parseColor("#ff824c"));
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                LendFragment lendFragment = new LendFragment();
                ft.replace(R.id.fl_distributor,lendFragment).commit();

                break;
            case R.id.tv_return:
                //归还
                mTvLend.setBackgroundResource(R.drawable.shape_left_dis);
                mTvLend.setTextColor(Color.parseColor("#ff824c"));
                mTvReturn.setBackgroundResource(R.drawable.shape_center_dis);
                mTvReturn.setTextColor(Color.parseColor("#ffffff"));
                mTvMyself.setBackgroundResource(R.drawable.shape_right_bg);
                mTvMyself.setTextColor(Color.parseColor("#ff824c"));
                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                DisReturnFragment disReturnFragment = new DisReturnFragment();
                ft1.replace(R.id.fl_distributor,disReturnFragment).commit();
                break;
            case R.id.tv_myself:
                //我的
                mTvLend.setBackgroundResource(R.drawable.shape_left_dis);
                mTvLend.setTextColor(Color.parseColor("#ff824c"));
                mTvReturn.setBackgroundResource(R.drawable.shape_center_bg);
                mTvReturn.setTextColor(Color.parseColor("#ff824c"));
                mTvMyself.setBackgroundResource(R.drawable.shape_right_dis);
                mTvMyself.setTextColor(Color.parseColor("#ffffff"));
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                MySelfFragment mySelfFragment = new MySelfFragment();
                ft2.replace(R.id.fl_distributor,mySelfFragment).commit();
                break;
        }
    }
}

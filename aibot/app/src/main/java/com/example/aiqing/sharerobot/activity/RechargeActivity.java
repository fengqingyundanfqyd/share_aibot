package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * 充值
 */
public class RechargeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnFive;
    private Button mBtnTwo;
    private Button mBtnOne;
    private Button mBtnFifty;
    private EditText mEtOtherNum;
    private RelativeLayout mRlZhifubaoPay;
    private RelativeLayout mRlWeixinPay;
    private ImageView mIvZhibaoPay;
    private ImageView mIvWeixinPay;
    private Button mBtnRecharge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("充值");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

        initId();
    }

    private void initId() {
        mBtnFive = (Button) findViewById(R.id.btn_five);
        mBtnTwo = (Button) findViewById(R.id.btn_two);
        mBtnOne = (Button) findViewById(R.id.btn_one);
        mBtnFifty = (Button) findViewById(R.id.btn_fifty);
        mEtOtherNum = (EditText) findViewById(R.id.et_othersnum);
        mRlZhifubaoPay = (RelativeLayout) findViewById(R.id.rl_zhifubaopay);
        mRlWeixinPay = (RelativeLayout) findViewById(R.id.rl_weixinpay);
        mIvZhibaoPay = (ImageView) findViewById(R.id.iv_zhifubao);
        mIvWeixinPay = (ImageView) findViewById(R.id.iv_weixinpay);
        mBtnRecharge = (Button) findViewById(R.id.btn_recharge);

        mIvZhibaoPay.setVisibility(View.VISIBLE);
        mIvWeixinPay.setVisibility(View.GONE);

        mBtnFive.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnFifty.setOnClickListener(this);
        mEtOtherNum.setOnClickListener(this);
        mRlZhifubaoPay.setOnClickListener(this);
        mRlWeixinPay.setOnClickListener(this);
        mBtnRecharge.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_five:
                //500
                mBtnFive.setBackgroundResource(R.mipmap.selected_icon);
                mBtnTwo.setBackgroundResource(R.mipmap.unselected_icon);
                mEtOtherNum.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnOne.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFifty.setBackgroundResource(R.mipmap.unselected_icon);
                break;
            case R.id.btn_two:
                //200
                mBtnTwo.setBackgroundResource(R.mipmap.selected_icon);
                mBtnFive.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnOne.setBackgroundResource(R.mipmap.unselected_icon);
                mEtOtherNum.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFifty.setBackgroundResource(R.mipmap.unselected_icon);
                break;
            case R.id.btn_one:
                //100
                mBtnOne.setBackgroundResource(R.mipmap.selected_icon);
                mBtnTwo.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFive.setBackgroundResource(R.mipmap.unselected_icon);
                mEtOtherNum.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFifty.setBackgroundResource(R.mipmap.unselected_icon);
                break;
            case R.id.btn_fifty:
                //50
                mBtnFifty.setBackgroundResource(R.mipmap.selected_icon);
                mBtnOne.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnTwo.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFive.setBackgroundResource(R.mipmap.unselected_icon);
                mEtOtherNum.setBackgroundResource(R.mipmap.unselected_icon);
                break;
            case R.id.et_othersnum:
                //其他金额
                mEtOtherNum.setText(" ");
                mEtOtherNum.setInputType(EditorInfo.TYPE_CLASS_PHONE);
                mEtOtherNum.setBackgroundResource(R.mipmap.selected_icon);
                mBtnFifty.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnOne.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnTwo.setBackgroundResource(R.mipmap.unselected_icon);
                mBtnFive.setBackgroundResource(R.mipmap.unselected_icon);
                break;
            case R.id.rl_zhifubaopay:
                //支付宝
                mIvZhibaoPay.setVisibility(View.VISIBLE);
                mIvWeixinPay.setVisibility(View.GONE);
                String number = mEtOtherNum.getText().toString().trim();
                break;
            case R.id.rl_weixinpay:
                //微信
                mIvZhibaoPay.setVisibility(View.GONE);
                mIvWeixinPay.setVisibility(View.VISIBLE);
                String number1 = mEtOtherNum.getText().toString().trim();
                break;
            case R.id.btn_recharge:
                //确定充值
                break;
        }
    }
}

package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;

/**
 * 添加银行卡
 */
public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLlCardId;
    private LinearLayout mLlYanzhengmessage;
    private LinearLayout mLlYanzhengma;
    private ImageView mIvReturn;
    private EditText mEtPutCardnum;
    private Button mBtnNextOne;
    private TextView mTvCardtypename;
    private EditText mEtCardmansName;
    private EditText mEtShenfenzhengnum;
    private EditText mEtBankphonenum;
    private Button mBtnNextTwo;
    private TextView mTvPhonenumGet;
    private EditText mEtZanzhengma_get;
    private Button mBtnGetYanzhengma;
    private Button mBtnComplete;
    private String mPhonenum;
    private String mBankcardnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
        initId();
        initData();
    }

    private void initData() {
//        mLlCardId.setVisibility(View.VISIBLE);
//        mLlYanzhengmessage.setVisibility(View.GONE);
//        mLlYanzhengma.setVisibility(View.GONE);

        mIvReturn.setOnClickListener(this);
        //输入的银行卡号
        mBankcardnum = mEtPutCardnum.getText().toString().trim();

        mBtnNextOne.setOnClickListener(this);
        Toast.makeText(this, "银行卡号"+mBankcardnum, Toast.LENGTH_SHORT).show();
        //持卡人姓名
        String personsname = mEtCardmansName.getText().toString().trim();
        //持卡人身份证
        String shenfenzheng = mEtShenfenzhengnum.getText().toString().trim();

        //银行预留电话
        mPhonenum = mEtBankphonenum.getText().toString().trim();

        mBtnNextTwo.setOnClickListener(this);

        mTvPhonenumGet.setText(mPhonenum);
        mBtnGetYanzhengma.setOnClickListener(this);

        mBtnComplete.setOnClickListener(this);
    }

    private void initId() {
        mLlCardId = (LinearLayout) findViewById(R.id.ll_cardid);
        mLlYanzhengmessage = (LinearLayout) findViewById(R.id.ll_yanzhengmessage);
        mLlYanzhengma = (LinearLayout) findViewById(R.id.ll_yanzhengma);
        mIvReturn = (ImageView) findViewById(R.id.iv_return_addcard);
        mEtPutCardnum = (EditText) findViewById(R.id.et_putincardnum);
        mBtnNextOne = (Button) findViewById(R.id.btn_next_step_put_cardnum);
        mTvCardtypename = (TextView) findViewById(R.id.tv_typename);
        mEtCardmansName = (EditText) findViewById(R.id.et_cardmansname);
        mEtShenfenzhengnum = (EditText) findViewById(R.id.et_shenfenzhengnum);
        mEtBankphonenum = (EditText) findViewById(R.id.et_bankphonenum);
        mBtnNextTwo = (Button) findViewById(R.id.btn_message_next);
        mTvPhonenumGet = (TextView) findViewById(R.id.tv_phonenum_get);
        mEtZanzhengma_get = (EditText) findViewById(R.id.et_zanzhengma_get);
        mBtnGetYanzhengma = (Button) findViewById(R.id.btn_get_yanzhengma);
        mBtnComplete = (Button) findViewById(R.id.btn_complete);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_return_addcard:
                finish();
                break;
            case R.id.btn_next_step_put_cardnum:

                Log.e("银行卡", "onClick: "+mBankcardnum);
                mLlCardId.setVisibility(View.GONE);
                mLlYanzhengmessage.setVisibility(View.VISIBLE);
                mLlYanzhengma.setVisibility(View.GONE);
                break;
            case R.id.btn_message_next:
                Log.e("银行卡号", "onClick: "+mBankcardnum);
                Log.e("银行预留电话", "onClick: "+mPhonenum );
                mLlCardId.setVisibility(View.GONE);
                mLlYanzhengmessage.setVisibility(View.GONE);
                mLlYanzhengma.setVisibility(View.VISIBLE);

                break;
            case R.id.btn_get_yanzhengma:

                //发送验证码
                String yanzhengma = mEtZanzhengma_get.getText().toString().trim();
                break;
            case R.id.btn_complete:
               finish();
                break;
        }
    }
}
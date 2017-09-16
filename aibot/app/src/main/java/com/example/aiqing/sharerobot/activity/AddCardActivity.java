package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.BankCardNumBean;
import com.example.aiqing.sharerobot.bean.SaveBankinfoBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.example.aiqing.sharerobot.R.id.et_cardmansname;

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
    private String mCookie;
    private HttpTool mHttpTool;
    private String mBankAddr;

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


        mBtnNextOne.setOnClickListener(this);
        Toast.makeText(this, "银行卡号" + mBankcardnum, Toast.LENGTH_SHORT).show();
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
        mEtCardmansName = (EditText) findViewById(et_cardmansname);
        mEtShenfenzhengnum = (EditText) findViewById(R.id.et_shenfenzhengnum);
        mEtBankphonenum = (EditText) findViewById(R.id.et_bankphonenum);
        mBtnNextTwo = (Button) findViewById(R.id.btn_message_next);
        mTvPhonenumGet = (TextView) findViewById(R.id.tv_phonenum_get);
        mEtZanzhengma_get = (EditText) findViewById(R.id.et_zanzhengma_get);
        mBtnGetYanzhengma = (Button) findViewById(R.id.btn_get_yanzhengma);
        mBtnComplete = (Button) findViewById(R.id.btn_complete);


        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_return_addcard:
                finish();
                break;
            case R.id.btn_next_step_put_cardnum:

                //输入的银行卡号
                mBankcardnum = mEtPutCardnum.getText().toString().trim();
                //判断银行卡所处银行
                checkBankCard(mBankcardnum);
                mLlCardId.setVisibility(View.GONE);
                mLlYanzhengmessage.setVisibility(View.VISIBLE);
                mLlYanzhengma.setVisibility(View.GONE);
                break;
            case R.id.btn_message_next:
                // 输入持卡人  身份证  手机号
                commit();


//                Log.e("银行卡号", "onClick: "+mBankcardnum);
//                Log.e("银行预留电话", "onClick: "+mPhonenum );
//                mLlCardId.setVisibility(View.GONE);
//                mLlYanzhengmessage.setVisibility(View.GONE);
//                mLlYanzhengma.setVisibility(View.VISIBLE);

                break;
//            case R.id.btn_get_yanzhengma:
//
//                //发送验证码
//                String yanzhengma = mEtZanzhengma_get.getText().toString().trim();
//                break;
//            case R.id.btn_complete:
//               finish();
//                break;
        }
    }

    private void commit() {
        String name = mEtCardmansName.getText().toString();
        String idcardnum = mEtShenfenzhengnum.getText().toString();
        String phone = mEtBankphonenum.getText().toString();

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/bank/saveBankCard.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<SaveBankinfoBean> call = apiService.savebankinfo(mCookie, mBankcardnum, phone, name, mTvCardtypename.getText().toString(), "");
        call.enqueue(new Callback<SaveBankinfoBean>() {
            @Override
            public void onResponse(Response<SaveBankinfoBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    Toast.makeText(AddCardActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddCardActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                }
                finish();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

    //判断银行卡所处银行
    private void checkBankCard(String bankcardnum) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/bank/bankType.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<BankCardNumBean> call = apiService.banknum(mCookie, bankcardnum);
        call.enqueue(new Callback<BankCardNumBean>() {
            @Override
            public void onResponse(Response<BankCardNumBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    //银行名称
                    mBankAddr = response.body().getObj().getBankAddr();
                    mTvCardtypename.setText(mBankAddr);
                } else {
                    Toast.makeText(AddCardActivity.this, response.body().getErrorMsg().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}

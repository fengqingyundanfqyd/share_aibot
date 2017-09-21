package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.AddressAdapter;
import com.example.aiqing.sharerobot.bean.UsersAddressBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by aiqing on 2017/6/24.
 * <p>
 * 申请租小宝
 */

public class ApplyRentActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLlAddnewAddress;
    private Button mBtnNext;
    private LinearLayout mLlShangmen;
    private LinearLayout mLlSonghuo;
    private ImageView mIvSonghuo;
    private ImageView mIvShangmen;
    private LinearLayout mLloldAddress;
    private ListView mListViewAddress;
    private ListView mListviewGetAdd;
    private List<UsersAddressBean.ObjBean.ResultBean> mResult;
    private String mAddressId;
    private Dialog mLoadingDialog;
    private String mDistributorId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_apply_rent);

        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("申请租");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //跳转到Delivery界面
        initFindId();
        mListviewGetAdd.setVisibility(View.GONE);
        mLlAddnewAddress.setVisibility(View.VISIBLE);
        mBtnNext.setVisibility(View.VISIBLE);
        initGetData();
    }


    private void initGetData() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        String sid = spcookie.getString("mCookie", "");
        HttpTool client = new HttpTool(this);
        Retrofit builder = new Retrofit.Builder()
                .client(client.client())
                .baseUrl("http://relay.aqcome.com/account/getCustAddInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<UsersAddressBean> call = apiService.getAddressData(sid, "", "");
        call.enqueue(new Callback<UsersAddressBean>() {
            @Override
            public void onResponse(Response<UsersAddressBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    mResult = response.body().getObj().getResult();
                    for (int i = 0; i < mResult.size(); i++) {
                        UsersAddressBean.ObjBean.ResultBean list = mResult.get(i);
                        String name = list.getName();
                        String mobile = list.getMobile();
                        String fAddress = list.getFAddress();
                        mAddressId = list.getAddressId();

                        mListviewGetAdd.setVisibility(View.VISIBLE);
                        mIvShangmen.setVisibility(View.GONE);

                        AddressAdapter adapter = new AddressAdapter(ApplyRentActivity.this, name, mobile, fAddress, mResult);
                        mListviewGetAdd.setAdapter(adapter);

//                    mListviewGetAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                            Toast.makeText(ApplyRentActivity.this, "点击了"+(position+1), Toast.LENGTH_SHORT).show();
//                            LinearLayout view1 = (LinearLayout) parent.getChildAt(position);
//                            ImageView ivNO = (ImageView) view1.findViewById(R.id.iv_no);
//                            if (mResult.get(position).getIsDefault().equals(1)){
//                                ivNO.setImageResource(R.mipmap.gou);
//                            }else if (mResult.get(position).getIsDefault().equals(0)){
//                                ivNO.setImageResource(R.mipmap.unselected);
//                            }
//                        }
//                    });
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ApplyRentActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    private void initFindId() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            mDistributorId = bundle.getString("mDistributorId");
        }
        mLlAddnewAddress = (LinearLayout) findViewById(R.id.ll_addnewaddress);
        mBtnNext = (Button) findViewById(R.id.btn_next);
        mLlShangmen = (LinearLayout) findViewById(R.id.ll_shangmen);
        mIvShangmen = (ImageView) findViewById(R.id.iv_gou_shangmen);
        mLlSonghuo = (LinearLayout) findViewById(R.id.ll_songhuo);
        mIvSonghuo = (ImageView) findViewById(R.id.iv_songhuo);
        mLloldAddress = (LinearLayout) findViewById(R.id.ll_old_address);
        mListviewGetAdd = (ListView) findViewById(R.id.listview_getaddress);


        mLlShangmen.setOnClickListener(this);
        mLlSonghuo.setOnClickListener(this);

        mBtnNext.setOnClickListener(this);
        mIvShangmen.setVisibility(View.VISIBLE);
        mLlAddnewAddress.setVisibility(View.GONE);

        mLlAddnewAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.ll_addnewaddress:
                intent.setClass(ApplyRentActivity.this, AddAddressActivity.class);
                startActivityForResult(intent, 250);
                //  ApplyRentActivity.this.finish();
                break;
            case R.id.btn_next:
                intent.setClass(ApplyRentActivity.this, PayDepositActivity.class);
                intent.putExtra("mAddressId", mAddressId);
                intent.putExtra("mDistributorId", mDistributorId);
                startActivity(intent);
                //   ApplyRentActivity.this.finish();
                break;
            case R.id.ll_shangmen:
                mIvShangmen.setVisibility(View.VISIBLE);
                mListviewGetAdd.setVisibility(View.GONE);
                mLlAddnewAddress.setVisibility(View.GONE);
                break;
            case R.id.ll_songhuo:
                mIvShangmen.setVisibility(View.GONE);
                mListviewGetAdd.setVisibility(View.VISIBLE);
                mLlAddnewAddress.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 250 && data != null) {
            Bundle bundle = data.getExtras();
            String mName = bundle.getString("name");
            String mNumber = bundle.getString("number");
            String mDetaadd = bundle.getString("detaadd");

            AddressAdapter addressAdapter = new AddressAdapter(this, mName, mNumber, mDetaadd, mResult);
            mListviewGetAdd.setAdapter(addressAdapter);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

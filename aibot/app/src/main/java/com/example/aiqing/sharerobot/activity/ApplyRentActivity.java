package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
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
    private AddressAdapter mAdapter;
    private String mSid;
    private HttpTool mClient;
    private int selectPositon = -1;//用于记录用户选择的变量


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
        mSid = spcookie.getString("mCookie", "");
        mClient = new HttpTool(this);
        Retrofit builder = new Retrofit.Builder()
                .client(mClient.client())
                .baseUrl("http://120.132.117.157:8083/account/getCustAddInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<UsersAddressBean> call = apiService.getAddressData(mSid, "1", "5");
        call.enqueue(new Callback<UsersAddressBean>() {
            @Override
            public void onResponse(Response<UsersAddressBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    mResult = response.body().getObj().getResult();
                    mAdapter = new AddressAdapter(ApplyRentActivity.this, mResult);
                    mListviewGetAdd.setAdapter(mAdapter);
                    mListviewGetAdd.setVisibility(View.VISIBLE);
                    mIvShangmen.setVisibility(View.GONE);

                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ApplyRentActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });


        mListviewGetAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectPositon = position;
                mAdapter.notifyDataSetChanged();

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
                //TODO 此处需判断
                if (selectPositon==-1) {
                    intent.setClass(ApplyRentActivity.this, PayDepositActivity.class);
                    intent.putExtra("mAddressId", mAddressId);
                    intent.putExtra("mDistributorId", mDistributorId);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "请选择收货地址", Toast.LENGTH_SHORT).show();
                }
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
            mAdapter.notifyDataSetChanged();
            Bundle bundle = data.getExtras();
            String mName = bundle.getString("name");
            String mNumber = bundle.getString("number");
            String mDetaadd = bundle.getString("detaadd");


            getAddlist();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getAddlist() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mClient.client())
                .baseUrl("http://120.132.117.157:8083/account/getCustAddInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<UsersAddressBean> call = apiService.getAddressData(mSid, "1", "5");
        call.enqueue(new Callback<UsersAddressBean>() {
            @Override
            public void onResponse(Response<UsersAddressBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body() != null) {
                    mResult = response.body().getObj().getResult();
                    mAdapter = new AddressAdapter(ApplyRentActivity.this, mResult);
                    mListviewGetAdd.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }


    public class AddressAdapter extends BaseAdapter {
        private final Context context;
        private final List<UsersAddressBean.ObjBean.ResultBean> result;

        public AddressAdapter(Context context, List<UsersAddressBean.ObjBean.ResultBean> result) {
            this.context=context;
            this.result=result;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int position) {
            return result.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView==null){
                viewHolder = new ViewHolder();
                convertView=View.inflate(context, R.layout.item_getaddress,null);
                viewHolder.tvName= (TextView) convertView.findViewById(R.id.tv_gername);
                viewHolder.tvNumber= (TextView) convertView.findViewById(R.id.tv_getnum);
                viewHolder.tvDetaadd= (TextView) convertView.findViewById(R.id.tv_detaadd);
                viewHolder.iv_no= (ImageView) convertView.findViewById(R.id.iv_no);
                convertView.setTag(viewHolder);

            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.tvName.setText(result.get(position).getName());
            viewHolder.tvNumber.setText(result.get(position).getMobile());
            viewHolder.tvDetaadd.setText(result.get(position).getFAddress());

            if (selectPositon==position){
                convertView.setSelected(true);
                viewHolder.iv_no.setVisibility(View.VISIBLE);
            }else {
                convertView.setSelected(false);
                viewHolder.iv_no.setVisibility(View.GONE);
            }

            return convertView;
        }
        class ViewHolder{
            TextView tvName;
            TextView tvNumber;
            TextView tvDetaadd;
            ImageView iv_no;
        }
    }


}

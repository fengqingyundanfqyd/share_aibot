package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DeleteAddressBean;
import com.example.aiqing.sharerobot.bean.MyAddressBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;
import com.example.aiqing.sharerobot.view.SideslipListView;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by aiqing on 2017/6/29.
 * <p>
 * 个人中心  我的地址
 */

public class MyAddressActivity extends AppCompatActivity {

    private List<MyAddressBean.ObjBean.ResultBean> mResult;
    private SideslipListView mSidelv;
    private HttpTool mHttpTool;
    private String mSid;
    private String mProvince;
    private String mCity;
    private String mDistrict;
    private Dialog mLoadingDialog;
    private String mAddressId;
    private ListView mLvMyaddress;
    private SwipeRefreshLayout mRefresh;
    private MyAddressAdapter mMyAddressAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaddress);

        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("我的地址");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mHttpTool = new HttpTool(this);
        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");
        initHttp();
        initId();

    }

    private void initId() {
        TextView tvAdd = (TextView) findViewById(R.id.tv_add_myaddress);
        mLvMyaddress = (ListView) findViewById(R.id.lv_myaddress);
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.refresh);


        // mSidelv = (SideslipListView) findViewById(R.id.sideliplistview);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyAddressActivity.this, AddAddressActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(199,1000);
            }
        });

        //条目点击监听
//        mSidelv.setOnItemClickListener(new AddressItemClickListener());
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==199){
                    if (mMyAddressAdapter!=null){
                        mMyAddressAdapter.notifyDataSetChanged();
                    }
                //设置组件的刷洗状态；false代表关闭
                mRefresh.setRefreshing(false);
            }
        }
    };
//    class AddressItemClickListener implements AdapterView.OnItemClickListener {
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            //mLoadingDialog = DialogUtil.createLoadingDialog(MyAddressActivity.this, "加载中...");
//            mAddressId = mResult.get(position).getAddressId();
//            Log.e("mAddressId", "onItemClick: "+ mAddressId);
//            String name = mResult.get(position).getName();
//            String mobile = mResult.get(position).getMobile();
//            mProvince = mResult.get(position).getProvince();
//            mCity = mResult.get(position).getCity();
//            mDistrict = mResult.get(position).getDistrict();
//            String township = mResult.get(position).getTownship();
//            String street = mResult.get(position).getStreet();
//            String streetnumber = mResult.get(position).getStreetnumber();
//            String building = mResult.get(position).getBuilding();
//            String isDefault = mResult.get(position).getIsDefault();
//            String fAddress = mResult.get(position).getFAddress();
//            String dAddress = mResult.get(position).getDAddress();
//            String lgt = mResult.get(position).getLgt();
//            String lat = mResult.get(position).getLat();
//
//            String add=mProvince+mCity+mDistrict;
//
//            Intent intent = new Intent();
//            intent.putExtra("mAddressId",mAddressId);
//            intent.putExtra("name",name);
//            intent.putExtra("mobile",mobile);
//            intent.putExtra("add",add);
//
//            setResult(4,intent);
//            finish();
//
//            Log.e("地址id", "onItemClick: "+ mAddressId);
//
////            Toast.makeText(MyAddressActivity.this, "点击了" + lgt + mDistrict + building, Toast.LENGTH_SHORT).show();
////            Retrofit builder = new Retrofit.Builder()
////                    .client(mHttpTool.client())
////                    .baseUrl("https://shared.aqcome.com/account/updateAddress.shtml")
////                    .addConverterFactory(GsonConverterFactory.create())
////                    .build();
////            ApiService apiService = builder.create(ApiService.class);
////
////            Call<UpdateAddressBean> call = apiService.updateadd(mSid, mAddressId, name, mobile, mProvince, mCity, mDistrict, township, street
////                    , streetnumber, building, isDefault, fAddress, dAddress, lgt, lat);
////            call.enqueue(new Callback<UpdateAddressBean>() {
////                @Override
////                public void onResponse(Response<UpdateAddressBean> response, Retrofit retrofit) {
////                    Log.e("修改地址", "onResponse: " + response.body().isSuccess());
//////                    Intent intent = new Intent();
//////                    intent.setClass(MyAddressActivity.this, AddAddressActivity.class);
//////                    startActivity(intent);
////                }
////
////                @Override
////                public void onFailure(Throwable t) {
////                    Toast.makeText(MyAddressActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
////                    Log.e("666", "onFailure: " + "网络连接失败");
////                }
////            });
//        }
//    }
    private void initHttp() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getCustAddInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);

        Call<MyAddressBean> call = apiService.getMyAddress(mSid, "1", "10");
        call.enqueue(new Callback<MyAddressBean>() {
            @Override
            public void onResponse(Response<MyAddressBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(mLoadingDialog);
                if (response.body()!=null) {
                    mResult = response.body().getObj().getResult();
                    mMyAddressAdapter = new MyAddressAdapter();
//                    mSidelv.setAdapter(myAddressAdapter);
                    mLvMyaddress.setAdapter(mMyAddressAdapter);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MyAddressActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class MyAddressAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mResult.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(MyAddressActivity.this, R.layout.item_myaddress, null);
               // SwipeLayout swipelayout = (SwipeLayout) convertView.findViewById(R.id.swipe);
                viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_addname);
                viewHolder.tvPhonenum = (TextView) convertView.findViewById(R.id.tv_addnum);
                viewHolder.tvMorenAddress = (TextView) convertView.findViewById(R.id.tv_addaddress);
                viewHolder.tv_default = (TextView) convertView.findViewById(R.id.tv_default);
                viewHolder.txtv_delete = (TextView) convertView.findViewById(R.id.txtv_delete);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.tvName.setText(mResult.get(position).getName());
            viewHolder.tvPhonenum.setText(mResult.get(position).getMobile());
            viewHolder.tvMorenAddress.setText(mResult.get(position).getFAddress());
            String isDefault = mResult.get(position).getIsDefault();
            if (isDefault.equals("1")) {
                viewHolder.tv_default.setVisibility(View.VISIBLE);
            } else if (isDefault.equals("0")) {
                viewHolder.tv_default.setVisibility(View.GONE);
            }
            final String addressId = mResult.get(position).getAddressId();
            Log.e("地址ID", "getView: "+ addressId);
            final int pos = position;
            viewHolder.txtv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //从服务器删除
                    Retrofit builder = new Retrofit.Builder()
                            .client(mHttpTool.client())
                            .baseUrl("http://120.132.117.157:8083/account/updateStatus.shtml")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    ApiService apiService = builder.create(ApiService.class);

                    Call<DeleteAddressBean> call = apiService.deleteadd(mSid,addressId);
                    call.enqueue(new Callback<DeleteAddressBean>() {
                        @Override
                        public void onResponse(Response<DeleteAddressBean> response, Retrofit retrofit) {


                            boolean success = response.body().isSuccess();
                            Log.e("删除地址", "onResponse: "+success );
                            Toast.makeText(MyAddressActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(MyAddressActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                        }
                    });
                    mResult.remove(pos);
                    notifyDataSetChanged();
                 //   mSidelv.turnNormal();
                }

            });

            return convertView;
        }
    }

    private class ViewHolder {
        TextView tvName;
        TextView tvPhonenum;
        TextView tvMorenAddress;
        TextView tv_default;
        TextView txtv_delete;

    }
}

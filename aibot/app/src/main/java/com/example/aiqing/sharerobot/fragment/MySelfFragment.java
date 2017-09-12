package com.example.aiqing.sharerobot.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.RecharActivity;
import com.example.aiqing.sharerobot.activity.ShopDataActivity;
import com.example.aiqing.sharerobot.bean.DistributorMineBean;
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
 * 投放商我的
 * Created by aiqing on 2017/9/9.
 */

public class MySelfFragment extends Fragment implements View.OnClickListener {
    private String mCookie;
    private HttpTool mHttpTool;
    private TextView mRlDisName;
    private TextView mTvFuNum;
    private TextView mTvLeave;
    private TextView mTvRended;
    private TextView mTvHistoryMoney;
    private TextView mTvLastmonth;
    private TextView mTvMymoney;
    private TextView mTvDeposit;
    private TextView mTvBalanceDis;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_myself, container, false);
        initFindId(view);
        initData();
        return view;
    }

    private void initData() {

        SharedPreferences preferences = getActivity().getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");

        mHttpTool = new HttpTool(getActivity());

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(getActivity(), "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/myDistributorInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DistributorMineBean> call = apiService.disMy(mCookie);
        call.enqueue(new Callback<DistributorMineBean>() {
            @Override
            public void onResponse(Response<DistributorMineBean> response, Retrofit retrofit) {
                String name = response.body().getObj().getName();
                mRlDisName.setText(name);
                String advanceAmount = response.body().getObj().getAdvanceAmount();
                mTvFuNum.setText(advanceAmount);

                String balance = response.body().getObj().getBalance();
                mTvBalanceDis.setText(balance);
                String cDeposit = response.body().getObj().getCDeposit();
                mTvDeposit.setText(cDeposit);
                String bDeposit = response.body().getObj().getBDeposit();
                mTvMymoney.setText(bDeposit);
//                String curprofit = response.body().getObj().getCurProfit().toString();
//                mTvLastmonth.setText(curprofit);
//                String totalMoney = response.body().getObj().getTotalProfit().toString();
//                mTvHistoryMoney.setText(totalMoney);
                String totalNum = response.body().getObj().getTotalNum();
                mTvRended.setText(totalNum);
                String curNum = response.body().getObj().getCurNum();
                mTvLeave.setText(curNum);
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "请求数据失败，请检查您的网络连接", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }

    private void initFindId(View view) {
        RelativeLayout rlShopData = (RelativeLayout) view.findViewById(R.id.rl_shop_data);
        mRlDisName = (TextView) view.findViewById(R.id.tv_dis_name);
        mTvFuNum = (TextView) view.findViewById(R.id.tv_future_num);
        TextView tvCash = (TextView) view.findViewById(R.id.tv_cash);
        TextView tvRecharge = (TextView) view.findViewById(R.id.tv_recharge);
        mTvMymoney = (TextView) view.findViewById(R.id.tv_mymoney);
        mTvDeposit = (TextView) view.findViewById(R.id.tv_deposit);
        mTvBalanceDis = (TextView) view.findViewById(R.id.tv_balance_dis);
        mTvHistoryMoney = (TextView) view.findViewById(R.id.tv_history_money);
        mTvLastmonth = (TextView) view.findViewById(R.id.tv_lastmonth_money);
        mTvRended = (TextView) view.findViewById(R.id.tv_rended);
        mTvLeave = (TextView) view.findViewById(R.id.tv_leave);

        rlShopData.setOnClickListener(this);
        tvRecharge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.rl_shop_data:
                //店铺资料
                intent.setClass(getActivity(), ShopDataActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.tv_recharge:
                //充值 预发量
                intent.setClass(getActivity(), RecharActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }
}

package com.example.aiqing.sharerobot.fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.LendAllAdapger;
import com.example.aiqing.sharerobot.adapter.LendPagerAdapter;
import com.example.aiqing.sharerobot.adapter.LendWaitAdapger;
import com.example.aiqing.sharerobot.bean.DisAllLendBean;
import com.example.aiqing.sharerobot.bean.DisWaitLendBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.Context.MODE_PRIVATE;

/**投放商出租
 * Created by aiqing on 2017/9/9.
 */

public class LendFragment extends Fragment {
    private View view1;
    private View view2;
    private TabLayout mTabLend;
    private ViewPager mVpLend;
    private String mCookie;
    private HttpTool mHttpTool;
    private ListView mLvAllLend;
    private ListView mLvWaitLend;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_lend,container,false);
        initId(view);
        initData(savedInstanceState);
        getAllData();
        getWaitData();
        return view;
    }

    private void getWaitData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(getActivity(), "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/rentAll.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DisWaitLendBean> call = apiService.getWait(mCookie, "2", "1", "5");
        call.enqueue(new Callback<DisWaitLendBean>() {
            @Override
            public void onResponse(Response<DisWaitLendBean> response, Retrofit retrofit) {
                if (response.body().getObj().getResult()!=null) {
                    List<DisWaitLendBean.ObjBean.ResultBean> waitresult = response.body().getObj().getResult();
                    LendWaitAdapger lendWaitAdapger = new LendWaitAdapger(getActivity(), waitresult);
                    mLvWaitLend.setAdapter(lendWaitAdapger);
                    DialogUtil.closeDialog(loadingDialog);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getContext(), "网络出错，请检查网络", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }

    private void getAllData() {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(getActivity(), "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/rentAll.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DisAllLendBean> call = apiService.getAll(mCookie, "0", "1", "10");
        call.enqueue(new Callback<DisAllLendBean>() {
            @Override
            public void onResponse(Response<DisAllLendBean> response, Retrofit retrofit) {
               // String address = response.body().getObj().getResult().get(1).getAddress();
               // Log.e("出租地址", "onResponse: "+ address);

                List<DisAllLendBean.ObjBean.ResultBean> lendresult = response.body().getObj().getResult();
                LendAllAdapger lendAllAdapger = new LendAllAdapger(getActivity(),lendresult);
                mLvAllLend.setAdapter(lendAllAdapger);
                DialogUtil.closeDialog(loadingDialog);
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "网络出错，请检查网络", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });

    }

    private void initData(Bundle savedInstanceState) {
        LayoutInflater inflater = getLayoutInflater(savedInstanceState);
        view1 = inflater.inflate(R.layout.item_lend_all, null);
        view2 = inflater.inflate(R.layout.item_lend_wait, null);
        List<View> mViewsList = new ArrayList<>();
        mViewsList.add(view1);
        mViewsList.add(view2);
        LendPagerAdapter lendPagerAdapter = new LendPagerAdapter(getContext(),mViewsList);
        mVpLend.setAdapter(lendPagerAdapter);
        mTabLend.setupWithViewPager(mVpLend);
        mTabLend.getTabAt(0).setText("全部");
        mTabLend.getTabAt(1).setText("待处理");

        mLvAllLend = (ListView) view1.findViewById(R.id.lv_all_lend);
        mLvWaitLend = (ListView) view2.findViewById(R.id.lv_wait_lend);

    }

    private void initId(View view) {
        SharedPreferences preferences = getActivity().getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");

        mHttpTool = new HttpTool(getActivity());
        mTabLend = (TabLayout) view.findViewById(R.id.tab_lend);
        mVpLend = (ViewPager) view.findViewById(R.id.vp_lend);
    }
}

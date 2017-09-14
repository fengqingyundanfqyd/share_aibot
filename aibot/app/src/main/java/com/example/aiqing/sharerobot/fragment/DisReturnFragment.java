package com.example.aiqing.sharerobot.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.ScanActivity;
import com.example.aiqing.sharerobot.adapter.DisreturnAdapter;
import com.example.aiqing.sharerobot.bean.DisReturnBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.Context.MODE_PRIVATE;

/**
 * 投放商归还
 * Created by aiqing on 2017/9/9.
 */

public class DisReturnFragment extends Fragment {

    private ListView mLvDisReturn;
    private String mCookie;
    private HttpTool mHttpTool;
    private List<DisReturnBean.ObjBean.ResultBean> mResult;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_return_dis, container, false);
        initFindId(view);
        getData(view);
        return view;
    }

    private void getData(View view) {
        SharedPreferences preferences = getActivity().getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(getActivity());

        SharedPreferences spDis = getActivity().getSharedPreferences("DATA", MODE_PRIVATE);
      String  distributorid = spDis.getString("distributorid", "");
       // Log.e("投放商id", "getData: "+ distributorid);

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(getActivity(), "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/returnToDistributor.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DisReturnBean> call = apiService.disReturn(mCookie,distributorid, "1", "5");
        call.enqueue(new Callback<DisReturnBean>() {
            @Override
            public void onResponse(Response<DisReturnBean> response, Retrofit retrofit) {

                int size = response.body().getObj().getSize();
                Log.e("归还数", "onResponse: "+size );

//                DisReturnBean.ObjBean obj = response.body().getObj();
//                Log.e("投放商", "onResponse: "+ obj);
                if (response.body().getObj() != null) {
                    mResult = response.body().getObj().getResult();
                    DisreturnAdapter disreturnAdapter = new DisreturnAdapter(getActivity(), mResult);
                    mLvDisReturn.setAdapter(disreturnAdapter);
                }

                DialogUtil.closeDialog(loadingDialog);

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getActivity(), "网络连接失败", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }


    private void initFindId(View view) {
        mLvDisReturn = (ListView) view.findViewById(R.id.lv_disreturn);

        TextView tvGetobj = (TextView) view.findViewById(R.id.tv_getobj);
       // mLlSure = (LinearLayout) view.findViewById(R.id.ll_sure);
        tvGetobj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), ScanActivity.class);
                startActivity(intent);
            }
        });
    }
}

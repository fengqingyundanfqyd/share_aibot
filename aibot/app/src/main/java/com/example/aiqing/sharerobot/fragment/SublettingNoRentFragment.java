package com.example.aiqing.sharerobot.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.MyAibotBean;

/**转租中
 * Created by aiqing on 2017/8/25.
 */

public class SublettingNoRentFragment extends Fragment {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean noSublet;
    private TextView mTvSublettingId;
    private TextView mTvSublettingName;
    private TextView mTvSublettingTime;
    private TextView mTvSublettingPhone;
    private TextView mTvSublettingAdd;
    private TextView mTvSublettingRemark;
    @SuppressLint({"NewApi", "ValidFragment"})
    public SublettingNoRentFragment(Context context, MyAibotBean.ObjBean.ResultBean noSublet) {
        this.context=context;
        this.noSublet=noSublet;
    }
    public SublettingNoRentFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.item_subletting,container,false);

        initId(view);
        initData();
        return view;
    }

    private void initData() {
        mTvSublettingId.setText(noSublet.getProductId()+"");
        mTvSublettingName.setText(noSublet.getZzUser());

        mTvSublettingPhone.setText(noSublet.getZzMobile()+"");
        mTvSublettingAdd.setText(noSublet.getZzAddress());
        if (noSublet.getZzRemark()==null){
            mTvSublettingRemark.setText("暂无备注信息");
        }else {
            mTvSublettingRemark.setText(noSublet.getZzRemark());
        }
    }

    private void initId(View view) {
        mTvSublettingId = (TextView) view.findViewById(R.id.tv_subletting_id);
        mTvSublettingName = (TextView) view.findViewById(R.id.tv_subletting_name);
        mTvSublettingTime = (TextView) view.findViewById(R.id.tv_subletting_time);
        mTvSublettingPhone = (TextView) view.findViewById(R.id.tv_subletting_phone);
        mTvSublettingAdd = (TextView) view.findViewById(R.id.tv_subletting_address);
        mTvSublettingRemark = (TextView) view.findViewById(R.id.tv_subletting_remark);

    }
}

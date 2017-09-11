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

public class SublettingFragment extends Fragment {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean sublet;
    private TextView mTvSublettingId;
    private TextView mTvSublettingName;
    private TextView mTvSublettingTime;
    private TextView mTvSublettingPhone;
    private TextView mTvSublettingAdd;
    private TextView mTvSublettingRemark;
    @SuppressLint({"NewApi", "ValidFragment"})
    public SublettingFragment(Context context, MyAibotBean.ObjBean.ResultBean sublet) {
        this.context=context;
        this.sublet=sublet;
    }
    public SublettingFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.item_subletting,container,false);

        initId(view);
        initData();
        return view;
    }

    private void initData() {
        mTvSublettingId.setText(sublet.getProductId()+"");
        mTvSublettingName.setText(sublet.getZzUser());

        mTvSublettingPhone.setText(sublet.getZzMobile()+"");
        mTvSublettingAdd.setText(sublet.getZzAddress());
        if (sublet.getZzRemark()==null){
            mTvSublettingRemark.setText("暂无备注信息");
        }else {
            mTvSublettingRemark.setText(sublet.getZzRemark());
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

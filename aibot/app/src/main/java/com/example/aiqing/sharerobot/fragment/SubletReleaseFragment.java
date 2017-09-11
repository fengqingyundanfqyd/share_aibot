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

/**转租发货中
 * Created by aiqing on 2017/8/25.
 */

public class SubletReleaseFragment extends Fragment {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean release;

    private TextView mTvSubletRealeId;
    private TextView mTvName;
    private TextView mTvStatus;
    private TextView mTvNum;
    private TextView mTvAdd;

    @SuppressLint({"NewApi", "ValidFragment"})
    public SubletReleaseFragment(Context context, MyAibotBean.ObjBean.ResultBean release) {
        this.context=context;
        this.release=release;
    }
    public SubletReleaseFragment(){}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view=inflater.inflate(R.layout.item_subletrelease,container,false);
        initViewId(view);

        initData();
        return view;
    }

    private void initViewId(View view) {
        mTvSubletRealeId = (TextView) view.findViewById(R.id.tv_subletrelease_id);
        mTvName = (TextView) view.findViewById(R.id.tv_subletrelease_name);
        mTvStatus = (TextView) view.findViewById(R.id.tv_ubletrelease_status);
        mTvNum = (TextView) view.findViewById(R.id.tv_ubletrelease_num);
        mTvAdd = (TextView) view.findViewById(R.id.tv_ubletrelease_add);

    }

    private void initData() {
        mTvSubletRealeId.setText(release.getProductId()+"");
        mTvName.setText(release.getCzUser());
        if (release.getCzMobile()==null&&release.getCzAddress()==null) {
            mTvNum.setText("上门自提");
        }else {
            mTvNum.setText(release.getCzMobile() + "");
            mTvAdd.setText(release.getCzAddress() + "");
        }
    }
}

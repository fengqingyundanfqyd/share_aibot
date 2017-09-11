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

/**买断
 * Created by aiqing on 2017/8/28.
 */

public class BuyOutFragment extends Fragment {
    private  Context context;
    private  MyAibotBean.ObjBean.ResultBean buyoutbean;
//    public static BuyOutFragment newInstance(Context context, MyAibotBean.ObjBean.ResultBean buyoutbean) {
//        BuyOutFragment newFragment = new BuyOutFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("name", name);
//        bundle.putString("passwd", passwd);
//        newFragment.setArguments(bundle);
//        return newFragment;
//
//    }
   @SuppressLint({"NewApi", "ValidFragment"})
    public BuyOutFragment(Context context, MyAibotBean.ObjBean.ResultBean buyoutbean) {
        this.context=context;
        this.buyoutbean=buyoutbean;
    }
    public BuyOutFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.item_buyout,container,false);
        initId(view);
        return view;
    }

    private void initId(View view) {
        TextView tvBuyoutId = (TextView) view.findViewById(R.id.tv_buyout_id);
        TextView tvLend = (TextView) view.findViewById(R.id.tv_lend_buyout);
        TextView tvRepay = (TextView) view.findViewById(R.id.tv_repay_buyout);

        tvBuyoutId.setText(buyoutbean.getProductId()+"");
        tvLend.setText(buyoutbean.getLeaseFrom2()+"");
        tvRepay.setText(buyoutbean.getLeaseTo2()+"");
    }
}

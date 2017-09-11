package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aiqing on 2017/7/1.
 */

public class MyAibotAdapter extends PagerAdapter {
    private final Context context;
    private final List<View> viewMyaibotList;

//    private final Context context;
//    private final List<MyAibotBean.ObjBean.ResultBean> result;
//
//    public MyAibotAdapter(Context context, List<MyAibotBean.ObjBean.ResultBean> result) {
//        this.context=context;
//        this.result=result;
//    }

    public MyAibotAdapter(Context context, List<View> viewMyaibotList) {
        this.context=context;
        this.viewMyaibotList=viewMyaibotList;
    }

    @Override
    public int getCount() {
        return viewMyaibotList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//       View view = LayoutInflater.from(context).inflate(vp_myaibot1, null);
//        mViews.add(view);
        container.addView(viewMyaibotList.get(position));
        return viewMyaibotList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //View view = result.get(position);
        container.removeView(viewMyaibotList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}

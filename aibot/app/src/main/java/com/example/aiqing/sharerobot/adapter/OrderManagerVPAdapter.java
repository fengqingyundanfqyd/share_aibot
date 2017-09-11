package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class OrderManagerVPAdapter extends PagerAdapter{
    private final Context context;
    private final List<View> mViewsList;

    public OrderManagerVPAdapter(Context context, List<View> mViewsList) {
        this.context=context;
        this.mViewsList=mViewsList;
    }

    @Override
    public int getCount() {
        return mViewsList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViewsList.get(position));
        return mViewsList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(mViewsList.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}

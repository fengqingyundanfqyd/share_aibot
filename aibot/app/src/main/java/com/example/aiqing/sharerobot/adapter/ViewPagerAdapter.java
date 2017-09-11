package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aiqing on 2017/6/30.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private final Context context;
    private final List<View> viewsList;

    public ViewPagerAdapter(Context context, List<View> viewsList) {
        this.context=context;
        this.viewsList=viewsList;

    }

    @Override
    public int getCount() {
        return viewsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewsList.get(position));
            return viewsList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewsList.get(position));
    }
}

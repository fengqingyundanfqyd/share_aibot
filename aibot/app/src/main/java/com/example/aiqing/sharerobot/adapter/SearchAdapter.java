package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.amap.api.services.help.Tip;
import com.example.aiqing.sharerobot.R;

import java.util.List;

/**
 * Created by aiqing on 2017/6/27.
 */

public class SearchAdapter extends BaseAdapter {
    private final List<Tip> list;
    private LayoutInflater mInflater = null;

    public SearchAdapter(Context context, List<Tip> list) {
        this.mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            mViewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_location, null);
            mViewHolder.detail = (TextView) convertView.findViewById(R.id.tv);
            mViewHolder.city = (TextView) convertView.findViewById(R.id.info);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.detail.setText(list.get(position).getName());
        mViewHolder.city.setText(list.get(position).getAddress());
        Log.e("搜索地址2", "getView: "+ list.get(1).getName());
//        mViewHolder.detail.setText(("中大银泰城"));
//        mViewHolder.city.setText(("杭州下城区"));
        return convertView;
    }

    private static class ViewHolder {
        TextView detail;
        TextView city;
    }

}

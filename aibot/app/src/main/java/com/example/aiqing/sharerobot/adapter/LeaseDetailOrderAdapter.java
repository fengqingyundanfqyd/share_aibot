package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.LeaseDetailBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/12.
 */

public class LeaseDetailOrderAdapter extends BaseAdapter {
    private final Context context;
    private final LeaseDetailBean body;
    private final List<LeaseDetailBean.RecListBean> mRecList;

    public LeaseDetailOrderAdapter(Context context, LeaseDetailBean body) {
        this.context=context;
        this.body=body;
        mRecList = body.getRecList();
    }

    @Override
    public int getCount() {

        return mRecList.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_lease_order, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_year_month = (TextView) convertView.findViewById(R.id.tv_year_month);
            viewHolder.tv_time_lease_order = (TextView) convertView.findViewById(R.id.tv_time_lease_order);
            viewHolder.tv_status_order = (TextView) convertView.findViewById(R.id.tv_status_order);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_year_month.setText(mRecList.get(position).getTimestamp()+"");
        //viewHolder.tv_time_lease_order.setText("16:30");
        viewHolder.tv_status_order.setText(mRecList.get(position).getRemark());
        return convertView;
    }

    private class ViewHolder {

        TextView tv_year_month;
        TextView tv_time_lease_order;
        TextView tv_status_order;
    }
}

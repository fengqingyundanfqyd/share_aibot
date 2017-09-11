package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/7/7.
 */

public class LeaseHistoryAdapter extends BaseAdapter {
    private final Context context;

    public LeaseHistoryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
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
            convertView = View.inflate(context, R.layout.item_lease_history, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon_circle = (ImageView) convertView.findViewById(R.id.iv_icon_circle);
            viewHolder.tv_xiaobao = (TextView) convertView.findViewById(R.id.tv_xiaobao);
            viewHolder.tv_data_history = (TextView) convertView.findViewById(R.id.tv_data_history);
            viewHolder.tv_time_history = (TextView) convertView.findViewById(R.id.tv_time_history);
            viewHolder.tv_id_history = (TextView) convertView.findViewById(R.id.tv_id_history);
            viewHolder.tv_type_history = (TextView) convertView.findViewById(R.id.tv_type_history);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_icon_circle.setImageResource(R.mipmap.icon_circle_bg);
        viewHolder.tv_xiaobao.setText("小宝");
        viewHolder.tv_data_history.setText("2017-7-9");
        viewHolder.tv_time_history.setText("14:30");
        viewHolder.tv_id_history.setText("gioejgoieheieeih");
        viewHolder.tv_type_history.setText("已还");
        return convertView;
    }

    class ViewHolder {
        ImageView iv_icon_circle;
        TextView tv_xiaobao;
        TextView tv_data_history;
        TextView tv_time_history;
        TextView tv_id_history;
        TextView tv_type_history;
    }
}

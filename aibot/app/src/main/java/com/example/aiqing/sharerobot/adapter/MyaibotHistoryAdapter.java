package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.MyAibotOrderBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/12.
 */

public class MyaibotHistoryAdapter extends BaseAdapter {
    private final Context context;
    private final List<MyAibotOrderBean.UseHistoryBean.ResultBean> result;

    public MyaibotHistoryAdapter(Context context, List<MyAibotOrderBean.UseHistoryBean.ResultBean> result) {
        this.context=context;
        this.result=result;
    }

    @Override
    public int getCount() {
        return result.size();
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
            convertView = View.inflate(context, R.layout.item_myaibot_history, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_header_item_history = (ImageView) convertView.findViewById(R.id.iv_header_item_history);
            viewHolder.tv_name_item = (TextView) convertView.findViewById(R.id.tv_name_item);
            viewHolder.tv_year_item = (TextView) convertView.findViewById(R.id.tv_year_item);
            viewHolder.tv_time_item = (TextView) convertView.findViewById(R.id.tv_time_item);
            viewHolder.tv_item_id = (TextView) convertView.findViewById(R.id.tv_item_id);
            viewHolder.tv_item_status = (TextView) convertView.findViewById(R.id.tv_item_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_header_item_history.setImageResource(R.mipmap.but_small);
        viewHolder.tv_name_item.setText(result.get(position).getPTypeName());
        viewHolder.tv_year_item.setText(result.get(position).getTimestamp()+"");
       // viewHolder.tv_time_item.setText("14:30");
        viewHolder.tv_item_id.setText(result.get(position).getProductId()+"");
        String status = result.get(position).getStatus();
        if (status.equals("0")){
            viewHolder.tv_item_status.setText("未初始化");
        }else if (status.equals("1")){
            viewHolder.tv_item_status.setText("待租中（B端）");
        }else if (status.equals("2")){
            viewHolder.tv_item_status.setText("待租中（C端）");
        }else if (status.equals("3")){
            viewHolder.tv_item_status.setText("转租中（未被支付押金）");
        }else if (status.equals("4")){
            viewHolder.tv_item_status.setText("转租中（已被支付押金）");
        }else if (status.equals("5")){
            viewHolder.tv_item_status.setText("租用中");
        }else if (status.equals("6")){
            viewHolder.tv_item_status.setText("归还中（已租）");
        }else if (status.equals("7")){
            viewHolder.tv_item_status.setText("归还中（未租）");
        }else if (status.equals("8")){
            viewHolder.tv_item_status.setText("售后中");
        }else if (status.equals("9")){
            viewHolder.tv_item_status.setText("返厂中");
        }else if (status.equals("11")){
            viewHolder.tv_item_status.setText("待租中（B端已被交付押金预约）");
        }else if (status.equals("12")){
            viewHolder.tv_item_status.setText("待租中（C端已被交付押金预约）");
        }else if (status.equals("99")){
            viewHolder.tv_item_status.setText("买断");
        }

        return convertView;
    }

    class ViewHolder {
        ImageView iv_header_item_history;
        TextView tv_name_item;
        TextView tv_year_item;
        TextView tv_time_item;
        TextView tv_item_id;
        TextView tv_item_status;
    }
}

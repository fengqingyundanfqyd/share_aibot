package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/7/7.
 */

public class MoneyDetailingAdapter extends BaseAdapter {
    private final Context context;


    public MoneyDetailingAdapter(Context context) {
        this.context=context;

    }

    @Override
    public int getCount() {
        return 10;
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
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_money_detailing,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_leasemonth= (TextView) convertView.findViewById(R.id.tv_leasemonth);
            viewHolder.tv_money_detail= (TextView) convertView.findViewById(R.id.tv_money_detail);
            viewHolder.tv_data_detail= (TextView) convertView.findViewById(R.id.tv_data_detail);
            viewHolder.tv_time_detail= (TextView) convertView.findViewById(R.id.tv_time_detail);
            viewHolder.tv_zhifustyle= (TextView) convertView.findViewById(R.id.tv_zhifustyle);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_leasemonth.setText("租金一个月");
        viewHolder.tv_money_detail.setText("-900");
        viewHolder.tv_data_detail.setText("2017-7-9");
        viewHolder.tv_time_detail.setText("14:30");
        viewHolder.tv_zhifustyle.setText("支付宝");
        return convertView;
    }
    class ViewHolder{
        TextView tv_leasemonth;
        TextView tv_money_detail;
        TextView tv_data_detail;
        TextView tv_time_detail;
        TextView tv_zhifustyle;
    }
}

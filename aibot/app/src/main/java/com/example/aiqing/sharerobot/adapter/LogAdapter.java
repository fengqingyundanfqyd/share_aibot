package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/7/6.
 */

public class LogAdapter extends BaseAdapter {
    private final Context context;

    public LogAdapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 5;
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
            convertView=View.inflate(context, R.layout.item_log,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_header_log= (ImageView) convertView.findViewById(R.id.iv_header_log);
            viewHolder.tv_nicname_log= (TextView) convertView.findViewById(R.id.tv_nicname_log);
            viewHolder.tv_result_log= (TextView) convertView.findViewById(R.id.tv_result_log);
            viewHolder.tv_robotid_log= (TextView) convertView.findViewById(R.id.tv_robotid_log);
            viewHolder.tv_id_log= (TextView) convertView.findViewById(R.id.tv_id_log);
            viewHolder.tv_data_log= (TextView) convertView.findViewById(R.id.tv_data_log);
            viewHolder.tv_time_log= (TextView) convertView.findViewById(R.id.tv_time_log);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_header_log.setImageResource(R.mipmap.header);
        viewHolder.tv_nicname_log.setText("账号/昵称");
        viewHolder.tv_result_log.setText("转租成功");
        viewHolder.tv_robotid_log.setText("小宝ID");
        viewHolder.tv_id_log.setText("gjieejgejgoejfoejfiej");
        viewHolder.tv_data_log.setText("2017-7-6");
        viewHolder.tv_time_log.setText("14：11");
        return convertView;
    }
    class ViewHolder{
        ImageView  iv_header_log;
        TextView tv_nicname_log;
        TextView tv_robotid_log;
        TextView tv_id_log;
        TextView tv_data_log;
        TextView tv_time_log;
        TextView tv_result_log;
    }
}

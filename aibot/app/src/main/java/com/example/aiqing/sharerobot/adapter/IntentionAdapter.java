package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/7/6.
 */

public class IntentionAdapter extends BaseAdapter {
    private final Context context;

    public IntentionAdapter(Context context) {
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
            convertView=View.inflate(context, R.layout.item_intention,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_header_intention= (ImageView) convertView.findViewById(R.id.iv_header_intention);
            viewHolder.tv_nicname_intention= (TextView) convertView.findViewById(R.id.tv_nicname_intention);
            viewHolder.tv_robotnum_intention= (TextView) convertView.findViewById(R.id.tv_robotnum_intention);
            viewHolder.tv_number_intention= (TextView) convertView.findViewById(R.id.tv_number_intention);
            viewHolder.tv_address_intention= (TextView) convertView.findViewById(R.id.tv_address_intention);
            viewHolder.tv_name_intention= (TextView) convertView.findViewById(R.id.tv_name_intention);
            viewHolder.btn_suresend_intention= (Button) convertView.findViewById(R.id.btn_suresend_intention);
            viewHolder.tv_data_intention= (TextView) convertView.findViewById(R.id.tv_data_intention);
            viewHolder.tv_time_intention= (TextView) convertView.findViewById(R.id.tv_time_intention);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_header_intention.setImageResource(R.mipmap.header);
        viewHolder.tv_nicname_intention.setText("账号/昵称");
        viewHolder.tv_robotnum_intention.setText("4");
        viewHolder.tv_name_intention.setText("爱卿");
        viewHolder.tv_number_intention.setText("127374827484");
        viewHolder.tv_address_intention.setText("中大从覅的gif供给规划估计各地id和");
        viewHolder.tv_data_intention.setText("2017-7-6");
        viewHolder.tv_time_intention.setText("14：11");
        viewHolder.btn_suresend_intention.setText("确认发货");
        return convertView;
    }
    class ViewHolder{
        ImageView  iv_header_intention;
        TextView tv_nicname_intention;
        TextView tv_robotnum_intention;
        TextView tv_name_intention;
        TextView tv_number_intention;
        TextView tv_address_intention;
        Button btn_suresend_intention;
        TextView tv_data_intention;
        TextView tv_time_intention;
    }
}

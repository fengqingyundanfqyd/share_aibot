package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/6/28.
 */

public class HadInitAdapter extends BaseAdapter {
    private final Context context;

    boolean isClick=false;


    public HadInitAdapter(Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView=View.inflate(context, R.layout.item_hadinit,null);
            viewHolder.tv_hadinit_date= (TextView) convertView.findViewById(R.id.tv_hadinit_date);
            viewHolder.tv_hadinit_id= (TextView) convertView.findViewById(R.id.tv_hadinit_id);
//            viewHolder.tvDetaadd= (TextView) convertView.findViewById(R.id.tv_detaadd);
//            viewHolder.iv_no= (ImageView) convertView.findViewById(R.id.iv_no);
            convertView.setTag(viewHolder);
//
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        viewHolder.tvName.setText(name);
//        viewHolder.tvNumber.setText(number);
//        viewHolder.tvDetaadd.setText(detaadd);

        return convertView;
    }
    class ViewHolder{
        TextView tv_hadinit_date;
        TextView tv_hadinit_id;
//        TextView tvDetaadd;
//        ImageView iv_no;
    }
}

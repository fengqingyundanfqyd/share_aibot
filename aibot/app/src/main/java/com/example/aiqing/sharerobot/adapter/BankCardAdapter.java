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

public class BankCardAdapter extends BaseAdapter {
    private final Context context;

    public BankCardAdapter(Context context) {
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
            convertView=View.inflate(context, R.layout.item_bank_card,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_card_header= (ImageView) convertView.findViewById(R.id.iv_card_header);
            viewHolder.tv_bank_name= (TextView) convertView.findViewById(R.id.tv_bank_name);
            viewHolder.tv_bank_lastnum= (TextView) convertView.findViewById(R.id.tv_bank_lastnum);
            viewHolder.iv_bank_status= (ImageView) convertView.findViewById(R.id.iv_bank_status);



            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_card_header.setImageResource(R.mipmap.header);
        viewHolder.tv_bank_name.setText("中国银行");
        viewHolder.tv_bank_lastnum.setText("9999");
        viewHolder.iv_bank_status.setImageResource(R.mipmap.check_icon);


        return convertView;
    }
    class ViewHolder{
        ImageView  iv_card_header;
        TextView tv_bank_name;
        TextView tv_bank_lastnum;
        ImageView iv_bank_status;

    }
}

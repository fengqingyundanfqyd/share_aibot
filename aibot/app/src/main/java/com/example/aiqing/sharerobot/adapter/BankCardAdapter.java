package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.BankListBean;

import java.util.List;

import static android.R.attr.name;

/**
 * Created by aiqing on 2017/7/6.
 */

public class BankCardAdapter extends BaseAdapter {
    private final Context context;
    private final List<BankListBean.ObjBean> list;

    public BankCardAdapter(Context context, List<BankListBean.ObjBean> list) {
        this.context=context;
        this.list=list;
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
        viewHolder.tv_bank_name.setText(list.get(position).getAccountName());
        String cardNo = list.get(position).getCardNo();
        String num = cardNo.substring(cardNo.length() - 4, cardNo.length());

        viewHolder.tv_bank_lastnum.setText(num);
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

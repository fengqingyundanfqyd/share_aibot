package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.HavaLeaseBean;

import java.util.List;

/**
 * Created by aiqing on 2017/6/30.
 */

public class RenttingAdapter extends BaseAdapter {
    private final Context context;
    private final List<HavaLeaseBean.OrderListBean.ResultBean> result1;

    public RenttingAdapter(Context context, List<HavaLeaseBean.OrderListBean.ResultBean> result1) {
        this.context = context;
        this.result1 = result1;
    }

    @Override
    public int getCount() {
        return result1.size();
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
            convertView = View.inflate(context, R.layout.item_rentting, null);
            viewHolder = new ViewHolder();
            //viewHolder.ivHeader = (ImageView) convertView.findViewById(R.id.iv_neworder);
            viewHolder.tvPhoneNum = (TextView) convertView.findViewById(R.id.tv_robot_id);
            viewHolder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //viewHolder.ivHeader.setImageResource(R.mipmap.header);
        String status = result1.get(position).getStatus();
        viewHolder.tvPhoneNum.setText(result1.get(position)+"");
        if (status.equals("2")){
            viewHolder.tvState.setText("转租中");
        }else if (status.equals("4")){
            viewHolder.tvState.setText("租用中");
        } else if (status.equals("5")) {
            viewHolder.tvState.setText("确认收货");
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView ivHeader;
        TextView tvPhoneNum;
        TextView tvState;
    }
}

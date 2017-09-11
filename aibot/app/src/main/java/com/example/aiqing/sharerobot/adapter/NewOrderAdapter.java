package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.OrderBean;

import java.util.List;

/**
 * Created by aiqing on 2017/6/30.
 */

public class NewOrderAdapter extends BaseAdapter {
    private final Context context;
    private final List<OrderBean.OrderListBean.ResultBean> result3;

    public NewOrderAdapter(Context context, List<OrderBean.OrderListBean.ResultBean> result3) {
        this.context = context;
        this.result3 = result3;
    }

    @Override
    public int getCount() {
        return result3.size();
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
            convertView = View.inflate(context, R.layout.item_neworder, null);
            viewHolder = new ViewHolder();
            viewHolder.ivHeader = (ImageView) convertView.findViewById(R.id.iv_neworder);
            viewHolder.tvPhoneNum = (TextView) convertView.findViewById(R.id.tv_newordernum);
            viewHolder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            viewHolder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
            convertView.setTag(viewHolder);
        }else {
             viewHolder = (ViewHolder) convertView.getTag();
        }
        //头像为空
       // Bitmap bm = BitmapFactory.decodeFile(result3.get(position).);
        viewHolder.ivHeader.setImageResource(R.mipmap.header);
        viewHolder.tvPhoneNum.setText(result3.get(position).getMobile());
        viewHolder.tv_count.setText(result3.get(position).getCount()+"");
        String doStatus = result3.get(position).getDoStatus();
        if (doStatus.equals("5")){
            viewHolder.tvState.setText("确认发货");
        }else if (doStatus.equals("6")){
            viewHolder.tvState.setText("已发货");
        }else if (doStatus.equals("9")){
            viewHolder.tvState.setText("已取消");
        }else if (doStatus.equals("10")){
            viewHolder.tvState.setText("确认收货");
        }

        return convertView;
    }

    private class ViewHolder {
        ImageView ivHeader;
        TextView tvPhoneNum;
        TextView tvState;
        TextView tv_count;
    }
}

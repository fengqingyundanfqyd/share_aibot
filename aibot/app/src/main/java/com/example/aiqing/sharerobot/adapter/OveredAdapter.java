package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.LeaseManagerDaiBean;

import java.util.List;

/**
 * Created by aiqing on 2017/6/30.
 */

public class OveredAdapter extends BaseAdapter {
    private final Context context;

    private final List<LeaseManagerDaiBean.ObjBean.ResultBean> result;

    public OveredAdapter(Context context, List<LeaseManagerDaiBean.ObjBean.ResultBean> result) {
        this.context = context;
        this.result = result;
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
            convertView = View.inflate(context, R.layout.item_overed, null);
            viewHolder = new ViewHolder();
            //viewHolder.ivHeader = (ImageView) convertView.findViewById(R.id.iv_neworder);
            viewHolder.tvPhoneNum = (TextView) convertView.findViewById(R.id.tv_robot_id);
            viewHolder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //viewHolder.ivHeader.setImageResource(R.mipmap.robot);
        viewHolder.tvPhoneNum.setText(result.get(position).getProductId()+"");
        //状态1--待租中（B端）3--待租中（C端自己结束租用）
        if (result.get(position).getStatus().equals("1")){
            viewHolder.tvState.setText("待租中");
        }else if (result.get(position).getStatus().equals("1")){
            viewHolder.tvState.setText("待租中");
        }
        //viewHolder.tvState.setText("已结束");
        return convertView;
    }

    private class ViewHolder {
        ImageView ivHeader;
        TextView tvPhoneNum;
        TextView tvState;
    }
}

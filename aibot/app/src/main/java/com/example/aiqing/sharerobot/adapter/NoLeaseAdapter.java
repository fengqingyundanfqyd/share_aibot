package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.NotUsedBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/12.
 */

public class NoLeaseAdapter extends BaseAdapter {
    private final Context context;
    private final List<NotUsedBean.ObjBean.ResultBean> result;

    public NoLeaseAdapter(Context context, List<NotUsedBean.ObjBean.ResultBean> result) {
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
            convertView = View.inflate(context, R.layout.item_no_lease, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_header_nolease = (ImageView) convertView.findViewById(R.id.iv_header_nolease);
            viewHolder.tv_name_nolease = (TextView) convertView.findViewById(R.id.tv_name_nolease);
            viewHolder.tv_year_nolease = (TextView) convertView.findViewById(R.id.tv_year_nolease);
            viewHolder.tv_time_nolease = (TextView) convertView.findViewById(R.id.tv_time_nolease);
            viewHolder.tv_nolease_id = (TextView) convertView.findViewById(R.id.tv_nolease_id);
            viewHolder.tv_nolease_status = (TextView) convertView.findViewById(R.id.tv_nolease_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_header_nolease.setImageResource(R.mipmap.but_small);
        viewHolder.tv_name_nolease.setText(result.get(position).getPtypeName());
       // viewHolder.tv_year_nolease.setText("2017-7-9");
        viewHolder.tv_time_nolease.setText(result.get(position).getCreateTime()+"");
        viewHolder.tv_nolease_id.setText(result.get(position).getProductId()+"");
        viewHolder.tv_nolease_status.setText("撤销");
        return convertView;
    }

    class ViewHolder {
        ImageView iv_header_nolease;
        TextView tv_name_nolease;
        TextView tv_year_nolease;
        TextView tv_time_nolease;
        TextView tv_nolease_id;
        TextView tv_nolease_status;
    }
}

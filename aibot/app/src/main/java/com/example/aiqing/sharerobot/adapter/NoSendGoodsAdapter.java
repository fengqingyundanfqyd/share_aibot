package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.NoSendBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/12.
 */

public class NoSendGoodsAdapter extends BaseAdapter {
    private final Context context;
    private final List<NoSendBean.ObjBean.ResultBean> result;

    public NoSendGoodsAdapter(Context context, List<NoSendBean.ObjBean.ResultBean> result) {
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
            convertView = View.inflate(context, R.layout.item_onsend_goods, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_header_nosend = (ImageView) convertView.findViewById(R.id.iv_header_nosend);
            viewHolder.tv_name_nosend = (TextView) convertView.findViewById(R.id.tv_name_nosend);
            viewHolder.tv_year_nosend = (TextView) convertView.findViewById(R.id.tv_year_nosend);
            viewHolder.tv_time_nosend = (TextView) convertView.findViewById(R.id.tv_time_nosend);
            viewHolder.tv_nosend_id = (TextView) convertView.findViewById(R.id.tv_nosend_id);
            viewHolder.tv_inosend_status = (TextView) convertView.findViewById(R.id.tv_inosend_status);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_header_nosend.setImageResource(R.mipmap.but_small);
        viewHolder.tv_name_nosend.setText(result.get(position).getPtypeName());
        //viewHolder.tv_year_nosend.setText(result.get(position).getCreateTime());
        viewHolder.tv_time_nosend.setText(result.get(position).getCreateTime()+"");
        viewHolder.tv_nosend_id.setText(result.get(position).getApplyNum()+"");
        viewHolder.tv_inosend_status.setText("撤销");
        return convertView;
    }

    class ViewHolder {
        ImageView iv_header_nosend;
        TextView tv_name_nosend;
        TextView tv_year_nosend;
        TextView tv_time_nosend;
        TextView tv_nosend_id;
        TextView tv_inosend_status;
    }
}

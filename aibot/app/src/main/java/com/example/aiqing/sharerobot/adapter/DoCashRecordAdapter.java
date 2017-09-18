package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DoCashDetailBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class DoCashRecordAdapter extends BaseAdapter {
    private final Context context;
    private final List<DoCashDetailBean.CashApplyListBean.ResultBean> result;

    public DoCashRecordAdapter(Context context, List<DoCashDetailBean.CashApplyListBean.ResultBean> result) {
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
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item_docash,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_docashnum= (TextView) convertView.findViewById(R.id.tv_docashnum);
            viewHolder.tv_docash_time= (TextView) convertView.findViewById(R.id.tv_docash_time);
            viewHolder.tv_docash_status= (TextView) convertView.findViewById(R.id.tv_docash_status);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_docashnum.setText(result.get(position).getAmount()+"");
        viewHolder.tv_docash_time.setText(result.get(position).getApplyTime()+"");
        viewHolder.tv_docash_status.setText(result.get(position).getType());


        return convertView;
    }
    class ViewHolder{
        TextView  tv_docashnum;
        TextView tv_docash_time;
        TextView tv_docash_status;

    }
}

package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.InAndOutBeanDai;

import java.util.List;

/**
 * Created by aiqing on 2017/8/12.
 */

public class DaiInAndOutAdapter extends BaseAdapter {
    private final Context context;
    private final List<InAndOutBeanDai.AgencyListBean.ResultBean> beanList;


    public DaiInAndOutAdapter(Context context, List<InAndOutBeanDai.AgencyListBean.ResultBean> beanList) {
        this.context=context;
        this.beanList=beanList;
    }

    @Override
    public int getCount() {
        return beanList.size();
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
            viewHolder = new ViewHolder();
            convertView=View.inflate(context, R.layout.item_in_out_dai,null);
            viewHolder.tv_product_dai= (TextView) convertView.findViewById(R.id.tv_product_dai);
            viewHolder.tv_status_dai= (TextView) convertView.findViewById(R.id.tv_status_dai);
            viewHolder.tv_data_dai= (TextView) convertView.findViewById(R.id.tv_data_dai);
            viewHolder.tv_time_dai= (TextView) convertView.findViewById(R.id.tv_time_dai);
            viewHolder.tv_status2_dai= (TextView) convertView.findViewById(R.id.tv_status2_dai);
            viewHolder.tv_applynum_dai= (TextView) convertView.findViewById(R.id.tv_applynum_dai);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_product_dai.setText(beanList.get(position).getPtypeName());
        String curFor = beanList.get(position).getCurFor();
        if (curFor.equals("-")){
            viewHolder.tv_status_dai.setText("(发货)");
        }else if (curFor.equals("+")){
            viewHolder.tv_status_dai.setText("(进货)");
        }
        viewHolder.tv_data_dai.setText(beanList.get(position).getCreateTime()+"");
        String doStatus = beanList.get(position).getDoStatus();
        if (doStatus.equals("2")){
            viewHolder.tv_status2_dai.setText("待审核");
        }else if (doStatus.equals("6")){
            viewHolder.tv_status2_dai.setText("物流中");
        }else if (doStatus.equals("8")){
            viewHolder.tv_status2_dai.setText("交易成功");
        }
        String curFor1 = beanList.get(position).getCurFor();
        viewHolder.tv_applynum_dai.setText(curFor1+beanList.get(position).getApplyNum()+"");
        return convertView;
    }
    private class ViewHolder{
        TextView tv_product_dai;
        TextView tv_status_dai;
        TextView tv_data_dai;
        TextView tv_time_dai;
        TextView tv_status2_dai;
        TextView tv_applynum_dai;
    }
}

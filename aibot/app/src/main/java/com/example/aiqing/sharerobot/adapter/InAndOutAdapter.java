package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.InAndOutBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/4.
 */

public class InAndOutAdapter extends BaseAdapter {
    private final Context context;
    private final List<InAndOutBean.DistributorListBean.ResultBean> resultBeanList;

    public InAndOutAdapter(Context context, List<InAndOutBean.DistributorListBean.ResultBean> resultBeanList) {
        this.context=context;
        this.resultBeanList=resultBeanList;
    }

    @Override
    public int getCount() {
        return resultBeanList.size();
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
            convertView=View.inflate(context, R.layout.item_in_out,null);
            viewHolder.tv_product= (TextView) convertView.findViewById(R.id.tv_product);
            viewHolder.tv_status= (TextView) convertView.findViewById(R.id.tv_status);
            viewHolder.tv_data= (TextView) convertView.findViewById(R.id.tv_data);
            viewHolder.tv_time= (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_status2= (TextView) convertView.findViewById(R.id.tv_status2);
            viewHolder.tv_applynum= (TextView) convertView.findViewById(R.id.tv_applynum);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_product.setText(resultBeanList.get(position).getPtypeName());
        String curFor = resultBeanList.get(position).getCurFor();
        if (curFor.equals("-")){
            viewHolder.tv_status.setText("(发货)");
        }else if (curFor.equals("+")){
            viewHolder.tv_status.setText("(进货)");
        }
        viewHolder.tv_data.setText(resultBeanList.get(position).getCreateTime()+"");
        String doStatus = resultBeanList.get(position).getDoStatus();
        if (doStatus.equals("2")){
            viewHolder.tv_status2.setText("待审核");
        }else if (doStatus.equals("6")){
            viewHolder.tv_status2.setText("物流中");
        }else if (doStatus.equals("8")){
            viewHolder.tv_status2.setText("交易成功");
        }
        String curFor1 = resultBeanList.get(position).getCurFor();
        viewHolder.tv_applynum.setText(curFor1+resultBeanList.get(position).getApplyNum()+"");
        return convertView;
    }
    private class ViewHolder{
        TextView tv_product;
        TextView tv_status;
        TextView tv_data;
        TextView tv_time;
        TextView tv_status2;
        TextView tv_applynum;
    }
}

package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AgencyDisBean;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class AgencyNextDisAdapter extends BaseAdapter {
    private final Context context;
    private final List<AgencyDisBean.ResultBeanX.ResultBean> result;

    public AgencyNextDisAdapter(Context context, List<AgencyDisBean.ResultBeanX.ResultBean> result) {
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
            convertView=View.inflate(context, R.layout.item_nextdis,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_disheader= (ImageView) convertView.findViewById(R.id.iv_header_log);
            viewHolder.tv_disname= (TextView) convertView.findViewById(R.id.tv_disname);
            viewHolder.tv_disphone= (TextView) convertView.findViewById(R.id.tv_disphone);
            viewHolder.tv_history_get= (TextView) convertView.findViewById(R.id.tv_history_get);
            viewHolder.tv_income= (TextView) convertView.findViewById(R.id.tv_income);
            viewHolder.tv_dis_address= (TextView) convertView.findViewById(R.id.tv_dis_address);
            viewHolder.tv_discreatime= (TextView) convertView.findViewById(R.id.tv_discreatime);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        viewHolder.iv_header_log.setImageResource(R.mipmap.header);
        viewHolder.tv_disname.setText(result.get(position).getName());
        viewHolder.tv_disphone.setText(result.get(position).getContact1()+"");

        if (result.get(position).getMoney()==null){
            viewHolder.tv_history_get.setText("+"+"0.00");
        }else {
            DecimalFormat df = new DecimalFormat("0.00");
            String format = df.format(Double.valueOf(result.get(position).getMoney().toString()));
            viewHolder.tv_history_get.setText(format+"");
        }
        viewHolder.tv_income.setText(result.get(position).getStock()+"");
        viewHolder.tv_dis_address.setText(result.get(position).getAddress());
        viewHolder.tv_discreatime.setText(result.get(position).getCreateTime()+"");
        return convertView;
    }
    class ViewHolder{
        ImageView  iv_disheader;
        TextView tv_disname;
        TextView tv_disphone;
        TextView tv_history_get;
        TextView tv_income;
        TextView tv_dis_address;
        TextView tv_discreatime;
    }
}

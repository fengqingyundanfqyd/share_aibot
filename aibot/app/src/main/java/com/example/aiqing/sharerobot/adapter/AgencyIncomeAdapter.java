package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.AgencyIncomeBaen;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class AgencyIncomeAdapter extends BaseAdapter {
    private final Context context;
    private final List<AgencyIncomeBaen.ResultBeanX.ResultBean> beanList;

    public AgencyIncomeAdapter(Context context, List<AgencyIncomeBaen.ResultBeanX.ResultBean> beanList) {
        this.context = context;
        this.beanList = beanList;
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
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_historyincome, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_agency_disheader= (ImageView) convertView.findViewById(R.id.iv_agency_disheader);
            viewHolder.tv_a_getmoney= (TextView) convertView.findViewById(R.id.tv_a_getmoney);
            viewHolder.tv_income_address= (TextView) convertView.findViewById(R.id.tv_income_address);
            viewHolder.tv_income_phone= (TextView) convertView.findViewById(R.id.tv_income_phone);
            viewHolder.tv_income_id= (TextView) convertView.findViewById(R.id.tv_income_id);
            viewHolder.tv_income_time= (TextView) convertView.findViewById(R.id.tv_income_time);
            viewHolder.tv_income_name= (TextView) convertView.findViewById(R.id.tv_income_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        viewHolder.iv_header_log.setImageResource(R.mipmap.header);
        viewHolder.tv_a_getmoney.setText(beanList.get(position).getMoney()+"");
        viewHolder.tv_income_address.setText(beanList.get(position).getAddress());
        viewHolder.tv_income_phone.setText(beanList.get(position).getMobile()+"");
        viewHolder.tv_income_id.setText(beanList.get(position).getProductId()+"");
        viewHolder.tv_income_time.setText(beanList.get(position).getLeaseFrom()+"");
        viewHolder.tv_income_name.setText(beanList.get(position).getName());
        return convertView;
    }

    class ViewHolder {
        ImageView iv_agency_disheader;
        TextView tv_a_getmoney;
        TextView tv_income_address;
        TextView tv_income_phone;
        TextView tv_income_id;
        TextView tv_income_time;
        TextView tv_income_name;
    }
}

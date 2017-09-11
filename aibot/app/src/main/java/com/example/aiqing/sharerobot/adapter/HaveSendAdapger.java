package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DaiOrderBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class HaveSendAdapger extends BaseAdapter {
    private final Context context;
    private final List<DaiOrderBean.ProListBean.ResultBean> havasend;

    public HaveSendAdapger(Context context, List<DaiOrderBean.ProListBean.ResultBean> havasend) {
        this.context=context;
        this.havasend=havasend;
    }

    @Override
    public int getCount() {
        return havasend.size();
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
            convertView=View.inflate(context,R.layout.item_applysend,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_shoplogo= (ImageView) convertView.findViewById(R.id.iv_shoplogo);
            viewHolder.tv_shopname= (TextView) convertView.findViewById(R.id.tv_shopname);
            viewHolder.tv_shopaddress= (TextView) convertView.findViewById(R.id.tv_shopaddress);
            viewHolder.tv_shopnumber= (TextView) convertView.findViewById(R.id.tv_shopnumber);
            viewHolder.tv_shopbossname= (TextView) convertView.findViewById(R.id.tv_shopbossname);
            viewHolder.tv_robotnumber= (TextView) convertView.findViewById(R.id.tv_robotnumber);
            viewHolder.tv_robotmath= (TextView) convertView.findViewById(R.id.tv_robotmath);
            viewHolder.btn_suresend= (Button) convertView.findViewById(R.id.btn_suresend);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.iv_shoplogo.setImageResource(R.mipmap.robot);
        viewHolder.tv_shopname.setText(havasend.get(position).getCustName());
        viewHolder.tv_shopaddress.setText(havasend.get(position).getAddress());
        viewHolder.tv_shopnumber.setText(havasend.get(position).getMobile()+"");
        viewHolder.tv_shopbossname.setText(havasend.get(position).getName());
        viewHolder.tv_robotnumber.setText("台数");
        viewHolder.tv_robotmath.setText(havasend.get(position).getApplyNum()+"");
        viewHolder.btn_suresend.setText("已发货");
        return convertView;
    }
    class ViewHolder{
        ImageView iv_shoplogo;
        TextView tv_shopname;
        TextView tv_shopaddress;
        TextView tv_shopnumber;
        TextView tv_shopbossname;
        TextView tv_robotnumber;
        TextView tv_robotmath;
        Button btn_suresend;
    }
}

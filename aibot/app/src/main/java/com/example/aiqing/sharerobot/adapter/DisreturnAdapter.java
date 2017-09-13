package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.activity.GetGoodsLogActivity;
import com.example.aiqing.sharerobot.bean.DisReturnBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class DisreturnAdapter extends BaseAdapter {
    private final Context context;
    private final List<DisReturnBean.ObjBean.ResultBean> result;

    public DisreturnAdapter(Context context, List<DisReturnBean.ObjBean.ResultBean> result) {
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
            convertView=View.inflate(context, R.layout.item_dis_return,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_disreturn_id= (TextView) convertView.findViewById(R.id.tv_disreturn_id);
            viewHolder.tv_disreturn_address= (TextView) convertView.findViewById(R.id.tv_disreturn_address);
            viewHolder.tv_disreturn_phone= (TextView) convertView.findViewById(R.id.tv_disreturn_phone);
            viewHolder.btn_dis_return = (Button) convertView.findViewById(R.id.btn_dis_return);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_disreturn_id.setText(result.get(position).getProductId()+"");
        viewHolder.tv_disreturn_address.setText(result.get(position).getAddressOr());
        viewHolder.tv_disreturn_phone.setText(result.get(position).getMobile2()+"");
        final String productId = result.get(position).getProductId();
        viewHolder.btn_dis_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(context,GetGoodsLogActivity.class);
                intent.putExtra("productId",productId);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView  tv_disreturn_id;
        TextView tv_disreturn_address;
        TextView tv_disreturn_phone;
        Button  btn_dis_return;

    }
}

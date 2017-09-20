package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.NearbyShopBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class NearbyAdapter extends BaseAdapter {
    private final Context context;
    private final List<NearbyShopBean.DistributorBean.ResultBean> result;

    public NearbyAdapter(Context context, List<NearbyShopBean.DistributorBean.ResultBean> result) {
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
            convertView=View.inflate(context, R.layout.item_nearbyshop,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_shop_name= (TextView) convertView.findViewById(R.id.tv_shop_name);
            viewHolder.tv_dis_distance= (TextView) convertView.findViewById(R.id.tv_dis_distance);
            viewHolder.tv_shop_building= (TextView) convertView.findViewById(R.id.tv_shop_building);
            viewHolder.tv_shop_phone= (TextView) convertView.findViewById(R.id.tv_shop_phone);
            viewHolder.tv_shop_otime= (TextView) convertView.findViewById(R.id.tv_shop_otime);
            viewHolder.tv_shop_ctime= (TextView) convertView.findViewById(R.id.tv_shop_ctime);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_shop_name.setText(result.get(position).getName());
        viewHolder.tv_dis_distance.setText(result.get(position).getDistance()+"米");
        viewHolder.tv_shop_building.setText(result.get(position).getBuilding());
        viewHolder.tv_shop_phone.setText(result.get(position).getContact1()+"");
        String openTime = result.get(position).getOpenTime();
        String[] op = openTime.split(" ");
        String op1 = op[1];
        String[] opt = op1.split(":");
       String opentiem= opt[0]+":"+opt[1];
        String closedTime = result.get(position).getClosedTime();
        String[] ct = closedTime.split(" ");
        String ct1 = ct[1];
        String[] close = ct1.split(":");
        String closetiem= close[0]+":"+close[1];
        viewHolder.tv_shop_otime.setText(opentiem);
        viewHolder.tv_shop_ctime.setText(closetiem);
        return convertView;
    }
    class ViewHolder{
        TextView tv_shop_name;
        TextView tv_dis_distance;
        TextView tv_shop_building;
        TextView tv_shop_phone;
        TextView tv_shop_otime;
        TextView tv_shop_ctime;

    }
}

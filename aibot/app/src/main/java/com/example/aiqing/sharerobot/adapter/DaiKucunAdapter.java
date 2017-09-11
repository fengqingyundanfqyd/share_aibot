package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DaiKucunBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/2.
 */

public class DaiKucunAdapter extends BaseAdapter {
    private final Context context;
    private final List<DaiKucunBean.ProListBean.ObjBean.ResultBean> result;


    public DaiKucunAdapter(Context context, List<DaiKucunBean.ProListBean.ObjBean.ResultBean> result) {
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
            convertView=View.inflate(context, R.layout.item_kucun,null);
            viewHolder = new ViewHolder();
//            viewHolder.tvRobot= ((TextView) convertView.findViewById(R.id.tv_robot));
//            viewHolder.tvId= ((TextView) convertView.findViewById(R.id.tv_id));
//            viewHolder.tvDate= ((TextView) convertView.findViewById(R.id.tv_date));
            viewHolder.tv_agent= ((TextView) convertView.findViewById(R.id.tv_agent));
            viewHolder.tv_agent_status= ((TextView) convertView.findViewById(R.id.tv_agent_status));
            viewHolder.tv_agent_yajin= ((TextView) convertView.findViewById(R.id.tv_agent_yajin));
            viewHolder.tv_agent_num= ((TextView) convertView.findViewById(R.id.tv_agent_num));
            viewHolder.tv_applysend_num= ((TextView) convertView.findViewById(R.id.tv_applysend_num));
            viewHolder.tv_shijisend_num= ((TextView) convertView.findViewById(R.id.tv_shijisend_num));
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        viewHolder.tvRobot.setText("小宝");
//        viewHolder.tvId.setText(result.get(position).getProductId());
//        viewHolder.tvDate.setText("2017-7-3");//服务器返回空
        viewHolder.tv_agent.setText(result.get(position).getName());
        String doStatus = result.get(position).getDoStatus();
        if (doStatus.equals("1")){
            viewHolder.tv_agent_status.setText("未完成第三方支付");
        }else if (doStatus.equals("2")){
            viewHolder.tv_agent_status.setText("待审核");
        }else if (doStatus.equals("3")){
            viewHolder.tv_agent_status.setText("待发货");
        }else if (doStatus.equals("4")){
            viewHolder.tv_agent_status.setText("交易关闭");
        }else if (doStatus.equals("5")){
            viewHolder.tv_agent_status.setText("待发货");
        }else if (doStatus.equals("6")){
            viewHolder.tv_agent_status.setText("待发货");
        }else if (doStatus.equals("7")){
            viewHolder.tv_agent_status.setText("交易关闭");
        }else if (doStatus.equals("8")){
            viewHolder.tv_agent_status.setText("交易成功");
        }else if (doStatus.equals("9")){
            viewHolder.tv_agent_status.setText("交易关闭");
        }else if (doStatus.equals("10")){
            viewHolder.tv_agent_status.setText("换货重新发货");
        }
        viewHolder.tv_agent_yajin.setText(result.get(position).getMoney()+"");
        viewHolder.tv_agent_num.setText("x"+result.get(position).getApplyNum()+"");
        viewHolder.tv_applysend_num.setText(result.get(position).getApplyNum()+"");
        viewHolder.tv_shijisend_num.setText(result.get(position).getFactNum()+"");

        return convertView;
    }
    private class ViewHolder {
//        TextView tvRobot;
//        TextView tvId;
//        TextView tvDate;
        TextView tv_agent;
        TextView tv_agent_status;
        TextView tv_agent_yajin;
        TextView tv_agent_num;
        TextView tv_applysend_num;
        TextView tv_shijisend_num;
    }
}

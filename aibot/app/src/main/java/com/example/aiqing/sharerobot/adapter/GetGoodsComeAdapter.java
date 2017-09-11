package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.GetGoodsYuanBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/4.
 */

public class GetGoodsComeAdapter extends BaseAdapter {


    private final Context context;
    private final List<GetGoodsYuanBean.ObjBean> been;

    public GetGoodsComeAdapter(Context context, List<GetGoodsYuanBean.ObjBean> been) {
        this.context=context;
        this.been=been;
    }

    @Override
    public int getCount() {
        return been.size();
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
            convertView=View.inflate(context, R.layout.item_getgoodscome,null);
            viewHolder.tv_getname= (TextView) convertView.findViewById(R.id.tv_getgoodsname);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_getname.setText(been.get(position).getCustName());
        return convertView;
    }
    private class ViewHolder{
        TextView tv_getname;

    }
}

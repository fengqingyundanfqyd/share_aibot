package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.ProblemBean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/6.
 */

public class ProblemAdapter extends BaseAdapter {
    private final Context context;
    private final List<ProblemBean.ObjBean> obj;

    public ProblemAdapter(Context context, List<ProblemBean.ObjBean> obj) {
        this.context=context;
        this.obj=obj;
    }

    @Override
    public int getCount() {
        return obj.size();
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
            convertView=View.inflate(context, R.layout.item_problem,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_empty= (ImageView) convertView.findViewById(R.id.iv_empty);
            viewHolder.tv_problem= (TextView) convertView.findViewById(R.id.tv_problem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        viewHolder.iv_header_log.setImageResource(R.mipmap.header);
        viewHolder.tv_problem.setText(obj.get(position).getName());

        return convertView;
    }
    class ViewHolder {
        ImageView iv_empty;
        TextView tv_problem;
    }
}

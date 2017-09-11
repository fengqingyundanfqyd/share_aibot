package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.UsersAddressBean;

import java.util.List;

/**
 * Created by aiqing on 2017/6/28.
 */

public class AddressAdapter extends BaseAdapter {
    private final Context context;
    private final String name;
    private final String number;
    private final String detaadd;
    private final List<UsersAddressBean.ObjBean.ResultBean> result;
    boolean isClick=false;

//    public AddressAdapter(Context context, String name, String number, String detaadd) {
//        this.context=context;
//        this.name=name;
//        this.number=number;
//        this.detaadd=detaadd;
//        Log.e("99999", "AddressAdapter: "+name );
//        Log.e("99999", "AddressAdapter: "+number );
//        Log.e("99999", "AddressAdapter: "+detaadd );
//    }

    public AddressAdapter(Context context, String name, String number, String detaadd, List<UsersAddressBean.ObjBean.ResultBean> result) {
        this.context=context;
        this.name=name;
        this.number=number;
        this.detaadd=detaadd;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView=View.inflate(context, R.layout.item_getaddress,null);
            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tv_gername);
            viewHolder.tvNumber= (TextView) convertView.findViewById(R.id.tv_getnum);
            viewHolder.tvDetaadd= (TextView) convertView.findViewById(R.id.tv_detaadd);
            viewHolder.iv_no= (ImageView) convertView.findViewById(R.id.iv_no);
            convertView.setTag(viewHolder);

        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(name);
        viewHolder.tvNumber.setText(number);
        viewHolder.tvDetaadd.setText(detaadd);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(context, "点击了"+(position+1), Toast.LENGTH_SHORT).show();
                isClick=!isClick;
                if (isClick){
                    viewHolder.iv_no.setVisibility(View.VISIBLE);
                  //  Toast.makeText(context, "正确", Toast.LENGTH_SHORT).show();
                }else {
                    viewHolder.iv_no.setVisibility(View.GONE);
                }


            }
        });
//        viewHolder.iv_no.setVisibility(View.VISIBLE);
        return convertView;
    }
    class ViewHolder{
        TextView tvName;
        TextView tvNumber;
        TextView tvDetaadd;
        ImageView iv_no;
    }
}

//package com.example.aiqing.sharerobot.adapter;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.aiqing.sharerobot.R;
//import com.example.aiqing.sharerobot.bean.UsersAddressBean;
//
//import java.util.List;
//
///**
// * Created by aiqing on 2017/6/28.
// */
//
//public class AddressAdapter extends BaseAdapter {
//    private final Context context;
////    private final String name;
////    private final String number;
////    private final String detaadd;
//    private final List<UsersAddressBean.ObjBean.ResultBean> result;
//    private final int selectPositon;
//    boolean isClick=false;
//
//
//
////    public AddressAdapter(Context context, String name, String number, String detaadd, List<UsersAddressBean.ObjBean.ResultBean> result) {
////        this.context=context;
////        this.name=name;
////        this.number=number;
////        this.detaadd=detaadd;
////        this.result=result;
////    }
//
//    public AddressAdapter(Context context, List<UsersAddressBean.ObjBean.ResultBean> result, int selectPositon) {
//        this.context=context;
//        this.result=result;
//        this.selectPositon=selectPositon;
//
//    }
//
//    @Override
//    public int getCount() {
//        return 4;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return result.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        final ViewHolder viewHolder;
//        if (convertView==null){
//            viewHolder = new ViewHolder();
//            convertView=View.inflate(context, R.layout.item_getaddress,null);
//            viewHolder.tvName= (TextView) convertView.findViewById(R.id.tv_gername);
//            viewHolder.tvNumber= (TextView) convertView.findViewById(R.id.tv_getnum);
//            viewHolder.tvDetaadd= (TextView) convertView.findViewById(R.id.tv_detaadd);
//            viewHolder.iv_no= (ImageView) convertView.findViewById(R.id.iv_no);
//            convertView.setTag(viewHolder);
//
//        }else {
//            viewHolder= (ViewHolder) convertView.getTag();
//        }
//        viewHolder.tvName.setText(result.get(position).getName());
//        viewHolder.tvNumber.setText(result.get(position).getMobile());
//        viewHolder.tvDetaadd.setText(result.get(position).getFAddress());
//
//        if (selectPositon==position){
//            convertView.setSelected(true);
//            viewHolder.iv_no.setVisibility(View.VISIBLE);
//        }else {
//            convertView.setSelected(false);
//            viewHolder.iv_no.setVisibility(View.GONE);
//        }
//
////        convertView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                isClick=!isClick;
////                if (isClick){
////                    viewHolder.iv_no.setVisibility(View.VISIBLE);
////                }else {
////                    viewHolder.iv_no.setVisibility(View.GONE);
////                }
////
////
////            }
////        });
//
//        return convertView;
//    }
//    class ViewHolder{
//        TextView tvName;
//        TextView tvNumber;
//        TextView tvDetaadd;
//        ImageView iv_no;
//    }
//}

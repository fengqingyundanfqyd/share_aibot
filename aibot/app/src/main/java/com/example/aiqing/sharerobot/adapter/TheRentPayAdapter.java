package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.RentPayBean;

import java.util.List;

/**
 * Created by aiqing on 2017/6/30.
 */

public class TheRentPayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final Context context;
    private final LayoutInflater mInflater;
    private final List<RentPayBean.FeeSetListBean> feeSetList;
    private ViewHolder mViewHolder;

    public TheRentPayAdapter(Context context, List<RentPayBean.FeeSetListBean> feeSetList) {
        this.context = context;
        this.feeSetList = feeSetList;
        mInflater = LayoutInflater.from(context);
    }
    private OnItemClickListener mOnItemClickListener = null;

    public  interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View arg0) {
            super(arg0);
        }

        TextView tv_aibot_user;
        TextView tv_user_month;
        TextView tv_month;
        TextView tv_money_user;
        TextView tv_rent_money;
        LinearLayout ll_yongjiu;
        LinearLayout ll_yue;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recyclerview, parent, false);

        mViewHolder = new ViewHolder(view);
        mViewHolder.tv_aibot_user = (TextView) view.findViewById(R.id.tv_aibot_user);
        mViewHolder.tv_user_month = (TextView) view.findViewById(R.id.tv_user_month);
        mViewHolder.tv_month = (TextView) view.findViewById(R.id.tv_month);
        mViewHolder.tv_money_user = (TextView) view.findViewById(R.id.tv_money_user);
        mViewHolder.tv_rent_money = (TextView) view.findViewById(R.id.tv_rent_money);
        mViewHolder.ll_yongjiu = (LinearLayout) view.findViewById(R.id.ll_yongjiu);
        mViewHolder.ll_yue = (LinearLayout) view.findViewById(R.id.ll_yue);

        view.setOnClickListener(this);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (Integer.parseInt(feeSetList.get(position).getType()) == 2) {
            mViewHolder.tv_aibot_user.setText("小宝使用权");
            mViewHolder.tv_user_month.setText(Integer.toString(feeSetList.get(position).getLength()));
            if (Integer.parseInt(feeSetList.get(position).getLengthUnit()) == 1) {
                mViewHolder.tv_month.setText(feeSetList.get(position).getLength());
                mViewHolder.tv_month.setText("周");
                mViewHolder.tv_money_user.setText("￥");
                mViewHolder.tv_rent_money.setText(feeSetList.get(position).getFee2());
            } else if (Integer.parseInt(feeSetList.get(position).getLengthUnit()) == 2) {
                mViewHolder.tv_month.setText(Integer.toString(feeSetList.get(position).getLength()));
                mViewHolder.tv_month.setText("月");
                mViewHolder.tv_money_user.setText("￥");
                mViewHolder.tv_rent_money.setText(feeSetList.get(position).getFee2());
            } else if (Integer.parseInt(feeSetList.get(position).getLengthUnit()) == 2) {
                mViewHolder.tv_month.setText(Integer.toString(feeSetList.get(position).getLength()));
                mViewHolder.tv_month.setText("年");
                mViewHolder.tv_money_user.setText("￥");
                mViewHolder.tv_rent_money.setText(feeSetList.get(position).getFee2());
            }

        } else if (Integer.parseInt(feeSetList.get(position).getType()) == 3) {
            mViewHolder.tv_aibot_user.setText("小宝使用权");
            mViewHolder.ll_yue.setVisibility(View.GONE);
            mViewHolder.ll_yongjiu.setVisibility(View.VISIBLE);
            mViewHolder.tv_money_user.setText("￥");
            mViewHolder.tv_rent_money.setText(feeSetList.get(position).getFee2());
        }
        holder.itemView.setTag(position);
    }
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public int getItemCount() {
        if (feeSetList.size()>0){
            return feeSetList.size();
        }else {
            return 5;
        }
        //return feeSetList.size()>0?feeSetList.size():5;
    }
}

package com.example.aiqing.sharerobot.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DaiOrderBean;
import com.example.aiqing.sharerobot.bean.SendGoodsBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aiqing on 2017/7/6.
 */

public class ApplySendAdapger extends BaseAdapter {
    private final Context context;
    private final List<DaiOrderBean.ProListBean.ResultBean> proList;

    public ApplySendAdapger(Context context, List<DaiOrderBean.ProListBean.ResultBean> proList) {
        this.context=context;
        this.proList=proList;
    }

    @Override
    public int getCount() {
        return proList.size();
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
        viewHolder.tv_shopname.setText(proList.get(position).getCustName());
        viewHolder.tv_shopaddress.setText(proList.get(position).getAddress());
        viewHolder.tv_shopnumber.setText(proList.get(position).getMobile()+"");
        viewHolder.tv_shopbossname.setText(proList.get(position).getName());
        viewHolder.tv_robotnumber.setText("台数");
        viewHolder.tv_robotmath.setText(proList.get(position).getApplyNum()+"");
        viewHolder.btn_suresend.setText("确认发货");
        viewHolder.btn_suresend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.btn_suresend.setBackgroundResource(R.mipmap.dissabled);
                initHttp(position);
                //TODO 刷新
            }
        });
        return convertView;
    }

    private void initHttp(int position) {
        SharedPreferences preferences = context.getSharedPreferences("COOKIE", MODE_PRIVATE);
      String  cookie = preferences.getString("mCookie", "");
        HttpTool httpTool = new HttpTool(context);

        String paId = proList.get(position).getPaId();
        SharedPreferences spDis = context.getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = spDis.getString("agencyId", "");

        final Retrofit builder = new Retrofit.Builder()
                .client(httpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/agencyConfirmReceipt.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<SendGoodsBean> call = apiService.sendGoods(cookie,paId,agencyId);
        call.enqueue(new Callback<SendGoodsBean>() {
            @Override
            public void onResponse(Response<SendGoodsBean> response, Retrofit retrofit) {
                Log.e("确认发货", "onResponse: "+response.body().isSuccess() );
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(context, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
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

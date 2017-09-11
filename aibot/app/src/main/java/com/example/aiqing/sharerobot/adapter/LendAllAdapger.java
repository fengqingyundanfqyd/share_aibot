package com.example.aiqing.sharerobot.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DisAllLendBean;
import com.example.aiqing.sharerobot.bean.PlatformSendBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by aiqing on 2017/9/11.
 */

public class LendAllAdapger extends BaseAdapter {
    private final Context context;
    private final List<DisAllLendBean.ObjBean.ResultBean> lendresult;
    private final HttpTool mHttpTool;
    private final String mCookie;
    private final String mDistributorid;

    public LendAllAdapger(Context context, List<DisAllLendBean.ObjBean.ResultBean> lendresult) {
        this.context = context;
        this.lendresult = lendresult;
        SharedPreferences sp = context.getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = sp.getString("distributorid", "");
        Log.e("投放商id", "sendGoodHttp: "+ mDistributorid);
        mHttpTool = new HttpTool(context);
        SharedPreferences preferences = context.getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
    }

    @Override
    public int getCount() {
        return lendresult.size();
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_all, null);
            viewHolder = new ViewHolder();
            viewHolder.tv_num_all = (TextView) convertView.findViewById(R.id.tv_num_all);
            viewHolder.tv_product_name = (TextView) convertView.findViewById(R.id.tv_product_name);
            viewHolder.tv_all_status = (TextView) convertView.findViewById(R.id.tv_all_status);
            viewHolder.tv_time_all = (TextView) convertView.findViewById(R.id.tv_time_all);
            viewHolder.tv_send_style = (TextView) convertView.findViewById(R.id.tv_send_style);
            viewHolder.tv_all_address = (TextView) convertView.findViewById(R.id.tv_all_address);
            viewHolder.tv_all_phone = (TextView) convertView.findViewById(R.id.tv_all_phone);
            viewHolder.tv_all_name = (TextView) convertView.findViewById(R.id.tv_all_name);
            viewHolder.tv_direct_send = (TextView) convertView.findViewById(R.id.tv_direct_send);
            viewHolder.tv_platform_send = (TextView) convertView.findViewById(R.id.tv_platform_send);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        int factNum = lendresult.get(position).getFactNum();
        viewHolder.tv_num_all.setText(factNum + "");
        viewHolder.tv_product_name.setText(lendresult.get(position).getPtypeName());

        String status = lendresult.get(position).getStatus();

        viewHolder.tv_all_status.setText(status + "");
        viewHolder.tv_time_all.setText(lendresult.get(position).getCreateTime2() + "");

        String bdealType = lendresult.get(position).getBdealType();
        if (bdealType.equals("0")) {
            viewHolder.tv_send_style.setText("未选择发货方式");
        } else if (bdealType.equals("1")) {
            if (status.equals("待发货")) {
                viewHolder.tv_send_style.setText("等待平台发货");
            } else if (status.equals("已发货")) {
                viewHolder.tv_send_style.setText("平台代为发货");
            }
        } else if (bdealType.equals("2")) {
            if (status.equals("已发货")) {
                viewHolder.tv_send_style.setText("商家直接发货");
            } else if (status.equals("部分发货")) {
                int sendNum = lendresult.get(position).getSendNum();
                int hai = factNum - sendNum;
                viewHolder.tv_send_style.setText("已发货" + sendNum + "台，还有" + hai + "几台");
            }
        }


        viewHolder.tv_all_address.setText(lendresult.get(position).getAddress());
        viewHolder.tv_all_phone.setText(lendresult.get(position).getMobile()+"");
        viewHolder.tv_all_name.setText(lendresult.get(position).getName());



        viewHolder.tv_platform_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendGoodHttp(position);
            }
        });
        viewHolder.tv_direct_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 扫苗二维码
            }
        });

        return convertView;
    }
    //平台申请
    private void sendGoodHttp(int position) {

        String paId = lendresult.get(position).getPaId();
        int factNum = lendresult.get(position).getFactNum();
        String fact = String.valueOf(factNum);
        String ptypeId = lendresult.get(position).getPtypeId();

        final Dialog loadingDialog = DialogUtil.createLoadingDialog(context, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/appFormDelivery.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<PlatformSendBean> call = apiService.platformSend(mCookie, paId, fact, mDistributorid, ptypeId);
        call.enqueue(new Callback<PlatformSendBean>() {
            @Override
            public void onResponse(Response<PlatformSendBean> response, Retrofit retrofit) {
                String coder = response.body().getCoder();
                Log.e("平台申请发货", "onResponse: "+coder );

                DialogUtil.closeDialog(loadingDialog);
                //if (coder!=null){
                    if (coder.equals("0000")){
                        Toast.makeText(context, "申请发货成功。", Toast.LENGTH_SHORT).show();
                    }else if (coder.equals("10000")){
                        Toast.makeText(context, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    }
               // }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(context, "网络出错，请检查网络", Toast.LENGTH_SHORT).show();
                DialogUtil.closeDialog(loadingDialog);
            }
        });
    }

    class ViewHolder {

        TextView tv_num_all;
        TextView tv_product_name;
        TextView tv_all_status;
        TextView tv_time_all;
        TextView tv_send_style;
        TextView tv_all_address;
        TextView tv_all_phone;
        TextView tv_all_name;
        TextView tv_direct_send;
        TextView tv_platform_send;
    }
}

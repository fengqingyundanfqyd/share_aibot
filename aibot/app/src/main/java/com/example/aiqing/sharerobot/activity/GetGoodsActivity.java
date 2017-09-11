package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.GetGoodsComeAdapter;
import com.example.aiqing.sharerobot.bean.DistributorGetGoodsBean;
import com.example.aiqing.sharerobot.bean.GetGoodsYuanBean;
import com.example.aiqing.sharerobot.bean.UploadImaBean;
import com.example.aiqing.sharerobot.fragment.LowmenuFragment;
import com.example.aiqing.sharerobot.fragment.MenuItemOnClickListener;
import com.example.aiqing.sharerobot.fragment.MenuItems;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.PictureUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 投放商   我要进货 25-4
 */
public class GetGoodsActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mRlPayforstyle;
    private RelativeLayout mRlUploadpinz;
    private String mStrnew;
    private String mCookie;
    private ImageView mIvPrint;
    private static final int SCALE = 1;//照片缩小比例
    private ImageView mIvLess;
    private ImageView mIvAdd;
    private int num = 1;
    private TextView mTvGetNum;
    private int PHOTO_REQUEST_GALLERY = 0;
    private Dialog mLoadingDialog;
    private TextView mTvPay;
    private Bitmap mBitmap;
    private HttpTool mHttpTool;
    private String mDistributorid;
    private ListView mLvAgenceder;
    private String mAgencyId;
    private String mAddressId;
    private Dialog mDialog;
    private TextView mTvCustName;
    private TextView mTvName;
    private TextView mTvPhone;
    private TextView mTvAdd;
    private RelativeLayout mRlAddress;
    private LinearLayout mLlAddress;
    private String mObj;
    private String mObjNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_get_goods);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("我要进货");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initFindId();
        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorid = spDis.getString("distributorid", "");
        Log.e("mDistributorid", "onCreate: " + mDistributorid);

        // initData();


    }


    /**
     * bitmap转为base64
     *
     * @param bitmap
     * @return
     */
    public static String bitmapToBase64(Bitmap bitmap) {

        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = "data:image/png;base64," + Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    private void initFindId() {
        //   RelativeLayout rLAddaddresstop = (RelativeLayout) findViewById(R.id.rL_addaddresstop);
        RelativeLayout rLRobottype = (RelativeLayout) findViewById(R.id.rL_robottype);
        RelativeLayout rlGoodscomes = (RelativeLayout) findViewById(R.id.rl_goodscomes);
        mRlPayforstyle = (RelativeLayout) findViewById(R.id.rl_payforstyle);
        EditText etGoodsNum = (EditText) findViewById(R.id.et_goodsnum);
        EditText etBeizhu = (EditText) findViewById(R.id.et_beizhu);
        Button btnApplynow = (Button) findViewById(R.id.btn_applynow);
        mRlUploadpinz = (RelativeLayout) findViewById(R.id.rl_upload_pinz);
        mIvPrint = (ImageView) findViewById(R.id.iv_print);
        mIvLess = (ImageView) findViewById(R.id.iv_lessgoods);
        mIvAdd = (ImageView) findViewById(R.id.iv_addgoods);
        mTvGetNum = (TextView) findViewById(R.id.tv_getgoodsnum);
        mTvPay = (TextView) findViewById(R.id.tv_pay);
        mRlAddress = (RelativeLayout) findViewById(R.id.rl_address);
        mTvCustName = (TextView) findViewById(R.id.tv_custname);
        mTvName = (TextView) findViewById(R.id.tv_name_getgoods);
        mTvPhone = (TextView) findViewById(R.id.tv_phone_getoods);
        mTvAdd = (TextView) findViewById(R.id.tv_address_getgoods);
        mLlAddress = (LinearLayout) findViewById(R.id.ll_address);

        mRlPayforstyle.setOnClickListener(this);
        btnApplynow.setOnClickListener(this);
        mIvPrint.setOnClickListener(this);
        mIvLess.setOnClickListener(this);
        mIvAdd.setOnClickListener(this);
        btnApplynow.setOnClickListener(this);
        rlGoodscomes.setOnClickListener(this);
        mRlAddress.setOnClickListener(this);
    }

    private void initData() {
        // mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        if (mTvPay.getText().toString().equals("余额支付")) {
            getGoods();
        } else if (mTvPay.getText().toString().equals("线下支付")) {

            String base64 = bitmapToBase64(mBitmap);
            Log.e("base64", "initData: " + base64);

            Retrofit builder = new Retrofit.Builder()
                    .client(mHttpTool.client())
                    .baseUrl("https://shared.aqcome.com/image/uploadImageBase64.shtml")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService apiService = builder.create(ApiService.class);
            Call<UploadImaBean> call = apiService.uploadpic(mCookie, base64);
            call.enqueue(new Callback<UploadImaBean>() {
                @Override
                public void onResponse(Response<UploadImaBean> response, Retrofit retrofit) {
                    //  DialogUtil.closeDialog(mLoadingDialog);
                    if (response.body() != null) {
                        //路径
                        mObj = response.body().getObj();
                        getGoods();
                        Log.e("上传图片路径", "onResponse: " + mObj);
                    } else {
                        return;
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    DialogUtil.closeDialog(mLoadingDialog);
                    Toast.makeText(GetGoodsActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                    Log.e("失败", "失败" + t.getMessage());
                }
            });
        }
    }

    //立即申请
    private void getGoods() {
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/saveDistributorApply.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DistributorGetGoodsBean> call = apiService.applygetGoods(mCookie, mAgencyId, mDistributorid, mTvGetNum.getText().toString(), mTvPay.getText().toString(), "1", mAddressId, mObjNew);
        call.enqueue(new Callback<DistributorGetGoodsBean>() {
            @Override
            public void onResponse(Response<DistributorGetGoodsBean> response, Retrofit retrofit) {
                String coder = response.body().getCoder();
                Log.e("coder", "onResponse: " + coder);
                if (coder.equals("0000")) {
                    Toast.makeText(GetGoodsActivity.this, "申请进货成功。", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(GetGoodsActivity.this, ApplySuccessActivity.class);
                    startActivity(intent);
                    GetGoodsActivity.this.finish();
                } else {
                    Toast.makeText(GetGoodsActivity.this, response.body().getErrorMsg().toString(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(GetGoodsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //支付方式  底部弹出选择框
            case R.id.rl_payforstyle:
                LowmenuFragment lowmenuFragment = new LowmenuFragment();
                List<MenuItems> itemList = new ArrayList<>();

                MenuItems menuItems1 = new MenuItems();
                menuItems1.setText("余额支付");
                MenuItems menuItems2 = new MenuItems();
                menuItems2.setText("线下打款");

                menuItems1.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Toast.makeText(GetGoodsActivity.this, "余额支付", Toast.LENGTH_SHORT).show();
                        mTvPay.setText("余额支付");
                        mRlUploadpinz.setVisibility(View.GONE);
                        mObj = "";
                    }
                });
                menuItems2.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems2) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Toast.makeText(GetGoodsActivity.this, "线下打款", Toast.LENGTH_SHORT).show();
                        mTvPay.setText("线下打款");
                        mRlUploadpinz.setVisibility(View.VISIBLE);
                        mObjNew = mObj;
                    }
                });
                itemList.add(menuItems1);
                itemList.add(menuItems2);
                lowmenuFragment.setMenuItemses(itemList);
                lowmenuFragment.show(getFragmentManager(), "LowmenuFragment");
                break;
            case R.id.btn_applynow:
                //立即申请
                initData();

                break;
            case R.id.iv_print:
                //打印凭证  相册
                Intent albumIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(albumIntent, PHOTO_REQUEST_GALLERY);
                break;
            case R.id.iv_lessgoods:
                //减
                num -= 1;
                if (num <= 0) {
                    num = 1;
                }
                mTvGetNum.setText(num + "");
                break;
            case R.id.iv_addgoods:
                //加
                num += 1;
                mTvGetNum.setText(num + "");
                break;
            case R.id.rl_goodscomes:
                //进货源
                showDialog();
                break;
            case R.id.rl_address:
                Intent intent = new Intent();
                intent.setClass(GetGoodsActivity.this, MyAddressActivity.class);
                startActivityForResult(intent, 4);
                break;

        }
    }

    private void showDialog() {
        mDialog = new Dialog(GetGoodsActivity.this);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(R.layout.item_getgoods);
        Window dialogWindow = mDialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);

        lp.y = 0; // 新位置Y坐标
        lp.width = 960; // 宽度
        lp.height = 400; // 高度
        dialogWindow.setAttributes(lp);

        getGoodsComeHttp();
        mLvAgenceder = (ListView) mDialog.findViewById(R.id.listview_getgoods);


        mDialog.show();
    }

    private void getGoodsComeHttp() {
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/disributorPurchase.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<GetGoodsYuanBean> call = apiService.getGoods(mCookie, mDistributorid);
        call.enqueue(new Callback<GetGoodsYuanBean>() {
            @Override
            public void onResponse(Response<GetGoodsYuanBean> response, Retrofit retrofit) {
                final List<GetGoodsYuanBean.ObjBean> been = response.body().getObj();
                GetGoodsComeAdapter adapter = new GetGoodsComeAdapter(GetGoodsActivity.this, been);
                mLvAgenceder.setAdapter(adapter);
                mLvAgenceder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        mAgencyId = been.get(position).getAgencyId();
                        Log.e("agencyId", "onItemClick: " + mAgencyId);
                        String custName = been.get(position).getCustName();
                        mTvCustName.setText(custName);
                        mDialog.dismiss();
                    }
                });
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PHOTO_REQUEST_GALLERY) {

                Uri uri = data.getData();
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));

                    mIvPrint.setImageBitmap(PictureUtil.getSmallBitmap(path, 480, 800));
                    mBitmap = PictureUtil.getSmallBitmap(path, 20, 20);

                }


//                Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
//                Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
//                //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
//                bitmap.recycle();
//
//                //将处理过的图片显示在界面上，并保存到本地
//                mIvPrint.setImageBitmap(newBitmap);
//                ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));

            }
        } else if (requestCode == 4) {
            mRlAddress.setVisibility(View.GONE);
            mLlAddress.setVisibility(View.VISIBLE);
            Bundle bundle = data.getExtras();
            mAddressId = bundle.getString("mAddressId");
            String name = bundle.getString("name");
            String mobile = bundle.getString("mobile");
            String add = bundle.getString("add");
            mTvName.setText(name);
            mTvPhone.setText(mobile + "");
            mTvAdd.setText(add);
        }
    }
}

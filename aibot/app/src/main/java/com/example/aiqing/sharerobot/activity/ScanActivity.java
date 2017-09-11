package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.DiaTouInitBean;
import com.example.aiqing.sharerobot.bean.ScanRentBean;
import com.example.aiqing.sharerobot.bean.TouInitRobotBean;
import com.example.aiqing.sharerobot.bean.daiInitRobotBean;
import com.example.aiqing.sharerobot.bean.scanAgencyBean;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;

public class ScanActivity extends AppCompatActivity implements QRCodeView.Delegate, View.OnClickListener {

    private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;
    private QRCodeView mQRCodeView;
    private String mSid;
    private HttpTool mHttpTool;
    private LinearLayout mLlScanandscan;
    private LinearLayout mLlDailishangScan;
    private LinearLayout mLloufangcan;
    private LinearLayout mLlDaiAndTou;
    private ImageView mIvScanW;
    private ImageView mIvScanA;
    private ImageView mIvScanB;
    private ImageView mIvScanAB;
    private boolean isScan = false;
    private boolean isDaiScan = false;
    private boolean isTouScan = false;
    private boolean isDaiTouScan = false;
    private String mAgencyid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        mQRCodeView = (ZXingView) findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);

        SharedPreferences spcookie = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mSid = spcookie.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

        initId();
    }

    private void initId() {
        mLlScanandscan = (LinearLayout) findViewById(R.id.ll_scanandscan);

        mLlDailishangScan = (LinearLayout) findViewById(R.id.ll_dailishang_scan);
        mLloufangcan = (LinearLayout) findViewById(R.id.ll_toufang_scan);
        mLlDaiAndTou = (LinearLayout) findViewById(R.id.ll_daiandtou_scan);
        mIvScanW = (ImageView) findViewById(R.id.iv_icon_scan_w);
        mIvScanA = (ImageView) findViewById(R.id.iv_a_o);
        mIvScanB = (ImageView) findViewById(R.id.iv_b_o);
        mIvScanAB = (ImageView) findViewById(R.id.iv_ab_o);
        Button btnOpenPic = (Button) findViewById(R.id.btn_openpic);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_return_erwema);
        LinearLayout llAllScan = (LinearLayout) findViewById(R.id.ll_all_scan);

        Log.e("555555", "initId: " + getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", ""));
        //既不是投放商也不是代理商
        if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            llAllScan.setVisibility(View.GONE);
            mQRCodeView.startSpot();
            isScan = true;
        } else if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "") != null && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "") != null) {
            mLlScanandscan.setVisibility(View.VISIBLE);
            mLlDailishangScan.setVisibility(View.VISIBLE);
            mLloufangcan.setVisibility(View.VISIBLE);
            mLlDaiAndTou.setVisibility(View.VISIBLE);
        } else if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "") != null && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "").equals("")) {
            mLlScanandscan.setVisibility(View.VISIBLE);
            mLlDailishangScan.setVisibility(View.GONE);
            mLloufangcan.setVisibility(View.VISIBLE);
            mLlDaiAndTou.setVisibility(View.GONE);
        } else if (getSharedPreferences("DATA", MODE_PRIVATE).getString("distributorid", "").equals("") && getSharedPreferences("DATA", MODE_PRIVATE).getString("agencyId", "") != null) {
            mLlScanandscan.setVisibility(View.VISIBLE);
            mLlDailishangScan.setVisibility(View.VISIBLE);
            mLloufangcan.setVisibility(View.GONE);
            mLlDaiAndTou.setVisibility(View.GONE);
        }

        mLlScanandscan.setOnClickListener(this);
        mLlDaiAndTou.setOnClickListener(this);
        mLlDailishangScan.setOnClickListener(this);
        mLloufangcan.setOnClickListener(this);
        btnOpenPic.setOnClickListener(this);
        ivReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_scanandscan:
                isScan = true;
                isDaiScan = false;
                isTouScan = false;
                isDaiTouScan = false;
                mQRCodeView.startSpot();
                mIvScanW.setImageResource(R.mipmap.icon_scan);
                mIvScanAB.setImageResource(R.mipmap.ab);
                mIvScanB.setImageResource(R.mipmap.b);
                mIvScanA.setImageResource(R.mipmap.a);
                break;
            case R.id.ll_dailishang_scan:
                isDaiScan = true;
                isScan = false;
                isTouScan = false;
                isDaiTouScan = false;
                //代理商
                mQRCodeView.startSpot();
                mIvScanB.setImageResource(R.mipmap.b);
                mIvScanA.setImageResource(R.mipmap.a_o);
                mIvScanW.setImageResource(R.mipmap.icon_scan_w);
                mIvScanAB.setImageResource(R.mipmap.ab);
                break;
            case R.id.ll_toufang_scan:
                isTouScan = true;
                isScan = false;
                isDaiScan = false;
                isDaiTouScan = false;
                //投放商
                mQRCodeView.startSpot();
                mIvScanB.setImageResource(R.mipmap.b_o);
                mIvScanW.setImageResource(R.mipmap.icon_scan_w);
                mIvScanA.setImageResource(R.mipmap.a);
                mIvScanAB.setImageResource(R.mipmap.ab);
                break;
            case R.id.ll_daiandtou_scan:
                isDaiTouScan = true;
                isScan = false;
                isDaiScan = false;
                isTouScan = false;
                //待投
                mQRCodeView.startSpot();
                mIvScanAB.setImageResource(R.mipmap.ab_o);
                mIvScanB.setImageResource(R.mipmap.b);
                mIvScanW.setImageResource(R.mipmap.icon_scan_w);
                mIvScanA.setImageResource(R.mipmap.a);
                break;
            case R.id.btn_openpic:
                //打开相册
//                Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
//                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                startActivityForResult(albumIntent, PHOTO_REQUEST_GALLERY);
               // startActivityForResult(BGAPhotoPickerActivity.newIntent(this, null, 1, null, false), REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY);
                break;
            case R.id.iv_return_erwema:
                finish();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
      //  Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        if (isScan) {
            //扫一扫
            initScan(result);
        } else if (isTouScan) {
            //投放商扫一扫初始化小宝
            initTou(result);
        } else if (isDaiTouScan) {
            //代理商和投放商初始化小宝
            initDaiAndTou(result);
        } else if (isDaiScan) {
            //代理商扫一扫初始化小宝
            initDai(result);
        }
        vibrate();
        mQRCodeView.startSpot();
    }

    //代理商扫一扫初始化小宝扫一扫
    private void initDai(String result) {
        if (result.contains("shared.aqcome.com")) {
            String[] split = result.split("\\?");
            String str = split[split.length - 1];
            String[] split1 = str.split("=");
            String s = split1[0];
            String productId = split1[1];
            if (s.equals("p")) {
                agenceScan(productId);
            } else {
                Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //代理商初始化小宝
    private void agenceScan(String productId) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/addProduct.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<daiInitRobotBean> call = apiService.daiInitRobot(mSid, "1", productId);
        call.enqueue(new Callback<daiInitRobotBean>() {
            @Override
            public void onResponse(Response<daiInitRobotBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                Log.e("代理商初始化信息", "onResponse: " + response.body().getCoder());
                if (response.body().getCoder().equals("0000")) {
                    Toast.makeText(ScanActivity.this, "初始化成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScanActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ScanActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //代理商和投放商初始化小宝
    private void initDaiAndTou(String result) {
        if (result.contains("shared.aqcome.com")) {
            String[] split = result.split("\\?");
            String str = split[split.length - 1];
            String[] split1 = str.split("=");
            String s = split1[0];
            String product = split1[1];
            if (s.equals("p")) {
                daiAndTouScan(product);
            } else {
                Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //代理商和投放商初始化小宝
    private void daiAndTouScan(String product) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/addProductRec.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<DiaTouInitBean> call = apiService.daiAndTouInitRobot(mSid, "1", product);
        call.enqueue(new Callback<DiaTouInitBean>() {
            @Override
            public void onResponse(Response<DiaTouInitBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    Toast.makeText(ScanActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScanActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ScanActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //投放商扫一扫初始化小宝
    private void initTou(String result) {
        if (result.contains("shared.aqcome.com")) {
            String[] split = result.split("\\?");
            String str = split[split.length - 1];
            String[] split1 = str.split("=");
            String s = split1[0];
            String distributor = split1[1];
            if (s.equals("p")) {
                distributorScan(distributor);
            } else {
                Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //投放商初始化小宝
    private void distributorScan(String distributor) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/distributor/addProduct.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<TouInitRobotBean> call = apiService.touInitRobot(mSid, "1", distributor);
        call.enqueue(new Callback<TouInitRobotBean>() {
            @Override
            public void onResponse(Response<TouInitRobotBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    Toast.makeText(ScanActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ScanActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ScanActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //扫一扫
    private void initScan(String result) {
        if (result.contains("shared.aqcome.com")) {
            String[] split = result.split("\\?");
            String str = split[split.length - 1];
            String[] split1 = str.split("=");
            String s = split1[0];
            String s1 = split1[1];

            if (s.equals("c")) {
                //扫用户码
                //   initHttp(s1);
            } else if (s.equals("a")) {
                //代理商码  判断自己是否是投放商，如果不是，则跳到申请加盟界面
                //扫代理商码  截取"="后面的agencyId
                String[] agency = result.split("=");
                mAgencyid = agency[1];

                scanAgence(mAgencyid);

            } else if (s.equals("d")) {
                //投放商码   跳转到商家详情页面
                //initHttpTou(s1);
                Intent intent = new Intent(ScanActivity.this, BusinessInfoActivity.class);
                startActivity(intent);
            } else if (s.equals("p")) {
                //租用码
                String[] product = result.split("=");
                String productId = product[1];
                applyNum(productId);
            }
        } else {
            Toast.makeText(this, "无效二维码", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //扫租用码
    private void applyNum(final String productId) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/pay/scanCProdCode.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<ScanRentBean> call = apiService.scanRentNum(mSid, productId);
        call.enqueue(new Callback<ScanRentBean>() {
            @Override
            public void onResponse(Response<ScanRentBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                Log.e("机器人码", "onResponse: " + response.body().getCoder());

                String mDistributorId = response.body().getDistributorId();

                if (response.body().getCoder().equals("0000")) {
                    if (response.body().getPage().equals("1")||response.body().getPage().equals("2")) {
                        //B2C押金支付页面
                        Intent intent = new Intent(ScanActivity.this, ApplyRentActivity.class);
                        intent.putExtra("mDistributorId",mDistributorId);
                        startActivity(intent);
                    } else if (response.body().getPage().equals("3")) {
                        //租金支付页面
                        Intent intent = new Intent(ScanActivity.this, TheRentPayActivity.class);
                        intent.putExtra("productId",productId);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(ScanActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ScanActivity.this, "请检查网络！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //扫代理商码
    private void scanAgence(String agencyid) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/scanAgency.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);

        Call<scanAgencyBean> call = apiService.scanAgency(mSid, agencyid);
        call.enqueue(new Callback<scanAgencyBean>() {
            @Override
            public void onResponse(Response<scanAgencyBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    if (response.body().getObj() == 0) {
                        // 返回0 说明自己不是投放商，需要跳转到 投放商申请页面
                        Intent intent = new Intent(ScanActivity.this, TojoininApplyActivity.class);
                        intent.putExtra("agencyid", mAgencyid);
                        startActivity(intent);
                    } else if (response.body().getObj() == 1) {
                        Toast.makeText(ScanActivity.this, "绑定成功！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(ScanActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ScanActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        mQRCodeView.showScanRect();
//
//        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY) {
//            final String picturePath = BGAPhotoPickerActivity.getSelectedImages(data).get(0);
//
//            /*
//            这里为了偷懒，就没有处理匿名 AsyncTask 内部类导致 Activity 泄漏的问题
//            请开发在使用时自行处理匿名内部类导致Activity内存泄漏的问题，处理方式可参考 https://github.com/GeniusVJR/LearningNotes/blob/master/Part1/Android/Android%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E6%80%BB%E7%BB%93.md
//             */
//            new AsyncTask<Void, Void, String>() {
//                @Override
//                protected String doInBackground(Void... params) {
//                    return QRCodeDecoder.syncDecodeQRCode(picturePath);
//                }
//
//                @Override
//                protected void onPostExecute(String result) {
//                    if (TextUtils.isEmpty(result)) {
//                        Toast.makeText(ScanActivity.this, "未发现二维码", Toast.LENGTH_SHORT).show();
//                    } else {
//                        if (isScan) {
//                            //扫一扫
//                            initScan(result);
//                        } else if (isTouScan) {
//                            //投放商扫一扫初始化小宝
//                            initTou(result);
//                        } else if (isDaiTouScan) {
//                            //代理商和投放商初始化小宝
//                            initDaiAndTou(result);
//                        } else if (isDaiScan) {
//                            //代理商扫一扫初始化小宝
//                            initDai(result);
//                        }
//                        Toast.makeText(ScanActivity.this, result, Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }.execute();
//        }
//    }


}

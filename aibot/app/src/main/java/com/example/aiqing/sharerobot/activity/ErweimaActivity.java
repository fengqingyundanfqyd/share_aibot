package com.example.aiqing.sharerobot.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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

import java.nio.ByteBuffer;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by aiqing on 2017/6/28.
 * <p>
 * 扫面二维码界面
 */

public class ErweimaActivity extends AppCompatActivity implements QRCodeView.Delegate, View.OnClickListener {
    private static final String TAG = ErweimaActivity.class.getSimpleName();
    private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;
    private static final int PHOTO_REQUEST_GALLERY = 2;

    private QRCodeView mQRCodeView;
    private ImageView mIvScanW;
    private ImageView mIvScanA;
    private ImageView mIvScanB;
    private ImageView mIvScanAB;
    private String mSid;
    private LinearLayout mLlScanandscan;
    private LinearLayout mLlDailishangScan;
    private LinearLayout mLloufangcan;
    private LinearLayout mLlDaiAndTou;
    private boolean isScan = false;
    private boolean isDaiScan = false;
    private boolean isTouScan = false;
    private boolean isDaiTouScan = false;
    private HttpTool mHttpTool;
    private String mAgencyid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erwema);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mQRCodeView = (ZBarView) findViewById(R.id.zbarview);
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
                Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
                albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(albumIntent, PHOTO_REQUEST_GALLERY);
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
        //        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

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

    //扫描结果
    @Override
    public void onScanQRCodeSuccess(String result) {
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
                    Toast.makeText(ErweimaActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ErweimaActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ErweimaActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(ErweimaActivity.this, "初始化成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ErweimaActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ErweimaActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
            }
        });
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
                    Toast.makeText(ErweimaActivity.this, "初始化成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ErweimaActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ErweimaActivity.this, "请检查您的网络", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(ErweimaActivity.this, BusinessInfoActivity.class);
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
    private void applyNum(String productId) {
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
                if (response.body().getCoder().equals("0000")) {
                    if (response.body().getPage().equals("1")) {
                        //B2C押金支付页面
                        Intent intent = new Intent(ErweimaActivity.this, ApplyRentActivity.class);
                        startActivity(intent);
                    } else if (response.body().getPage().equals("2")) {
                        //C2C押金支付页面
                        Intent intent = new Intent(ErweimaActivity.this, ApplyRentActivity.class);
                        startActivity(intent);
                    } else if (response.body().getPage().equals("3")) {
                        //租金支付页面
                        Intent intent = new Intent(ErweimaActivity.this, TheRentPayActivity.class);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(ErweimaActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ErweimaActivity.this, "请检查网络！", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //扫代理商码
    private void scanAgence(String agencyId) {
        final Dialog loadingDialog = DialogUtil.createLoadingDialog(this, "识别中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/agency/scanAgency.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);

        Call<scanAgencyBean> call = apiService.scanAgency(mSid, agencyId);
        call.enqueue(new Callback<scanAgencyBean>() {
            @Override
            public void onResponse(Response<scanAgencyBean> response, Retrofit retrofit) {
                DialogUtil.closeDialog(loadingDialog);
                if (response.body().getCoder().equals("0000")) {
                    if (response.body().getObj() == 0) {
                        // 返回0 说明自己不是投放商，需要跳转到 投放商申请页面
                        Intent intent = new Intent(ErweimaActivity.this, TojoininApplyActivity.class);
                        intent.putExtra("agencyid", mAgencyid);
                        startActivity(intent);
                    } else if (response.body().getObj() == 1) {
                        Toast.makeText(ErweimaActivity.this, "绑定成功！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(ErweimaActivity.this, response.body().getErrorMsg(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(ErweimaActivity.this, "请检查网络连接", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.start_spot:
//                mQRCodeView.startSpot();
//                break;
//            case R.id.stop_spot:
//                mQRCodeView.stopSpot();
//                break;
//            case R.id.start_spot_showrect:
//                mQRCodeView.startSpotAndShowRect();
//                break;
//            case R.id.stop_spot_hiddenrect:
//                mQRCodeView.stopSpotAndHiddenRect();
//                break;
//            case R.id.show_rect:
//                mQRCodeView.showScanRect();
//                break;
//            case R.id.hidden_rect:
//                mQRCodeView.hiddenScanRect();
//                break;
//            case R.id.start_preview:
//                mQRCodeView.startCamera();
//                break;
//            case R.id.stop_preview:
//                mQRCodeView.stopCamera();
//                break;
//            case R.id.open_flashlight:
//                mQRCodeView.openFlashlight();
//                break;
//            case R.id.close_flashlight:
//                mQRCodeView.closeFlashlight();
//                break;
//            case R.id.scan_barcode:
//                mQRCodeView.changeToScanBarcodeStyle();
//                break;
//            case R.id.scan_qrcode:
//                mQRCodeView.changeToScanQRCodeStyle();
//                break;
//            case R.id.choose_qrcde_from_gallery:
                            /*
117                 从相册选取二维码图片，这里为了方便演示，使用的是
118                 https://github.com/bingoogolapple/BGAPhotoPicker-Android
119                 这个库来从图库中选择二维码图片，这个库不是必须的，你也可以通过自己的方式从图库中选择图片
120                  */

    // 识别图片中的二维码还有问题，占时不要用
    //                startActivityForResult(BGAPhotoPickerActivity.newIntent(this, null, 1, null, false), REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY);
//                break;
//        }
//    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        // 识别图片中的二维码还有问题，占时不要用
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY) {
            //final String picturePath = BGAPhotoPickerActivity.getSelectedImages(data).get(0);
            int[] icons = {R.mipmap.phone, R.mipmap.now, R.mipmap.add, R.mipmap.address};
            final String iconpath = String.valueOf(icons);

                    /*
138             这里为了偷懒，就没有处理匿名 AsyncTask 内部类导致 Activity 泄漏的问题
139             请开发在使用时自行处理匿名内部类导致Activity内存泄漏的问题，处理方式可参考 https://github.com/GeniusVJR/LearningNotes/blob/master/Part1/Android/Android%E5%86%85%E5%AD%98%E6%B3%84%E6%BC%8F%E6%80%BB%E7%BB%93.md
140              */
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {
                    Bitmap bitmap = getDecodeAbleBitmap(iconpath);
                    int picw = bitmap.getWidth();
                    int pich = bitmap.getHeight();
                    int[] pix = new int[picw * pich];
                    byte[] pixytes = new byte[picw * pich];
                    bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich);
                    int R, G, B, Y;
                    for (int y = 0; y < pich; y++) {
                        for (int x = 0; x < picw; x++) {
                            int index = y * picw + x;
                            R = (pix[index] >> 16) & 0xff;     //bitwise shifting
                            G = (pix[index] >> 8) & 0xff;
                            B = pix[index] & 0xff;
                            pixytes[index] = (byte) (0xff000000 | (R << 16) | (G << 8) | B);
                        }
                    }
                    ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
                    byte[] data = new byte[(int) (bitmap.getHeight() * bitmap.getWidth() * 1.5)];
                    rgba2Yuv420(pixytes, data, bitmap.getWidth(), bitmap.getHeight());
                    return mQRCodeView.processData(data, bitmap.getWidth(), bitmap.getHeight(), true);
                }

                @Override
                protected void onPostExecute(String result) {
                    if (TextUtils.isEmpty(result)) {
                        Toast.makeText(ErweimaActivity.this, "未发现二维码", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ErweimaActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                }
            }.execute();
        }
    }

    /**
     * 将本地图片文件转换成可解码二维码的 Bitmap。为了避免图片太大，这里对图片进行了压缩。感谢 https://github.com/devilsen 提的 PR
     *
     * @param picturePath 本地图片文件路径
     * @return
     */
    private static Bitmap getDecodeAbleBitmap(String picturePath) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(picturePath, options);
            int sampleSize = options.outHeight / 400;
            if (sampleSize <= 0) {
                sampleSize = 1;
            }
            options.inSampleSize = sampleSize;
            options.inJustDecodeBounds = false;


            return BitmapFactory.decodeFile(picturePath, options);
        } catch (Exception e) {
            return null;
        }
    }

    public static void rgba2Yuv420(byte[] src, byte[] dst, int width, int height) {
        // Y
        for (int y = 0; y < height; y++) {
            int dstOffset = y * width;
            int srcOffset = y * width * 4;
            for (int x = 0; x < width && dstOffset < dst.length && srcOffset < src.length; x++) {
                dst[dstOffset] = src[srcOffset];
                dstOffset += 1;
                srcOffset += 4;
            }
        }
              /* Cb and Cr */
        for (int y = 0; y < height / 2; y++) {
            int dstUOffset = y * width + width * height;
            int srcUOffset = y * width * 8 + 1;

            int dstVOffset = y * width + width * height + 1;
            int srcVOffset = y * width * 8 + 2;
            for (int x = 0; x < width / 2 && dstUOffset < dst.length && srcUOffset < src.length && dstVOffset < dst.length && srcVOffset < src.length; x++) {
                dst[dstUOffset] = src[srcUOffset];
                dst[dstVOffset] = src[srcVOffset];

                dstUOffset += 2;
                dstVOffset += 2;

                srcUOffset += 8;
                srcVOffset += 8;
            }
        }

    }


}

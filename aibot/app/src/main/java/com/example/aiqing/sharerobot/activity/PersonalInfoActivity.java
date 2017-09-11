package com.example.aiqing.sharerobot.activity;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.bean.PersonalInfoBean;
import com.example.aiqing.sharerobot.bean.UpDataSexBean;
import com.example.aiqing.sharerobot.bean.UploadHeaderBean;
import com.example.aiqing.sharerobot.fragment.LowmenuFragment;
import com.example.aiqing.sharerobot.fragment.MenuItemOnClickListener;
import com.example.aiqing.sharerobot.fragment.MenuItems;
import com.example.aiqing.sharerobot.inf.ApiService;
import com.example.aiqing.sharerobot.inf.HttpTool;
import com.example.aiqing.sharerobot.utils.DialogUtil;
import com.example.aiqing.sharerobot.utils.ImageTools;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * 个人中心
 */
public class PersonalInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int REQUST_TAKE_PHOTTO_CODE2 = 1;
    private static final int BIG_CAPTURE = 6;
    private RelativeLayout mRelativelayoutHeader;
    private RelativeLayout mRelativelayoutNiname;
    private RelativeLayout mRelativelayoutSex;
    private RelativeLayout mRelativelayoutPhonenum;
    private RelativeLayout mRelativelayoutMyaddress;
    private LinearLayout mLlPersonInfo;
    private LinearLayout mLlNicheng;
    private TopMenuHeader mTopMenu;
    private ImageView mIvHeader;
    private TextView mTvNickname;
    private TextView mTvSex;
    private TextView mTvPersoninfonum;
    private String mNewCookie;
    private int SCALE = 3;
    private EditText mEtNiname;
    private HttpTool mHttpTool;
    private Dialog mLoadingDialog;
    private Uri mOutputFileUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        mTopMenu = new TopMenuHeader(getWindow().getDecorView());
        mTopMenu.topMenuTitle.setText("个人资料");
        mTopMenu.topMenuRight.setVisibility(View.GONE);
        mTopMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initFindId();

        initPost();

        initData();
    }

    private void initFindId() {
        mRelativelayoutHeader = (RelativeLayout) findViewById(R.id.relativelayout_header);
        mRelativelayoutNiname = (RelativeLayout) findViewById(R.id.relativelayout_niname);
        mRelativelayoutSex = (RelativeLayout) findViewById(R.id.relativelayout_sex);
        mRelativelayoutPhonenum = (RelativeLayout) findViewById(R.id.relativelayout_phonenum);
        mRelativelayoutMyaddress = (RelativeLayout) findViewById(R.id.relativelayout_myaddress);
        mLlPersonInfo = (LinearLayout) findViewById(R.id.linearlayout_personinfo);
        mLlNicheng = (LinearLayout) findViewById(R.id.ll_nicheng);

        mIvHeader = (ImageView) findViewById(R.id.iv_info_header);
        mTvNickname = (TextView) findViewById(R.id.tv_nickname);
        mTvSex = (TextView) findViewById(R.id.tv_sex);
        mTvPersoninfonum = (TextView) findViewById(R.id.tv_personinfonum);

        SharedPreferences preferences = getSharedPreferences("COOKIE", MODE_PRIVATE);
        mNewCookie = preferences.getString("mCookie", "");
        mHttpTool = new HttpTool(this);

    }

    private void initData() {

        mRelativelayoutHeader.setOnClickListener(this);
        mRelativelayoutNiname.setOnClickListener(this);
        mRelativelayoutSex.setOnClickListener(this);
        mRelativelayoutPhonenum.setOnClickListener(this);
        mRelativelayoutMyaddress.setOnClickListener(this);
    }

    private void initPost() {
        mLoadingDialog = DialogUtil.createLoadingDialog(this, "加载中...");
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("http://120.132.117.157:8083/account/getCustInfo.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<PersonalInfoBean> call = apiService.getPersonsInfo(mNewCookie);

        call.enqueue(new Callback<PersonalInfoBean>() {
            @Override
            public void onResponse(Response<PersonalInfoBean> response, Retrofit retrofit) {
                //   String headImg = response.body().getObj().getHeadImg();
//             //   Bitmap bm = BitmapFactory.decodeFile(headImg);
//           //     mIvHeader.setImageBitmap(bm);
//                Log.e("昵称", "onResponse: "+response.body().getObj().getNickname() );
                //TODO 下载图片
                    downImg(response.body());
                DialogUtil.closeDialog(mLoadingDialog);

                if (response.body()==null) {
                    return;
                }else {
                    mTvNickname.setText(response.body().getObj().getNickname());
                    if (response.body().getObj()!=null){
                        mTvSex.setText("男");
                    }else if (!response.body().getObj().equals("")&&response.body().getObj().getSex().equals("2")){
                        mTvSex.setText("女");
                    }else {
                        return;
                    }
                    mTvPersoninfonum.setText(response.body().getObj().getMobile());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(PersonalInfoActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                Log.e("失败", "失败" + t.getMessage());
            }
        });
    }

    private void downImg(PersonalInfoBean body) {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        LowmenuFragment lowmenuFragment = new LowmenuFragment();
        List<MenuItems> menuItemsList = new ArrayList<>();
        switch (v.getId()) {
            case R.id.relativelayout_header:
                //设置头像
                MenuItems menuItems2 = new MenuItems();
                menuItems2.setText("相册");
                MenuItems menuItems3 = new MenuItems();
                menuItems3.setText("相机");

                menuItems2.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems2) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Intent albumIntent = new Intent(Intent.ACTION_PICK, null);
                        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(albumIntent, PHOTO_REQUEST_GALLERY);
                    }
                });
                menuItems3.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems3) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "image.jpg"));
                        //指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(openCameraIntent, REQUST_TAKE_PHOTTO_CODE2);


//                        File file = FileUtils.createImageFile();
//                        mOutputFileUri = Uri.fromFile(file);
//                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT, mOutputFileUri);
//                        if (intent.resolveActivity(getPackageManager()) != null) {
//                            startActivityForResult(intent, BIG_CAPTURE);
//                        }

                    }
                });

                menuItemsList.add(menuItems2);
                menuItemsList.add(menuItems3);
                lowmenuFragment.setMenuItemses(menuItemsList);
                lowmenuFragment.show(getFragmentManager(), "LowmenuFragment");
                break;
            case R.id.relativelayout_niname:
                intent.setClass(PersonalInfoActivity.this, UpdataNickNameActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.relativelayout_sex:
                //设置性别
                MenuItems menuItems = new MenuItems();
                menuItems.setText("男");
                MenuItems menuItems1 = new MenuItems();
                menuItems1.setText("女");

                menuItems.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        String man = menuItems.getText().toString();
                        mTvSex.setText(man);
                        mLoadingDialog = DialogUtil.createLoadingDialog(PersonalInfoActivity.this, "加载中...");
                        Retrofit builder = new Retrofit.Builder()
                                .client(mHttpTool.client())
                                .baseUrl("http://120.132.117.157:8083/account/updateSex.shtml")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        ApiService apiService = builder.create(ApiService.class);
                        Call<UpDataSexBean> call = apiService.upDataSex(mNewCookie,man);
                        call.enqueue(new Callback<UpDataSexBean>() {
                            @Override
                            public void onResponse(Response<UpDataSexBean> response, Retrofit retrofit) {
                                Log.e("555555", "onResponse: "+response.body().isSuccess() );
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                Toast.makeText(PersonalInfoActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                                Log.e("失败", "失败" + t.getMessage());
                            }
                        });
                    }
                });
                menuItems1.setMenuItemOnClickListener(new MenuItemOnClickListener(lowmenuFragment, menuItems1) {
                    @Override
                    public void onClickMenuItem(View v, MenuItems menuItems) {
                        String woman = menuItems.getText().toString();
                        mTvSex.setText(woman);
                        mLoadingDialog = DialogUtil.createLoadingDialog(PersonalInfoActivity.this, "加载中...");
                        Retrofit builder = new Retrofit.Builder()
                                .client(mHttpTool.client())
                                .baseUrl("http://120.132.117.157:8083/account/updateSex.shtml")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                        ApiService apiService = builder.create(ApiService.class);
                        Call<UpDataSexBean> call = apiService.upDataSex(mNewCookie,woman);
                        call.enqueue(new Callback<UpDataSexBean>() {
                            @Override
                            public void onResponse(Response<UpDataSexBean> response, Retrofit retrofit) {
                                Log.e("666666", "onResponse: "+response.body().isSuccess() );
                            }

                            @Override
                            public void onFailure(Throwable t) {
                                Toast.makeText(PersonalInfoActivity.this, "网络连接失败，请检查您的网络！", Toast.LENGTH_SHORT).show();
                                Log.e("失败", "失败" + t.getMessage());
                            }
                        });
                    }
                });

                menuItemsList.add(menuItems);
                menuItemsList.add(menuItems1);
                lowmenuFragment.setMenuItemses(menuItemsList);
                lowmenuFragment.show(getFragmentManager(), "LowmenuFragment");
                break;
            case R.id.relativelayout_phonenum:
                //设置手机号
                break;
            case R.id.relativelayout_myaddress:
                intent.setClass(PersonalInfoActivity.this, MyAddressActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUST_TAKE_PHOTTO_CODE2://相机
                    //将保存在本地的图片取出并缩小后显示在界面上
                    Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
                    Bitmap headerBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
                    //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                    bitmap.recycle();

                    //将处理过的图片显示在界面上，并保存到本地
                    mIvHeader.setImageBitmap(headerBitmap);
                    ImageTools.savePhotoToSDCard(headerBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));
                    //上传
                    uploadImag(headerBitmap);

                    break;

                case PHOTO_REQUEST_GALLERY://
                    ContentResolver resolver = getContentResolver();
                    //照片的原始资源地址
                    Uri originalUri = data.getData();
                    try {
                        //使用ContentProvider通过URI获取原始图片
                        Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                        if (photo != null) {
                            //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
                            Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
                            //释放原始图片占用的内存，防止out of memory异常发生
                            photo.recycle();

                            mIvHeader.setImageBitmap(smallBitmap);

                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    break;
            }
        }
    }
    //上传相机
    private void uploadImag(Bitmap headerBitmap) {
        String base64 = bitmapToBase64(headerBitmap);
        Log.e("base64", "uploadImag: "+ base64);
        Retrofit builder = new Retrofit.Builder()
                .client(mHttpTool.client())
                .baseUrl("https://shared.aqcome.com/image/addImageBase64.shtml")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = builder.create(ApiService.class);
        Call<UploadHeaderBean> call = apiService.uploadheader(mNewCookie, base64);
        call.enqueue(new Callback<UploadHeaderBean>() {
            @Override
            public void onResponse(Response<UploadHeaderBean> response, Retrofit retrofit) {
                //路径
               // Object obj = response.body().getObj();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
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
}

package com.example.aiqing.sharerobot.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.QRCodeUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * Created by aiqing on 2017/6/28.
 * 投放商码
 */

public class YajinActivity extends AppCompatActivity{

    private String mDistributorId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_yajin);
        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        mDistributorId = spDis.getString("distributorId", "");
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("押金码");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        initFindId();
    }

    private void initFindId() {
        ImageView ivYajin = (ImageView) findViewById(R.id.iv_yajin);
        ivYajin.setImageBitmap(QRCodeUtil.createQRCode("https://shared.aqcome.com/?d="+mDistributorId));
    }
}

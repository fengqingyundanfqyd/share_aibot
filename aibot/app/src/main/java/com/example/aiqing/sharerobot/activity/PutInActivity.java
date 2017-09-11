package com.example.aiqing.sharerobot.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.QRCodeUtil;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;
/*
* 代理商码
* */
public class PutInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_in);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("投放商邀请码");
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

        SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
        String agencyId = spDis.getString("agencyId", "");

        ImageView ivPutIn = (ImageView) findViewById(R.id.iv_putin);
        ivPutIn.setImageBitmap(QRCodeUtil.createQRCode("https://shared.aqcome.com/?a="+agencyId));
    }
}

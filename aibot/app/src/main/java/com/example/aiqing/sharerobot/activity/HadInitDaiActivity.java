package com.example.aiqing.sharerobot.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.HadInitAdapter;
/*
* 已初始化
* */
public class HadInitDaiActivity extends AppCompatActivity {

    private ImageView mIvReturn;
    private ListView mLvHadInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_had_init_dai);
        initId();

        initData();
    }

    private void initData() {
        mIvReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        HadInitAdapter hadInitAdapter = new HadInitAdapter(this);
        mLvHadInit.setAdapter(hadInitAdapter);
    }

    private void initId() {
        mIvReturn = (ImageView) findViewById(R.id.iv_hadinit_return);
        mLvHadInit = (ListView) findViewById(R.id.lv_hadinit);
    }
}

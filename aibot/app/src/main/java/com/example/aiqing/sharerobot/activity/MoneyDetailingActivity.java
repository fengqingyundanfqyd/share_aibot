package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * 我的钱包明细
 */
public class MoneyDetailingActivity extends AppCompatActivity {

    private ListView mLvDetailing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_detailing);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("明细");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initId();

    }

    private void initId() {
        mLvDetailing = (ListView) findViewById(R.id.listview_detailing);

    }
}

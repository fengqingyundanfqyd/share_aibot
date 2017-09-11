package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.IntentionAdapter;
import com.example.aiqing.sharerobot.adapter.LogAdapter;
import com.example.aiqing.sharerobot.adapter.SubletVPAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 转租
 */
public class SubletActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvZhuanzuSublet;
    private Button mBtnSublet;
    private TabLayout mTabSublet;
    private ViewPager mVpSublet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sublet);
        initFindId();

        initData();
    }

    private void initFindId() {
        mIvZhuanzuSublet = (ImageView) findViewById(R.id.top_zhuanzu_sublet);
        mBtnSublet = (Button) findViewById(R.id.btn_save_sublet);
        mTabSublet = (TabLayout) findViewById(R.id.tab_sublet);
        mVpSublet = (ViewPager) findViewById(R.id.vp_sublet);

    }

    private void initData() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View viewSublet1 = inflater.inflate(R.layout.vp_sublet1, null);
        View viewSublet2 = inflater.inflate(R.layout.vp_sublet2, null);
        View viewSublet3 = inflater.inflate(R.layout.vp_sublet3, null);
        List<View> viewList=new ArrayList<>();
        viewList.add(viewSublet1);
        viewList.add(viewSublet2);
        viewList.add(viewSublet3);
        SubletVPAdapter subletVPAdapter = new SubletVPAdapter(this, viewList);
        mVpSublet.setAdapter(subletVPAdapter);
        mTabSublet.setupWithViewPager(mVpSublet);


        mTabSublet.getTabAt(0).setText("发布中");
        mTabSublet.getTabAt(1).setText("意向租");
        mTabSublet.getTabAt(2).setText("日志");

        ListView lvIntention = (ListView) viewSublet2.findViewById(R.id.listview_intention);
        IntentionAdapter intentionAdapter = new IntentionAdapter(this);
        lvIntention.setAdapter(intentionAdapter);

        ListView lvLog = (ListView) viewSublet3.findViewById(R.id.listview_log);
        LogAdapter logAdapter = new LogAdapter(this);
        lvLog.setAdapter(logAdapter);

        mIvZhuanzuSublet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.top_zhuanzu_sublet:
                finish();
                break;
        }
    }
}

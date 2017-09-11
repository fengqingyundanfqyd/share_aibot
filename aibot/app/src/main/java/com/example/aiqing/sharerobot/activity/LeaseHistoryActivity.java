package com.example.aiqing.sharerobot.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.LeaseHistoryAdapter;
import com.example.aiqing.sharerobot.utils.TopMenuHeader;

/**
 * 租赁历史
 */
public class LeaseHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lease_history);
        TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
        topMenu.topMenuTitle.setText("租赁历史");
        topMenu.topMenuRight.setVisibility(View.GONE);
        topMenu.topMenuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ListView lvLeaseHistory = (ListView) findViewById(R.id.listview_leasthistory);
        LeaseHistoryAdapter leaseHistoryAdapter = new LeaseHistoryAdapter(this);
        lvLeaseHistory.setAdapter(leaseHistoryAdapter);
    }
}

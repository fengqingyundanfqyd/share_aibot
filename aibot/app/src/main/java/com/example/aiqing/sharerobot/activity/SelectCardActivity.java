package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.aiqing.sharerobot.R;
import com.example.aiqing.sharerobot.adapter.BankCardAdapter;

/**
 * 选择银行卡
 */
public class SelectCardActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mLvCard;
    private ImageView mIvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_card);
        initId();

    }

    private void initId() {
        Button btnAddcard = (Button) findViewById(R.id.btn_add_card);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_select_card);
        mLvCard = (ListView) findViewById(R.id.listview_card);

        BankCardAdapter bankCardAdapter = new BankCardAdapter(this);
        mLvCard.setAdapter(bankCardAdapter);

        btnAddcard.setOnClickListener(this);
        ivReturn.setOnClickListener(this);

        mLvCard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mIvStatus = (ImageView) view.findViewById(R.id.iv_bank_status);
                mIvStatus.setTag("0");
                if (mIvStatus.getTag().equals("0")){
                    mIvStatus.setTag("1");
                    mIvStatus.setVisibility(View.VISIBLE);
                }else {
                    mIvStatus.setTag("0");
                    mIvStatus.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_card:
                //添加银行卡
                Intent intent=new Intent();
                intent.setClass(SelectCardActivity.this,AddCardActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_select_card:
               finish();
                break;
        }
    }
}

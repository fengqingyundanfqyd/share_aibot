package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aiqing.sharerobot.R;

public class DisDetailAddressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_detail_address);
        ImageView ivReturn = (ImageView) findViewById(R.id.iv_detail_return);
        Button btnDetail = (Button) findViewById(R.id.btn_detail_save);
        EditText etSetaddress = (EditText) findViewById(R.id.et_setdetailaddress);
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        final String address = etSetaddress.getText().toString();
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("address",address);
                setResult(13,intent);
                finish();
            }
        });
    }
}

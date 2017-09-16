package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aiqing.sharerobot.R;

public class UpdataPhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_phone);

        ImageView ivReturn = (ImageView) findViewById(R.id.iv_phone_return);
        Button btnPhoneSave = (Button) findViewById(R.id.btn_phone_save);
        EditText etSetphone = (EditText) findViewById(R.id.et_setphone);

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final String phone = etSetphone.getText().toString();
        btnPhoneSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("phone",phone);
                setResult(14,intent);
                finish();
            }
        });
    }
}

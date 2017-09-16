package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.aiqing.sharerobot.R;
//店铺资料修改名称
public class UpdataNameActivity extends AppCompatActivity {

    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updata_name);

        ImageView ivReturn = (ImageView) findViewById(R.id.iv_updata_return);
        Button btnSave = (Button) findViewById(R.id.btn_updata_save);
        EditText etSetname = (EditText) findViewById(R.id.et_setname);

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mName = etSetname.getText().toString();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("name", mName);
                setResult(11,intent);
                finish();
            }
        });
    }
}

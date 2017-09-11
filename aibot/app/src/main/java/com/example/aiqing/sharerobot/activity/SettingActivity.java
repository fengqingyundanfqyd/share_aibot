package com.example.aiqing.sharerobot.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.aiqing.sharerobot.R;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initId();
    }

    private void initId() {
        ImageView ivReturnSet = (ImageView) findViewById(R.id.iv_return_setting);
        RelativeLayout rlCleanSet = (RelativeLayout) findViewById(R.id.rl_clean_setting);
        RelativeLayout rlSuggestSet = (RelativeLayout) findViewById(R.id.rl_suggest_setting);
        RelativeLayout rlAboutusSet = (RelativeLayout) findViewById(R.id.rl_aboutus_setting);
        Button btnLogoutSet = (Button) findViewById(R.id.btn_logout_setting);

        ivReturnSet.setOnClickListener(this);
        rlCleanSet.setOnClickListener(this);
        rlSuggestSet.setOnClickListener(this);
        rlAboutusSet.setOnClickListener(this);
        btnLogoutSet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()){
            case R.id.iv_return_setting:
                finish();
                break;
            case R.id.rl_clean_setting:
                Toast.makeText(this, "清理缓存", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_suggest_setting:
                Toast.makeText(this, "意见", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_aboutus_setting:
                Toast.makeText(this, "关于我们", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_logout_setting:
                Toast.makeText(this, "退出登陆", Toast.LENGTH_SHORT).show();
                SharedPreferences sp = getSharedPreferences("COOKIE", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();

                SharedPreferences spDis = getSharedPreferences("DATA", MODE_PRIVATE);
                spDis.edit().clear().commit();

                intent.setClass(SettingActivity.this,Main2Activity.class);

                startActivity(intent);
                finish();
                break;
        }
    }


}

package com.example.aiqing.sharerobot.utils;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

/**
 * Created by aiqing on 2017/6/24.
 *
 * 公用的布局头
 * // 顶部设置  使用方法
    TopMenuHeader topMenu = new TopMenuHeader(getWindow().getDecorView());
     topMenu.topMenuTitle.setText("首页");
    topMenu.topMenuTitle.setTextColor(Color.parseColor("#2fcfc9"));
    topMenu.topMenuRight.setVisibility(View.GONE);
    topMenu.topMenuLeft.setVisibility(View.GONE);
 *
 *
 *
 */

public class TopMenuHeader {

    // 顶部菜单左边按钮
    public ImageView topMenuLeft;

    // 顶部菜单右边按钮
    public Button topMenuRight;

    // 顶部菜单文字
    public TextView topMenuTitle;

    public TopMenuHeader(View v) {

        // 右边按钮
        topMenuRight = (Button) v.findViewById(R.id.top_menu_right);

        // 左边按钮
        topMenuLeft = (ImageView) v.findViewById(R.id.top_menu_left);

        // 顶部中间文字
        topMenuTitle = (TextView) v.findViewById(R.id.top_menu_title);

    }

}

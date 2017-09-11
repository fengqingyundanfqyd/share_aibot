package com.example.aiqing.sharerobot.fragment;

import android.util.Log;
import android.view.View;

/**
 * Created by aiqing on 2017/7/10.
 */

public abstract class MenuItemOnClickListener implements View.OnClickListener{

    private  String TAG = "MenuItemOnClickListener";

    public MenuItemOnClickListener(LowmenuFragment _bottomMenuFragment, MenuItems _menuItems) {
        this.bottomMenuFragment = _bottomMenuFragment;
        this.mMenuItems = _menuItems;
    }

    public LowmenuFragment getBottomMenuFragment() {
        return bottomMenuFragment;
    }
    public void setBottomMenuFragment(LowmenuFragment bottomMenuFragment) {
        this.bottomMenuFragment = bottomMenuFragment;
    }
    public MenuItems getMenuItems() {
        return mMenuItems;
    }
    public void setMenuItems(MenuItems menuItems) {
        this.mMenuItems = menuItems;
    }

    private LowmenuFragment bottomMenuFragment;
    private MenuItems mMenuItems;
    @Override
    public void onClick(View v){

        Log.i(TAG, "onClick: ");

        if(bottomMenuFragment != null && bottomMenuFragment.isVisible()) {
            bottomMenuFragment.dismiss();
        }

        this.onClickMenuItem(v, this.mMenuItems);
    }
    public abstract void onClickMenuItem(View v, MenuItems menuItems);

}

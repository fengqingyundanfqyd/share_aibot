package com.example.aiqing.sharerobot.fragment;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.aiqing.sharerobot.R;

import java.util.List;

/**
 * Created by aiqing on 2017/7/10.
 */

public class MenuItemAdapter extends BaseAdapter {
    private Context context;//运行上下文

    private LayoutInflater listContainer;  //视图容器

    private List<MenuItems> mMenuItemses;

//    public MenuItemAdapter(Context _context, List<MenuItems> _menuItems) {
//        this.context = _context;
//        this.listContainer = LayoutInflater.from(_context);
//        this.mMenuItemses = _menuItems;
//    }

    public MenuItemAdapter(Context context, List<MenuItems> menuItemses) {
        this.context = context;
        this.listContainer = LayoutInflater.from(context);
        this.mMenuItemses = menuItemses;
    }

    @Override
    public int getCount() {
        return mMenuItemses.size();
    }

    @Override
    public Object getItem(int position) {
        if (position >= mMenuItemses.size() || position < 0) {
            return null;
        } else {
            return mMenuItemses.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = listContainer.inflate(R.layout.menu_item, null);
        }
        MenuItems menuItems = (MenuItems) mMenuItemses.get(position);
        TextView textView = (TextView) view.findViewById(R.id.menu_item);
        textView.setText(menuItems.getText());
        if (mMenuItemses.size() == 1) {
            textView.setBackgroundResource(R.drawable.bottom_menu_btn_selector);
        } else if (position == 0) {
            textView.setBackgroundResource(R.drawable.bottom_menu_top_btn_selector);
        } else if (position < mMenuItemses.size() - 1) {
            textView.setBackgroundResource(R.drawable.bottom_menu_mid_btn_selector);
        } else {
            textView.setBackgroundResource(R.drawable.bottom_menu_bottom_btn_selector);
        }
        if (menuItems.getStyle() == MenuItems.MenuItemStyle.COMMON) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.bottom_menu_btn_text_commom_color));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.bottom_menu_btn_text_stress_color));
        }
        MenuItemOnClickListener _menuItemOnClickListener = menuItems.getMenuItemOnClickListener();
        if (_menuItemOnClickListener != null) {
            textView.setOnClickListener(_menuItemOnClickListener);
        }
        return view;
    }
}

package com.example.aiqing.sharerobot.fragment;

/**
 * Created by aiqing on 2017/7/10.
 */

public class MenuItems {
    public MenuItems() {
    }
    public MenuItems(String _item_name, String _text, MenuItemStyle _style, MenuItemOnClickListener _menuItemOnClickListener){
        this.item_name = _item_name;
        this.text = _text;
        this.style = _style;
        this.menuItemOnClickListener = _menuItemOnClickListener;
    }


    private String item_name;
    private String text;
    private MenuItemStyle style;

    public String getItem_name() {
        return item_name;
    }

    public String getText() {
        return text;
    }

    public MenuItemStyle getStyle() {
        return style;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setStyle(MenuItemStyle style) {
        this.style = style;
    }

    public MenuItemOnClickListener getMenuItemOnClickListener() {
        return menuItemOnClickListener;
    }

    public void setMenuItemOnClickListener(MenuItemOnClickListener menuItemOnClickListener) {
        this.menuItemOnClickListener = menuItemOnClickListener;
    }

    private MenuItemOnClickListener menuItemOnClickListener;


    public  enum MenuItemStyle{
        COMMON , STRESS
    }
}

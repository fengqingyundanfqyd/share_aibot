package com.example.aiqing.sharerobot.utils;

import android.app.Application;



/**
 * Created by aiqing on 2017/6/23.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
       myApplication = this;
        //ZXingLibrary.initDisplayOpinion(this);
    }
}

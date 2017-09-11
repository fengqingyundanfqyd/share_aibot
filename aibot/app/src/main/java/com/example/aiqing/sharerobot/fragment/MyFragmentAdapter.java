package com.example.aiqing.sharerobot.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by aiqing on 2017/8/25.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList;
    private final Context context;

    public MyFragmentAdapter(Context context, FragmentManager fm, List<Fragment> mFragmentList) {
        super(fm);
        this.mFragmentList = mFragmentList;
        this.context = context;
    }

//    @Override
//    public Fragment getItem(int position) {
//
//        // WaitPayFragment waitPayFragment = new WaitPayFragment();
//        // RenttingFragment renttingFragment = new RenttingFragment();
////        SubletReleaseFragment subletReleaseFragment = new SubletReleaseFragment();
////        SublettingFragment sublettingFragment = new SublettingFragment();
//        // mFragmentList.add(waitPayFragment);
////        mFragmentList.add(renttingFragment);
////        mFragmentList.add(subletReleaseFragment);
////        mFragmentList.add(sublettingFragment);
////        String pStatus = result.get(position).getPStatus();
////         List<Fragment> fragmentList= new ArrayList<>();
////        switch (pStatus){
////            case "1":
////                WaitPayFragment waitPayFragment = new WaitPayFragment(result);
////                fragmentList.add(waitPayFragment);
////                break;
////            case "2":
////                RenttingFragment renttingFragment = new RenttingFragment();
////                fragmentList.add(renttingFragment);
////                break;
////            case "3":
////                SubletReleaseFragment subletReleaseFragment = new SubletReleaseFragment();
////                fragmentList.add(subletReleaseFragment);
////                break;
////            case "4":
////                SublettingFragment sublettingFragment = new SublettingFragment();
////                fragmentList.add(sublettingFragment);
////                break;
////            case "5":
//////                WaitPayFragment waitPayFragment = new WaitPayFragment(result);
//////                mFragmentList.add(waitPayFragment);
////                break;
////        }
//
//        return result.get(position);
//    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
}

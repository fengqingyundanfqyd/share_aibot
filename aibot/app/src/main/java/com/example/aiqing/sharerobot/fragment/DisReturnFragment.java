package com.example.aiqing.sharerobot.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aiqing.sharerobot.R;

/** 投放商归还
 * Created by aiqing on 2017/9/9.
 */

public class DisReturnFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.item_return_dis,container,false);
        return view;
    }
}

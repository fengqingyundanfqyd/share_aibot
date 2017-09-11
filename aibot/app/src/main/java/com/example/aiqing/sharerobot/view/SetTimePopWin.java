package com.example.aiqing.sharerobot.view;

/**
 * Created by aiqing on 2017/7/29.
 */

//public class SetTimePopWin extends PopupWindow {
//
//    private final WheelView mHour;
//    private final WheelView mMinite;
//    private final RelativeLayout mSettime;
//    private final View mView;
//    private final Context context;
//    private WheelView hour;
//    private WheelView minite;
//    private ArrayList<String> mListHour;
//    private ArrayList<String> mListMinutes;
//    private String mMinute;
//    private String mHour1;
//
//    public SetTimePopWin(Context context) {
//        this.context=context;
//        this.mView = LayoutInflater.from(context).inflate(R.layout.settime,null);
//        mHour = (WheelView) mView.findViewById(R.id.wheel_hour);
//        mMinite = (WheelView) mView.findViewById(R.id.wheel_minite);
//        mSettime = (RelativeLayout) mView.findViewById(R.id.tv_settime);
//
//        initView();
//
//        //外部可点击
//        this.setOutsideTouchable(true);
//
//        //确定
//        mSettime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //获取时间
//                dismiss();
//            }
//        });
//
//    /* 设置弹出窗口特征 */
//        // 设置视图
//        this.setContentView(this.mView);
//        // 设置弹出窗体的宽和高
//        this.setHeight(600);
//        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
//
//        // 设置弹出窗体可点击
//        this.setFocusable(true);
//
//        // 实例化一个ColorDrawable颜色为半透明
//        //ColorDrawable dw = new ColorDrawable(0xb0000000);
//        ColorDrawable dw=new ColorDrawable(0xffff0000);
//        // 设置弹出窗体的背景
//        this.setBackgroundDrawable(dw);
//
//        // 设置弹出窗体显示时的动画，从底部向上弹出
//        this.setAnimationStyle(R.style.popupwindow_anim_style);
//
//    }
//
//    private void initView() {
//        hour = (WheelView)mView.findViewById(R.id.wheel_hour);
//        minite = (WheelView)mView.findViewById(R.id.wheel_minite);
//
//        mHour.setWheelAdapter(new ArrayWheelAdapter(context));
//        mHour.setSkin(WheelView.Skin.Holo);
//        mHour.setWheelData(createHours());
//        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
//        style.selectedTextColor = Color.parseColor("#0288ce");
//        style.textColor = Color.GRAY;
//        style.selectedTextSize = 20;
//        mHour.setStyle(style);
//        mHour.setExtraText("时", Color.parseColor("#0288ce"), 40, 70);
//
//        mHour.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
//            @Override
//            public void onItemSelected(int position, Object o) {
//                if (!mListHour.get(position).equals("00")){
//                    mHour1 = mListHour.get(position);
//                    Log.e("时", "onItemSelected: "+ mHour1);
//                }
//            }
//        });
//
//
//        mMinite.setWheelAdapter(new ArrayWheelAdapter(context));
//        mMinite.setSkin(WheelView.Skin.Holo);
//        mMinite.setWheelData(createMinutes());
//        mMinite.setStyle(style);
//        mMinite.setExtraText("分", Color.parseColor("#0288ce"), 40, 70);
//        mMinite.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectedListener() {
//            @Override
//            public void onItemSelected(int position, Object o) {
//                if (!mListMinutes.get(position).equals("00")){
//                    mMinute = mListMinutes.get(position);
//                    Log.e("分", "onItemSelected: "+ mMinute);
//
//                }
//            }
//        });
//    }
//
//    private ArrayList<String> createHours() {
//        mListHour = new ArrayList<>();
//        for (int i = 0; i < 24; i++) {
//            if (i < 10) {
//                mListHour.add("0" + i);
//            } else {
//                mListHour.add("" + i);
//            }
//        }
//        return mListHour;
//    }
//    private ArrayList<String> createMinutes() {
//        mListMinutes = new ArrayList<>();
//        for (int i = 0; i < 60; i++) {
//            if (i < 10) {
//                mListMinutes.add("0" + i);
//            } else {
//                mListMinutes.add("" + i);
//            }
//        }
//        return mListMinutes;
//    }
//
//}

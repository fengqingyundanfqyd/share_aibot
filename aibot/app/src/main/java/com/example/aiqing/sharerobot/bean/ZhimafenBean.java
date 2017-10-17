package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/10/17.
 */

public class ZhimafenBean {

    /**
     * coder : 0000
     * obj : apiname=com.alipay.account.auth&app_id=2017062407561730&app_name=mc&auth_type=AUTHACCOUNT&biz_type=openservice&method=alipay.open.auth.sdk.code.get&pid=2088721294401673&product_id=APP_FAST_LOGIN&scope=kuaijie&sign_type=RSA2&target_id=20141225xxxx&sign=UM28OTa7Bv9Bb1XVOxa6sB73GbTlRpFub8iFLx%2F2YOw8nvNMKeqfB3TlfeOUeGNGT5zWxZJA6oKQHQezW97wg%2BwazNW8CWIxP2ivgyUrAFGlhqjT%2FXc6bcaR9ApVRSr%2BblSnzgO2VJujgpkdTqKGTA%2Bu8gS%2FTVEMZmk7VIVZAmJLNn4a7BAR%2FyMRd0G1gyV7z2NoFu1h%2Bko8KYkaAp9KEHgmXihga4Wi%2BgRxIsDcdWdPr4jTnY95eOTiLGWFTUX%2FvxPltZArMI15oLxpZh1GIfMQtWgbjSGzAN2sgadfFh%2FmlmJzQolNDVuuO4zob2VVI5JNKuDdMTsLMr1hFvZWog%3D%3D
     * errorMsg : null
     * transNo : null
     * sign : null
     * success : true
     */

    private String coder;
    private String obj;
    private Object errorMsg;
    private Object transNo;
    private Object sign;
    private boolean success;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getTransNo() {
        return transNo;
    }

    public void setTransNo(Object transNo) {
        this.transNo = transNo;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/13.
 */

public class ScanDisSendBean {

    /**
     * coder : 10000
     * obj : 0
     * errorMsg : 设备无效！
     * transNo : null
     * sign : null
     * success : false
     */

    private String coder;
    private int obj;
    private String errorMsg;
    private Object transNo;
    private Object sign;
    private boolean success;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public int getObj() {
        return obj;
    }

    public void setObj(int obj) {
        this.obj = obj;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
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

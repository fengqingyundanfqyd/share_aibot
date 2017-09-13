package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/13.
 */

public class ScanReturnBean {

    /**
     * errorMsg : 该设备待租中，无法收货
     * coder : 1000
     * success : false
     */

    private String errorMsg;
    private String coder;
    private boolean success;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}

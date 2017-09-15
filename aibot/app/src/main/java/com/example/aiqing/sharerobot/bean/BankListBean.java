package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/15.
 */

public class BankListBean {

    /**
     * coder : 0000
     * obj : []
     * errorMsg : null
     * transNo : null
     * sign : null
     * success : true
     */

    private String coder;
    private Object errorMsg;
    private Object transNo;
    private Object sign;
    private boolean success;
    private List<?> obj;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
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

    public List<?> getObj() {
        return obj;
    }

    public void setObj(List<?> obj) {
        this.obj = obj;
    }
}

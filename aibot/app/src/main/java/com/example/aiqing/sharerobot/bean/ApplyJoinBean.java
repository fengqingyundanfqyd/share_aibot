package com.example.aiqing.sharerobot.bean;

/**
 * //申请加盟
 * Created by aiqing on 2017/7/10.
 */

public class ApplyJoinBean {


    /**
     * coder : 10000
     * obj : null
     * errorMsg : 代理商投放商意向绑定失败！
     * transNo : null
     * sign : null
     * success : false
     */

    private String coder;
    private Object obj;
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

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
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

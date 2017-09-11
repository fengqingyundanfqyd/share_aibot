package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/10.
 */

public class GetYanzhengmaBean {

    /**
     * retcode : true
     * retMsg : 446069（动态验证码），请在1分钟内填写。
     */

    private boolean retcode;
    private String retMsg;

    public boolean isRetcode() {
        return retcode;
    }

    public void setRetcode(boolean retcode) {
        this.retcode = retcode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}

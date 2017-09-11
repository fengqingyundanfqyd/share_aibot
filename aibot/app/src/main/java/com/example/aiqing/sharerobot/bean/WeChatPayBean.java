package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/8/7.
 */

public class WeChatPayBean {

    /**
     * prepayid : wx201708071110190e742615b10493262692
     * partnerid : 1485489132
     * signtype : MD5
     * paySuccess : false
     * timestamp : 1502075185
     * noncestr : 4dz1wf5pgr70n4nh
     * paId : 170807110611078066
     * appid : wx7458b61d79664e24
     * sign : 2DF8E3AF74584919BE346AE0FAA9183D
     */

    private String prepayid;
    private String partnerid;
    private String signtype;
    private String paySuccess;
    private String timestamp;
    private String noncestr;
    private String paId;
    private String appid;
    private String sign;

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getSigntype() {
        return signtype;
    }

    public void setSigntype(String signtype) {
        this.signtype = signtype;
    }

    public String getPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(String paySuccess) {
        this.paySuccess = paySuccess;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPaId() {
        return paId;
    }

    public void setPaId(String paId) {
        this.paId = paId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

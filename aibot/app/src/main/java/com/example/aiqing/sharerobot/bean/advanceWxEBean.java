package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/12.
 */

public class advanceWxEBean {

    /**
     * prepayid : wx20170912165302299afdf62d0242102686
     * partnerid : 1485489132
     * signtype : MD5
     * aaaid : 170912165303434234
     * coder : 0000
     * paySuccess : false
     * timestamp : 1505206383
     * noncestr : z1sv2u3apksrfdgz
     * appid : wx7458b61d79664e24
     * sign : 0CCA2D95560992EECED0ECE37EC739F9
     */

    private String prepayid;
    private String partnerid;
    private String signtype;
    private String aaaid;
    private String coder;
    private String paySuccess;
    private String timestamp;
    private String noncestr;
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

    public String getAaaid() {
        return aaaid;
    }

    public void setAaaid(String aaaid) {
        this.aaaid = aaaid;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
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

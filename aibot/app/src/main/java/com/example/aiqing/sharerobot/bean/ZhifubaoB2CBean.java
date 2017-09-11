package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/9.
 */

public class ZhifubaoB2CBean {

    /**
     * coder : 0000
     * paySuccess : false
     * zfbid : 2017062407561730
     * paId : 170909164424465000
     * body : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017062407561730&biz_content=%7B%22body%22%3A%22%E5%B0%8F%E5%AE%9D%22%2C%22out_trade_no%22%3A%22170909164424465000%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%8A%BC%E9%87%91%E6%94%AF%E4%BB%98%22%2C%22timeout_express%22%3A%225m%22%2C%22total_amount%22%3A%220.03%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Frelay.aqcome.com%2Fgateway%2Falipay%2Fbcdeposit_notify.do&sign=EyeAZGu%2F7eigofHSSVnaDA3RmmiYGtMQuqbbzVtU%2F0KUoeBdVs%2Br2rxt7ycm%2FkvK29azpi5cWexSBWWnIl%2B1KMqH5kMJITR%2BWwQEgJljuHH3eCMu2rsQqRW17GE%2F%2Bh9j96hhvA%2BSoihJ08dNHGB046rCqEpMFJvdCLJYHOpMduyZOGHt58QsBKTZ7y1DL30G98HyFD3%2FT5XMpv6ZGsb9EV9Uh421hbfQG7iMGHJEUiLVgEdAy%2FjIilztnPdbHuIs8SYGO4fupfuCKkqkqhKfsSc%2F4e7n%2BFujpI2raJwcqk15DjgGmbUsm2RUmafj6I5FuUHHvYF%2FKSIIXMKWMFBSew%3D%3D&sign_type=RSA2&timestamp=2017-09-09+16%3A44%3A33&version=1.0
     */

    private String coder;
    private boolean paySuccess;
    private String zfbid;
    private String paId;
    private String body;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public boolean isPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(boolean paySuccess) {
        this.paySuccess = paySuccess;
    }

    public String getZfbid() {
        return zfbid;
    }

    public void setZfbid(String zfbid) {
        this.zfbid = zfbid;
    }

    public String getPaId() {
        return paId;
    }

    public void setPaId(String paId) {
        this.paId = paId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

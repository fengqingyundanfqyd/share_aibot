package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/12.
 */

public class advanceZfbBean {

    /**
     * coder : 0000
     * paySuccess : false
     * zfbid : 2017062407561730
     * aaaid : 170912160611971216
     * body : alipay_sdk=alipay-sdk-java-dynamicVersionNo&app_id=2017062407561730&biz_content=%7B%22body%22%3A%22%E6%8A%95%E6%94%BE%E5%95%86%E6%8A%BC%E9%87%91%22%2C%22out_trade_no%22%3A%22170912160611971216%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%8A%BC%E9%87%91%E6%94%AF%E4%BB%98%22%2C%22timeout_express%22%3A%225m%22%2C%22total_amount%22%3A%229.99%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Frelay.aqcome.com%2Fgateway%2Falipay%2Fadvance_notify.do&sign=YIKkWF0IHxAUmuxUxWwu1yMS6quHoH8u6NUIdTAroKzrd3XfVKo3OWzfS09IfLaUaJ3QuYC8zSVijMnUJKfFdJ2HbgcdxGzt6OQm%2FWQ8uZ19drSvL4sdGxDwWvOsBHe4FzDnV5qgR9Ezim7rw3dOX1vyYhjMufKDrfmAXf9BzfqykKEodMcjvHuFZJ2nGCy5K1POdKTOi5A97pb%2F6Tp99eJQRwpzxa%2F9PtLuPHYZ0rhoMPWlDrpvM2lLbkH7tyAOYf9o5nz55JFVJTcfg%2BDo2CxaKRYj64xsdnXtn72MSjElqd73S%2FIABxMQoYD9GXAMXJtmxjQyTnoAMTI4T8tsBw%3D%3D&sign_type=RSA2&timestamp=2017-09-12+16%3A06%3A12&version=1.0
     */

    private String coder;
    private boolean paySuccess;
    private String zfbid;
    private String aaaid;
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

    public String getAaaid() {
        return aaaid;
    }

    public void setAaaid(String aaaid) {
        this.aaaid = aaaid;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

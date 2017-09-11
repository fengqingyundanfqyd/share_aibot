package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/8/17.
 */

public class ScanRentBean {

    /**
     * pTypeId : 1
     * c1CustId : null
     * page : 1
     * xzfNum : 1
     * errorMsg : 执行成功
     * coder : 0000
     * distributorId : 170814205055272035
     */

    private String pTypeId;
    private Object c1CustId;
    private String page;
    private String xzfNum;
    private String errorMsg;
    private String coder;
    private String distributorId;

    public String getPTypeId() {
        return pTypeId;
    }

    public void setPTypeId(String pTypeId) {
        this.pTypeId = pTypeId;
    }

    public Object getC1CustId() {
        return c1CustId;
    }

    public void setC1CustId(Object c1CustId) {
        this.c1CustId = c1CustId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getXzfNum() {
        return xzfNum;
    }

    public void setXzfNum(String xzfNum) {
        this.xzfNum = xzfNum;
    }

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

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }
}

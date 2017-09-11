package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/11.
 */

public class AngentyBean {


    /**
     * total : 0
     * stock : 0
     * shipmentNum : 0
     * toDeliveNum : 4
     * coder : 0000
     * errorMsg : 执行成功
     */

    private int total;
    private int stock;
    private int shipmentNum;
    private int toDeliveNum;
    private String coder;
    private String errorMsg;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getShipmentNum() {
        return shipmentNum;
    }

    public void setShipmentNum(int shipmentNum) {
        this.shipmentNum = shipmentNum;
    }

    public int getToDeliveNum() {
        return toDeliveNum;
    }

    public void setToDeliveNum(int toDeliveNum) {
        this.toDeliveNum = toDeliveNum;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

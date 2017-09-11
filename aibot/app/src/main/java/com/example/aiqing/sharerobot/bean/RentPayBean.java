package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/9.
 */

public class RentPayBean {

    /**
     * coder : 0000
     * errorMsg : 执行成功
     * feeSetList : [{"id":"3","ptypeId":"1","type":"2","fee":500,"length":1,"lengthUnit":"2","sort":3,"status":"1","fee2":"500.00"},{"id":"4","ptypeId":"1","type":"2","fee":1000,"length":3,"lengthUnit":"2","sort":4,"status":"1","fee2":"1000.00"},{"id":"5","ptypeId":"1","type":"2","fee":3000,"length":1,"lengthUnit":"3","sort":5,"status":"1","fee2":"3000.00"},{"id":"6","ptypeId":"1","type":"3","fee":12000,"length":2,"lengthUnit":"1","sort":6,"status":"1","fee2":"12000.00"}]
     * balance : 6.00
     */

    private String coder;
    private String errorMsg;
    private String balance;
    private List<FeeSetListBean> feeSetList;

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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<FeeSetListBean> getFeeSetList() {
        return feeSetList;
    }

    public void setFeeSetList(List<FeeSetListBean> feeSetList) {
        this.feeSetList = feeSetList;
    }

    public static class FeeSetListBean {
        /**
         * id : 3
         * ptypeId : 1
         * type : 2
         * fee : 500.0
         * length : 1
         * lengthUnit : 2
         * sort : 3
         * status : 1
         * fee2 : 500.00
         */

        private String id;
        private String ptypeId;
        private String type;
        private double fee;
        private int length;
        private String lengthUnit;
        private int sort;
        private String status;
        private String fee2;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(String ptypeId) {
            this.ptypeId = ptypeId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getLengthUnit() {
            return lengthUnit;
        }

        public void setLengthUnit(String lengthUnit) {
            this.lengthUnit = lengthUnit;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFee2() {
            return fee2;
        }

        public void setFee2(String fee2) {
            this.fee2 = fee2;
        }
    }
}

package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/8/12.
 */

public class TouOrderBean {

    /**
     * errorMsg : 执行成功
     * coder : 0000
     * apply : {"mobile":"18767160533","factNum":1,"createTime":"2017-08-05 03:22:26","status":"已发货","doStatus":"6","remark":"申请上门自提设备"}
     */

    private String errorMsg;
    private String coder;
    private ApplyBean apply;

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

    public ApplyBean getApply() {
        return apply;
    }

    public void setApply(ApplyBean apply) {
        this.apply = apply;
    }

    public static class ApplyBean {
        /**
         * mobile : 18767160533
         * factNum : 1
         * createTime : 2017-08-05 03:22:26
         * status : 已发货
         * doStatus : 6
         * remark : 申请上门自提设备
         */

        private String mobile;
        private int factNum;
        private String createTime;
        private String status;
        private String doStatus;
        private String remark;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getFactNum() {
            return factNum;
        }

        public void setFactNum(int factNum) {
            this.factNum = factNum;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDoStatus() {
            return doStatus;
        }

        public void setDoStatus(String doStatus) {
            this.doStatus = doStatus;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}

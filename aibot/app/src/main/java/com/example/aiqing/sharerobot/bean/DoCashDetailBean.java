package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/18.
 */

public class DoCashDetailBean {

    /**
     * coder : 0000
     * errorMsg : 执行成功
     * cashApplyList : {"size":5,"total":3,"currentPage":1,"totalPage":1,"currentResult":0,"result":[{"caId":null,"custId":null,"amount":100,"cardId":null,"status":null,"applyTime":"2017-09-18 14:44:16","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"},{"caId":null,"custId":null,"amount":18,"cardId":null,"status":null,"applyTime":"2017-09-18 14:47:08","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"},{"caId":null,"custId":null,"amount":18,"cardId":null,"status":null,"applyTime":"2017-09-18 14:48:36","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"}]}
     */

    private String coder;
    private String errorMsg;
    private CashApplyListBean cashApplyList;

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

    public CashApplyListBean getCashApplyList() {
        return cashApplyList;
    }

    public void setCashApplyList(CashApplyListBean cashApplyList) {
        this.cashApplyList = cashApplyList;
    }

    public static class CashApplyListBean {
        /**
         * size : 5
         * total : 3
         * currentPage : 1
         * totalPage : 1
         * currentResult : 0
         * result : [{"caId":null,"custId":null,"amount":100,"cardId":null,"status":null,"applyTime":"2017-09-18 14:44:16","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"},{"caId":null,"custId":null,"amount":18,"cardId":null,"status":null,"applyTime":"2017-09-18 14:47:08","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"},{"caId":null,"custId":null,"amount":18,"cardId":null,"status":null,"applyTime":"2017-09-18 14:48:36","cancelTime":null,"passTime":null,"refuseTime":null,"rejectReason":null,"refundTime":null,"remark":null,"batchSn":null,"transSn":null,"transTime":null,"transResult":null,"applyTime2":null,"custName":null,"mobile":null,"bankName":null,"accountName":null,"accountNo":null,"bankCode":null,"bankAddr":null,"type":"处理中"}]
         */

        private int size;
        private int total;
        private int currentPage;
        private int totalPage;
        private int currentResult;
        private List<ResultBean> result;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrentResult() {
            return currentResult;
        }

        public void setCurrentResult(int currentResult) {
            this.currentResult = currentResult;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * caId : null
             * custId : null
             * amount : 100.0
             * cardId : null
             * status : null
             * applyTime : 2017-09-18 14:44:16
             * cancelTime : null
             * passTime : null
             * refuseTime : null
             * rejectReason : null
             * refundTime : null
             * remark : null
             * batchSn : null
             * transSn : null
             * transTime : null
             * transResult : null
             * applyTime2 : null
             * custName : null
             * mobile : null
             * bankName : null
             * accountName : null
             * accountNo : null
             * bankCode : null
             * bankAddr : null
             * type : 处理中
             */

            private Object caId;
            private Object custId;
            private double amount;
            private Object cardId;
            private Object status;
            private String applyTime;
            private Object cancelTime;
            private Object passTime;
            private Object refuseTime;
            private Object rejectReason;
            private Object refundTime;
            private Object remark;
            private Object batchSn;
            private Object transSn;
            private Object transTime;
            private Object transResult;
            private Object applyTime2;
            private Object custName;
            private Object mobile;
            private Object bankName;
            private Object accountName;
            private Object accountNo;
            private Object bankCode;
            private Object bankAddr;
            private String type;

            public Object getCaId() {
                return caId;
            }

            public void setCaId(Object caId) {
                this.caId = caId;
            }

            public Object getCustId() {
                return custId;
            }

            public void setCustId(Object custId) {
                this.custId = custId;
            }

            public double getAmount() {
                return amount;
            }

            public void setAmount(double amount) {
                this.amount = amount;
            }

            public Object getCardId() {
                return cardId;
            }

            public void setCardId(Object cardId) {
                this.cardId = cardId;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public String getApplyTime() {
                return applyTime;
            }

            public void setApplyTime(String applyTime) {
                this.applyTime = applyTime;
            }

            public Object getCancelTime() {
                return cancelTime;
            }

            public void setCancelTime(Object cancelTime) {
                this.cancelTime = cancelTime;
            }

            public Object getPassTime() {
                return passTime;
            }

            public void setPassTime(Object passTime) {
                this.passTime = passTime;
            }

            public Object getRefuseTime() {
                return refuseTime;
            }

            public void setRefuseTime(Object refuseTime) {
                this.refuseTime = refuseTime;
            }

            public Object getRejectReason() {
                return rejectReason;
            }

            public void setRejectReason(Object rejectReason) {
                this.rejectReason = rejectReason;
            }

            public Object getRefundTime() {
                return refundTime;
            }

            public void setRefundTime(Object refundTime) {
                this.refundTime = refundTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getBatchSn() {
                return batchSn;
            }

            public void setBatchSn(Object batchSn) {
                this.batchSn = batchSn;
            }

            public Object getTransSn() {
                return transSn;
            }

            public void setTransSn(Object transSn) {
                this.transSn = transSn;
            }

            public Object getTransTime() {
                return transTime;
            }

            public void setTransTime(Object transTime) {
                this.transTime = transTime;
            }

            public Object getTransResult() {
                return transResult;
            }

            public void setTransResult(Object transResult) {
                this.transResult = transResult;
            }

            public Object getApplyTime2() {
                return applyTime2;
            }

            public void setApplyTime2(Object applyTime2) {
                this.applyTime2 = applyTime2;
            }

            public Object getCustName() {
                return custName;
            }

            public void setCustName(Object custName) {
                this.custName = custName;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public Object getBankName() {
                return bankName;
            }

            public void setBankName(Object bankName) {
                this.bankName = bankName;
            }

            public Object getAccountName() {
                return accountName;
            }

            public void setAccountName(Object accountName) {
                this.accountName = accountName;
            }

            public Object getAccountNo() {
                return accountNo;
            }

            public void setAccountNo(Object accountNo) {
                this.accountNo = accountNo;
            }

            public Object getBankCode() {
                return bankCode;
            }

            public void setBankCode(Object bankCode) {
                this.bankCode = bankCode;
            }

            public Object getBankAddr() {
                return bankAddr;
            }

            public void setBankAddr(Object bankAddr) {
                this.bankAddr = bankAddr;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

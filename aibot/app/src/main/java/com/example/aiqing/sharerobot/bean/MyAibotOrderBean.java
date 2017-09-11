package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/8/15.
 */

public class MyAibotOrderBean {

    /**
     * all : 33
     * notSend : 6
     * hasUse : 6
     * notUse : 1
     * coder : 0000
     * msg : 查询成功
     * useHistory : {"size":5,"total":10,"currentPage":1,"totalPage":2,"currentResult":0,"result":[{"id":null,"type":null,"productId":"lKF421hM8cbI5rjzEql4xgK7sEpe8AXH","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"99","timestamp":"2017-08-08 11:16:07","pTypeName":"小宝","timestamp2":"2017-08-08 11:16","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"eQANWe4Unmwq1VlT0rcd7NZGJpD6GVlb","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-08 10:52:16","pTypeName":"小宝","timestamp2":"2017-08-08 10:52","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"Ts8jRyvaxNzDMbBLuNunz7VOIOn7ycAx","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"99","timestamp":"2017-08-08 09:58:04","pTypeName":"小宝","timestamp2":"2017-08-08 09:58","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"f5HsIKKbH1sjIReuj5CfmAuKJ1U9YORX","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-07 11:56:34","pTypeName":"小宝","timestamp2":"2017-08-07 11:56","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-07 11:49:16","pTypeName":"小宝","timestamp2":"2017-08-07 11:49","paId":null,"remark":null,"productIds":null}]}
     */

    private int all;
    private int notSend;
    private int hasUse;
    private int notUse;
    private String coder;
    private String msg;
    private UseHistoryBean useHistory;

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public int getNotSend() {
        return notSend;
    }

    public void setNotSend(int notSend) {
        this.notSend = notSend;
    }

    public int getHasUse() {
        return hasUse;
    }

    public void setHasUse(int hasUse) {
        this.hasUse = hasUse;
    }

    public int getNotUse() {
        return notUse;
    }

    public void setNotUse(int notUse) {
        this.notUse = notUse;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UseHistoryBean getUseHistory() {
        return useHistory;
    }

    public void setUseHistory(UseHistoryBean useHistory) {
        this.useHistory = useHistory;
    }

    public static class UseHistoryBean {
        /**
         * size : 5
         * total : 10
         * currentPage : 1
         * totalPage : 2
         * currentResult : 0
         * result : [{"id":null,"type":null,"productId":"lKF421hM8cbI5rjzEql4xgK7sEpe8AXH","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"99","timestamp":"2017-08-08 11:16:07","pTypeName":"小宝","timestamp2":"2017-08-08 11:16","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"eQANWe4Unmwq1VlT0rcd7NZGJpD6GVlb","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-08 10:52:16","pTypeName":"小宝","timestamp2":"2017-08-08 10:52","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"Ts8jRyvaxNzDMbBLuNunz7VOIOn7ycAx","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"99","timestamp":"2017-08-08 09:58:04","pTypeName":"小宝","timestamp2":"2017-08-08 09:58","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"f5HsIKKbH1sjIReuj5CfmAuKJ1U9YORX","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-07 11:56:34","pTypeName":"小宝","timestamp2":"2017-08-07 11:56","paId":null,"remark":null,"productIds":null},{"id":null,"type":null,"productId":"M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":"2017-08-07 11:49:16","pTypeName":"小宝","timestamp2":"2017-08-07 11:49","paId":null,"remark":null,"productIds":null}]
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
             * id : null
             * type : null
             * productId : lKF421hM8cbI5rjzEql4xgK7sEpe8AXH
             * ptypeId : null
             * agencyId : null
             * acustId : null
             * aresetTime : null
             * distributorId : null
             * bcustId : null
             * bresetTime : null
             * reletCustId : null
             * depositCustId : null
             * lockCustId : null
             * custId : null
             * leaseFrom : null
             * leaseTo : null
             * lgt : null
             * lat : null
             * address : null
             * status : 99
             * timestamp : 2017-08-08 11:16:07
             * pTypeName : 小宝
             * timestamp2 : 2017-08-08 11:16
             * paId : null
             * remark : null
             * productIds : null
             */

            private Object id;
            private Object type;
            private String productId;
            private Object ptypeId;
            private Object agencyId;
            private Object acustId;
            private Object aresetTime;
            private Object distributorId;
            private Object bcustId;
            private Object bresetTime;
            private Object reletCustId;
            private Object depositCustId;
            private Object lockCustId;
            private Object custId;
            private Object leaseFrom;
            private Object leaseTo;
            private Object lgt;
            private Object lat;
            private Object address;
            private String status;
            private String timestamp;
            private String pTypeName;
            private String timestamp2;
            private Object paId;
            private Object remark;
            private Object productIds;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public Object getPtypeId() {
                return ptypeId;
            }

            public void setPtypeId(Object ptypeId) {
                this.ptypeId = ptypeId;
            }

            public Object getAgencyId() {
                return agencyId;
            }

            public void setAgencyId(Object agencyId) {
                this.agencyId = agencyId;
            }

            public Object getAcustId() {
                return acustId;
            }

            public void setAcustId(Object acustId) {
                this.acustId = acustId;
            }

            public Object getAresetTime() {
                return aresetTime;
            }

            public void setAresetTime(Object aresetTime) {
                this.aresetTime = aresetTime;
            }

            public Object getDistributorId() {
                return distributorId;
            }

            public void setDistributorId(Object distributorId) {
                this.distributorId = distributorId;
            }

            public Object getBcustId() {
                return bcustId;
            }

            public void setBcustId(Object bcustId) {
                this.bcustId = bcustId;
            }

            public Object getBresetTime() {
                return bresetTime;
            }

            public void setBresetTime(Object bresetTime) {
                this.bresetTime = bresetTime;
            }

            public Object getReletCustId() {
                return reletCustId;
            }

            public void setReletCustId(Object reletCustId) {
                this.reletCustId = reletCustId;
            }

            public Object getDepositCustId() {
                return depositCustId;
            }

            public void setDepositCustId(Object depositCustId) {
                this.depositCustId = depositCustId;
            }

            public Object getLockCustId() {
                return lockCustId;
            }

            public void setLockCustId(Object lockCustId) {
                this.lockCustId = lockCustId;
            }

            public Object getCustId() {
                return custId;
            }

            public void setCustId(Object custId) {
                this.custId = custId;
            }

            public Object getLeaseFrom() {
                return leaseFrom;
            }

            public void setLeaseFrom(Object leaseFrom) {
                this.leaseFrom = leaseFrom;
            }

            public Object getLeaseTo() {
                return leaseTo;
            }

            public void setLeaseTo(Object leaseTo) {
                this.leaseTo = leaseTo;
            }

            public Object getLgt() {
                return lgt;
            }

            public void setLgt(Object lgt) {
                this.lgt = lgt;
            }

            public Object getLat() {
                return lat;
            }

            public void setLat(Object lat) {
                this.lat = lat;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getPTypeName() {
                return pTypeName;
            }

            public void setPTypeName(String pTypeName) {
                this.pTypeName = pTypeName;
            }

            public String getTimestamp2() {
                return timestamp2;
            }

            public void setTimestamp2(String timestamp2) {
                this.timestamp2 = timestamp2;
            }

            public Object getPaId() {
                return paId;
            }

            public void setPaId(Object paId) {
                this.paId = paId;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getProductIds() {
                return productIds;
            }

            public void setProductIds(Object productIds) {
                this.productIds = productIds;
            }
        }
    }
}

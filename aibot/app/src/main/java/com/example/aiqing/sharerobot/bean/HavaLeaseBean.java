package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/11.
 */

public class HavaLeaseBean {


    /**
     * orderList : {"size":15,"total":4,"currentPage":1,"totalPage":1,"currentResult":0,"result":[{"productId":"211411111","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"2","headImg":null},{"productId":"300000","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"4","headImg":null},{"productId":"305","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"5","headImg":null},{"productId":"CD3999AFBDCBE3471C8D894D1A5BD5E2","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"4","headImg":null}]}
     * errorMsg : 执行成功
     * coder : 0000
     */

    private OrderListBean orderList;
    private String errorMsg;
    private String coder;

    public OrderListBean getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderListBean orderList) {
        this.orderList = orderList;
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

    public static class OrderListBean {
        /**
         * size : 15
         * total : 4
         * currentPage : 1
         * totalPage : 1
         * currentResult : 0
         * result : [{"productId":"211411111","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"2","headImg":null},{"productId":"300000","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"4","headImg":null},{"productId":"305","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"5","headImg":null},{"productId":"CD3999AFBDCBE3471C8D894D1A5BD5E2","ptypeId":null,"agencyId":null,"distributorId":null,"custId":null,"leaseFrom":null,"leaseTo":null,"endTime":null,"lgt":null,"lat":null,"address":null,"status":"4","headImg":null}]
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
             * productId : 211411111
             * ptypeId : null
             * agencyId : null
             * distributorId : null
             * custId : null
             * leaseFrom : null
             * leaseTo : null
             * endTime : null
             * lgt : null
             * lat : null
             * address : null
             * status : 2
             * headImg : null
             */

            private String productId;
            private Object ptypeId;
            private Object agencyId;
            private Object distributorId;
            private Object custId;
            private Object leaseFrom;
            private Object leaseTo;
            private Object endTime;
            private Object lgt;
            private Object lat;
            private Object address;
            private String status;
            private Object headImg;

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

            public Object getDistributorId() {
                return distributorId;
            }

            public void setDistributorId(Object distributorId) {
                this.distributorId = distributorId;
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

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
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

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
            }
        }
    }
}

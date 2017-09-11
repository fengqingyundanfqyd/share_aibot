package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/12.
 */

public class LeaseDetailBean {


    /**
     * product : {"mobile":"15988481506","factNum":1,"remark":"待收货","doStatus":"6"}
     * errorMsg : 执行成功
     * coder : 0000
     * recList : [{"id":null,"type":null,"productId":"M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":"170803192424096000","leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"6","timestamp":null,"pTypeName":null,"timestamp2":"2017-08-07 04:54:30","paId":null,"remark":"来自[啊哈哈哈]的15988481506发起归还申请","productIds":null},{"id":null,"type":null,"productId":"M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W","ptypeId":null,"agencyId":null,"acustId":null,"aresetTime":null,"distributorId":null,"bcustId":null,"bresetTime":null,"reletCustId":null,"depositCustId":null,"lockCustId":null,"custId":"170803192424096000","leaseFrom":null,"leaseTo":null,"lgt":null,"lat":null,"address":null,"status":"5","timestamp":null,"pTypeName":null,"timestamp2":"2017-08-07 11:49:16","paId":null,"remark":"15988481506扫码租用，套餐[500元/月（小宝）]，地址为[浙江省杭州市下城区石祥路靠近中大银泰城]","productIds":null}]
     */

    private ProductBean product;
    private String errorMsg;
    private String coder;
    private List<RecListBean> recList;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
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

    public List<RecListBean> getRecList() {
        return recList;
    }

    public void setRecList(List<RecListBean> recList) {
        this.recList = recList;
    }

    public static class ProductBean {
        /**
         * mobile : 15988481506
         * factNum : 1
         * remark : 待收货
         * doStatus : 6
         */

        private String mobile;
        private int factNum;
        private String remark;
        private String doStatus;

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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getDoStatus() {
            return doStatus;
        }

        public void setDoStatus(String doStatus) {
            this.doStatus = doStatus;
        }
    }

    public static class RecListBean {
        /**
         * id : null
         * type : null
         * productId : M2IOkSK1suxbofPcjsiCfEPvOklE3Z6W
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
         * custId : 170803192424096000
         * leaseFrom : null
         * leaseTo : null
         * lgt : null
         * lat : null
         * address : null
         * status : 6
         * timestamp : null
         * pTypeName : null
         * timestamp2 : 2017-08-07 04:54:30
         * paId : null
         * remark : 来自[啊哈哈哈]的15988481506发起归还申请
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
        private String custId;
        private Object leaseFrom;
        private Object leaseTo;
        private Object lgt;
        private Object lat;
        private Object address;
        private String status;
        private Object timestamp;
        private Object pTypeName;
        private String timestamp2;
        private Object paId;
        private String remark;
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

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
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

        public Object getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Object timestamp) {
            this.timestamp = timestamp;
        }

        public Object getPTypeName() {
            return pTypeName;
        }

        public void setPTypeName(Object pTypeName) {
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
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

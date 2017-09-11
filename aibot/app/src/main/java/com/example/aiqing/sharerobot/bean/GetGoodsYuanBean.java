package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/7.
 */

public class GetGoodsYuanBean {

    /**
     * obj : [{"agencyId":"170823152759814000","levelId":null,"custId":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"mobile":"18768163700","custName":"摇曳的栗子","ptypeId":null,"productId":null,"reset":null,"lgt":null,"lat":null,"address":null,"headImg":null,"realName":null,"id":null},{"agencyId":"170818141831108004","levelId":null,"custId":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"mobile":"15988481506","custName":"159****1506","ptypeId":null,"productId":null,"reset":null,"lgt":null,"lat":null,"address":null,"headImg":null,"realName":null,"id":null},{"agencyId":"170816120237366008","levelId":null,"custId":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"mobile":"18158107237","custName":"汪东平","ptypeId":null,"productId":null,"reset":null,"lgt":null,"lat":null,"address":null,"headImg":null,"realName":null,"id":null}]
     * productList : [{"ptypeId":"1","name":"小宝","sort":1,"status":"1","fee":999}]
     * AccountList : {"accountId":"170818151922253008","custId":"170818151922250007","balance":0,"cDeposit":0,"aDeposit":0,"bDeposit":0,"withdraw":0,"createTime":"2017-08-18 15:19:22","status":"1"}
     * coder : 0000
     * errorMsg : 执行成功
     */

    private AccountListBean AccountList;
    private String coder;
    private String errorMsg;
    private List<ObjBean> obj;
    private List<ProductListBean> productList;

    public AccountListBean getAccountList() {
        return AccountList;
    }

    public void setAccountList(AccountListBean AccountList) {
        this.AccountList = AccountList;
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

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class AccountListBean {
        /**
         * accountId : 170818151922253008
         * custId : 170818151922250007
         * balance : 0.0
         * cDeposit : 0.0
         * aDeposit : 0.0
         * bDeposit : 0.0
         * withdraw : 0.0
         * createTime : 2017-08-18 15:19:22
         * status : 1
         */

        private String accountId;
        private String custId;
        private double balance;
        private double cDeposit;
        private double aDeposit;
        private double bDeposit;
        private double withdraw;
        private String createTime;
        private String status;

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public double getCDeposit() {
            return cDeposit;
        }

        public void setCDeposit(double cDeposit) {
            this.cDeposit = cDeposit;
        }

        public double getADeposit() {
            return aDeposit;
        }

        public void setADeposit(double aDeposit) {
            this.aDeposit = aDeposit;
        }

        public double getBDeposit() {
            return bDeposit;
        }

        public void setBDeposit(double bDeposit) {
            this.bDeposit = bDeposit;
        }

        public double getWithdraw() {
            return withdraw;
        }

        public void setWithdraw(double withdraw) {
            this.withdraw = withdraw;
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
    }

    public static class ObjBean {
        /**
         * agencyId : 170823152759814000
         * levelId : null
         * custId : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : null
         * mobile : 18768163700
         * custName : 摇曳的栗子
         * ptypeId : null
         * productId : null
         * reset : null
         * lgt : null
         * lat : null
         * address : null
         * headImg : null
         * realName : null
         * id : null
         */

        private String agencyId;
        private Object levelId;
        private Object custId;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private Object status;
        private String mobile;
        private String custName;
        private Object ptypeId;
        private Object productId;
        private Object reset;
        private Object lgt;
        private Object lat;
        private Object address;
        private Object headImg;
        private Object realName;
        private Object id;

        public String getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(String agencyId) {
            this.agencyId = agencyId;
        }

        public Object getLevelId() {
            return levelId;
        }

        public void setLevelId(Object levelId) {
            this.levelId = levelId;
        }

        public Object getCustId() {
            return custId;
        }

        public void setCustId(Object custId) {
            this.custId = custId;
        }

        public Object getCreater() {
            return creater;
        }

        public void setCreater(Object creater) {
            this.creater = creater;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdater() {
            return updater;
        }

        public void setUpdater(Object updater) {
            this.updater = updater;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public Object getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(Object ptypeId) {
            this.ptypeId = ptypeId;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public Object getReset() {
            return reset;
        }

        public void setReset(Object reset) {
            this.reset = reset;
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

        public Object getHeadImg() {
            return headImg;
        }

        public void setHeadImg(Object headImg) {
            this.headImg = headImg;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }

    public static class ProductListBean {
        /**
         * ptypeId : 1
         * name : 小宝
         * sort : 1
         * status : 1
         * fee : 999.0
         */

        private String ptypeId;
        private String name;
        private int sort;
        private String status;
        private double fee;

        public String getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(String ptypeId) {
            this.ptypeId = ptypeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }
    }
}

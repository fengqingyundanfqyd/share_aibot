package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/8/16.
 */

public class NoSendBean {


    /**
     * coder : 0000
     * msg : 查询成功
     * obj : {"size":5,"total":4,"currentPage":1,"totalPage":1,"currentResult":0,"result":[{"paId":"170815160425363159","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:08:38","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:08","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815160930273163","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:13:43","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:13","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815161002921175","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:13:59","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:13","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815161006719165","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:14:19","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:14","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null}]}
     */

    private String coder;
    private String msg;
    private ObjBean obj;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * size : 5
         * total : 4
         * currentPage : 1
         * totalPage : 1
         * currentResult : 0
         * result : [{"paId":"170815160425363159","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:08:38","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:08","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815160930273163","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:13:43","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:13","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815161002921175","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:13:59","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:13","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null},{"paId":"170815161006719165","ptypeId":null,"ptypeName":"小宝","productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":1,"factNum":null,"sendNum":null,"refundNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":null,"address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":null,"createTime":"2017-08-15 16:14:19","updateTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":"2017-08-15 16:14","custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"mobile2":null,"count":null,"addressOr":null,"state":null,"createTimeone":null,"createTimetwo":null,"outstock":null,"benifit":null,"id":null,"updateTime2":null,"updateTimeone":null,"updateTimetwo":null,"infoList":null,"nickname":null,"headImg":null,"transferNo":null,"totalAmount":null,"returnType":null,"totalAmount2":null,"ct":0,"curFor1":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"onlinepayType":null,"applyCount":null}]
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
             * paId : 170815160425363159
             * ptypeId : null
             * ptypeName : 小宝
             * productId : null
             * applyType : null
             * sendType : null
             * curFor : null
             * agencyId : null
             * acustId : null
             * distributorId : null
             * bcustId : null
             * c1custId : null
             * c2custId : null
             * applyNum : 1
             * factNum : null
             * sendNum : null
             * refundNum : null
             * unitMoney : null
             * money : null
             * voucherImg : null
             * receiveType : null
             * name : null
             * mobile : null
             * address : null
             * remark1 : null
             * remark2 : null
             * remark3 : null
             * doStatus : null
             * createTime : 2017-08-15 16:08:38
             * updateTime : null
             * status : null
             * custName : null
             * custMobile : null
             * isAgency : null
             * isDistributor : null
             * createTime2 : 2017-08-15 16:08
             * custRole : null
             * money2 : null
             * unitMoney2 : null
             * custId : null
             * creater : null
             * accountNo : null
             * zzje : null
             * yecl : null
             * initnum : null
             * payType : null
             * addressId : null
             * realName : null
             * stock : null
             * mobile2 : null
             * count : null
             * addressOr : null
             * state : null
             * createTimeone : null
             * createTimetwo : null
             * outstock : null
             * benifit : null
             * id : null
             * updateTime2 : null
             * updateTimeone : null
             * updateTimetwo : null
             * infoList : null
             * nickname : null
             * headImg : null
             * transferNo : null
             * totalAmount : null
             * returnType : null
             * totalAmount2 : null
             * ct : 0
             * curFor1 : null
             * onlinePay : null
             * offlinePay : null
             * balancePay : null
             * onlinepayType : null
             * applyCount : null
             */

            private String paId;
            private Object ptypeId;
            private String ptypeName;
            private Object productId;
            private Object applyType;
            private Object sendType;
            private Object curFor;
            private Object agencyId;
            private Object acustId;
            private Object distributorId;
            private Object bcustId;
            private Object c1custId;
            private Object c2custId;
            private int applyNum;
            private Object factNum;
            private Object sendNum;
            private Object refundNum;
            private Object unitMoney;
            private Object money;
            private Object voucherImg;
            private Object receiveType;
            private Object name;
            private Object mobile;
            private Object address;
            private Object remark1;
            private Object remark2;
            private Object remark3;
            private Object doStatus;
            private String createTime;
            private Object updateTime;
            private Object status;
            private Object custName;
            private Object custMobile;
            private Object isAgency;
            private Object isDistributor;
            private String createTime2;
            private Object custRole;
            private Object money2;
            private Object unitMoney2;
            private Object custId;
            private Object creater;
            private Object accountNo;
            private Object zzje;
            private Object yecl;
            private Object initnum;
            private Object payType;
            private Object addressId;
            private Object realName;
            private Object stock;
            private Object mobile2;
            private Object count;
            private Object addressOr;
            private Object state;
            private Object createTimeone;
            private Object createTimetwo;
            private Object outstock;
            private Object benifit;
            private Object id;
            private Object updateTime2;
            private Object updateTimeone;
            private Object updateTimetwo;
            private Object infoList;
            private Object nickname;
            private Object headImg;
            private Object transferNo;
            private Object totalAmount;
            private Object returnType;
            private Object totalAmount2;
            private int ct;
            private Object curFor1;
            private Object onlinePay;
            private Object offlinePay;
            private Object balancePay;
            private Object onlinepayType;
            private Object applyCount;

            public String getPaId() {
                return paId;
            }

            public void setPaId(String paId) {
                this.paId = paId;
            }

            public Object getPtypeId() {
                return ptypeId;
            }

            public void setPtypeId(Object ptypeId) {
                this.ptypeId = ptypeId;
            }

            public String getPtypeName() {
                return ptypeName;
            }

            public void setPtypeName(String ptypeName) {
                this.ptypeName = ptypeName;
            }

            public Object getProductId() {
                return productId;
            }

            public void setProductId(Object productId) {
                this.productId = productId;
            }

            public Object getApplyType() {
                return applyType;
            }

            public void setApplyType(Object applyType) {
                this.applyType = applyType;
            }

            public Object getSendType() {
                return sendType;
            }

            public void setSendType(Object sendType) {
                this.sendType = sendType;
            }

            public Object getCurFor() {
                return curFor;
            }

            public void setCurFor(Object curFor) {
                this.curFor = curFor;
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

            public Object getC1custId() {
                return c1custId;
            }

            public void setC1custId(Object c1custId) {
                this.c1custId = c1custId;
            }

            public Object getC2custId() {
                return c2custId;
            }

            public void setC2custId(Object c2custId) {
                this.c2custId = c2custId;
            }

            public int getApplyNum() {
                return applyNum;
            }

            public void setApplyNum(int applyNum) {
                this.applyNum = applyNum;
            }

            public Object getFactNum() {
                return factNum;
            }

            public void setFactNum(Object factNum) {
                this.factNum = factNum;
            }

            public Object getSendNum() {
                return sendNum;
            }

            public void setSendNum(Object sendNum) {
                this.sendNum = sendNum;
            }

            public Object getRefundNum() {
                return refundNum;
            }

            public void setRefundNum(Object refundNum) {
                this.refundNum = refundNum;
            }

            public Object getUnitMoney() {
                return unitMoney;
            }

            public void setUnitMoney(Object unitMoney) {
                this.unitMoney = unitMoney;
            }

            public Object getMoney() {
                return money;
            }

            public void setMoney(Object money) {
                this.money = money;
            }

            public Object getVoucherImg() {
                return voucherImg;
            }

            public void setVoucherImg(Object voucherImg) {
                this.voucherImg = voucherImg;
            }

            public Object getReceiveType() {
                return receiveType;
            }

            public void setReceiveType(Object receiveType) {
                this.receiveType = receiveType;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public Object getAddress() {
                return address;
            }

            public void setAddress(Object address) {
                this.address = address;
            }

            public Object getRemark1() {
                return remark1;
            }

            public void setRemark1(Object remark1) {
                this.remark1 = remark1;
            }

            public Object getRemark2() {
                return remark2;
            }

            public void setRemark2(Object remark2) {
                this.remark2 = remark2;
            }

            public Object getRemark3() {
                return remark3;
            }

            public void setRemark3(Object remark3) {
                this.remark3 = remark3;
            }

            public Object getDoStatus() {
                return doStatus;
            }

            public void setDoStatus(Object doStatus) {
                this.doStatus = doStatus;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

            public Object getCustName() {
                return custName;
            }

            public void setCustName(Object custName) {
                this.custName = custName;
            }

            public Object getCustMobile() {
                return custMobile;
            }

            public void setCustMobile(Object custMobile) {
                this.custMobile = custMobile;
            }

            public Object getIsAgency() {
                return isAgency;
            }

            public void setIsAgency(Object isAgency) {
                this.isAgency = isAgency;
            }

            public Object getIsDistributor() {
                return isDistributor;
            }

            public void setIsDistributor(Object isDistributor) {
                this.isDistributor = isDistributor;
            }

            public String getCreateTime2() {
                return createTime2;
            }

            public void setCreateTime2(String createTime2) {
                this.createTime2 = createTime2;
            }

            public Object getCustRole() {
                return custRole;
            }

            public void setCustRole(Object custRole) {
                this.custRole = custRole;
            }

            public Object getMoney2() {
                return money2;
            }

            public void setMoney2(Object money2) {
                this.money2 = money2;
            }

            public Object getUnitMoney2() {
                return unitMoney2;
            }

            public void setUnitMoney2(Object unitMoney2) {
                this.unitMoney2 = unitMoney2;
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

            public Object getAccountNo() {
                return accountNo;
            }

            public void setAccountNo(Object accountNo) {
                this.accountNo = accountNo;
            }

            public Object getZzje() {
                return zzje;
            }

            public void setZzje(Object zzje) {
                this.zzje = zzje;
            }

            public Object getYecl() {
                return yecl;
            }

            public void setYecl(Object yecl) {
                this.yecl = yecl;
            }

            public Object getInitnum() {
                return initnum;
            }

            public void setInitnum(Object initnum) {
                this.initnum = initnum;
            }

            public Object getPayType() {
                return payType;
            }

            public void setPayType(Object payType) {
                this.payType = payType;
            }

            public Object getAddressId() {
                return addressId;
            }

            public void setAddressId(Object addressId) {
                this.addressId = addressId;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
            }

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
                this.stock = stock;
            }

            public Object getMobile2() {
                return mobile2;
            }

            public void setMobile2(Object mobile2) {
                this.mobile2 = mobile2;
            }

            public Object getCount() {
                return count;
            }

            public void setCount(Object count) {
                this.count = count;
            }

            public Object getAddressOr() {
                return addressOr;
            }

            public void setAddressOr(Object addressOr) {
                this.addressOr = addressOr;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getCreateTimeone() {
                return createTimeone;
            }

            public void setCreateTimeone(Object createTimeone) {
                this.createTimeone = createTimeone;
            }

            public Object getCreateTimetwo() {
                return createTimetwo;
            }

            public void setCreateTimetwo(Object createTimetwo) {
                this.createTimetwo = createTimetwo;
            }

            public Object getOutstock() {
                return outstock;
            }

            public void setOutstock(Object outstock) {
                this.outstock = outstock;
            }

            public Object getBenifit() {
                return benifit;
            }

            public void setBenifit(Object benifit) {
                this.benifit = benifit;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public Object getUpdateTime2() {
                return updateTime2;
            }

            public void setUpdateTime2(Object updateTime2) {
                this.updateTime2 = updateTime2;
            }

            public Object getUpdateTimeone() {
                return updateTimeone;
            }

            public void setUpdateTimeone(Object updateTimeone) {
                this.updateTimeone = updateTimeone;
            }

            public Object getUpdateTimetwo() {
                return updateTimetwo;
            }

            public void setUpdateTimetwo(Object updateTimetwo) {
                this.updateTimetwo = updateTimetwo;
            }

            public Object getInfoList() {
                return infoList;
            }

            public void setInfoList(Object infoList) {
                this.infoList = infoList;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
            }

            public Object getTransferNo() {
                return transferNo;
            }

            public void setTransferNo(Object transferNo) {
                this.transferNo = transferNo;
            }

            public Object getTotalAmount() {
                return totalAmount;
            }

            public void setTotalAmount(Object totalAmount) {
                this.totalAmount = totalAmount;
            }

            public Object getReturnType() {
                return returnType;
            }

            public void setReturnType(Object returnType) {
                this.returnType = returnType;
            }

            public Object getTotalAmount2() {
                return totalAmount2;
            }

            public void setTotalAmount2(Object totalAmount2) {
                this.totalAmount2 = totalAmount2;
            }

            public int getCt() {
                return ct;
            }

            public void setCt(int ct) {
                this.ct = ct;
            }

            public Object getCurFor1() {
                return curFor1;
            }

            public void setCurFor1(Object curFor1) {
                this.curFor1 = curFor1;
            }

            public Object getOnlinePay() {
                return onlinePay;
            }

            public void setOnlinePay(Object onlinePay) {
                this.onlinePay = onlinePay;
            }

            public Object getOfflinePay() {
                return offlinePay;
            }

            public void setOfflinePay(Object offlinePay) {
                this.offlinePay = offlinePay;
            }

            public Object getBalancePay() {
                return balancePay;
            }

            public void setBalancePay(Object balancePay) {
                this.balancePay = balancePay;
            }

            public Object getOnlinepayType() {
                return onlinepayType;
            }

            public void setOnlinepayType(Object onlinepayType) {
                this.onlinepayType = onlinepayType;
            }

            public Object getApplyCount() {
                return applyCount;
            }

            public void setApplyCount(Object applyCount) {
                this.applyCount = applyCount;
            }
        }
    }
}

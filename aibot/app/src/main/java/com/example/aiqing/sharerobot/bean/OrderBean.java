package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/11.
 */

public class OrderBean {


    /**
     * orderList : {"size":15,"total":1,"currentPage":1,"totalPage":1,"currentResult":0,"result":[{"paId":null,"ptypeId":null,"ptypeName":null,"productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":null,"factNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":"18767160538","address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":"5","createTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":null,"custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"headImg":"img/170711165414076009.jpg","mobile2":null,"count":"5"}]}
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
         * total : 1
         * currentPage : 1
         * totalPage : 1
         * currentResult : 0
         * result : [{"paId":null,"ptypeId":null,"ptypeName":null,"productId":null,"applyType":null,"sendType":null,"curFor":null,"agencyId":null,"acustId":null,"distributorId":null,"bcustId":null,"c1custId":null,"c2custId":null,"applyNum":null,"factNum":null,"unitMoney":null,"money":null,"voucherImg":null,"receiveType":null,"name":null,"mobile":"18767160538","address":null,"remark1":null,"remark2":null,"remark3":null,"doStatus":"5","createTime":null,"status":null,"custName":null,"custMobile":null,"isAgency":null,"isDistributor":null,"createTime2":null,"custRole":null,"money2":null,"unitMoney2":null,"custId":null,"creater":null,"accountNo":null,"zzje":null,"yecl":null,"initnum":null,"payType":null,"addressId":null,"realName":null,"stock":null,"headImg":"img/170711165414076009.jpg","mobile2":null,"count":"5"}]
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
             * paId : null
             * ptypeId : null
             * ptypeName : null
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
             * applyNum : null
             * factNum : null
             * unitMoney : null
             * money : null
             * voucherImg : null
             * receiveType : null
             * name : null
             * mobile : 18767160538
             * address : null
             * remark1 : null
             * remark2 : null
             * remark3 : null
             * doStatus : 5
             * createTime : null
             * status : null
             * custName : null
             * custMobile : null
             * isAgency : null
             * isDistributor : null
             * createTime2 : null
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
             * headImg : img/170711165414076009.jpg
             * mobile2 : null
             * count : 5
             */

            private Object paId;
            private Object ptypeId;
            private Object ptypeName;
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
            private Object applyNum;
            private Object factNum;
            private Object unitMoney;
            private Object money;
            private Object voucherImg;
            private Object receiveType;
            private Object name;
            private String mobile;
            private Object address;
            private Object remark1;
            private Object remark2;
            private Object remark3;
            private String doStatus;
            private Object createTime;
            private Object status;
            private Object custName;
            private Object custMobile;
            private Object isAgency;
            private Object isDistributor;
            private Object createTime2;
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
            private String headImg;
            private Object mobile2;
            private String count;

            public Object getPaId() {
                return paId;
            }

            public void setPaId(Object paId) {
                this.paId = paId;
            }

            public Object getPtypeId() {
                return ptypeId;
            }

            public void setPtypeId(Object ptypeId) {
                this.ptypeId = ptypeId;
            }

            public Object getPtypeName() {
                return ptypeName;
            }

            public void setPtypeName(Object ptypeName) {
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

            public Object getApplyNum() {
                return applyNum;
            }

            public void setApplyNum(Object applyNum) {
                this.applyNum = applyNum;
            }

            public Object getFactNum() {
                return factNum;
            }

            public void setFactNum(Object factNum) {
                this.factNum = factNum;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
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

            public String getDoStatus() {
                return doStatus;
            }

            public void setDoStatus(String doStatus) {
                this.doStatus = doStatus;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
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

            public Object getCreateTime2() {
                return createTime2;
            }

            public void setCreateTime2(Object createTime2) {
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

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public Object getMobile2() {
                return mobile2;
            }

            public void setMobile2(Object mobile2) {
                this.mobile2 = mobile2;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }
        }
    }
}

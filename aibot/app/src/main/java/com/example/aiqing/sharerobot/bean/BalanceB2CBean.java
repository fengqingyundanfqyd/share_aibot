package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/23.
 */

public class BalanceB2CBean {

    /**
     * coder : 0000
     * obj : {"code":"0","orderId":null,"agencyId":null,"distributorId":null,"productId":null,"mjje":null,"xzfje":0,"addressId":null,"ptypeId":null,"paId":"170923111357218245","pTypeName":null,"xzfNum":0,"c1CustId":null,"page":null,"createTime":null,"feeMark":null,"factPay":null,"mch_id":null,"payType":null,"depositPay":null,"yjPaId":null,"cdId":null,"totalMoney":null}
     * errorMsg : null
     * transNo : null
     * sign : null
     * success : true
     */

    private String coder;
    private ObjBean obj;
    private Object errorMsg;
    private Object transNo;
    private Object sign;
    private boolean success;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getTransNo() {
        return transNo;
    }

    public void setTransNo(Object transNo) {
        this.transNo = transNo;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class ObjBean {
        /**
         * code : 0
         * orderId : null
         * agencyId : null
         * distributorId : null
         * productId : null
         * mjje : null
         * xzfje : 0
         * addressId : null
         * ptypeId : null
         * paId : 170923111357218245
         * pTypeName : null
         * xzfNum : 0
         * c1CustId : null
         * page : null
         * createTime : null
         * feeMark : null
         * factPay : null
         * mch_id : null
         * payType : null
         * depositPay : null
         * yjPaId : null
         * cdId : null
         * totalMoney : null
         */

        private String code;
        private Object orderId;
        private Object agencyId;
        private Object distributorId;
        private Object productId;
        private Object mjje;
        private int xzfje;
        private Object addressId;
        private Object ptypeId;
        private String paId;
        private Object pTypeName;
        private int xzfNum;
        private Object c1CustId;
        private Object page;
        private Object createTime;
        private Object feeMark;
        private Object factPay;
        private Object mch_id;
        private Object payType;
        private Object depositPay;
        private Object yjPaId;
        private Object cdId;
        private Object totalMoney;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Object getOrderId() {
            return orderId;
        }

        public void setOrderId(Object orderId) {
            this.orderId = orderId;
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

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public Object getMjje() {
            return mjje;
        }

        public void setMjje(Object mjje) {
            this.mjje = mjje;
        }

        public int getXzfje() {
            return xzfje;
        }

        public void setXzfje(int xzfje) {
            this.xzfje = xzfje;
        }

        public Object getAddressId() {
            return addressId;
        }

        public void setAddressId(Object addressId) {
            this.addressId = addressId;
        }

        public Object getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(Object ptypeId) {
            this.ptypeId = ptypeId;
        }

        public String getPaId() {
            return paId;
        }

        public void setPaId(String paId) {
            this.paId = paId;
        }

        public Object getPTypeName() {
            return pTypeName;
        }

        public void setPTypeName(Object pTypeName) {
            this.pTypeName = pTypeName;
        }

        public int getXzfNum() {
            return xzfNum;
        }

        public void setXzfNum(int xzfNum) {
            this.xzfNum = xzfNum;
        }

        public Object getC1CustId() {
            return c1CustId;
        }

        public void setC1CustId(Object c1CustId) {
            this.c1CustId = c1CustId;
        }

        public Object getPage() {
            return page;
        }

        public void setPage(Object page) {
            this.page = page;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getFeeMark() {
            return feeMark;
        }

        public void setFeeMark(Object feeMark) {
            this.feeMark = feeMark;
        }

        public Object getFactPay() {
            return factPay;
        }

        public void setFactPay(Object factPay) {
            this.factPay = factPay;
        }

        public Object getMch_id() {
            return mch_id;
        }

        public void setMch_id(Object mch_id) {
            this.mch_id = mch_id;
        }

        public Object getPayType() {
            return payType;
        }

        public void setPayType(Object payType) {
            this.payType = payType;
        }

        public Object getDepositPay() {
            return depositPay;
        }

        public void setDepositPay(Object depositPay) {
            this.depositPay = depositPay;
        }

        public Object getYjPaId() {
            return yjPaId;
        }

        public void setYjPaId(Object yjPaId) {
            this.yjPaId = yjPaId;
        }

        public Object getCdId() {
            return cdId;
        }

        public void setCdId(Object cdId) {
            this.cdId = cdId;
        }

        public Object getTotalMoney() {
            return totalMoney;
        }

        public void setTotalMoney(Object totalMoney) {
            this.totalMoney = totalMoney;
        }
    }
}

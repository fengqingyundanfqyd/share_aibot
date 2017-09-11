package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/9.
 */

public class PutManagerBean {


    /**
     * coder : 0000
     * obj : {"id":null,"accountId":null,"custId":null,"type":null,"changeMoney":null,"balance":null,"cDeposit":null,"aDeposit":null,"bDeposit":8991,"withdraw":null,"onlinePay":null,"offlinePay":null,"balancePay":null,"cutPay":null,"coupon1Pay":null,"coupon2Pay":null,"onlinepayType":null,"cardId":null,"onlinepayNo":null,"offlineId":null,"paId":null,"raId":null,"ptypeId":null,"ptypeName":null,"productId":null,"orderId":null,"refundsId":null,"forfeitId":null,"accId":null,"cunitDeposit":null,"cdepositNum":null,"ccurNum":null,"aunitDeposit":null,"adepositNum":null,"acurNum":null,"bunitDeposit":null,"bdepositNum":null,"bcurNum":null,"taxPoint":null,"tax":null,"createTime":null,"paydoneTime":null,"name":"飞刀","statusOne":null,"statusZero":null,"balanceor":0,"changeMoneyor":0,"bDepost":null,"zjMoney":"2560.0024","kcNum":16,"resetNum":9,"usedNum":9,"needSendNum":10,"needReciveNum":1,"payTime":null,"delayPay":null}
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
         * id : null
         * accountId : null
         * custId : null
         * type : null
         * changeMoney : null
         * balance : null
         * cDeposit : null
         * aDeposit : null
         * bDeposit : 8991.0
         * withdraw : null
         * onlinePay : null
         * offlinePay : null
         * balancePay : null
         * cutPay : null
         * coupon1Pay : null
         * coupon2Pay : null
         * onlinepayType : null
         * cardId : null
         * onlinepayNo : null
         * offlineId : null
         * paId : null
         * raId : null
         * ptypeId : null
         * ptypeName : null
         * productId : null
         * orderId : null
         * refundsId : null
         * forfeitId : null
         * accId : null
         * cunitDeposit : null
         * cdepositNum : null
         * ccurNum : null
         * aunitDeposit : null
         * adepositNum : null
         * acurNum : null
         * bunitDeposit : null
         * bdepositNum : null
         * bcurNum : null
         * taxPoint : null
         * tax : null
         * createTime : null
         * paydoneTime : null
         * name : 飞刀
         * statusOne : null
         * statusZero : null
         * balanceor : 0.0
         * changeMoneyor : 0.0
         * bDepost : null
         * zjMoney : 2560.0024
         * kcNum : 16
         * resetNum : 9
         * usedNum : 9
         * needSendNum : 10
         * needReciveNum : 1
         * payTime : null
         * delayPay : null
         */

        private Object id;
        private Object accountId;
        private Object custId;
        private Object type;
        private Object changeMoney;
        private Object balance;
        private Object cDeposit;
        private Object aDeposit;
        private double bDeposit;
        private Object withdraw;
        private Object onlinePay;
        private Object offlinePay;
        private Object balancePay;
        private Object cutPay;
        private Object coupon1Pay;
        private Object coupon2Pay;
        private Object onlinepayType;
        private Object cardId;
        private Object onlinepayNo;
        private Object offlineId;
        private Object paId;
        private Object raId;
        private Object ptypeId;
        private Object ptypeName;
        private Object productId;
        private Object orderId;
        private Object refundsId;
        private Object forfeitId;
        private Object accId;
        private Object cunitDeposit;
        private Object cdepositNum;
        private Object ccurNum;
        private Object aunitDeposit;
        private Object adepositNum;
        private Object acurNum;
        private Object bunitDeposit;
        private Object bdepositNum;
        private Object bcurNum;
        private Object taxPoint;
        private Object tax;
        private Object createTime;
        private Object paydoneTime;
        private String name;
        private Object statusOne;
        private Object statusZero;
        private double balanceor;
        private double changeMoneyor;
        private Object bDepost;
        private String zjMoney;
        private int kcNum;
        private int resetNum;
        private int usedNum;
        private int needSendNum;
        private int needReciveNum;
        private Object payTime;
        private Object delayPay;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getAccountId() {
            return accountId;
        }

        public void setAccountId(Object accountId) {
            this.accountId = accountId;
        }

        public Object getCustId() {
            return custId;
        }

        public void setCustId(Object custId) {
            this.custId = custId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getChangeMoney() {
            return changeMoney;
        }

        public void setChangeMoney(Object changeMoney) {
            this.changeMoney = changeMoney;
        }

        public Object getBalance() {
            return balance;
        }

        public void setBalance(Object balance) {
            this.balance = balance;
        }

        public Object getCDeposit() {
            return cDeposit;
        }

        public void setCDeposit(Object cDeposit) {
            this.cDeposit = cDeposit;
        }

        public Object getADeposit() {
            return aDeposit;
        }

        public void setADeposit(Object aDeposit) {
            this.aDeposit = aDeposit;
        }

        public double getBDeposit() {
            return bDeposit;
        }

        public void setBDeposit(double bDeposit) {
            this.bDeposit = bDeposit;
        }

        public Object getWithdraw() {
            return withdraw;
        }

        public void setWithdraw(Object withdraw) {
            this.withdraw = withdraw;
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

        public Object getCutPay() {
            return cutPay;
        }

        public void setCutPay(Object cutPay) {
            this.cutPay = cutPay;
        }

        public Object getCoupon1Pay() {
            return coupon1Pay;
        }

        public void setCoupon1Pay(Object coupon1Pay) {
            this.coupon1Pay = coupon1Pay;
        }

        public Object getCoupon2Pay() {
            return coupon2Pay;
        }

        public void setCoupon2Pay(Object coupon2Pay) {
            this.coupon2Pay = coupon2Pay;
        }

        public Object getOnlinepayType() {
            return onlinepayType;
        }

        public void setOnlinepayType(Object onlinepayType) {
            this.onlinepayType = onlinepayType;
        }

        public Object getCardId() {
            return cardId;
        }

        public void setCardId(Object cardId) {
            this.cardId = cardId;
        }

        public Object getOnlinepayNo() {
            return onlinepayNo;
        }

        public void setOnlinepayNo(Object onlinepayNo) {
            this.onlinepayNo = onlinepayNo;
        }

        public Object getOfflineId() {
            return offlineId;
        }

        public void setOfflineId(Object offlineId) {
            this.offlineId = offlineId;
        }

        public Object getPaId() {
            return paId;
        }

        public void setPaId(Object paId) {
            this.paId = paId;
        }

        public Object getRaId() {
            return raId;
        }

        public void setRaId(Object raId) {
            this.raId = raId;
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

        public Object getOrderId() {
            return orderId;
        }

        public void setOrderId(Object orderId) {
            this.orderId = orderId;
        }

        public Object getRefundsId() {
            return refundsId;
        }

        public void setRefundsId(Object refundsId) {
            this.refundsId = refundsId;
        }

        public Object getForfeitId() {
            return forfeitId;
        }

        public void setForfeitId(Object forfeitId) {
            this.forfeitId = forfeitId;
        }

        public Object getAccId() {
            return accId;
        }

        public void setAccId(Object accId) {
            this.accId = accId;
        }

        public Object getCunitDeposit() {
            return cunitDeposit;
        }

        public void setCunitDeposit(Object cunitDeposit) {
            this.cunitDeposit = cunitDeposit;
        }

        public Object getCdepositNum() {
            return cdepositNum;
        }

        public void setCdepositNum(Object cdepositNum) {
            this.cdepositNum = cdepositNum;
        }

        public Object getCcurNum() {
            return ccurNum;
        }

        public void setCcurNum(Object ccurNum) {
            this.ccurNum = ccurNum;
        }

        public Object getAunitDeposit() {
            return aunitDeposit;
        }

        public void setAunitDeposit(Object aunitDeposit) {
            this.aunitDeposit = aunitDeposit;
        }

        public Object getAdepositNum() {
            return adepositNum;
        }

        public void setAdepositNum(Object adepositNum) {
            this.adepositNum = adepositNum;
        }

        public Object getAcurNum() {
            return acurNum;
        }

        public void setAcurNum(Object acurNum) {
            this.acurNum = acurNum;
        }

        public Object getBunitDeposit() {
            return bunitDeposit;
        }

        public void setBunitDeposit(Object bunitDeposit) {
            this.bunitDeposit = bunitDeposit;
        }

        public Object getBdepositNum() {
            return bdepositNum;
        }

        public void setBdepositNum(Object bdepositNum) {
            this.bdepositNum = bdepositNum;
        }

        public Object getBcurNum() {
            return bcurNum;
        }

        public void setBcurNum(Object bcurNum) {
            this.bcurNum = bcurNum;
        }

        public Object getTaxPoint() {
            return taxPoint;
        }

        public void setTaxPoint(Object taxPoint) {
            this.taxPoint = taxPoint;
        }

        public Object getTax() {
            return tax;
        }

        public void setTax(Object tax) {
            this.tax = tax;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getPaydoneTime() {
            return paydoneTime;
        }

        public void setPaydoneTime(Object paydoneTime) {
            this.paydoneTime = paydoneTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getStatusOne() {
            return statusOne;
        }

        public void setStatusOne(Object statusOne) {
            this.statusOne = statusOne;
        }

        public Object getStatusZero() {
            return statusZero;
        }

        public void setStatusZero(Object statusZero) {
            this.statusZero = statusZero;
        }

        public double getBalanceor() {
            return balanceor;
        }

        public void setBalanceor(double balanceor) {
            this.balanceor = balanceor;
        }

        public double getChangeMoneyor() {
            return changeMoneyor;
        }

        public void setChangeMoneyor(double changeMoneyor) {
            this.changeMoneyor = changeMoneyor;
        }

        public Object getBDepost() {
            return bDepost;
        }

        public void setBDepost(Object bDepost) {
            this.bDepost = bDepost;
        }

        public String getZjMoney() {
            return zjMoney;
        }

        public void setZjMoney(String zjMoney) {
            this.zjMoney = zjMoney;
        }

        public int getKcNum() {
            return kcNum;
        }

        public void setKcNum(int kcNum) {
            this.kcNum = kcNum;
        }

        public int getResetNum() {
            return resetNum;
        }

        public void setResetNum(int resetNum) {
            this.resetNum = resetNum;
        }

        public int getUsedNum() {
            return usedNum;
        }

        public void setUsedNum(int usedNum) {
            this.usedNum = usedNum;
        }

        public int getNeedSendNum() {
            return needSendNum;
        }

        public void setNeedSendNum(int needSendNum) {
            this.needSendNum = needSendNum;
        }

        public int getNeedReciveNum() {
            return needReciveNum;
        }

        public void setNeedReciveNum(int needReciveNum) {
            this.needReciveNum = needReciveNum;
        }

        public Object getPayTime() {
            return payTime;
        }

        public void setPayTime(Object payTime) {
            this.payTime = payTime;
        }

        public Object getDelayPay() {
            return delayPay;
        }

        public void setDelayPay(Object delayPay) {
            this.delayPay = delayPay;
        }
    }
}

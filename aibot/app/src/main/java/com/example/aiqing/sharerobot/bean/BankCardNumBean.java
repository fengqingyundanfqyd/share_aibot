package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/15.
 */

public class BankCardNumBean {

    /**
     * coder : 0000
     * obj : {"cardId":null,"custId":null,"authStatus":null,"cardType":null,"accountName":null,"cardNo":null,"cardBank":"04437010","bankAddr":"贵阳市商业银行","bindingMobile":null,"transAmount":null,"authDesc":null,"validateDendline":null,"checkTime":null,"checkUser":null,"verifyTime":null,"createTime":null,"updateTime":null,"status":null}
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
         * cardId : null
         * custId : null
         * authStatus : null
         * cardType : null
         * accountName : null
         * cardNo : null
         * cardBank : 04437010
         * bankAddr : 贵阳市商业银行
         * bindingMobile : null
         * transAmount : null
         * authDesc : null
         * validateDendline : null
         * checkTime : null
         * checkUser : null
         * verifyTime : null
         * createTime : null
         * updateTime : null
         * status : null
         */

        private Object cardId;
        private Object custId;
        private Object authStatus;
        private Object cardType;
        private Object accountName;
        private Object cardNo;
        private String cardBank;
        private String bankAddr;
        private Object bindingMobile;
        private Object transAmount;
        private Object authDesc;
        private Object validateDendline;
        private Object checkTime;
        private Object checkUser;
        private Object verifyTime;
        private Object createTime;
        private Object updateTime;
        private Object status;

        public Object getCardId() {
            return cardId;
        }

        public void setCardId(Object cardId) {
            this.cardId = cardId;
        }

        public Object getCustId() {
            return custId;
        }

        public void setCustId(Object custId) {
            this.custId = custId;
        }

        public Object getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(Object authStatus) {
            this.authStatus = authStatus;
        }

        public Object getCardType() {
            return cardType;
        }

        public void setCardType(Object cardType) {
            this.cardType = cardType;
        }

        public Object getAccountName() {
            return accountName;
        }

        public void setAccountName(Object accountName) {
            this.accountName = accountName;
        }

        public Object getCardNo() {
            return cardNo;
        }

        public void setCardNo(Object cardNo) {
            this.cardNo = cardNo;
        }

        public String getCardBank() {
            return cardBank;
        }

        public void setCardBank(String cardBank) {
            this.cardBank = cardBank;
        }

        public String getBankAddr() {
            return bankAddr;
        }

        public void setBankAddr(String bankAddr) {
            this.bankAddr = bankAddr;
        }

        public Object getBindingMobile() {
            return bindingMobile;
        }

        public void setBindingMobile(Object bindingMobile) {
            this.bindingMobile = bindingMobile;
        }

        public Object getTransAmount() {
            return transAmount;
        }

        public void setTransAmount(Object transAmount) {
            this.transAmount = transAmount;
        }

        public Object getAuthDesc() {
            return authDesc;
        }

        public void setAuthDesc(Object authDesc) {
            this.authDesc = authDesc;
        }

        public Object getValidateDendline() {
            return validateDendline;
        }

        public void setValidateDendline(Object validateDendline) {
            this.validateDendline = validateDendline;
        }

        public Object getCheckTime() {
            return checkTime;
        }

        public void setCheckTime(Object checkTime) {
            this.checkTime = checkTime;
        }

        public Object getCheckUser() {
            return checkUser;
        }

        public void setCheckUser(Object checkUser) {
            this.checkUser = checkUser;
        }

        public Object getVerifyTime() {
            return verifyTime;
        }

        public void setVerifyTime(Object verifyTime) {
            this.verifyTime = verifyTime;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
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
    }
}

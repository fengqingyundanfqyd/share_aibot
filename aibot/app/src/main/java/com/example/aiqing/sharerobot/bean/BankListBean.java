package com.example.aiqing.sharerobot.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aiqing on 2017/9/15.
 */

public class BankListBean  implements Serializable {

    /**
     * coder : 0000
     * obj : [{"cardId":"3","custId":"170814204152864028","authStatus":"1","cardType":"1","accountName":"熊二","cardNo":"6222021202033733479","cardBank":"0102","bankAddr":"中国工商银行·E时代卡","bindingMobile":"13225642590","transAmount":null,"authDesc":null,"validateDendline":null,"checkTime":null,"checkUser":null,"verifyTime":null,"createTime":"2017-09-16 11:55:53","updateTime":null,"status":"1"}]
     * errorMsg : null
     * transNo : null
     * sign : null
     * success : true
     */

    private String coder;
    private Object errorMsg;
    private Object transNo;
    private Object sign;
    private boolean success;
    private List<ObjBean> obj;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
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

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean implements Serializable{
        /**
         * cardId : 3
         * custId : 170814204152864028
         * authStatus : 1
         * cardType : 1
         * accountName : 熊二
         * cardNo : 6222021202033733479
         * cardBank : 0102
         * bankAddr : 中国工商银行·E时代卡
         * bindingMobile : 13225642590
         * transAmount : null
         * authDesc : null
         * validateDendline : null
         * checkTime : null
         * checkUser : null
         * verifyTime : null
         * createTime : 2017-09-16 11:55:53
         * updateTime : null
         * status : 1
         */

        private String cardId;
        private String custId;
        private String authStatus;
        private String cardType;
        private String accountName;
        private String cardNo;
        private String cardBank;
        private String bankAddr;
        private String bindingMobile;
        private Object transAmount;
        private Object authDesc;
        private Object validateDendline;
        private Object checkTime;
        private Object checkUser;
        private Object verifyTime;
        private String createTime;
        private Object updateTime;
        private String status;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public String getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(String authStatus) {
            this.authStatus = authStatus;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
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

        public String getBindingMobile() {
            return bindingMobile;
        }

        public void setBindingMobile(String bindingMobile) {
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

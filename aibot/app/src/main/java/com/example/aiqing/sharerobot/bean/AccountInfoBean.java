package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/15.
 */

public class AccountInfoBean {

    /**
     * coder : 0000
     * obj : {"accountId":"170815094426766048","custId":"170815094426760047","balance":18839.6672,"cDeposit":0.87,"aDeposit":9991998,"bDeposit":29970.01,"withdraw":0,"createTime":"2017-08-15 09:44:27","status":"1","deposit":null,"balance2":null,"dzfje":null,"accountRecId":null,"pTypeId":null,"body":null,"changeMoney":null}
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
         * accountId : 170815094426766048
         * custId : 170815094426760047
         * balance : 18839.6672
         * cDeposit : 0.87
         * aDeposit : 9991998.0
         * bDeposit : 29970.01
         * withdraw : 0.0
         * createTime : 2017-08-15 09:44:27
         * status : 1
         * deposit : null
         * balance2 : null
         * dzfje : null
         * accountRecId : null
         * pTypeId : null
         * body : null
         * changeMoney : null
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
        private Object deposit;
        private Object balance2;
        private Object dzfje;
        private Object accountRecId;
        private Object pTypeId;
        private Object body;
        private Object changeMoney;

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

        public Object getDeposit() {
            return deposit;
        }

        public void setDeposit(Object deposit) {
            this.deposit = deposit;
        }

        public Object getBalance2() {
            return balance2;
        }

        public void setBalance2(Object balance2) {
            this.balance2 = balance2;
        }

        public Object getDzfje() {
            return dzfje;
        }

        public void setDzfje(Object dzfje) {
            this.dzfje = dzfje;
        }

        public Object getAccountRecId() {
            return accountRecId;
        }

        public void setAccountRecId(Object accountRecId) {
            this.accountRecId = accountRecId;
        }

        public Object getPTypeId() {
            return pTypeId;
        }

        public void setPTypeId(Object pTypeId) {
            this.pTypeId = pTypeId;
        }

        public Object getBody() {
            return body;
        }

        public void setBody(Object body) {
            this.body = body;
        }

        public Object getChangeMoney() {
            return changeMoney;
        }

        public void setChangeMoney(Object changeMoney) {
            this.changeMoney = changeMoney;
        }
    }
}

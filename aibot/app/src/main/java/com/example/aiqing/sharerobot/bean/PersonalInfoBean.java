package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/9.
 */

public class PersonalInfoBean {

    /**
     * coder : 0000
     * obj : {"custId":"1","realName":"陆恩辉","headImg":"img/170703182505045000.jpg","mobile":"18768163700","nickname":"Shushaoyong","sex":"0","idNum":"331082198912137877","loginPwd":null,"loginpwdsalt":null,"loginErrTimes":null,"isLock":null,"lockTime":null,"loginTime":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"isAgency":"1","isDistributor":"1","openId":null,"comeFrom":null,"custStatus":null,"balance":6,"agencyId":"1","distributorId":"4"}
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
         * custId : 1
         * realName : 陆恩辉
         * headImg : img/170703182505045000.jpg
         * mobile : 18768163700
         * nickname : Shushaoyong
         * sex : 0
         * idNum : 331082198912137877
         * loginPwd : null
         * loginpwdsalt : null
         * loginErrTimes : null
         * isLock : null
         * lockTime : null
         * loginTime : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * isAgency : 1
         * isDistributor : 1
         * openId : null
         * comeFrom : null
         * custStatus : null
         * balance : 6.0
         * agencyId : 1
         * distributorId : 4
         */

        private String custId;
        private String realName;
        private String headImg;
        private String mobile;
        private String nickname;
        private String sex;
        private String idNum;
        private Object loginPwd;
        private Object loginpwdsalt;
        private Object loginErrTimes;
        private Object isLock;
        private Object lockTime;
        private Object loginTime;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private String isAgency;
        private String isDistributor;
        private Object openId;
        private Object comeFrom;
        private Object custStatus;
        private double balance;
        private String agencyId;
        private String distributorId;

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIdNum() {
            return idNum;
        }

        public void setIdNum(String idNum) {
            this.idNum = idNum;
        }

        public Object getLoginPwd() {
            return loginPwd;
        }

        public void setLoginPwd(Object loginPwd) {
            this.loginPwd = loginPwd;
        }

        public Object getLoginpwdsalt() {
            return loginpwdsalt;
        }

        public void setLoginpwdsalt(Object loginpwdsalt) {
            this.loginpwdsalt = loginpwdsalt;
        }

        public Object getLoginErrTimes() {
            return loginErrTimes;
        }

        public void setLoginErrTimes(Object loginErrTimes) {
            this.loginErrTimes = loginErrTimes;
        }

        public Object getIsLock() {
            return isLock;
        }

        public void setIsLock(Object isLock) {
            this.isLock = isLock;
        }

        public Object getLockTime() {
            return lockTime;
        }

        public void setLockTime(Object lockTime) {
            this.lockTime = lockTime;
        }

        public Object getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Object loginTime) {
            this.loginTime = loginTime;
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

        public String getIsAgency() {
            return isAgency;
        }

        public void setIsAgency(String isAgency) {
            this.isAgency = isAgency;
        }

        public String getIsDistributor() {
            return isDistributor;
        }

        public void setIsDistributor(String isDistributor) {
            this.isDistributor = isDistributor;
        }

        public Object getOpenId() {
            return openId;
        }

        public void setOpenId(Object openId) {
            this.openId = openId;
        }

        public Object getComeFrom() {
            return comeFrom;
        }

        public void setComeFrom(Object comeFrom) {
            this.comeFrom = comeFrom;
        }

        public Object getCustStatus() {
            return custStatus;
        }

        public void setCustStatus(Object custStatus) {
            this.custStatus = custStatus;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(String agencyId) {
            this.agencyId = agencyId;
        }

        public String getDistributorId() {
            return distributorId;
        }

        public void setDistributorId(String distributorId) {
            this.distributorId = distributorId;
        }
    }
}

package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/13.
 */

public class ToLoginBean {


    /**
     * success : true
     * result : {"bean":{"custId":"170725183828469007","realName":null,"headImg":null,"mobile":"15988481506","nickname":"15988481506","sex":null,"idNum":null,"loginPwd":null,"loginpwdsalt":null,"loginErrTimes":null,"isLock":null,"lockTime":null,"loginTime":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"isAgency":"1","isDistributor":"1","openId":null,"comeFrom":null,"custStatus":null,"balance":9960359.9672,"agencyId":"170725183828631009","distributorId":"170726174906582036","createTime2":null,"levelName":null},"code":"2","msg":"登录成功"}
     * errorMessage : null
     */

    private boolean success;
    private ResultBean result;
    private Object errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static class ResultBean {
        /**
         * bean : {"custId":"170725183828469007","realName":null,"headImg":null,"mobile":"15988481506","nickname":"15988481506","sex":null,"idNum":null,"loginPwd":null,"loginpwdsalt":null,"loginErrTimes":null,"isLock":null,"lockTime":null,"loginTime":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"isAgency":"1","isDistributor":"1","openId":null,"comeFrom":null,"custStatus":null,"balance":9960359.9672,"agencyId":"170725183828631009","distributorId":"170726174906582036","createTime2":null,"levelName":null}
         * code : 2
         * msg : 登录成功
         */

        private BeanBean bean;
        private String code;
        private String msg;

        public BeanBean getBean() {
            return bean;
        }

        public void setBean(BeanBean bean) {
            this.bean = bean;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static class BeanBean {
            /**
             * custId : 170725183828469007
             * realName : null
             * headImg : null
             * mobile : 15988481506
             * nickname : 15988481506
             * sex : null
             * idNum : null
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
             * balance : 9960359.9672
             * agencyId : 170725183828631009
             * distributorId : 170726174906582036
             * createTime2 : null
             * levelName : null
             */

            private String custId;
            private Object realName;
            private Object headImg;
            private String mobile;
            private String nickname;
            private Object sex;
            private Object idNum;
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
            private Object createTime2;
            private Object levelName;

            public String getCustId() {
                return custId;
            }

            public void setCustId(String custId) {
                this.custId = custId;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
            }

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
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

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public Object getIdNum() {
                return idNum;
            }

            public void setIdNum(Object idNum) {
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

            public Object getCreateTime2() {
                return createTime2;
            }

            public void setCreateTime2(Object createTime2) {
                this.createTime2 = createTime2;
            }

            public Object getLevelName() {
                return levelName;
            }

            public void setLevelName(Object levelName) {
                this.levelName = levelName;
            }
        }
    }
}

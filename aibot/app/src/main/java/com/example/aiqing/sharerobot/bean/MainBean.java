package com.example.aiqing.sharerobot.bean;
/**
 * Created by aiqing on 2017/6/25.
 */
public class MainBean {

    /**
     * coder : 0000
     * obj : {"distributorId":"1","custId":"2","name":"中大银泰城","contact1":"18767160533","contact2":"18767160533","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 09:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"address":"浙江省杭州市下城区东新路822号","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":"1","dzNum":"0","yzNum":"1","openTime2":"09:00","closedTime2":"22:00","mobile":null,"agencyId":null}
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
         * distributorId : 1
         * custId : 2
         * name : 中大银泰城
         * contact1 : 18767160533
         * contact2 : 18767160533
         * isStop : 0
         * isClosed : 0
         * is24hrs : 0
         * openTime : 1970-01-01 09:00:00
         * closedTime : 1970-01-01 22:00:00
         * isAllowed : null
         * address : 浙江省杭州市下城区东新路822号
         * lgt : null
         * lat : null
         * introduction : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : 1
         * dzNum : 0
         * yzNum : 1
         * openTime2 : 09:00
         * closedTime2 : 22:00
         * mobile : null
         * agencyId : null
         */

        private String distributorId;
        private String custId;
        private String name;
        private String contact1;
        private String contact2;
        private String isStop;
        private String isClosed;
        private String is24hrs;
        private String openTime;
        private String closedTime;
        private Object isAllowed;
        private String address;
        private Object lgt;
        private Object lat;
        private Object introduction;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private String status;
        private String dzNum;
        private String yzNum;
        private String openTime2;
        private String closedTime2;
        private Object mobile;
        private Object agencyId;

        public String getDistributorId() {
            return distributorId;
        }

        public void setDistributorId(String distributorId) {
            this.distributorId = distributorId;
        }

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContact1() {
            return contact1;
        }

        public void setContact1(String contact1) {
            this.contact1 = contact1;
        }

        public String getContact2() {
            return contact2;
        }

        public void setContact2(String contact2) {
            this.contact2 = contact2;
        }

        public String getIsStop() {
            return isStop;
        }

        public void setIsStop(String isStop) {
            this.isStop = isStop;
        }

        public String getIsClosed() {
            return isClosed;
        }

        public void setIsClosed(String isClosed) {
            this.isClosed = isClosed;
        }

        public String getIs24hrs() {
            return is24hrs;
        }

        public void setIs24hrs(String is24hrs) {
            this.is24hrs = is24hrs;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getClosedTime() {
            return closedTime;
        }

        public void setClosedTime(String closedTime) {
            this.closedTime = closedTime;
        }

        public Object getIsAllowed() {
            return isAllowed;
        }

        public void setIsAllowed(Object isAllowed) {
            this.isAllowed = isAllowed;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public Object getIntroduction() {
            return introduction;
        }

        public void setIntroduction(Object introduction) {
            this.introduction = introduction;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDzNum() {
            return dzNum;
        }

        public void setDzNum(String dzNum) {
            this.dzNum = dzNum;
        }

        public String getYzNum() {
            return yzNum;
        }

        public void setYzNum(String yzNum) {
            this.yzNum = yzNum;
        }

        public String getOpenTime2() {
            return openTime2;
        }

        public void setOpenTime2(String openTime2) {
            this.openTime2 = openTime2;
        }

        public String getClosedTime2() {
            return closedTime2;
        }

        public void setClosedTime2(String closedTime2) {
            this.closedTime2 = closedTime2;
        }

        public Object getMobile() {
            return mobile;
        }

        public void setMobile(Object mobile) {
            this.mobile = mobile;
        }

        public Object getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(Object agencyId) {
            this.agencyId = agencyId;
        }
    }
}

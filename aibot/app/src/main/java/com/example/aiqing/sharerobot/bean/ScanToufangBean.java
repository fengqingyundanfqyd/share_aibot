package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/7/11.
 */

public class ScanToufangBean {

    /**
     * coder : 0000
     * errorMsg : 执行成功!
     * obj : {"distributorId":"1","custId":"170703210333530011","name":null,"contact1":null,"contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":null,"lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":"1"}
     */

    private String coder;
    private String errorMsg;
    private ObjBean obj;

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * distributorId : 1
         * custId : 170703210333530011
         * name : null
         * contact1 : null
         * contact2 : null
         * isStop : null
         * isClosed : null
         * is24hrs : null
         * openTime : null
         * closedTime : null
         * isAllowed : null
         * building : null
         * address : null
         * lgt : null
         * lat : null
         * introduction : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : 1
         */

        private String distributorId;
        private String custId;
        private Object name;
        private Object contact1;
        private Object contact2;
        private Object isStop;
        private Object isClosed;
        private Object is24hrs;
        private Object openTime;
        private Object closedTime;
        private Object isAllowed;
        private Object building;
        private Object address;
        private Object lgt;
        private Object lat;
        private Object introduction;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private String status;

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

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getContact1() {
            return contact1;
        }

        public void setContact1(Object contact1) {
            this.contact1 = contact1;
        }

        public Object getContact2() {
            return contact2;
        }

        public void setContact2(Object contact2) {
            this.contact2 = contact2;
        }

        public Object getIsStop() {
            return isStop;
        }

        public void setIsStop(Object isStop) {
            this.isStop = isStop;
        }

        public Object getIsClosed() {
            return isClosed;
        }

        public void setIsClosed(Object isClosed) {
            this.isClosed = isClosed;
        }

        public Object getIs24hrs() {
            return is24hrs;
        }

        public void setIs24hrs(Object is24hrs) {
            this.is24hrs = is24hrs;
        }

        public Object getOpenTime() {
            return openTime;
        }

        public void setOpenTime(Object openTime) {
            this.openTime = openTime;
        }

        public Object getClosedTime() {
            return closedTime;
        }

        public void setClosedTime(Object closedTime) {
            this.closedTime = closedTime;
        }

        public Object getIsAllowed() {
            return isAllowed;
        }

        public void setIsAllowed(Object isAllowed) {
            this.isAllowed = isAllowed;
        }

        public Object getBuilding() {
            return building;
        }

        public void setBuilding(Object building) {
            this.building = building;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
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
    }
}

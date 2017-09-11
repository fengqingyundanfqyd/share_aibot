package com.example.aiqing.sharerobot.bean;

/**投放商店铺资料
 * Created by aiqing on 2017/7/11.
 */

public class ShopDataBean {


    /**
     * coder : 0000
     * obj : {"distributorId":null,"custId":null,"name":"中大银泰城","contact1":"18767160533","contact2":null,"isStop":"0","isClosed":null,"is24hrs":null,"openTime":"1970-01-01 11:00:00","closedTime":"1970-01-01 21:00:00","isAllowed":"1","building":"韩村(中大银泰城2、3、4号楼)","address":"浙江省杭州市下城区东新路822号12","lgt":"120.176879","lat":"30.327222","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":"1","headImg":null,"closedTime2":null,"openTime2":null}
     * errorMsg : 执行成功!
     * transNo : null
     * sign : null
     * success : true
     */

    private String coder;
    private ObjBean obj;
    private String errorMsg;
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

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
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
         * distributorId : null
         * custId : null
         * name : 中大银泰城
         * contact1 : 18767160533
         * contact2 : null
         * isStop : 0
         * isClosed : null
         * is24hrs : null
         * openTime : 1970-01-01 11:00:00
         * closedTime : 1970-01-01 21:00:00
         * isAllowed : 1
         * building : 韩村(中大银泰城2、3、4号楼)
         * address : 浙江省杭州市下城区东新路822号12
         * lgt : 120.176879
         * lat : 30.327222
         * introduction : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : 1
         * headImg : null
         * closedTime2 : null
         * openTime2 : null
         */

        private Object distributorId;
        private Object custId;
        private String name;
        private String contact1;
        private Object contact2;
        private String isStop;
        private Object isClosed;
        private Object is24hrs;
        private String openTime;
        private String closedTime;
        private String isAllowed;
        private String building;
        private String address;
        private String lgt;
        private String lat;
        private Object introduction;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private String status;
        private Object headImg;
        private Object closedTime2;
        private Object openTime2;

        public Object getDistributorId() {
            return distributorId;
        }

        public void setDistributorId(Object distributorId) {
            this.distributorId = distributorId;
        }

        public Object getCustId() {
            return custId;
        }

        public void setCustId(Object custId) {
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

        public Object getContact2() {
            return contact2;
        }

        public void setContact2(Object contact2) {
            this.contact2 = contact2;
        }

        public String getIsStop() {
            return isStop;
        }

        public void setIsStop(String isStop) {
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

        public String getIsAllowed() {
            return isAllowed;
        }

        public void setIsAllowed(String isAllowed) {
            this.isAllowed = isAllowed;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getLgt() {
            return lgt;
        }

        public void setLgt(String lgt) {
            this.lgt = lgt;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
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

        public Object getHeadImg() {
            return headImg;
        }

        public void setHeadImg(Object headImg) {
            this.headImg = headImg;
        }

        public Object getClosedTime2() {
            return closedTime2;
        }

        public void setClosedTime2(Object closedTime2) {
            this.closedTime2 = closedTime2;
        }

        public Object getOpenTime2() {
            return openTime2;
        }

        public void setOpenTime2(Object openTime2) {
            this.openTime2 = openTime2;
        }
    }
}

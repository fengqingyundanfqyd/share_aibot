package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/8/5.
 */

public class DaiInfoBean {

    /**
     * coder : 0000
     * obj : {"agencyId":"170804103234754066","levelId":null,"custId":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"mobile":"15988481506","custName":null,"ptypeId":null,"productId":null,"reset":null,"lgt":null,"lat":null,"address":null,"headImg":null,"realName":"159****1506","id":null}
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
         * agencyId : 170804103234754066
         * levelId : null
         * custId : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : null
         * mobile : 15988481506
         * custName : null
         * ptypeId : null
         * productId : null
         * reset : null
         * lgt : null
         * lat : null
         * address : null
         * headImg : null
         * realName : 159****1506
         * id : null
         */

        private String agencyId;
        private Object levelId;
        private Object custId;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private Object status;
        private String mobile;
        private Object custName;
        private Object ptypeId;
        private Object productId;
        private Object reset;
        private Object lgt;
        private Object lat;
        private Object address;
        private Object headImg;
        private String realName;
        private Object id;

        public String getAgencyId() {
            return agencyId;
        }

        public void setAgencyId(String agencyId) {
            this.agencyId = agencyId;
        }

        public Object getLevelId() {
            return levelId;
        }

        public void setLevelId(Object levelId) {
            this.levelId = levelId;
        }

        public Object getCustId() {
            return custId;
        }

        public void setCustId(Object custId) {
            this.custId = custId;
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

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getCustName() {
            return custName;
        }

        public void setCustName(Object custName) {
            this.custName = custName;
        }

        public Object getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(Object ptypeId) {
            this.ptypeId = ptypeId;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public Object getReset() {
            return reset;
        }

        public void setReset(Object reset) {
            this.reset = reset;
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

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getHeadImg() {
            return headImg;
        }

        public void setHeadImg(Object headImg) {
            this.headImg = headImg;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }
}

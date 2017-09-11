package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/1.
 */

public class ChangeRentBean {

    /**
     * coder : 0000
     * obj : {"craId":"170831113441120017","custId":"170815094426760047","ptypeId":null,"num":29,"mobile":"18757137805","address":"浙江省杭州市下城区浙江省","lgt":"120.176206","lat":"30.327301","createTime":null,"isPublish":null,"remark":"拖急急急急急","status":null,"realName":null,"headImg":"upload/img/170817172243267003.jpg","name":null,"nickName":"娃娃鱼11","yzNum":null,"ptypeName":null,"ct":0,"dzNum":"3","proInfoList":null}
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
         * craId : 170831113441120017
         * custId : 170815094426760047
         * ptypeId : null
         * num : 29.0
         * mobile : 18757137805
         * address : 浙江省杭州市下城区浙江省
         * lgt : 120.176206
         * lat : 30.327301
         * createTime : null
         * isPublish : null
         * remark : 拖急急急急急
         * status : null
         * realName : null
         * headImg : upload/img/170817172243267003.jpg
         * name : null
         * nickName : 娃娃鱼11
         * yzNum : null
         * ptypeName : null
         * ct : 0
         * dzNum : 3
         * proInfoList : null
         */

        private String craId;
        private String custId;
        private Object ptypeId;
        private double num;
        private String mobile;
        private String address;
        private String lgt;
        private String lat;
        private Object createTime;
        private Object isPublish;
        private String remark;
        private Object status;
        private Object realName;
        private String headImg;
        private Object name;
        private String nickName;
        private Object yzNum;
        private Object ptypeName;
        private int ct;
        private String dzNum;
        private Object proInfoList;

        public String getCraId() {
            return craId;
        }

        public void setCraId(String craId) {
            this.craId = craId;
        }

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

        public Object getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(Object ptypeId) {
            this.ptypeId = ptypeId;
        }

        public double getNum() {
            return num;
        }

        public void setNum(double num) {
            this.num = num;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getIsPublish() {
            return isPublish;
        }

        public void setIsPublish(Object isPublish) {
            this.isPublish = isPublish;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getRealName() {
            return realName;
        }

        public void setRealName(Object realName) {
            this.realName = realName;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public Object getYzNum() {
            return yzNum;
        }

        public void setYzNum(Object yzNum) {
            this.yzNum = yzNum;
        }

        public Object getPtypeName() {
            return ptypeName;
        }

        public void setPtypeName(Object ptypeName) {
            this.ptypeName = ptypeName;
        }

        public int getCt() {
            return ct;
        }

        public void setCt(int ct) {
            this.ct = ct;
        }

        public String getDzNum() {
            return dzNum;
        }

        public void setDzNum(String dzNum) {
            this.dzNum = dzNum;
        }

        public Object getProInfoList() {
            return proInfoList;
        }

        public void setProInfoList(Object proInfoList) {
            this.proInfoList = proInfoList;
        }
    }
}

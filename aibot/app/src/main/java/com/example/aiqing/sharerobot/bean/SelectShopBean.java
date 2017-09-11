package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/8/30.
 */

public class SelectShopBean {

    /**
     * errorMsg : 执行成功
     * coder : 0000
     * returnPoint : {"size":5,"total":8,"currentPage":1,"totalPage":2,"currentResult":0,"result":[{"distributorId":"170821152121826002","custId":null,"name":"飞天螳螂","contact1":null,"contact2":null,"isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":null,"address":"东新园小区(公交站)","lgt":"120.182953","lat":"31.313","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":109732,"id":null},{"distributorId":"170814203827496009","custId":null,"name":"栗子店铺","contact1":"18768163701","contact2":"18768163701","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"炉鱼(杭州中大银泰城店)","address":"无","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":132,"id":null},{"distributorId":"170814203827496019","custId":null,"name":"hiso","contact1":"18871579392","contact2":"18871579392","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 10:29:47","closedTime":"1970-01-01 17:29:50","isAllowed":null,"building":"中共中央俊伟主席熊大大","address":"0","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"10:29","closedTime2":"17:29","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":132,"id":null},{"distributorId":"170815094720959052","custId":null,"name":"哪吒","contact1":"18757137805","contact2":"18757137805","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"东新园小区(公交站)","address":"杭州市下城区东新路东新园小区8栋501","lgt":"120.182953","lat":"30.313","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":"upload/img/170817172243267003.jpg","distance":1720,"id":null},{"distributorId":"170814205055272035","custId":null,"name":"蚂蚱蜢","contact1":"13225642590","contact2":"13225642590","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 00:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"杭州城北体育公园","address":"我是Leo？我也好了","lgt":"120.16215","lat":"30.311129","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"00:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":"upload/img/170822145814020009.png","distance":2241,"id":null}]}
     * defaultDot : {"distributorId":"170815094720959052","custId":null,"name":"哪吒","contact1":"18757137805","contact2":"18757137805","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"东新园小区(公交站)","address":"杭州市下城区东新路东新园小区8栋501","lgt":"120.182953","lat":"30.313","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":"upload/img/170817172243267003.jpg","distance":1720,"id":null}
     */

    private String errorMsg;
    private String coder;
    private ReturnPointBean returnPoint;
    private DefaultDotBean defaultDot;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public ReturnPointBean getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(ReturnPointBean returnPoint) {
        this.returnPoint = returnPoint;
    }

    public DefaultDotBean getDefaultDot() {
        return defaultDot;
    }

    public void setDefaultDot(DefaultDotBean defaultDot) {
        this.defaultDot = defaultDot;
    }

    public static class ReturnPointBean {
        /**
         * size : 5
         * total : 8
         * currentPage : 1
         * totalPage : 2
         * currentResult : 0
         * result : [{"distributorId":"170821152121826002","custId":null,"name":"飞天螳螂","contact1":null,"contact2":null,"isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":null,"address":"东新园小区(公交站)","lgt":"120.182953","lat":"31.313","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":109732,"id":null},{"distributorId":"170814203827496009","custId":null,"name":"栗子店铺","contact1":"18768163701","contact2":"18768163701","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"炉鱼(杭州中大银泰城店)","address":"无","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":132,"id":null},{"distributorId":"170814203827496019","custId":null,"name":"hiso","contact1":"18871579392","contact2":"18871579392","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 10:29:47","closedTime":"1970-01-01 17:29:50","isAllowed":null,"building":"中共中央俊伟主席熊大大","address":"0","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"10:29","closedTime2":"17:29","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":null,"distance":132,"id":null},{"distributorId":"170815094720959052","custId":null,"name":"哪吒","contact1":"18757137805","contact2":"18757137805","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"东新园小区(公交站)","address":"杭州市下城区东新路东新园小区8栋501","lgt":"120.182953","lat":"30.313","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"08:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":"upload/img/170817172243267003.jpg","distance":1720,"id":null},{"distributorId":"170814205055272035","custId":null,"name":"蚂蚱蜢","contact1":"13225642590","contact2":"13225642590","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 00:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":null,"building":"杭州城北体育公园","address":"我是Leo？我也好了","lgt":"120.16215","lat":"30.311129","introduction":null,"creater":null,"createTime":null,"updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":"00:00","closedTime2":"22:00","mobile":null,"agencyId":null,"productId":null,"reset":0,"ptypeId":null,"headImg":"upload/img/170822145814020009.png","distance":2241,"id":null}]
         */

        private int size;
        private int total;
        private int currentPage;
        private int totalPage;
        private int currentResult;
        private List<ResultBean> result;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrentResult() {
            return currentResult;
        }

        public void setCurrentResult(int currentResult) {
            this.currentResult = currentResult;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * distributorId : 170821152121826002
             * custId : null
             * name : 飞天螳螂
             * contact1 : null
             * contact2 : null
             * isStop : 0
             * isClosed : 0
             * is24hrs : 0
             * openTime : 1970-01-01 08:00:00
             * closedTime : 1970-01-01 22:00:00
             * isAllowed : null
             * building : null
             * address : 东新园小区(公交站)
             * lgt : 120.182953
             * lat : 31.313
             * introduction : null
             * creater : null
             * createTime : null
             * updater : null
             * updateTime : null
             * status : null
             * dzNum : null
             * yzNum : null
             * openTime2 : 08:00
             * closedTime2 : 22:00
             * mobile : null
             * agencyId : null
             * productId : null
             * reset : 0
             * ptypeId : null
             * headImg : null
             * distance : 109732.0
             * id : null
             */

            private String distributorId;
            private Object custId;
            private String name;
            private Object contact1;
            private Object contact2;
            private String isStop;
            private String isClosed;
            private String is24hrs;
            private String openTime;
            private String closedTime;
            private Object isAllowed;
            private Object building;
            private String address;
            private String lgt;
            private String lat;
            private Object introduction;
            private Object creater;
            private Object createTime;
            private Object updater;
            private Object updateTime;
            private Object status;
            private Object dzNum;
            private Object yzNum;
            private String openTime2;
            private String closedTime2;
            private Object mobile;
            private Object agencyId;
            private Object productId;
            private int reset;
            private Object ptypeId;
            private Object headImg;
            private double distance;
            private Object id;

            public String getDistributorId() {
                return distributorId;
            }

            public void setDistributorId(String distributorId) {
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

            public Object getBuilding() {
                return building;
            }

            public void setBuilding(Object building) {
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

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getDzNum() {
                return dzNum;
            }

            public void setDzNum(Object dzNum) {
                this.dzNum = dzNum;
            }

            public Object getYzNum() {
                return yzNum;
            }

            public void setYzNum(Object yzNum) {
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

            public Object getProductId() {
                return productId;
            }

            public void setProductId(Object productId) {
                this.productId = productId;
            }

            public int getReset() {
                return reset;
            }

            public void setReset(int reset) {
                this.reset = reset;
            }

            public Object getPtypeId() {
                return ptypeId;
            }

            public void setPtypeId(Object ptypeId) {
                this.ptypeId = ptypeId;
            }

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }
        }
    }

    public static class DefaultDotBean {
        /**
         * distributorId : 170815094720959052
         * custId : null
         * name : 哪吒
         * contact1 : 18757137805
         * contact2 : 18757137805
         * isStop : 0
         * isClosed : 0
         * is24hrs : 0
         * openTime : 1970-01-01 08:00:00
         * closedTime : 1970-01-01 22:00:00
         * isAllowed : null
         * building : 东新园小区(公交站)
         * address : 杭州市下城区东新路东新园小区8栋501
         * lgt : 120.182953
         * lat : 30.313
         * introduction : null
         * creater : null
         * createTime : null
         * updater : null
         * updateTime : null
         * status : null
         * dzNum : null
         * yzNum : null
         * openTime2 : 08:00
         * closedTime2 : 22:00
         * mobile : null
         * agencyId : null
         * productId : null
         * reset : 0
         * ptypeId : null
         * headImg : upload/img/170817172243267003.jpg
         * distance : 1720.0
         * id : null
         */

        private String distributorId;
        private Object custId;
        private String name;
        private String contact1;
        private String contact2;
        private String isStop;
        private String isClosed;
        private String is24hrs;
        private String openTime;
        private String closedTime;
        private Object isAllowed;
        private String building;
        private String address;
        private String lgt;
        private String lat;
        private Object introduction;
        private Object creater;
        private Object createTime;
        private Object updater;
        private Object updateTime;
        private Object status;
        private Object dzNum;
        private Object yzNum;
        private String openTime2;
        private String closedTime2;
        private Object mobile;
        private Object agencyId;
        private Object productId;
        private int reset;
        private Object ptypeId;
        private String headImg;
        private double distance;
        private Object id;

        public String getDistributorId() {
            return distributorId;
        }

        public void setDistributorId(String distributorId) {
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

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public Object getDzNum() {
            return dzNum;
        }

        public void setDzNum(Object dzNum) {
            this.dzNum = dzNum;
        }

        public Object getYzNum() {
            return yzNum;
        }

        public void setYzNum(Object yzNum) {
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

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public int getReset() {
            return reset;
        }

        public void setReset(int reset) {
            this.reset = reset;
        }

        public Object getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(Object ptypeId) {
            this.ptypeId = ptypeId;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }
    }
}

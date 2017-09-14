package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/14.
 */

public class AgencyDisBean {

    /**
     * result : {"size":5,"total":6,"currentPage":1,"totalPage":2,"currentResult":0,"result":[{"distributorId":null,"custId":null,"name":"jjh店","headImg":null,"contact1":"18806719755","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-31 09:25:39","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719765","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"111","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-30 17:54:58","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719766","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-30 17:52:04","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719750","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-21 16:34:28","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"飞天螳螂","headImg":null,"contact1":null,"contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"东新园小区(公交站)","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-21 15:24:31","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null}]}
     * errorMsg : 执行成功
     * coder : 0000
     * count : 6
     */

    private ResultBeanX result;
    private String errorMsg;
    private String coder;
    private int count;

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class ResultBeanX {
        /**
         * size : 5
         * total : 6
         * currentPage : 1
         * totalPage : 2
         * currentResult : 0
         * result : [{"distributorId":null,"custId":null,"name":"jjh店","headImg":null,"contact1":"18806719755","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-31 09:25:39","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719765","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"111","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-30 17:54:58","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719766","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-30 17:52:04","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"1","headImg":null,"contact1":"18806719750","contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"1","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-21 16:34:28","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null},{"distributorId":null,"custId":null,"name":"飞天螳螂","headImg":null,"contact1":null,"contact2":null,"isStop":null,"isClosed":null,"is24hrs":null,"openTime":null,"closedTime":null,"isAllowed":null,"building":null,"address":"东新园小区(公交站)","lgt":null,"lat":null,"introduction":null,"creater":null,"createTime":"2017-08-21 15:24:31","updater":null,"updateTime":null,"status":null,"dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":0,"stock":"0","money":null,"page":null,"id":null}]
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
             * distributorId : null
             * custId : null
             * name : jjh店
             * headImg : null
             * contact1 : 18806719755
             * contact2 : null
             * isStop : null
             * isClosed : null
             * is24hrs : null
             * openTime : null
             * closedTime : null
             * isAllowed : null
             * building : null
             * address : 1
             * lgt : null
             * lat : null
             * introduction : null
             * creater : null
             * createTime : 2017-08-31 09:25:39
             * updater : null
             * updateTime : null
             * status : null
             * dzNum : null
             * yzNum : null
             * openTime2 : null
             * closedTime2 : null
             * mobile : null
             * agencyId : null
             * nickname : null
             * levelName : null
             * realName : null
             * sex : null
             * idNum : null
             * productId : null
             * reset : 0
             * ptypeId : null
             * distance : 0.0
             * stock : 0
             * money : null
             * page : null
             * id : null
             */

            private Object distributorId;
            private Object custId;
            private String name;
            private Object headImg;
            private String contact1;
            private Object contact2;
            private Object isStop;
            private Object isClosed;
            private Object is24hrs;
            private Object openTime;
            private Object closedTime;
            private Object isAllowed;
            private Object building;
            private String address;
            private Object lgt;
            private Object lat;
            private Object introduction;
            private Object creater;
            private String createTime;
            private Object updater;
            private Object updateTime;
            private Object status;
            private Object dzNum;
            private Object yzNum;
            private Object openTime2;
            private Object closedTime2;
            private Object mobile;
            private Object agencyId;
            private Object nickname;
            private Object levelName;
            private Object realName;
            private Object sex;
            private Object idNum;
            private Object productId;
            private int reset;
            private Object ptypeId;
            private double distance;
            private String stock;
            private Object money;
            private Object page;
            private Object id;

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

            public Object getHeadImg() {
                return headImg;
            }

            public void setHeadImg(Object headImg) {
                this.headImg = headImg;
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
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

            public Object getOpenTime2() {
                return openTime2;
            }

            public void setOpenTime2(Object openTime2) {
                this.openTime2 = openTime2;
            }

            public Object getClosedTime2() {
                return closedTime2;
            }

            public void setClosedTime2(Object closedTime2) {
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

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public Object getLevelName() {
                return levelName;
            }

            public void setLevelName(Object levelName) {
                this.levelName = levelName;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
                this.realName = realName;
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

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public Object getMoney() {
                return money;
            }

            public void setMoney(Object money) {
                this.money = money;
            }

            public Object getPage() {
                return page;
            }

            public void setPage(Object page) {
                this.page = page;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }
        }
    }
}

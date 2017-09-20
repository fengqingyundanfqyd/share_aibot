package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/20.
 */

public class NearbyShopBean {

    /**
     * coder : 0000
     * errorMsg : 执行成功
     * distributor : {"size":1,"total":13,"currentPage":1,"totalPage":13,"currentResult":0,"result":[{"distributorId":"170814203827496009","custId":"170814200209217000","name":"栗子店铺","headImg":null,"contact1":"18768163701","contact2":"18768163701","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":"0","building":"炉鱼(杭州中大银泰城店)","address":"无","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":"1","createTime":"2017-08-14 20:38:34","updater":null,"updateTime":null,"status":"1","dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":141,"stock":null,"money":null,"page":null,"ranger":0,"id":null}]}
     * custReletApply : {"size":1,"total":5,"currentPage":1,"totalPage":5,"currentResult":0,"result":[{"craId":"170814213115130008","custId":"170814203444135000","ptypeId":"1","num":null,"mobile":"18767160533","address":"龙汀小煮(中大银泰城1号楼)1","lgt":"120.173722","lat":"30.326578","createTime":"2017-08-16 16:33:17","isPublish":"1","remark":"111111","status":"1","realName":null,"headImg":null,"name":null,"nickName":"187****0533","yzNum":null,"ptypeName":null,"ct":0,"dzNum":null,"page":null,"ranger":0,"proInfoList":null}]}
     */

    private String coder;
    private String errorMsg;
    private DistributorBean distributor;
    private CustReletApplyBean custReletApply;

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

    public DistributorBean getDistributor() {
        return distributor;
    }

    public void setDistributor(DistributorBean distributor) {
        this.distributor = distributor;
    }

    public CustReletApplyBean getCustReletApply() {
        return custReletApply;
    }

    public void setCustReletApply(CustReletApplyBean custReletApply) {
        this.custReletApply = custReletApply;
    }

    public static class DistributorBean {
        /**
         * size : 1
         * total : 13
         * currentPage : 1
         * totalPage : 13
         * currentResult : 0
         * result : [{"distributorId":"170814203827496009","custId":"170814200209217000","name":"栗子店铺","headImg":null,"contact1":"18768163701","contact2":"18768163701","isStop":"0","isClosed":"0","is24hrs":"0","openTime":"1970-01-01 08:00:00","closedTime":"1970-01-01 22:00:00","isAllowed":"0","building":"炉鱼(杭州中大银泰城店)","address":"无","lgt":"120.174837","lat":"30.326783","introduction":null,"creater":"1","createTime":"2017-08-14 20:38:34","updater":null,"updateTime":null,"status":"1","dzNum":null,"yzNum":null,"openTime2":null,"closedTime2":null,"mobile":null,"agencyId":null,"nickname":null,"levelName":null,"realName":null,"sex":null,"idNum":null,"productId":null,"reset":0,"ptypeId":null,"distance":141,"stock":null,"money":null,"page":null,"ranger":0,"id":null}]
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
             * distributorId : 170814203827496009
             * custId : 170814200209217000
             * name : 栗子店铺
             * headImg : null
             * contact1 : 18768163701
             * contact2 : 18768163701
             * isStop : 0
             * isClosed : 0
             * is24hrs : 0
             * openTime : 1970-01-01 08:00:00
             * closedTime : 1970-01-01 22:00:00
             * isAllowed : 0
             * building : 炉鱼(杭州中大银泰城店)
             * address : 无
             * lgt : 120.174837
             * lat : 30.326783
             * introduction : null
             * creater : 1
             * createTime : 2017-08-14 20:38:34
             * updater : null
             * updateTime : null
             * status : 1
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
             * distance : 141.0
             * stock : null
             * money : null
             * page : null
             * ranger : 0
             * id : null
             */

            private String distributorId;
            private String custId;
            private String name;
            private Object headImg;
            private String contact1;
            private String contact2;
            private String isStop;
            private String isClosed;
            private String is24hrs;
            private String openTime;
            private String closedTime;
            private String isAllowed;
            private String building;
            private String address;
            private String lgt;
            private String lat;
            private Object introduction;
            private String creater;
            private String createTime;
            private Object updater;
            private Object updateTime;
            private String status;
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
            private Object stock;
            private Object money;
            private Object page;
            private int ranger;
            private Object id;

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

            public String getCreater() {
                return creater;
            }

            public void setCreater(String creater) {
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
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

            public Object getStock() {
                return stock;
            }

            public void setStock(Object stock) {
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

            public int getRanger() {
                return ranger;
            }

            public void setRanger(int ranger) {
                this.ranger = ranger;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }
        }
    }

    public static class CustReletApplyBean {
        /**
         * size : 1
         * total : 5
         * currentPage : 1
         * totalPage : 5
         * currentResult : 0
         * result : [{"craId":"170814213115130008","custId":"170814203444135000","ptypeId":"1","num":null,"mobile":"18767160533","address":"龙汀小煮(中大银泰城1号楼)1","lgt":"120.173722","lat":"30.326578","createTime":"2017-08-16 16:33:17","isPublish":"1","remark":"111111","status":"1","realName":null,"headImg":null,"name":null,"nickName":"187****0533","yzNum":null,"ptypeName":null,"ct":0,"dzNum":null,"page":null,"ranger":0,"proInfoList":null}]
         */

        private int size;
        private int total;
        private int currentPage;
        private int totalPage;
        private int currentResult;
        private List<ResultBeanX> result;

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

        public List<ResultBeanX> getResult() {
            return result;
        }

        public void setResult(List<ResultBeanX> result) {
            this.result = result;
        }

        public static class ResultBeanX {
            /**
             * craId : 170814213115130008
             * custId : 170814203444135000
             * ptypeId : 1
             * num : null
             * mobile : 18767160533
             * address : 龙汀小煮(中大银泰城1号楼)1
             * lgt : 120.173722
             * lat : 30.326578
             * createTime : 2017-08-16 16:33:17
             * isPublish : 1
             * remark : 111111
             * status : 1
             * realName : null
             * headImg : null
             * name : null
             * nickName : 187****0533
             * yzNum : null
             * ptypeName : null
             * ct : 0
             * dzNum : null
             * page : null
             * ranger : 0
             * proInfoList : null
             */

            private String craId;
            private String custId;
            private String ptypeId;
            private Object num;
            private String mobile;
            private String address;
            private String lgt;
            private String lat;
            private String createTime;
            private String isPublish;
            private String remark;
            private String status;
            private Object realName;
            private Object headImg;
            private Object name;
            private String nickName;
            private Object yzNum;
            private Object ptypeName;
            private int ct;
            private Object dzNum;
            private Object page;
            private int ranger;
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

            public String getPtypeId() {
                return ptypeId;
            }

            public void setPtypeId(String ptypeId) {
                this.ptypeId = ptypeId;
            }

            public Object getNum() {
                return num;
            }

            public void setNum(Object num) {
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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getIsPublish() {
                return isPublish;
            }

            public void setIsPublish(String isPublish) {
                this.isPublish = isPublish;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
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

            public Object getDzNum() {
                return dzNum;
            }

            public void setDzNum(Object dzNum) {
                this.dzNum = dzNum;
            }

            public Object getPage() {
                return page;
            }

            public void setPage(Object page) {
                this.page = page;
            }

            public int getRanger() {
                return ranger;
            }

            public void setRanger(int ranger) {
                this.ranger = ranger;
            }

            public Object getProInfoList() {
                return proInfoList;
            }

            public void setProInfoList(Object proInfoList) {
                this.proInfoList = proInfoList;
            }
        }
    }
}

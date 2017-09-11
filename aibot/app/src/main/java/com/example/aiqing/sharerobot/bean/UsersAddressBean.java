package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/7/8.
 */

public class UsersAddressBean {

    /**
     * coder : 0000
     * obj : {"size":15,"total":7,"currentPage":1,"totalPage":1,"currentResult":0,"result":[{"addressId":"170704134704843000","custId":"1","name":"网的","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"拱墅区","township":"米市巷街道","street":"湖墅南路","streetnumber":"","building":"豪客来(湖墅南路店)","fAddress":"浙江省杭州市拱墅区米市巷街道湖墅南路226号浙江物探大楼","dAddress":"21313don","isDefault":"1","lgt":"120.152936","lat":"30.283272","createTime":"2017-07-04 13:51:02","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170704141050590001","custId":"1","name":"新增","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"下城区","township":"东新街道","street":"石祥路","streetnumber":"","building":"新白鹿(中大银泰店)","fAddress":null,"dAddress":"ces","isDefault":"0","lgt":"120.174523","lat":"30.326724","createTime":"2017-07-04 14:14:48","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170703162315583001","custId":"1","name":"王聪","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"拱墅区","township":"米市巷街道","street":"湖墅南路","streetnumber":"","building":"豪客来(湖墅南路店)","fAddress":"浙江省杭州市拱墅区米市巷街道湖墅南路226号浙江物探大楼","dAddress":"16栋201","isDefault":"0","lgt":"120.152936","lat":"30.283272","createTime":"2017-07-03 16:27:17","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708150024171000","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:04:16","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708151741101000","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:21:33","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708151926197001","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:23:18","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708153222113004","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:36:14","updateTime":null,"status":null,"updateTime2":null}]}
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
         * size : 15
         * total : 7
         * currentPage : 1
         * totalPage : 1
         * currentResult : 0
         * result : [{"addressId":"170704134704843000","custId":"1","name":"网的","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"拱墅区","township":"米市巷街道","street":"湖墅南路","streetnumber":"","building":"豪客来(湖墅南路店)","fAddress":"浙江省杭州市拱墅区米市巷街道湖墅南路226号浙江物探大楼","dAddress":"21313don","isDefault":"1","lgt":"120.152936","lat":"30.283272","createTime":"2017-07-04 13:51:02","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170704141050590001","custId":"1","name":"新增","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"下城区","township":"东新街道","street":"石祥路","streetnumber":"","building":"新白鹿(中大银泰店)","fAddress":null,"dAddress":"ces","isDefault":"0","lgt":"120.174523","lat":"30.326724","createTime":"2017-07-04 14:14:48","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170703162315583001","custId":"1","name":"王聪","mobile":"18779283533","province":"浙江省","city":"杭州市","district":"拱墅区","township":"米市巷街道","street":"湖墅南路","streetnumber":"","building":"豪客来(湖墅南路店)","fAddress":"浙江省杭州市拱墅区米市巷街道湖墅南路226号浙江物探大楼","dAddress":"16栋201","isDefault":"0","lgt":"120.152936","lat":"30.283272","createTime":"2017-07-03 16:27:17","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708150024171000","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:04:16","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708151741101000","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:21:33","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708151926197001","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:23:18","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170708153222113004","custId":"1","name":"熊运飞","mobile":"18871579392","province":"浙江省","city":"杭州市","district":"下城区","township":"甘长存","street":"留石快速路","streetnumber":"110","building":"浙江省杭州市江干区下沙","fAddress":"浙江省杭州市江干区下沙","dAddress":"中大银泰城","isDefault":"0","lgt":"120.1751500000","lat":"30.3268900000","createTime":"2017-07-08 15:36:14","updateTime":null,"status":null,"updateTime2":null}]
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
             * addressId : 170704134704843000
             * custId : 1
             * name : 网的
             * mobile : 18779283533
             * province : 浙江省
             * city : 杭州市
             * district : 拱墅区
             * township : 米市巷街道
             * street : 湖墅南路
             * streetnumber :
             * building : 豪客来(湖墅南路店)
             * fAddress : 浙江省杭州市拱墅区米市巷街道湖墅南路226号浙江物探大楼
             * dAddress : 21313don
             * isDefault : 1
             * lgt : 120.152936
             * lat : 30.283272
             * createTime : 2017-07-04 13:51:02
             * updateTime : null
             * status : null
             * updateTime2 : null
             */

            private String addressId;
            private String custId;
            private String name;
            private String mobile;
            private String province;
            private String city;
            private String district;
            private String township;
            private String street;
            private String streetnumber;
            private String building;
            private String fAddress;
            private String dAddress;
            private String isDefault;
            private String lgt;
            private String lat;
            private String createTime;
            private Object updateTime;
            private Object status;
            private Object updateTime2;

            public String getAddressId() {
                return addressId;
            }

            public void setAddressId(String addressId) {
                this.addressId = addressId;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getTownship() {
                return township;
            }

            public void setTownship(String township) {
                this.township = township;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getStreetnumber() {
                return streetnumber;
            }

            public void setStreetnumber(String streetnumber) {
                this.streetnumber = streetnumber;
            }

            public String getBuilding() {
                return building;
            }

            public void setBuilding(String building) {
                this.building = building;
            }

            public String getFAddress() {
                return fAddress;
            }

            public void setFAddress(String fAddress) {
                this.fAddress = fAddress;
            }

            public String getDAddress() {
                return dAddress;
            }

            public void setDAddress(String dAddress) {
                this.dAddress = dAddress;
            }

            public String getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
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

            public Object getUpdateTime2() {
                return updateTime2;
            }

            public void setUpdateTime2(Object updateTime2) {
                this.updateTime2 = updateTime2;
            }
        }
    }
}

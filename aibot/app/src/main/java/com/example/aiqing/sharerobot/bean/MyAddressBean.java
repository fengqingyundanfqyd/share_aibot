package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**我的地址
 * Created by aiqing on 2017/7/13.
 */

public class MyAddressBean {


    /**
     * coder : 0000
     * obj : {"size":5,"total":7,"currentPage":1,"totalPage":2,"currentResult":0,"result":[{"addressId":"170803092651821022","custId":"170725183828469007","name":"啊2月了。我也","mobile":"15868475213","province":"浙江省","city":"杭州市","district":"下城区","township":"东新街道","street":"石祥路","streetnumber":"","building":"炉鱼(杭州中大银泰城店)","fAddress":"浙江省杭州市下城区东新街道炉鱼(杭州中大银泰城店)中大银泰城","dAddress":"吧发布了一个月了","isDefault":"1","lgt":"120.174837","lat":"30.326783","createTime":"2017-08-03 09:26:58","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170725183639323000","custId":"170725183828469007","name":"方正","mobile":"15988481506","province":"浙江省","city":"杭州市","district":"下城区","township":"石桥街道","street":"东新路","streetnumber":"","building":"中大银泰城","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"4号楼5楼","isDefault":"0","lgt":"120.175919","lat":"30.32743","createTime":"2017-07-25 18:36:56","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801153250592046","custId":"170725183828469007","name":"舒少勇","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:29:07","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801153756682058","custId":"170725183828469007","name":"把握不好","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:34:13","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801155219106036","custId":"170725183828469007","name":"1456","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:52:25","updateTime":null,"status":null,"updateTime2":null}]}
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
         * size : 5
         * total : 7
         * currentPage : 1
         * totalPage : 2
         * currentResult : 0
         * result : [{"addressId":"170803092651821022","custId":"170725183828469007","name":"啊2月了。我也","mobile":"15868475213","province":"浙江省","city":"杭州市","district":"下城区","township":"东新街道","street":"石祥路","streetnumber":"","building":"炉鱼(杭州中大银泰城店)","fAddress":"浙江省杭州市下城区东新街道炉鱼(杭州中大银泰城店)中大银泰城","dAddress":"吧发布了一个月了","isDefault":"1","lgt":"120.174837","lat":"30.326783","createTime":"2017-08-03 09:26:58","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170725183639323000","custId":"170725183828469007","name":"方正","mobile":"15988481506","province":"浙江省","city":"杭州市","district":"下城区","township":"石桥街道","street":"东新路","streetnumber":"","building":"中大银泰城","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"4号楼5楼","isDefault":"0","lgt":"120.175919","lat":"30.32743","createTime":"2017-07-25 18:36:56","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801153250592046","custId":"170725183828469007","name":"舒少勇","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:29:07","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801153756682058","custId":"170725183828469007","name":"把握不好","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:34:13","updateTime":null,"status":null,"updateTime2":null},{"addressId":"170801155219106036","custId":"170725183828469007","name":"1456","mobile":"15067774157","province":"浙江省","city":"杭州市","district":"下城区","township":null,"street":"石祥路","streetnumber":"134号","building":"未知","fAddress":"浙江省杭州市下城区石桥街道中大银泰城","dAddress":"浙江省杭州市下城区石桥街道中大银泰城","isDefault":"0","lgt":"30.327601","lat":"30.327601","createTime":"2017-08-01 15:52:25","updateTime":null,"status":null,"updateTime2":null}]
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
             * addressId : 170803092651821022
             * custId : 170725183828469007
             * name : 啊2月了。我也
             * mobile : 15868475213
             * province : 浙江省
             * city : 杭州市
             * district : 下城区
             * township : 东新街道
             * street : 石祥路
             * streetnumber :
             * building : 炉鱼(杭州中大银泰城店)
             * fAddress : 浙江省杭州市下城区东新街道炉鱼(杭州中大银泰城店)中大银泰城
             * dAddress : 吧发布了一个月了
             * isDefault : 1
             * lgt : 120.174837
             * lat : 30.326783
             * createTime : 2017-08-03 09:26:58
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

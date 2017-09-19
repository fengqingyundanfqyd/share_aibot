package com.example.aiqing.sharerobot.bean;

/**
 * Created by aiqing on 2017/9/19.
 */

public class GetSystemTimeBean {

    /**
     * coder : 0000
     * obj : {"id":"9","typeCode":"sys_code","typeName":"提现日设置","paramCode":"withdraw_cash","paramValue":"6,13,19,20,28","parentCode":null,"paremreMark":"提现日设置","status":"1","systemTime":"2017-09-19 10:28:48","systemTime2":"2017-09-19 10:28:48"}
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
         * id : 9
         * typeCode : sys_code
         * typeName : 提现日设置
         * paramCode : withdraw_cash
         * paramValue : 6,13,19,20,28
         * parentCode : null
         * paremreMark : 提现日设置
         * status : 1
         * systemTime : 2017-09-19 10:28:48
         * systemTime2 : 2017-09-19 10:28:48
         */

        private String id;
        private String typeCode;
        private String typeName;
        private String paramCode;
        private String paramValue;
        private Object parentCode;
        private String paremreMark;
        private String status;
        private String systemTime;
        private String systemTime2;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getParamCode() {
            return paramCode;
        }

        public void setParamCode(String paramCode) {
            this.paramCode = paramCode;
        }

        public String getParamValue() {
            return paramValue;
        }

        public void setParamValue(String paramValue) {
            this.paramValue = paramValue;
        }

        public Object getParentCode() {
            return parentCode;
        }

        public void setParentCode(Object parentCode) {
            this.parentCode = parentCode;
        }

        public String getParemreMark() {
            return paremreMark;
        }

        public void setParemreMark(String paremreMark) {
            this.paremreMark = paremreMark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSystemTime() {
            return systemTime;
        }

        public void setSystemTime(String systemTime) {
            this.systemTime = systemTime;
        }

        public String getSystemTime2() {
            return systemTime2;
        }

        public void setSystemTime2(String systemTime2) {
            this.systemTime2 = systemTime2;
        }
    }
}

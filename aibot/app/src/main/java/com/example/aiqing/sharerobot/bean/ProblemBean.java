package com.example.aiqing.sharerobot.bean;

import java.util.List;

/**
 * Created by aiqing on 2017/9/13.
 */

public class ProblemBean {

    /**
     * deposit : 0.0300
     * coder : 0000
     * msg : 查询成功
     * obj : [{"pfiId":"18","ptypeId":"1","name":"内部掏空","description":"内部主板零件掏空","fee":0.01,"sort":18,"status":"1"},{"pfiId":"19","ptypeId":"1","name":"整机丢失","description":"整机丢失","fee":0.01,"sort":19,"status":"1"}]
     */

    private String deposit;
    private String coder;
    private String msg;
    private List<ObjBean> obj;

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * pfiId : 18
         * ptypeId : 1
         * name : 内部掏空
         * description : 内部主板零件掏空
         * fee : 0.01
         * sort : 18
         * status : 1
         */

        private String pfiId;
        private String ptypeId;
        private String name;
        private String description;
        private double fee;
        private int sort;
        private String status;

        public String getPfiId() {
            return pfiId;
        }

        public void setPfiId(String pfiId) {
            this.pfiId = pfiId;
        }

        public String getPtypeId() {
            return ptypeId;
        }

        public void setPtypeId(String ptypeId) {
            this.ptypeId = ptypeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getFee() {
            return fee;
        }

        public void setFee(double fee) {
            this.fee = fee;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

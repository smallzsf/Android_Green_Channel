package com.xyj.strokeaid.bean;

/**
 * BaseResponseBean
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/9
 * email ：licy3051@qq.com
 */
public class BaseResponseBean<T extends Object> {


    /**
     * result : 1
     * message : null
     * data : {"userId":null,"tenantId":null,"id":null,"moduleId":null,"mkId":null,"auth":null,"sign":null,"pyt":null,"status":null,"createdBy":null,"createdByName":null,"createdByDate":null,"updatedBy":null,"updatedByName":null,"updatedByDate":null,"recordId":"752594697788198912","emergencyType":null,"createTime":null,"jsonText":null,"data":{"emergencydoctorreception":"","receptiontime":"","emergencydoctorreceptiontime":"","emergencynursereception":"","arrivedertime":"2020-09-09 19:03:41","arrivegatetime":"","receptionlocation":""}}
     */

    private int result;
    private String message;
    private DataBeanX<T> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX<T> getData() {
        return data;
    }

    public void setData(DataBeanX<T> data) {
        this.data = data;
    }

    public static class DataBeanX<T> {
        /**
         * userId : null
         * tenantId : null
         * id : null
         * moduleId : null
         * mkId : null
         * auth : null
         * sign : null
         * pyt : null
         * status : null
         * createdBy : null
         * createdByName : null
         * createdByDate : null
         * updatedBy : null
         * updatedByName : null
         * updatedByDate : null
         * recordId : 752594697788198912
         * emergencyType : null
         * createTime : null
         * jsonText : null
         * data : {"emergencydoctorreception":"","receptiontime":"","emergencydoctorreceptiontime":"","emergencynursereception":"","arrivedertime":"2020-09-09 19:03:41","arrivegatetime":"","receptionlocation":""}
         */

        private String id;
        private String recordId;
        private T data;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

    
    
       
    
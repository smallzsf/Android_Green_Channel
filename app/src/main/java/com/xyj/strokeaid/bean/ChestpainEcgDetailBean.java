package com.xyj.strokeaid.bean;

import com.xyj.strokeaid.base.BaseBean;

import java.util.List;

public class ChestpainEcgDetailBean extends BaseBean<ChestpainEcgDetailBean> {

    /**
     * userId : null
     * tenantId : null
     * id : 752972531077615616
     * moduleId : null
     * mkId : null
     * auth : null
     * sign : null
     * pyt : null
     * recordId : 505
     * ecgisexist : cpc_bool_true
     * ecgnotexistreason : cpc_bool_true
     * ecgisremotetransmission : cpc_ycxdtcsfs_wcs
     * ecgremotetransmissiontime : 2020-09-06 14:31:00
     * ecgremotetransmissionway : cpc_transway_wechat
     * ecgarray : [{"userId":null,"tenantId":null,"id":null,"moduleId":null,"mkId":null,"auth":null,"sign":null,"pyt":null,"recordId":"505","ecgtime":"2020-09-07 15:31:00","ecgfile":"/upload/files/20200904/3d050f2c-2146-43e8-9d77-ba9737ec5930.pdf,/upload/files/20200904/3d050f2c-2146-43e8-9d77-ba9737ec5930.pdf","ecgdiagnosistime":"2020-09-07 14:31:00","ecgdiagnosed":"你真好aaa","ecgrepguid":"asf"}]
     */

    private Object userId;
    private Object tenantId;
    private String id;
    private Object moduleId;
    private Object mkId;
    private Object auth;
    private Object sign;
    private Object pyt;
    private String recordId;
    private String ecgisexist;
    private String ecgnotexistreason;
    private String ecgisremotetransmission;
    private String ecgremotetransmissiontime;
    private String ecgremotetransmissionway;
    private List<EcgarrayBean> ecgarray;

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Object userId) {
        this.userId = userId;
    }

    public Object getTenantId() {
        return tenantId;
    }

    public void setTenantId(Object tenantId) {
        this.tenantId = tenantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getModuleId() {
        return moduleId;
    }

    public void setModuleId(Object moduleId) {
        this.moduleId = moduleId;
    }

    public Object getMkId() {
        return mkId;
    }

    public void setMkId(Object mkId) {
        this.mkId = mkId;
    }

    public Object getAuth() {
        return auth;
    }

    public void setAuth(Object auth) {
        this.auth = auth;
    }

    public Object getSign() {
        return sign;
    }

    public void setSign(Object sign) {
        this.sign = sign;
    }

    public Object getPyt() {
        return pyt;
    }

    public void setPyt(Object pyt) {
        this.pyt = pyt;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getEcgisexist() {
        return ecgisexist;
    }

    public void setEcgisexist(String ecgisexist) {
        this.ecgisexist = ecgisexist;
    }

    public String getEcgnotexistreason() {
        return ecgnotexistreason;
    }

    public void setEcgnotexistreason(String ecgnotexistreason) {
        this.ecgnotexistreason = ecgnotexistreason;
    }

    public String getEcgisremotetransmission() {
        return ecgisremotetransmission;
    }

    public void setEcgisremotetransmission(String ecgisremotetransmission) {
        this.ecgisremotetransmission = ecgisremotetransmission;
    }

    public String getEcgremotetransmissiontime() {
        return ecgremotetransmissiontime;
    }

    public void setEcgremotetransmissiontime(String ecgremotetransmissiontime) {
        this.ecgremotetransmissiontime = ecgremotetransmissiontime;
    }

    public String getEcgremotetransmissionway() {
        return ecgremotetransmissionway;
    }

    public void setEcgremotetransmissionway(String ecgremotetransmissionway) {
        this.ecgremotetransmissionway = ecgremotetransmissionway;
    }

    public List<EcgarrayBean> getEcgarray() {
        return ecgarray;
    }

    public void setEcgarray(List<EcgarrayBean> ecgarray) {
        this.ecgarray = ecgarray;
    }

    public static class EcgarrayBean {
        /**
         * userId : null
         * tenantId : null
         * id : null
         * moduleId : null
         * mkId : null
         * auth : null
         * sign : null
         * pyt : null
         * recordId : 505
         * ecgtime : 2020-09-07 15:31:00
         * ecgfile : /upload/files/20200904/3d050f2c-2146-43e8-9d77-ba9737ec5930.pdf,/upload/files/20200904/3d050f2c-2146-43e8-9d77-ba9737ec5930.pdf
         * ecgdiagnosistime : 2020-09-07 14:31:00
         * ecgdiagnosed : 你真好aaa
         * ecgrepguid : asf
         */

        private Object userId;
        private Object tenantId;
        private Object id;
        private Object moduleId;
        private Object mkId;
        private Object auth;
        private Object sign;
        private Object pyt;
        private String recordId;
        private String ecgtime;
        private String ecgfile;
        private String ecgdiagnosistime;
        private String ecgdiagnosed;
        private String ecgrepguid;

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Object getTenantId() {
            return tenantId;
        }

        public void setTenantId(Object tenantId) {
            this.tenantId = tenantId;
        }

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getModuleId() {
            return moduleId;
        }

        public void setModuleId(Object moduleId) {
            this.moduleId = moduleId;
        }

        public Object getMkId() {
            return mkId;
        }

        public void setMkId(Object mkId) {
            this.mkId = mkId;
        }

        public Object getAuth() {
            return auth;
        }

        public void setAuth(Object auth) {
            this.auth = auth;
        }

        public Object getSign() {
            return sign;
        }

        public void setSign(Object sign) {
            this.sign = sign;
        }

        public Object getPyt() {
            return pyt;
        }

        public void setPyt(Object pyt) {
            this.pyt = pyt;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getEcgtime() {
            return ecgtime;
        }

        public void setEcgtime(String ecgtime) {
            this.ecgtime = ecgtime;
        }

        public String getEcgfile() {
            return ecgfile;
        }

        public void setEcgfile(String ecgfile) {
            this.ecgfile = ecgfile;
        }

        public String getEcgdiagnosistime() {
            return ecgdiagnosistime;
        }

        public void setEcgdiagnosistime(String ecgdiagnosistime) {
            this.ecgdiagnosistime = ecgdiagnosistime;
        }

        public String getEcgdiagnosed() {
            return ecgdiagnosed;
        }

        public void setEcgdiagnosed(String ecgdiagnosed) {
            this.ecgdiagnosed = ecgdiagnosed;
        }

        public String getEcgrepguid() {
            return ecgrepguid;
        }

        public void setEcgrepguid(String ecgrepguid) {
            this.ecgrepguid = ecgrepguid;
        }
    }
}

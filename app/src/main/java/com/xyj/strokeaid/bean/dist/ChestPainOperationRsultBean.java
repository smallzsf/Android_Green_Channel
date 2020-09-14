package com.xyj.strokeaid.bean.dist;

import com.google.gson.annotations.SerializedName;
import com.xyj.strokeaid.base.BaseBean;

import java.util.List;

public class ChestPainOperationRsultBean extends BaseBean<ChestPainOperationRsultBean> {
    // 入路
    private String arterialapproach;
    // 部位（参考字典）
    private String coronaryangiography;
    // 腔内影像（"cpc_
    private String intracavitaryimaging;
    //  功能检测
    private String  functiondetection;
    // IABP
    private String  isiabp;
    // 临时起搏器
    private String istemporarypacemaker;
    // ECMO
    private String isecmo;
    // 左心室辅助装置
    private String isleftventassistdevice;
    // 术中并发症
    private String intraoperativecomplications;


    /**
     * userId : VDSu
     * tenantId : h)Gy!O
     * id : y7CB%$
     * moduleId : 9H*Q
     * mkId : )sSVR
     * auth : ZtM
     * sign : CdM
     * pyt : oLwV(rz
     * status : i]Gjg
     * createdBy : qg@QS
     * createdByName : uC#
     * createdByDate : sgi
     * updatedBy : hHMX0K
     * updatedByName : bry1CCx
     * updatedByDate : qfM$j
     * recordId : 3RLuM
     * functiondetectionvalue : v8*Fa
     * coronaryangiographyarray : [{"userId":"N0NCX","tenantId":"#QOT@","id":"wfrPGg","moduleId":"rDpp","mkId":"I)q1","auth":"(i7Zz","sign":")rs3j0","pyt":"0s8H","status":"k0e","createdBy":"GOt41M","createdByName":"AH!K^Y]","createdByDate":"&vay06T","updatedBy":"KuKi","updatedByName":"f2reN","updatedByDate":"XCI)s","recordId":"RNL","coronaryangiography":"sGYc","degreeofarterystenosis":"GD!e","timibefore":"cYY!#u(","isthrombosisinstent":"ZSrej","isbifurcation":"rjJA","iscto":"R[9H*Z","iscalcified":"@5lGE","iscriminal":"[XE4wv","ispci":"L)2!&N","intraoperativemanagement":"*n*zL","operationguidewirepasstime":"1986-01-22","timiafter":"PkUz","numberofstentsimplanted":"gCqc","stenttype":"ccmYe"}]
     */

    private String userId;
    private String tenantId;
    private String id;
    private String moduleId;
    private String mkId;
    private String auth;
    private String sign;
    private String pyt;
    private String status;
    private String createdBy;
    private String createdByName;
    private String createdByDate;
    private String updatedBy;
    private String updatedByName;
    private String updatedByDate;
    private String recordId;
    private String functiondetectionvalue;
    private List<CoronaryangiographyarrayBean> coronaryangiographyarray;

    public String getArterialapproach() {
        return arterialapproach;
    }

    public void setArterialapproach(String arterialapproach) {
        this.arterialapproach = arterialapproach;
    }

    public String getCoronaryangiography() {
        return coronaryangiography;
    }

    public void setCoronaryangiography(String coronaryangiography) {
        this.coronaryangiography = coronaryangiography;
    }

    public String getIntracavitaryimaging() {
        return intracavitaryimaging;
    }

    public void setIntracavitaryimaging(String intracavitaryimaging) {
        this.intracavitaryimaging = intracavitaryimaging;
    }

    public String getFunctiondetection() {
        return functiondetection;
    }

    public void setFunctiondetection(String functiondetection) {
        this.functiondetection = functiondetection;
    }

    public String getIsiabp() {
        return isiabp;
    }

    public void setIsiabp(String isiabp) {
        this.isiabp = isiabp;
    }

    public String getIstemporarypacemaker() {
        return istemporarypacemaker;
    }

    public void setIstemporarypacemaker(String istemporarypacemaker) {
        this.istemporarypacemaker = istemporarypacemaker;
    }

    public String getIsecmo() {
        return isecmo;
    }

    public void setIsecmo(String isecmo) {
        this.isecmo = isecmo;
    }

    public String getIsleftventassistdevice() {
        return isleftventassistdevice;
    }

    public void setIsleftventassistdevice(String isleftventassistdevice) {
        this.isleftventassistdevice = isleftventassistdevice;
    }

    public String getIntraoperativecomplications() {
        return intraoperativecomplications;
    }

    public void setIntraoperativecomplications(String intraoperativecomplications) {
        this.intraoperativecomplications = intraoperativecomplications;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getMkId() {
        return mkId;
    }

    public void setMkId(String mkId) {
        this.mkId = mkId;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPyt() {
        return pyt;
    }

    public void setPyt(String pyt) {
        this.pyt = pyt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(String createdByDate) {
        this.createdByDate = createdByDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedByName() {
        return updatedByName;
    }

    public void setUpdatedByName(String updatedByName) {
        this.updatedByName = updatedByName;
    }

    public String getUpdatedByDate() {
        return updatedByDate;
    }

    public void setUpdatedByDate(String updatedByDate) {
        this.updatedByDate = updatedByDate;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getFunctiondetectionvalue() {
        return functiondetectionvalue;
    }

    public void setFunctiondetectionvalue(String functiondetectionvalue) {
        this.functiondetectionvalue = functiondetectionvalue;
    }

    public List<CoronaryangiographyarrayBean> getCoronaryangiographyarray() {
        return coronaryangiographyarray;
    }

    public void setCoronaryangiographyarray(List<CoronaryangiographyarrayBean> coronaryangiographyarray) {
        this.coronaryangiographyarray = coronaryangiographyarray;
    }

    public static class CoronaryangiographyarrayBean {
        /**
         * userId : N0NCX
         * tenantId : #QOT@
         * id : wfrPGg
         * moduleId : rDpp
         * mkId : I)q1
         * auth : (i7Zz
         * sign : )rs3j0
         * pyt : 0s8H
         * status : k0e
         * createdBy : GOt41M
         * createdByName : AH!K^Y]
         * createdByDate : &vay06T
         * updatedBy : KuKi
         * updatedByName : f2reN
         * updatedByDate : XCI)s
         * recordId : RNL
         * coronaryangiography : sGYc
         * degreeofarterystenosis : GD!e
         * timibefore : cYY!#u(
         * isthrombosisinstent : ZSrej
         * isbifurcation : rjJA
         * iscto : R[9H*Z
         * iscalcified : @5lGE
         * iscriminal : [XE4wv
         * ispci : L)2!&N
         * intraoperativemanagement : *n*zL
         * operationguidewirepasstime : 1986-01-22
         * timiafter : PkUz
         * numberofstentsimplanted : gCqc
         * stenttype : ccmYe
         */

        private String userId;
        private String tenantId;
        private String id;
        private String moduleId;
        private String mkId;
        private String auth;
        private String sign;
        private String pyt;
        private String status;
        private String createdBy;
        private String createdByName;
        private String createdByDate;
        private String updatedBy;
        private String updatedByName;
        private String updatedByDate;
        private String recordId;
        @SerializedName("coronaryangiography")
        private String coronaryangiographyX;
        private String degreeofarterystenosis;
        private String timibefore;
        private String isthrombosisinstent;
        private String isbifurcation;
        private String iscto;
        private String iscalcified;
        private String iscriminal;
        private String ispci;
        private String intraoperativemanagement;
        private String operationguidewirepasstime;
        private String timiafter;
        private String numberofstentsimplanted;
        private String stenttype;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModuleId() {
            return moduleId;
        }

        public void setModuleId(String moduleId) {
            this.moduleId = moduleId;
        }

        public String getMkId() {
            return mkId;
        }

        public void setMkId(String mkId) {
            this.mkId = mkId;
        }

        public String getAuth() {
            return auth;
        }

        public void setAuth(String auth) {
            this.auth = auth;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getPyt() {
            return pyt;
        }

        public void setPyt(String pyt) {
            this.pyt = pyt;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getCreatedByName() {
            return createdByName;
        }

        public void setCreatedByName(String createdByName) {
            this.createdByName = createdByName;
        }

        public String getCreatedByDate() {
            return createdByDate;
        }

        public void setCreatedByDate(String createdByDate) {
            this.createdByDate = createdByDate;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public String getUpdatedByName() {
            return updatedByName;
        }

        public void setUpdatedByName(String updatedByName) {
            this.updatedByName = updatedByName;
        }

        public String getUpdatedByDate() {
            return updatedByDate;
        }

        public void setUpdatedByDate(String updatedByDate) {
            this.updatedByDate = updatedByDate;
        }

        public String getRecordId() {
            return recordId;
        }

        public void setRecordId(String recordId) {
            this.recordId = recordId;
        }

        public String getCoronaryangiographyX() {
            return coronaryangiographyX;
        }

        public void setCoronaryangiographyX(String coronaryangiographyX) {
            this.coronaryangiographyX = coronaryangiographyX;
        }

        public String getDegreeofarterystenosis() {
            return degreeofarterystenosis;
        }

        public void setDegreeofarterystenosis(String degreeofarterystenosis) {
            this.degreeofarterystenosis = degreeofarterystenosis;
        }

        public String getTimibefore() {
            return timibefore;
        }

        public void setTimibefore(String timibefore) {
            this.timibefore = timibefore;
        }

        public String getIsthrombosisinstent() {
            return isthrombosisinstent;
        }

        public void setIsthrombosisinstent(String isthrombosisinstent) {
            this.isthrombosisinstent = isthrombosisinstent;
        }

        public String getIsbifurcation() {
            return isbifurcation;
        }

        public void setIsbifurcation(String isbifurcation) {
            this.isbifurcation = isbifurcation;
        }

        public String getIscto() {
            return iscto;
        }

        public void setIscto(String iscto) {
            this.iscto = iscto;
        }

        public String getIscalcified() {
            return iscalcified;
        }

        public void setIscalcified(String iscalcified) {
            this.iscalcified = iscalcified;
        }

        public String getIscriminal() {
            return iscriminal;
        }

        public void setIscriminal(String iscriminal) {
            this.iscriminal = iscriminal;
        }

        public String getIspci() {
            return ispci;
        }

        public void setIspci(String ispci) {
            this.ispci = ispci;
        }

        public String getIntraoperativemanagement() {
            return intraoperativemanagement;
        }

        public void setIntraoperativemanagement(String intraoperativemanagement) {
            this.intraoperativemanagement = intraoperativemanagement;
        }

        public String getOperationguidewirepasstime() {
            return operationguidewirepasstime;
        }

        public void setOperationguidewirepasstime(String operationguidewirepasstime) {
            this.operationguidewirepasstime = operationguidewirepasstime;
        }

        public String getTimiafter() {
            return timiafter;
        }

        public void setTimiafter(String timiafter) {
            this.timiafter = timiafter;
        }

        public String getNumberofstentsimplanted() {
            return numberofstentsimplanted;
        }

        public void setNumberofstentsimplanted(String numberofstentsimplanted) {
            this.numberofstentsimplanted = numberofstentsimplanted;
        }

        public String getStenttype() {
            return stenttype;
        }

        public void setStenttype(String stenttype) {
            this.stenttype = stenttype;
        }
    }
}

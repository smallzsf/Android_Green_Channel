package com.xyj.strokeaid.bean.dist;

import java.util.List;

public class DistBean {

    /**
     * FieldName : InterventricularArtery
     * FieldLabel : 后降支室间支
     * GroupName : OperationResult
     * FieldDisplayType : 10
     * FieldValueType : 18
     * RequiredType : 1
     * VisibleRuleId : 300900274
     * ForbiddenRuleId : 0
     * HasDefaultValue : false
     * DefaultValue :
     * Remark : 后降支室间支
     * FormId : 0
     * MaxLength : 0
     * FieldType : module
     * OptionData : null
     * TreeOptionData : null
     * VisibleRule : {"JsContent":"function _fun_(InitialDiagnosis,IsSTEMIReperfusionMeasure,STEMIReperfusionMeasure,STEMIReperfusionMeasureThrombolysis,TPCIType,ACSReperfusionMeasure,ReGraceRiskLevel,CoronaryAngiography) {        if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zjpci\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_rs\"&&(STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_bjpci\"||STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_rshjr\")){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zypci\"&&TPCIType==\"cpc_tpcitype_jshz\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_nstemi\"&&ACSReperfusionMeasure==\"cpc_acs_zgzcsv2_jjjrzl\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_ua\"&&ACSReperfusionMeasure==\"cpc_acs_zgzcsv2_jjjrzl\"){return IsChecked(CoronaryAngiography);}if((InitialDiagnosis==\"cpc_cbzdv2_nstemi\"||InitialDiagnosis==\"cpc_cbzdv2_ua\")&&ReGraceRiskLevel==\"cpc_regracefc_zwstemi\"){if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zjpci\"){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_rs\"&&(STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_bjpci\"||STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_rshjr\")){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zypci\"&&TPCIType==\"cpc_tpcitype_jshz\"){return IsChecked(CoronaryAngiography);}}return false;function IsChecked(CoronaryAngiography) {if (CoronaryAngiography && CoronaryAngiography.indexOf(\"cpc_coronaryangiography_yjzsjz\") != -1) return true;return false;}    }","RuleParam":["InitialDiagnosis","IsSTEMIReperfusionMeasure","STEMIReperfusionMeasure","STEMIReperfusionMeasureThrombolysis","TPCIType","ACSReperfusionMeasure","ReGraceRiskLevel","CoronaryAngiography"],"RuleContent":"        if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zjpci\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_rs\"&&(STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_bjpci\"||STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_rshjr\")){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_stemi\"&&IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zypci\"&&TPCIType==\"cpc_tpcitype_jshz\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_nstemi\"&&ACSReperfusionMeasure==\"cpc_acs_zgzcsv2_jjjrzl\"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis==\"cpc_cbzdv2_ua\"&&ACSReperfusionMeasure==\"cpc_acs_zgzcsv2_jjjrzl\"){return IsChecked(CoronaryAngiography);}if((InitialDiagnosis==\"cpc_cbzdv2_nstemi\"||InitialDiagnosis==\"cpc_cbzdv2_ua\")&&ReGraceRiskLevel==\"cpc_regracefc_zwstemi\"){if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zjpci\"){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_rs\"&&(STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_bjpci\"||STEMIReperfusionMeasureThrombolysis==\"cpc_rs_zgzcs_rshjr\")){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure==\"cpc_bool_true\"&&STEMIReperfusionMeasure==\"cpc_stemi_zgzcsv2_zypci\"&&TPCIType==\"cpc_tpcitype_jshz\"){return IsChecked(CoronaryAngiography);}}return false;function IsChecked(CoronaryAngiography) {if (CoronaryAngiography && CoronaryAngiography.indexOf(\"cpc_coronaryangiography_yjzsjz\") != -1) return true;return false;}    ","TargetFieldName":"InterventricularArtery"}
     * ForbiddenRule : null
     * ValidateRules : null
     * JsValidateRule : null
     * IsChinaCPCField : false
     * ChinaCPCRuleId : null
     * ChinaCPCFieldRule : null
     * ChinaCPCMultiRequiredRuleId : null
     * ChinaCPCMultiRequiredRule : null
     * ModuleName : GMZYModule
     * FormGroupFields : [{"FieldName":"DegreeOfArteryStenosis","FieldLabel":"狭窄程度","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"狭窄程度","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_xzcd_xy50":"<50%","cpc_xzcd_50z69":"50~69%","cpc_xzcd_70z89":"70~89%","cpc_xzcd_90z99":"90~99%","cpc_xzcd_100":"100%"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"TIMIBefore","FieldLabel":"造影时TIMI血流","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"造影时TIMI血流","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_timi_0":"0级","cpc_timi_1":"1级","cpc_timi_2":"2级","cpc_timi_3":"3级"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsThrombosisInStent","FieldLabel":"支架内血栓","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"支架内血栓","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsBifurcation","FieldLabel":"是否分叉病变","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"是否分叉病变","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsCTO","FieldLabel":"是否CTO","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"是否CTO","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsCalcified","FieldLabel":"钙化病变","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"钙化病变","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsCriminal","FieldLabel":"罪犯病变","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"罪犯病变","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IsPCI","FieldLabel":"PCI","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"0","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"PCI","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_bool_true":"是","cpc_bool_false":"否"},"TreeOptionData":null,"VisibleRule":null,"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"IntraoperativeManagement","FieldLabel":"术中处理","GroupName":"","FieldDisplayType":5,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"300900278","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"术中处理","FormId":"0","MaxLength":0,"FieldType":"checkboxGroup","OptionData":{"cpc_intraoperativemanagement_zrzj":"植入支架","cpc_intraoperativemanagement_ptca":"PTCA","cpc_intraoperativemanagement_xscx":"血栓抽吸","cpc_intraoperativemanagement_gmnrs":"冠脉内溶栓","cpc_intraoperativemanagement_jsyds":"仅使用导丝","cpc_intraoperativemanagement_qt":"其他","cpc_intraoperativemanagement_wu":"无"},"TreeOptionData":null,"VisibleRule":{"JsContent":"function _fun_(IsPCI) {return IsPCI == \"cpc_bool_true\";}","RuleParam":["IsPCI"],"RuleContent":"return IsPCI == \"cpc_bool_true\";","TargetFieldName":"IntraoperativeManagement"},"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"OperationGuidewirePassTime","FieldLabel":"导丝通过时间","GroupName":"","FieldDisplayType":8,"FieldValueType":16,"RequiredType":1,"VisibleRuleId":"300900278","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"导丝通过时间","FormId":"0","MaxLength":0,"FieldType":"datetime","OptionData":null,"TreeOptionData":null,"VisibleRule":{"JsContent":"function _fun_(IsPCI) {return IsPCI == \"cpc_bool_true\";}","RuleParam":["IsPCI"],"RuleContent":"return IsPCI == \"cpc_bool_true\";","TargetFieldName":"OperationGuidewirePassTime"},"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"TIMIAfter","FieldLabel":"术后TIMI血流","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"300900278","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"术后TIMI血流","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_timi_0":"0级","cpc_timi_1":"1级","cpc_timi_2":"2级","cpc_timi_3":"3级"},"TreeOptionData":null,"VisibleRule":{"JsContent":"function _fun_(IsPCI) {return IsPCI == \"cpc_bool_true\";}","RuleParam":["IsPCI"],"RuleContent":"return IsPCI == \"cpc_bool_true\";","TargetFieldName":"TIMIAfter"},"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"NumberOfStentsImplanted","FieldLabel":"植入支架个数","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"300900278","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"植入支架个数","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_zrzjgs_0":"0枚","cpc_zrzjgs_1":"1枚","cpc_zrzjgs_2":"2枚","cpc_zrzjgs_dydy3":"≥3枚"},"TreeOptionData":null,"VisibleRule":{"JsContent":"function _fun_(IsPCI) {return IsPCI == \"cpc_bool_true\";}","RuleParam":["IsPCI"],"RuleContent":"return IsPCI == \"cpc_bool_true\";","TargetFieldName":"NumberOfStentsImplanted"},"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1},{"FieldName":"StentType","FieldLabel":"支架种类","GroupName":"","FieldDisplayType":3,"FieldValueType":18,"RequiredType":1,"VisibleRuleId":"300900279","ForbiddenRuleId":"0","HasDefaultValue":false,"DefaultValue":"","Remark":"支架种类","FormId":"0","MaxLength":0,"FieldType":"radioGroup","OptionData":{"cpc_stenttype_bms":"BMS","cpc_stenttype_des":"DES","cpc_stenttype_brs":"可降解支架","cpc_stenttype_other":"其他"},"TreeOptionData":null,"VisibleRule":{"JsContent":"function _fun_(IsPCI, NumberOfStentsImplanted) {if (IsPCI == \"cpc_bool_true\") {if (NumberOfStentsImplanted == \"cpc_zrzjgs_0\")return false;return true;}return false;}","RuleParam":["IsPCI","NumberOfStentsImplanted"],"RuleContent":"if (IsPCI == \"cpc_bool_true\") {if (NumberOfStentsImplanted == \"cpc_zrzjgs_0\")return false;return true;}return false;","TargetFieldName":"StentType"},"ForbiddenRule":null,"ValidateRules":null,"JsValidateRule":null,"IsChinaCPCField":true,"ChinaCPCRuleId":null,"ChinaCPCFieldRule":null,"ChinaCPCMultiRequiredRuleId":null,"ChinaCPCMultiRequiredRule":null,"ModuleName":"","FormGroupFields":null,"DiseaseType":1}]
     * DiseaseType : 1
     */

    private String FieldName;
    private String FieldLabel;
    private String GroupName;
    private int FieldDisplayType;
    private int FieldValueType;
    private int RequiredType;
    private String VisibleRuleId;
    private String ForbiddenRuleId;
    private boolean HasDefaultValue;
    private String DefaultValue;
    private String Remark;
    private String FormId;
    private int MaxLength;
    private String FieldType;
    private Object OptionData;
    private Object TreeOptionData;
    private VisibleRuleBean VisibleRule;
    private Object ForbiddenRule;
    private Object ValidateRules;
    private Object JsValidateRule;
    private boolean IsChinaCPCField;
    private Object ChinaCPCRuleId;
    private Object ChinaCPCFieldRule;
    private Object ChinaCPCMultiRequiredRuleId;
    private Object ChinaCPCMultiRequiredRule;
    private String ModuleName;
    private int DiseaseType;
    private List<FormGroupFieldsBean> FormGroupFields;

    public String getFieldName() {
        return FieldName;
    }

    public void setFieldName(String FieldName) {
        this.FieldName = FieldName;
    }

    public String getFieldLabel() {
        return FieldLabel;
    }

    public void setFieldLabel(String FieldLabel) {
        this.FieldLabel = FieldLabel;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    public int getFieldDisplayType() {
        return FieldDisplayType;
    }

    public void setFieldDisplayType(int FieldDisplayType) {
        this.FieldDisplayType = FieldDisplayType;
    }

    public int getFieldValueType() {
        return FieldValueType;
    }

    public void setFieldValueType(int FieldValueType) {
        this.FieldValueType = FieldValueType;
    }

    public int getRequiredType() {
        return RequiredType;
    }

    public void setRequiredType(int RequiredType) {
        this.RequiredType = RequiredType;
    }

    public String getVisibleRuleId() {
        return VisibleRuleId;
    }

    public void setVisibleRuleId(String VisibleRuleId) {
        this.VisibleRuleId = VisibleRuleId;
    }

    public String getForbiddenRuleId() {
        return ForbiddenRuleId;
    }

    public void setForbiddenRuleId(String ForbiddenRuleId) {
        this.ForbiddenRuleId = ForbiddenRuleId;
    }

    public boolean isHasDefaultValue() {
        return HasDefaultValue;
    }

    public void setHasDefaultValue(boolean HasDefaultValue) {
        this.HasDefaultValue = HasDefaultValue;
    }

    public String getDefaultValue() {
        return DefaultValue;
    }

    public void setDefaultValue(String DefaultValue) {
        this.DefaultValue = DefaultValue;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String getFormId() {
        return FormId;
    }

    public void setFormId(String FormId) {
        this.FormId = FormId;
    }

    public int getMaxLength() {
        return MaxLength;
    }

    public void setMaxLength(int MaxLength) {
        this.MaxLength = MaxLength;
    }

    public String getFieldType() {
        return FieldType;
    }

    public void setFieldType(String FieldType) {
        this.FieldType = FieldType;
    }

    public Object getOptionData() {
        return OptionData;
    }

    public void setOptionData(Object OptionData) {
        this.OptionData = OptionData;
    }

    public Object getTreeOptionData() {
        return TreeOptionData;
    }

    public void setTreeOptionData(Object TreeOptionData) {
        this.TreeOptionData = TreeOptionData;
    }

    public VisibleRuleBean getVisibleRule() {
        return VisibleRule;
    }

    public void setVisibleRule(VisibleRuleBean VisibleRule) {
        this.VisibleRule = VisibleRule;
    }

    public Object getForbiddenRule() {
        return ForbiddenRule;
    }

    public void setForbiddenRule(Object ForbiddenRule) {
        this.ForbiddenRule = ForbiddenRule;
    }

    public Object getValidateRules() {
        return ValidateRules;
    }

    public void setValidateRules(Object ValidateRules) {
        this.ValidateRules = ValidateRules;
    }

    public Object getJsValidateRule() {
        return JsValidateRule;
    }

    public void setJsValidateRule(Object JsValidateRule) {
        this.JsValidateRule = JsValidateRule;
    }

    public boolean isIsChinaCPCField() {
        return IsChinaCPCField;
    }

    public void setIsChinaCPCField(boolean IsChinaCPCField) {
        this.IsChinaCPCField = IsChinaCPCField;
    }

    public Object getChinaCPCRuleId() {
        return ChinaCPCRuleId;
    }

    public void setChinaCPCRuleId(Object ChinaCPCRuleId) {
        this.ChinaCPCRuleId = ChinaCPCRuleId;
    }

    public Object getChinaCPCFieldRule() {
        return ChinaCPCFieldRule;
    }

    public void setChinaCPCFieldRule(Object ChinaCPCFieldRule) {
        this.ChinaCPCFieldRule = ChinaCPCFieldRule;
    }

    public Object getChinaCPCMultiRequiredRuleId() {
        return ChinaCPCMultiRequiredRuleId;
    }

    public void setChinaCPCMultiRequiredRuleId(Object ChinaCPCMultiRequiredRuleId) {
        this.ChinaCPCMultiRequiredRuleId = ChinaCPCMultiRequiredRuleId;
    }

    public Object getChinaCPCMultiRequiredRule() {
        return ChinaCPCMultiRequiredRule;
    }

    public void setChinaCPCMultiRequiredRule(Object ChinaCPCMultiRequiredRule) {
        this.ChinaCPCMultiRequiredRule = ChinaCPCMultiRequiredRule;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String ModuleName) {
        this.ModuleName = ModuleName;
    }

    public int getDiseaseType() {
        return DiseaseType;
    }

    public void setDiseaseType(int DiseaseType) {
        this.DiseaseType = DiseaseType;
    }

    public List<FormGroupFieldsBean> getFormGroupFields() {
        return FormGroupFields;
    }

    public void setFormGroupFields(List<FormGroupFieldsBean> FormGroupFields) {
        this.FormGroupFields = FormGroupFields;
    }

    public static class VisibleRuleBean {
        /**
         * JsContent : function _fun_(InitialDiagnosis,IsSTEMIReperfusionMeasure,STEMIReperfusionMeasure,STEMIReperfusionMeasureThrombolysis,TPCIType,ACSReperfusionMeasure,ReGraceRiskLevel,CoronaryAngiography) {        if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zjpci"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_rs"&&(STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_bjpci"||STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_rshjr")){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zypci"&&TPCIType=="cpc_tpcitype_jshz"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_nstemi"&&ACSReperfusionMeasure=="cpc_acs_zgzcsv2_jjjrzl"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_ua"&&ACSReperfusionMeasure=="cpc_acs_zgzcsv2_jjjrzl"){return IsChecked(CoronaryAngiography);}if((InitialDiagnosis=="cpc_cbzdv2_nstemi"||InitialDiagnosis=="cpc_cbzdv2_ua")&&ReGraceRiskLevel=="cpc_regracefc_zwstemi"){if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zjpci"){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_rs"&&(STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_bjpci"||STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_rshjr")){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zypci"&&TPCIType=="cpc_tpcitype_jshz"){return IsChecked(CoronaryAngiography);}}return false;function IsChecked(CoronaryAngiography) {if (CoronaryAngiography && CoronaryAngiography.indexOf("cpc_coronaryangiography_yjzsjz") != -1) return true;return false;}    }
         * RuleParam : ["InitialDiagnosis","IsSTEMIReperfusionMeasure","STEMIReperfusionMeasure","STEMIReperfusionMeasureThrombolysis","TPCIType","ACSReperfusionMeasure","ReGraceRiskLevel","CoronaryAngiography"]
         * RuleContent :         if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zjpci"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_rs"&&(STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_bjpci"||STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_rshjr")){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_stemi"&&IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zypci"&&TPCIType=="cpc_tpcitype_jshz"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_nstemi"&&ACSReperfusionMeasure=="cpc_acs_zgzcsv2_jjjrzl"){return IsChecked(CoronaryAngiography);}if(InitialDiagnosis=="cpc_cbzdv2_ua"&&ACSReperfusionMeasure=="cpc_acs_zgzcsv2_jjjrzl"){return IsChecked(CoronaryAngiography);}if((InitialDiagnosis=="cpc_cbzdv2_nstemi"||InitialDiagnosis=="cpc_cbzdv2_ua")&&ReGraceRiskLevel=="cpc_regracefc_zwstemi"){if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zjpci"){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_rs"&&(STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_bjpci"||STEMIReperfusionMeasureThrombolysis=="cpc_rs_zgzcs_rshjr")){return IsChecked(CoronaryAngiography);}if(IsSTEMIReperfusionMeasure=="cpc_bool_true"&&STEMIReperfusionMeasure=="cpc_stemi_zgzcsv2_zypci"&&TPCIType=="cpc_tpcitype_jshz"){return IsChecked(CoronaryAngiography);}}return false;function IsChecked(CoronaryAngiography) {if (CoronaryAngiography && CoronaryAngiography.indexOf("cpc_coronaryangiography_yjzsjz") != -1) return true;return false;}
         * TargetFieldName : InterventricularArtery
         */

        private String JsContent;
        private String RuleContent;
        private String TargetFieldName;
        private List<String> RuleParam;

        public String getJsContent() {
            return JsContent;
        }

        public void setJsContent(String JsContent) {
            this.JsContent = JsContent;
        }

        public String getRuleContent() {
            return RuleContent;
        }

        public void setRuleContent(String RuleContent) {
            this.RuleContent = RuleContent;
        }

        public String getTargetFieldName() {
            return TargetFieldName;
        }

        public void setTargetFieldName(String TargetFieldName) {
            this.TargetFieldName = TargetFieldName;
        }

        public List<String> getRuleParam() {
            return RuleParam;
        }

        public void setRuleParam(List<String> RuleParam) {
            this.RuleParam = RuleParam;
        }
    }

    public static class FormGroupFieldsBean<T> {
        /**
         * FieldName : DegreeOfArteryStenosis
         * FieldLabel : 狭窄程度
         * GroupName :
         * FieldDisplayType : 3
         * FieldValueType : 18
         * RequiredType : 1
         * VisibleRuleId : 0
         * ForbiddenRuleId : 0
         * HasDefaultValue : false
         * DefaultValue :
         * Remark : 狭窄程度
         * FormId : 0
         * MaxLength : 0
         * FieldType : radioGroup
         * OptionData : {"cpc_xzcd_xy50":"<50%","cpc_xzcd_50z69":"50~69%","cpc_xzcd_70z89":"70~89%","cpc_xzcd_90z99":"90~99%","cpc_xzcd_100":"100%"}
         * TreeOptionData : null
         * VisibleRule : null
         * ForbiddenRule : null
         * ValidateRules : null
         * JsValidateRule : null
         * IsChinaCPCField : true
         * ChinaCPCRuleId : null
         * ChinaCPCFieldRule : null
         * ChinaCPCMultiRequiredRuleId : null
         * ChinaCPCMultiRequiredRule : null
         * ModuleName :
         * FormGroupFields : null
         * DiseaseType : 1
         */

        private String FieldName;
        private String FieldLabel;
        private String GroupName;
        private int FieldDisplayType;
        private int FieldValueType;
        private int RequiredType;
        private String VisibleRuleId;
        private String ForbiddenRuleId;
        private boolean HasDefaultValue;
        private String DefaultValue;
        private String Remark;
        private String FormId;
        private int MaxLength;
        private String FieldType;
        private T OptionData;
        private Object TreeOptionData;
        private Object VisibleRule;
        private Object ForbiddenRule;
        private Object ValidateRules;
        private Object JsValidateRule;
        private boolean IsChinaCPCField;
        private Object ChinaCPCRuleId;
        private Object ChinaCPCFieldRule;
        private Object ChinaCPCMultiRequiredRuleId;
        private Object ChinaCPCMultiRequiredRule;
        private String ModuleName;
        private Object FormGroupFields;
        private int DiseaseType;

        public String getFieldName() {
            return FieldName;
        }

        public void setFieldName(String FieldName) {
            this.FieldName = FieldName;
        }

        public String getFieldLabel() {
            return FieldLabel;
        }

        public void setFieldLabel(String FieldLabel) {
            this.FieldLabel = FieldLabel;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public int getFieldDisplayType() {
            return FieldDisplayType;
        }

        public void setFieldDisplayType(int FieldDisplayType) {
            this.FieldDisplayType = FieldDisplayType;
        }

        public int getFieldValueType() {
            return FieldValueType;
        }

        public void setFieldValueType(int FieldValueType) {
            this.FieldValueType = FieldValueType;
        }

        public int getRequiredType() {
            return RequiredType;
        }

        public void setRequiredType(int RequiredType) {
            this.RequiredType = RequiredType;
        }

        public String getVisibleRuleId() {
            return VisibleRuleId;
        }

        public void setVisibleRuleId(String VisibleRuleId) {
            this.VisibleRuleId = VisibleRuleId;
        }

        public String getForbiddenRuleId() {
            return ForbiddenRuleId;
        }

        public void setForbiddenRuleId(String ForbiddenRuleId) {
            this.ForbiddenRuleId = ForbiddenRuleId;
        }

        public boolean isHasDefaultValue() {
            return HasDefaultValue;
        }

        public void setHasDefaultValue(boolean HasDefaultValue) {
            this.HasDefaultValue = HasDefaultValue;
        }

        public String getDefaultValue() {
            return DefaultValue;
        }

        public void setDefaultValue(String DefaultValue) {
            this.DefaultValue = DefaultValue;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getFormId() {
            return FormId;
        }

        public void setFormId(String FormId) {
            this.FormId = FormId;
        }

        public int getMaxLength() {
            return MaxLength;
        }

        public void setMaxLength(int MaxLength) {
            this.MaxLength = MaxLength;
        }

        public String getFieldType() {
            return FieldType;
        }

        public void setFieldType(String FieldType) {
            this.FieldType = FieldType;
        }

        public T getOptionData() {
            return OptionData;
        }

        public void setOptionData(T OptionData) {
            this.OptionData = OptionData;
        }

        public Object getTreeOptionData() {
            return TreeOptionData;
        }

        public void setTreeOptionData(Object TreeOptionData) {
            this.TreeOptionData = TreeOptionData;
        }

        public Object getVisibleRule() {
            return VisibleRule;
        }

        public void setVisibleRule(Object VisibleRule) {
            this.VisibleRule = VisibleRule;
        }

        public Object getForbiddenRule() {
            return ForbiddenRule;
        }

        public void setForbiddenRule(Object ForbiddenRule) {
            this.ForbiddenRule = ForbiddenRule;
        }

        public Object getValidateRules() {
            return ValidateRules;
        }

        public void setValidateRules(Object ValidateRules) {
            this.ValidateRules = ValidateRules;
        }

        public Object getJsValidateRule() {
            return JsValidateRule;
        }

        public void setJsValidateRule(Object JsValidateRule) {
            this.JsValidateRule = JsValidateRule;
        }

        public boolean isIsChinaCPCField() {
            return IsChinaCPCField;
        }

        public void setIsChinaCPCField(boolean IsChinaCPCField) {
            this.IsChinaCPCField = IsChinaCPCField;
        }

        public Object getChinaCPCRuleId() {
            return ChinaCPCRuleId;
        }

        public void setChinaCPCRuleId(Object ChinaCPCRuleId) {
            this.ChinaCPCRuleId = ChinaCPCRuleId;
        }

        public Object getChinaCPCFieldRule() {
            return ChinaCPCFieldRule;
        }

        public void setChinaCPCFieldRule(Object ChinaCPCFieldRule) {
            this.ChinaCPCFieldRule = ChinaCPCFieldRule;
        }

        public Object getChinaCPCMultiRequiredRuleId() {
            return ChinaCPCMultiRequiredRuleId;
        }

        public void setChinaCPCMultiRequiredRuleId(Object ChinaCPCMultiRequiredRuleId) {
            this.ChinaCPCMultiRequiredRuleId = ChinaCPCMultiRequiredRuleId;
        }

        public Object getChinaCPCMultiRequiredRule() {
            return ChinaCPCMultiRequiredRule;
        }

        public void setChinaCPCMultiRequiredRule(Object ChinaCPCMultiRequiredRule) {
            this.ChinaCPCMultiRequiredRule = ChinaCPCMultiRequiredRule;
        }

        public String getModuleName() {
            return ModuleName;
        }

        public void setModuleName(String ModuleName) {
            this.ModuleName = ModuleName;
        }

        public Object getFormGroupFields() {
            return FormGroupFields;
        }

        public void setFormGroupFields(Object FormGroupFields) {
            this.FormGroupFields = FormGroupFields;
        }

        public int getDiseaseType() {
            return DiseaseType;
        }

        public void setDiseaseType(int DiseaseType) {
            this.DiseaseType = DiseaseType;
        }

    }
}

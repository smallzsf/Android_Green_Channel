package com.xyj.strokeaid.bean;


import java.util.Date;

/**
 * NIHSS
 */
//@TableName("EMERGENCY_CENTER_STROKE_TOOL_NIHSS")
public class ToolnihssBean {

    /**
     * ID
     */
    //@TableField(value = "ID")
    private String id;
    
    /**
     * 1a.意识水平     （0=清醒，反应灵敏,1=嗜睡，轻微刺激能唤醒，可回答问题，执行指令,2=昏睡或反应迟钝，需反复刺激、强烈或疼痛刺激才有非刻板的反应,3=昏迷，仅有反射性活动或自发性反应或完全无反应、软瘫、无反射）
     */
    //@TableField(value = "NIHSS_CONSCIOUSNESS")
    private Integer nihssConsciousness;
    
    /**
     * 1b.意识水平提问（0=两项均正确，1=一项正确，2=两项均不正确）
     */
    //@TableField(value = "NIHSS_CONSCIOUSNESSQUESTION")
    private Integer nihssConsciousnessquestion;
    
    /**
     * 1c.意识水平指令（0=两项均正确，1=一项正确，2=两项均不正确）
     */
    //@TableField(value = "NIHSS_CONSCIOUSNESSCOMMAND")
    private Integer nihssConsciousnesscommand;
    
    /**
     * 2.凝视（0=正常，1=部分凝视麻痹（单眼或双眼凝视异常，但无强迫凝视或凝视麻痹），2=强迫凝视或完全凝视麻痹（不能被头眼反射克服））
     */
    //@TableField(value = "NIHSS_EYEBALLGAZE")
    private Integer nihssEyeballgaze;
    
    /**
     * 3.视野（0=无视野缺损，1=部分偏盲，2=完全偏盲，3=双侧偏盲（包括皮质盲））
     */
    //@TableField(value = "NIHSS_EYSSIGHT")
    private Integer nihssEyssight;
    
    /**
     * 4.面瘫（0=正常，1=轻微（微笑时鼻唇沟变平、不对称），2=部分（下面部完全或几乎完全瘫痪），3=完全（单或双侧瘫痪，上下面部缺乏运动））
     */
    //@TableField(value = "NIHSS_FACIALPARALYSIS")
    private Integer nihssFacialparalysis;
    
    /**
     * 5a.上肢运动左侧（0=上肢于要求位置坚持10秒，无下落，1=上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物，2=能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上，3=不能抗重力，上肢快速下落，4=无运动，
9=截肢或关节融合）
     */
    //@TableField(value = "NIHSS_WEAKNESSTOPLEFT")
    private Integer nihssWeaknesstopleft;
    
    /**
     * 5b.上肢运动右侧（
0=上肢于要求位置坚持10秒，无下落，1=上肢能抬起，但不能维持10秒，下落时不撞击床或其他支持物，2=能对抗一些重力，但上肢不能达到或维持坐位90°或卧位45°，较快下落到床上，3=不能抗重力，上肢快速下落，4=无运动，9=截肢或关节融合）
     */
    //@TableField(value = "NIHSS_WEAKNESSTOPRIGHT")
    private Integer nihssWeaknesstopright;
    
    /**
     * 6a.下肢运动左侧（0=下肢于要求位置坚持5秒，无下落，1=在5秒末下落，不撞击床，2=5秒内较快下落到床上，但可抗重力，3=快速下落，不能抗重力，4=无运动，9=截肢或关节融合）
     */
    //@TableField(value = "NIHSS_WEAKNESSBOTTOMLEFT")
    private Integer nihssWeaknessbottomleft;
    
    /**
     * 6c.下肢运动右侧（0=下肢于要求位置坚持5秒，无下落，1=在5秒末下落，不撞击床，
2=5秒内较快下落到床上，但可抗重力，3=快速下落，不能抗重力，
4=无运动，9=截肢或关节融合）
     */
    //@TableField(value = "NIHSS_WEAKNESSBOTTOMRIGHT")
    private Integer nihssWeaknessbottomright;
    
    /**
     * 7.共济失调（0=无共济失调，1=一个肢体有，2=两个肢体有，9=截肢或关节融合）
     */
    //@TableField(value = "NIHSS_ATAXIA")
    private Integer nihssAtaxia;
    
    /**
     * 8.感觉（0=正常，没有感觉缺失，1=轻到中度，患侧针刺感不明显或为钝性或仅有触觉，2=严重到完全感觉缺失，面、上肢、下肢无触觉）
     */
    //@TableField(value = "NIHSS_FEEL")
    private Integer nihssFeel;
    
    /**
     * 9.语言（0=正常，无失语，1=轻到中度，流利程度和理解能力有一些缺损，但表达无明显受限，2=严重失语，交流是通过病人破碎的语言表达，交流困难，3=哑或完全失语，不能讲或不能理解）
     */
    //@TableField(value = "NIHSS_LANGUAGE")
    private Integer nihssLanguage;
    
    /**
     * 10.构音障碍（0=正常，1=轻到中度，至少有一些发音不清，虽有困难，但能被理解，2=言语不清，不能被理解，9=气管插管或其他物理障碍）
     */
    //@TableField(value = "NIHSS_SPEECH")
    private Integer nihssSpeech;
    
    /**
     * 11.忽视症（0=正常，1=视、触、听、空间觉或个人的忽视；或对任何一种感觉的双侧同时刺激消，2=严重的偏侧忽视；超过一种形式的偏侧忽视；不认识自己的手；只能对一侧空间定位）
     */
    //@TableField(value = "NIHSS_SIGHTIGNORE")
    private Integer nihssSightignore;
    
    /**
     * 总分
     */
    //@TableField(value = "SCORE")
    private Integer score;
    
    /**
     * 等级说明
     */
    //@TableField(value = "LEVEL_DESC")
    private String levelDesc;
    
    /**
     * 评分世间
     */
    //@TableField(value = "CREATE_TIME")
    private Date createTime;
    
    /**
     * 评分人
     */
    //@TableField(value = "CREATE_BY")
    private String createBy;
    
    /**
     * 
     */
    //@TableField(value = "CREATE_BY_NAME")
    private String createByName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNihssConsciousness() {
        return nihssConsciousness;
    }

    public void setNihssConsciousness(Integer nihssConsciousness) {
        this.nihssConsciousness = nihssConsciousness;
    }

    public Integer getNihssConsciousnessquestion() {
        return nihssConsciousnessquestion;
    }

    public void setNihssConsciousnessquestion(Integer nihssConsciousnessquestion) {
        this.nihssConsciousnessquestion = nihssConsciousnessquestion;
    }

    public Integer getNihssConsciousnesscommand() {
        return nihssConsciousnesscommand;
    }

    public void setNihssConsciousnesscommand(Integer nihssConsciousnesscommand) {
        this.nihssConsciousnesscommand = nihssConsciousnesscommand;
    }

    public Integer getNihssEyeballgaze() {
        return nihssEyeballgaze;
    }

    public void setNihssEyeballgaze(Integer nihssEyeballgaze) {
        this.nihssEyeballgaze = nihssEyeballgaze;
    }

    public Integer getNihssEyssight() {
        return nihssEyssight;
    }

    public void setNihssEyssight(Integer nihssEyssight) {
        this.nihssEyssight = nihssEyssight;
    }

    public Integer getNihssFacialparalysis() {
        return nihssFacialparalysis;
    }

    public void setNihssFacialparalysis(Integer nihssFacialparalysis) {
        this.nihssFacialparalysis = nihssFacialparalysis;
    }

    public Integer getNihssWeaknesstopleft() {
        return nihssWeaknesstopleft;
    }

    public void setNihssWeaknesstopleft(Integer nihssWeaknesstopleft) {
        this.nihssWeaknesstopleft = nihssWeaknesstopleft;
    }

    public Integer getNihssWeaknesstopright() {
        return nihssWeaknesstopright;
    }

    public void setNihssWeaknesstopright(Integer nihssWeaknesstopright) {
        this.nihssWeaknesstopright = nihssWeaknesstopright;
    }

    public Integer getNihssWeaknessbottomleft() {
        return nihssWeaknessbottomleft;
    }

    public void setNihssWeaknessbottomleft(Integer nihssWeaknessbottomleft) {
        this.nihssWeaknessbottomleft = nihssWeaknessbottomleft;
    }

    public Integer getNihssWeaknessbottomright() {
        return nihssWeaknessbottomright;
    }

    public void setNihssWeaknessbottomright(Integer nihssWeaknessbottomright) {
        this.nihssWeaknessbottomright = nihssWeaknessbottomright;
    }

    public Integer getNihssAtaxia() {
        return nihssAtaxia;
    }

    public void setNihssAtaxia(Integer nihssAtaxia) {
        this.nihssAtaxia = nihssAtaxia;
    }

    public Integer getNihssFeel() {
        return nihssFeel;
    }

    public void setNihssFeel(Integer nihssFeel) {
        this.nihssFeel = nihssFeel;
    }

    public Integer getNihssLanguage() {
        return nihssLanguage;
    }

    public void setNihssLanguage(Integer nihssLanguage) {
        this.nihssLanguage = nihssLanguage;
    }

    public Integer getNihssSpeech() {
        return nihssSpeech;
    }

    public void setNihssSpeech(Integer nihssSpeech) {
        this.nihssSpeech = nihssSpeech;
    }

    public Integer getNihssSightignore() {
        return nihssSightignore;
    }

    public void setNihssSightignore(Integer nihssSightignore) {
        this.nihssSightignore = nihssSightignore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    @Override
    public String toString() {
        return "ToolnihssBean{" +
                "id='" + id + '\'' +
                ", nihssConsciousness=" + nihssConsciousness +
                ", nihssConsciousnessquestion=" + nihssConsciousnessquestion +
                ", nihssConsciousnesscommand=" + nihssConsciousnesscommand +
                ", nihssEyeballgaze=" + nihssEyeballgaze +
                ", nihssEyssight=" + nihssEyssight +
                ", nihssFacialparalysis=" + nihssFacialparalysis +
                ", nihssWeaknesstopleft=" + nihssWeaknesstopleft +
                ", nihssWeaknesstopright=" + nihssWeaknesstopright +
                ", nihssWeaknessbottomleft=" + nihssWeaknessbottomleft +
                ", nihssWeaknessbottomright=" + nihssWeaknessbottomright +
                ", nihssAtaxia=" + nihssAtaxia +
                ", nihssFeel=" + nihssFeel +
                ", nihssLanguage=" + nihssLanguage +
                ", nihssSpeech=" + nihssSpeech +
                ", nihssSightignore=" + nihssSightignore +
                '}';
    }
}
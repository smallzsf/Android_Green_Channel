package com.xyj.strokeaid.event;

/**
 * ExitEvent
 * description: 退出事件
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public class ScoreEvent {

    /**
     * 分数
     */
    private String score;

    /**
     * 类型
     * 1、  fast
     * 2、  gsc
     * 3、  asptect
     * 4、  溶栓前nihss
     * 19、  溶栓后即刻nihss
     * 20、  溶栓24hnihss
     * 21、  溶栓7+2天 nihss
     * 5、  mrs
     * 6、  吞咽
     * 7、  thrive
     * 8、  hunt
     * 9、  fisher
     * 10、 ti
     * 11、 ts
     * 12、 iss
     * 13、 grace
     * 14、 phi
     * 15、 静脉溶栓适应症
     * 16、 静脉溶栓禁忌症
     * 17、 介入治疗禁忌症
     * 18、 介入治疗适应症
     */


    public static int TYPE_FAST = 1;
    public static int TYPE_GSC = 2;
    public static int TYPE_ASPTECT = 3;
    public static int TYPE_NIHSS_FIRST = 4;
    public static int TYPE_NIHSS_OVER = 5;
    public static int TYPE_NIHSS_OVER_24 = 6;
    public static int TYPE_NIHSS_OVER_7_2 = 7;
    public static int TYPE_MRS = 8;
    public static int TYPE_吞咽 = 9;
    public static int TYPE_THRIVE = 10;
    public static int TYPE_HUNT = 11;
    public static int TYPE_FISHER = 12;
    public static int TYPE_TI = 13;
    public static int TYPE_TS = 14;
    public static int TYPE_ISS = 15;
    public static int TYPE_GRACE = 16;
//    public static int TYPE_grace = 17;
    public static int TYPE_PHI = 18;
    public static int TYPE_静脉溶栓适应症 = 19;
    public static int TYPE_静脉溶栓禁忌症 = 20;
    public static int TYPE_介入治疗禁忌症 = 21;
    public static int TYPE_介入治疗适应症 = 22;
    public static int TYPE_NIHSS_出院 = 23;
    public static int TYPE_FAST_ED = 24;


    private int type;

    /**
     * id
     */
    private String id;

    /**
     * 扩展字段
     */
    private String message;

    public ScoreEvent(String score, int type, String id) {
        this.score = score;
        this.type = type;
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

    
    
       
    
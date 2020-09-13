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
     * 4、  nihss
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

    
    
       
    
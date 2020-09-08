package com.xyj.strokeaid.event;

/**
 * RefreshEvent
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/7
 * email ：licy3051@qq.com
 */
public class RefreshEvent {

    private boolean refresh;

    public RefreshEvent(boolean refresh) {
        this.refresh = refresh;
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }
}

    
    
       
    
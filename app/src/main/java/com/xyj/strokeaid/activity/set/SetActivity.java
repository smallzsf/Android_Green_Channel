package com.xyj.strokeaid.activity.set;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.xyj.strokeaid.R;

import java.util.List;

/**
 * SetActivity
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/13
 * email ：licy3051@qq.com
 */
public class SetActivity extends PreferenceActivity {




    @Override
    public void onResume() {
        super.onResume();

        ListView listView = this.getListView();
        if (listView != null) {
            listView.setDivider(getResources().getDrawable(R.drawable.divider_line));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if(hasHeaders()){
            Button button = new Button(this);
            button.setText("设置操作");
            setListFooter(button);
        }*/
    }

    //重写该方法，负责加载界面布局文件
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }


    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }



}

    
    
       
    
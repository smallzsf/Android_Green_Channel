package com.xyj.strokeaid.activity.set;

import android.preference.PreferenceActivity;
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
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers, target);
    }



    @Override
    public void onResume() {
        super.onResume();

        ListView listView = this.getListView();
        if (listView != null) {
            listView.setDivider(getResources().getDrawable(R.drawable.divider_line));
        }
    }
}

    
    
       
    
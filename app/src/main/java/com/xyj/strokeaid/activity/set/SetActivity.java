package com.xyj.strokeaid.activity.set;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
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


    private ImageView back;
    private TextView title_text;

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


        LinearLayout root = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
        View bar = LayoutInflater.from(this).inflate(R.layout.topbar, root, false);
        root.addView(bar, 0);
        title_text = (TextView) findViewById(R.id.tv_title);
        title_text.setText("设置");
        back = (ImageView) findViewById(R.id.iv_retun);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

    //重写该方法，负责加载界面布局文件
    @Override
    public void onBuildHeaders(List<Header> target) {

        loadHeadersFromResource(R.xml.preference_headers, target);
    }

    @Override
    public void onHeaderClick(Header header, int position) {
        super.onHeaderClick(header, position);
        Log.d("xxxx", "Settings onHeaderClick Header is:" + header.fragment + ",position is:" + position + "header" );

    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }


}

    
    
       
    
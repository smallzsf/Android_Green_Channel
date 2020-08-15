package com.xyj.strokeaid.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.xyj.strokeaid.fragment.DetailInfoFragment;

public class DetailPageAdapter extends FragmentPagerAdapter {

    private static int PAGE_COUNT;//表示要展示的页面数量
    private Context mContext;

    public DetailPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
        PAGE_COUNT=2;

    }

    @Override
    public Fragment getItem(int position) {
        return DetailInfoFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {//设置标题
        switch (position) {
            case 0:
                return "页面一";
            case 1:
                return "页面二";
            case 2:
                return "页面三";
            case 3:
                return "页面四";
            default:break;

        }
        return null;
    }
}
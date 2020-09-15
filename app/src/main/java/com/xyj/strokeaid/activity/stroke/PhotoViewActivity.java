package com.xyj.strokeaid.activity.stroke;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.photoview.PhotoView;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;

import butterknife.BindView;

/**
 * @Description: 查看图片
 * @Author: crq
 * @CreateDate: 2020/9/14 16:47
 */
public class PhotoViewActivity extends BaseActivity {
    @BindView(R.id.pv_picture)
    PhotoView pvPicture;

    public static void launch(@NonNull Activity activity, String filepath) {
        Intent intent = new Intent(activity, PhotoViewActivity.class);
        intent.putExtra("image", filepath);
        activity.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_photoview;
    }

    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        Glide.with(this).load("http://ykj.yjjk366.com" + image).into(pvPicture);
    }

    @Override
    public void initListener() {

    }


}

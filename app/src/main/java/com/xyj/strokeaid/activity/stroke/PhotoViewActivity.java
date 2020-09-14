package com.xyj.strokeaid.activity.stroke;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.luck.picture.lib.photoview.PhotoView;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Description: 查看图片
 * @Author: crq
 * @CreateDate: 2020/9/14 16:47
 */
public class PhotoViewActivity extends BaseActivity {
    @BindView(R.id.pv_picture)
    PhotoView pvPicture;

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
        Glide.with(this).load("http://ykj.yjjk366.com"+image).into(pvPicture);
    }

    @Override
    public void initListener() {

    }


}

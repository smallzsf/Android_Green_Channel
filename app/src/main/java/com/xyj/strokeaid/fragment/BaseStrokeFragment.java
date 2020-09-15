package com.xyj.strokeaid.fragment;

import android.os.Bundle;
import android.util.SparseArray;

import com.blankj.utilcode.util.LogUtils;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.app.IntentKey;
import com.xyj.strokeaid.base.BaseFragment;
import com.xyj.strokeaid.bean.BaseArrayBean;
import com.xyj.strokeaid.bean.file.FileInfoBean;
import com.xyj.strokeaid.http.FileServiceImpl;
import com.xyj.strokeaid.view.SettingBar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * BaseStrokeFragment
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/9/10
 * email ：licy3051@qq.com
 */
public abstract class BaseStrokeFragment extends BaseFragment {

    protected String mRecordId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRecordId = getArguments().getString(IntentKey.RECORD_ID);
        }
    }


    public void dealUploadListener(int index, SettingBar settingBar, SparseArray<String> filePaths) {
        showPhotoSelector(new OnResultCallbackListener<LocalMedia>() {
            @Override
            public void onResult(List<LocalMedia> result) {
                // 拍照
                if (result != null && result.size() > 0) {
                    showLoadingDialog();
                    LocalMedia localMedia = result.get(0);
                    LogUtils.d(localMedia.toString());
                    uploadFile(index, localMedia, settingBar, filePaths);
                }
            }

            @Override
            public void onCancel() {

            }
        }, new OnResultCallbackListener<LocalMedia>() {
            @Override
            public void onResult(List<LocalMedia> result) {
                // 相册
                if (result != null && result.size() > 0) {
                    showLoadingDialog();
                    LocalMedia localMedia = result.get(0);
                    LogUtils.d(localMedia.toString());
                    uploadFile(index, localMedia, settingBar, filePaths);
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    public void uploadFile(int index, LocalMedia localMedia, SettingBar settingBar, SparseArray<String> filePaths) {
        FileServiceImpl.uploadImage("ecg", localMedia.getPath(), new Callback<BaseArrayBean<FileInfoBean>>() {
            @Override
            public void onResponse(Call<BaseArrayBean<FileInfoBean>> call, Response<BaseArrayBean<FileInfoBean>> response) {
                hideLoadingDialog();
                if (response.body() != null && response.body().getResult() == 1) {
                    if (response.body().getData() != null) {
                        showToast(R.string.http_tip_data_file_success);
                        filePaths.put(index, response.body().getData().get(0).getPath());
                        // 修改状态
                        settingBar.setRightText("查看");
                        settingBar.setRightIcon(R.drawable.picture_icon_black_delete);
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseArrayBean<FileInfoBean>> call, Throwable t) {
                hideLoadingDialog();
            }
        });
    }

}

    
    
       
    
package com.xyj.strokeaid.activity.stroke;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.Permission;
import com.luck.picture.lib.permissions.RxPermissions;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.base.BaseActivity;
import com.xyj.strokeaid.helper.CalendarUtils;
import com.xyj.strokeaid.view.BaseTitleBar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

import static com.xyj.strokeaid.helper.CalendarUtils.TYPE_ALL;

/**
 * @Description: 心电图
 * @Author: crq
 * @CreateDate: 2020/8/22 17:55
 */
public class EcgExamnationMainActivity extends BaseActivity implements OnDateSetListener {


    @BindView(R.id.titlebar)
    BaseTitleBar titlebar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.app_tv_editSpinner_time)
    TextView appTvEditSpinnerTime;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.triage_time)
    LinearLayout triageTime;
    @BindView(R.id.doctor_name_line)
    View doctorNameLine;
    @BindView(R.id.app_et_ecg_result)
    EditText appEtEcgResult;
    @BindView(R.id.btn_getdata)
    AppCompatButton btnGetdata;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @BindView(R.id.btn_cancel)
    AppCompatButton btnCancel;
    @BindView(R.id.iv_heart)
    ImageView ivHeart;
    @BindView(R.id.tv_ecg_examine_and_shot)
    TextView tvEcgExamineAndShot;
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;

    private TimePickerDialog mDialogAll;
    private int position;
    private Bundle bundle;
    private Intent intent;
    private PopupWindow pop;
    private int maxSelectNum = 9;
    private List<LocalMedia> selectList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activityt_ecg_examination;
    }


    @Override
    protected void initInject() {

    }

    @Override
    public void initView() {
        intent = getIntent();
        bundle = intent.getExtras();
        ArrayList<String> list = ((ArrayList<String>) bundle.getSerializable("arrayList"));
        position = bundle.getInt("position", 0);
        titlebar.setTitle(list.get(position));
        tvName.setText(list.get(position));

        mDialogAll = new TimePickerDialog.Builder()
                .setType(Type.ALL)
                .setTitleStringId("选择时间")
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.colorPrimary))//当前文本颜色
                .setCallBack(this)
                .setCyclic(false)//是否可循环
                .setToolBarTextColor(R.color.colorPrimary)
                .build();
        //  btnGetdata.setVisibility(View.GONE);
    }

    @Override
    public void initListener() {


    }



    @OnClick({R.id.titlebar, R.id.tv_name, R.id.app_tv_editSpinner_time, R.id.iv_refresh, R.id.triage_time, R.id.doctor_name_line, R.id.app_et_ecg_result, R.id.tv_ecg_examine_and_shot, R.id.btn_getdata, R.id.btn_confirm, R.id.btn_cancel, R.id.iv_photo, R.id.iv_heart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.titlebar:

                break;
            case R.id.tv_name:
                break;
            case R.id.app_tv_editSpinner_time:
                mDialogAll.show(getSupportFragmentManager(), "All");
                break;
            case R.id.iv_refresh:
                appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date()));
                break;
            case R.id.triage_time:
                break;
            case R.id.doctor_name_line:
                break;
            case R.id.app_et_ecg_result:
                break;

            case R.id.btn_getdata:
                break;
            case R.id.btn_confirm:

                //把返回数据存入Intent
                intent.putExtra("result", appTvEditSpinnerTime.getText());
                intent.putExtra("position", position);
                //设置返回数据
                setResult(3, intent);
                //关闭Activity
                finish();
                break;
            case R.id.btn_cancel:

                //关闭Activity
                finish();

                break;
            case R.id.iv_photo:
                //获取写的权限
                RxPermissions rxPermission = new RxPermissions(EcgExamnationMainActivity.this);
                rxPermission.requestEach(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Consumer<Permission>() {
                            @Override
                            public void accept(Permission permission) {
                                if (permission.granted) {// 用户已经同意该权限
                                    //第一种方式，弹出选择和拍照的dialog
                                    showPop();

                                    //第二种方式，直接进入相册，但是 是有拍照得按钮的
//                                showAlbum();
                                } else {
                                    Toast.makeText(EcgExamnationMainActivity.this, "拒绝", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                break;
            case R.id.iv_heart:
                Toast.makeText(mContext, "心脏", Toast.LENGTH_SHORT).show();

                break;


        }
    }

    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        appTvEditSpinnerTime.setText(CalendarUtils.parseDate(TYPE_ALL, new Date(millseconds)));
    }


    /**
     *
     * 点击相机弹框
     *
     */
    private void showPop() {
        View bottomView = View.inflate(EcgExamnationMainActivity.this, R.layout.layout_bottom_dialog, null);
        TextView mAlbum = bottomView.findViewById(R.id.tv_album);
        TextView mCamera = bottomView.findViewById(R.id.tv_camera);
        TextView mCancel = bottomView.findViewById(R.id.tv_cancel);

        pop = new PopupWindow(bottomView, -1, -2);
        pop.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        pop.setOutsideTouchable(true);
        pop.setFocusable(true);
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.5f;
        getWindow().setAttributes(lp);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
       // pop.setAnimationStyle(R.style.main_menu_photo_anim);
        pop.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.tv_album:
                        //相册
                        PictureSelector.create(EcgExamnationMainActivity.this)
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(maxSelectNum)
                                .minSelectNum(1)
                                .imageSpanCount(4)
                                .selectionMode(PictureConfig.MULTIPLE)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                        break;
                    case R.id.tv_camera:
                        //拍照
                        PictureSelector.create(EcgExamnationMainActivity.this)
                                .openCamera(PictureMimeType.ofImage())
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                        break;
                    case R.id.tv_cancel:
                        //取消
                       // closePopupWindow();
                        break;
                }

                closePopupWindow();

            }
        };

        mAlbum.setOnClickListener(clickListener);
        mCamera.setOnClickListener(clickListener);
        mCancel.setOnClickListener(clickListener);
    }


    public void closePopupWindow() {
        if (pop != null && pop.isShowing()) {
            pop.dismiss();
            pop = null;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<LocalMedia> images;
        if (resultCode == RESULT_OK) {
            if (requestCode == PictureConfig.CHOOSE_REQUEST) {// 图片选择结果回调

                images = PictureSelector.obtainMultipleResult(data);
                selectList.addAll(images);
                Log.d("图片选择",selectList.toString());
                //selectList = PictureSelector.obtainMultipleResult(data);

                // 例如 LocalMedia 里面返回三种path
                // 1.media.getPath(); 为原图path
                // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
             /*   adapter.setList(selectList);
                adapter.notifyDataSetChanged();*/
            }
        }
    }



}
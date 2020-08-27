package com.xyj.strokeaid.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xyj.strokeaid.R;
import com.xyj.strokeaid.bean.AfterOperationDrugBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * AfterOperationDrugRvAdapter
 * description: TODO
 *
 * @author : Licy
 * @date : 2020/8/27
 * email ：licy3051@qq.com
 */
public class AfterOperationDrugRvAdapter extends BaseQuickAdapter<AfterOperationDrugBean, BaseViewHolder> {
    public AfterOperationDrugRvAdapter(@Nullable List<AfterOperationDrugBean> data) {
        super(R.layout.adapter_rv_after_operation_drug_item, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, AfterOperationDrugBean afterOperationDrugBean) {
        CheckBox cbDrug = baseViewHolder.getView(R.id.cb_name_adapter_after_operation_drug);
        EditText etNote = baseViewHolder.getView(R.id.et_note_adapter_after_operation_drug);
        cbDrug.setText(afterOperationDrugBean.getName());
        cbDrug.setChecked(afterOperationDrugBean.isChecked());
        etNote.setText(afterOperationDrugBean.getNote());
        cbDrug.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                afterOperationDrugBean.setChecked(isChecked);
            }
        });
        etNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                afterOperationDrugBean.setNote(s.toString());
            }
        });
    }
}

    
    
       
    
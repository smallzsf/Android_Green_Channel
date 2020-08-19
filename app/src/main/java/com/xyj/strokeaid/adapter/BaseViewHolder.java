package com.xyj.strokeaid.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    View mView ;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.mView=itemView;
    }

    public View getView(){
        return mView;
    }
}
package com.example.lenovo.recyclerview;

import android.view.View;

public class CustomOnclickClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;

    public CustomOnclickClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback=onItemClickCallback;

    }

    @Override
    public void onClick(View v) {
        onItemClickCallback.onItemClicked(v,position);


    }
    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}

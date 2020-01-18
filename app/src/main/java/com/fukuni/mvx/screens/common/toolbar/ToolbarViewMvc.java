package com.fukuni.mvx.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.fukuni.mvx.R;
import com.fukuni.mvx.screens.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {

    public interface NavigateUpClickListener {
        void onNavigateUpClicked();
    }

    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;

    private NavigateUpClickListener navigateUpClickListener;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(v -> {
            navigateUpClickListener.onNavigateUpClicked();
        });
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }


    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        this.navigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }
}

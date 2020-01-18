package com.fukuni.mvx.screens.common.toolbar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fukuni.mvx.R;
import com.fukuni.mvx.screens.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {

    private final TextView mTxtTitle;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }
}

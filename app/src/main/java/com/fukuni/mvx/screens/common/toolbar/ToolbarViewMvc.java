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

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }

    private final TextView mTxtTitle;
    private final ImageButton mBtnBack;
    private final ImageButton mHamburger;
    private NavigateUpClickListener navigateUpClickListener;
    private HamburgerClickListener hamburgerClickListener;
    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mTxtTitle = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mHamburger = findViewById(R.id.btn_hamburger);
        mHamburger.setOnClickListener(v -> {
            hamburgerClickListener.onHamburgerClicked();
        });
        mBtnBack.setOnClickListener(v -> {
            navigateUpClickListener.onNavigateUpClicked();
        });
    }

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    public void enableHamburgerButtonAndListen(HamburgerClickListener hamburgerClickListener) {
        if(navigateUpClickListener != null) {
            throw new RuntimeException("hamburger and back button cannot b shown at the same time");
        }

        this.hamburgerClickListener = hamburgerClickListener;
        mHamburger.setVisibility(View.VISIBLE);

    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        if(hamburgerClickListener != null) {
            throw new RuntimeException("hamburger and back button cannot b shown at the same time");
        }

        this.navigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }
}

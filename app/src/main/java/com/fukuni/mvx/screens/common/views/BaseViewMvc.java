package com.fukuni.mvx.screens.common.views;

import android.content.Context;
import android.view.View;

import androidx.annotation.StringRes;

public abstract class BaseViewMvc implements ViewMvc {

    private View mRootview;


    @Override
    public View getRootview() {
        return mRootview;
    }

    protected void setRootview(View rootview) {
        this.mRootview = rootview;
    }

    protected <T extends View> T findViewById(int id) {
        return getRootview().findViewById(id);
    }

    protected Context getContext() {
        return getRootview().getContext();
    }

    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }
}

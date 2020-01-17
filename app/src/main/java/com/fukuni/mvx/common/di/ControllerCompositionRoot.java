package com.fukuni.mvx.common.di;

import android.app.Activity;
import android.view.LayoutInflater;

import com.fukuni.mvx.networking.StackoverflowAPI;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;

    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.mCompositionRoot = compositionRoot;
        this.mActivity = activity;
    }

    public StackoverflowAPI getStackoverflowAPI() {
        return mCompositionRoot.getStackoverflowAPI();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

}

package com.fukuni.mvx.common;

import android.app.Application;

import com.fukuni.mvx.common.di.CompositionRoot;

public class CustomApplication extends Application {


    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }

}

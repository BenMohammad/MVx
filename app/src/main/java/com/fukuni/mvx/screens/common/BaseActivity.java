package com.fukuni.mvx.screens.common;

import androidx.appcompat.app.AppCompatActivity;

import com.fukuni.mvx.CustomApplication;
import com.fukuni.mvx.common.di.CompositionRoot;
import com.fukuni.mvx.common.di.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if(mControllerCompositionRoot == null) {
            mControllerCompositionRoot =  new ControllerCompositionRoot(
                    ((CustomApplication) getApplication()).getCompositionRoot(),
                    this
            );
        }

        return mControllerCompositionRoot;

    }



}

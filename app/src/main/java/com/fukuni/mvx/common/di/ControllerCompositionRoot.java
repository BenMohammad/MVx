package com.fukuni.mvx.common.di;

import android.app.Activity;
import android.view.LayoutInflater;

import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.questions.FetchLastActiveQuestionsUseCase;
import com.fukuni.mvx.questions.FetchQuestionDetailsUseCase;
import com.fukuni.mvx.screens.common.ViewMvcFactory;

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

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackoverflowAPI());
    }

    public FetchLastActiveQuestionsUseCase getFetchLastActiveQuestionsUseCase() {
        return new FetchLastActiveQuestionsUseCase(getStackoverflowAPI());
    }

}

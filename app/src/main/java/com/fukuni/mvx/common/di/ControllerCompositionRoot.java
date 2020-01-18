package com.fukuni.mvx.common.di;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.questions.FetchLastActiveQuestionsUseCase;
import com.fukuni.mvx.questions.FetchQuestionDetailsUseCase;
import com.fukuni.mvx.screens.common.messagedisplayer.MessagesDisplayer;
import com.fukuni.mvx.screens.common.screennavigator.ScreenNavigator;
import com.fukuni.mvx.screens.common.ViewMvcFactory;
import com.fukuni.mvx.screens.questionslist.QuestionsListController;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;

    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        this.mCompositionRoot = compositionRoot;
        this.mActivity = activity;
    }

    private Context getContext() {
        return mActivity;
    }

    public StackoverflowAPI getStackoverflowAPI() {
        return mCompositionRoot.getStackoverflowAPI();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
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

    public MessagesDisplayer getMessagesDisplayer() {
        return new MessagesDisplayer(getContext());
    }

    public ScreenNavigator getScreenNavigator() {
        return new ScreenNavigator(getContext());
    }

    public QuestionsListController getQuestionsListController() {
        return new QuestionsListController(getFetchLastActiveQuestionsUseCase(),
                                            getMessagesDisplayer(),
                                            getScreenNavigator());
    }


}

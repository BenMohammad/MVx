package com.fukuni.mvx.screens.questiondetails;

import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.views.ObservableViewMvc;
import com.fukuni.mvx.screens.common.views.ViewMvc;

public interface QuestionDetailsViewMvc extends ObservableViewMvc<QuestionDetailsViewMvc.Listener> {

    public interface Listener {
        void onNavigateUpClicked();
    }

    void bindQuestion(QuestionDetails questionDetails);
    void showProgress();
    void hideProgress();
}

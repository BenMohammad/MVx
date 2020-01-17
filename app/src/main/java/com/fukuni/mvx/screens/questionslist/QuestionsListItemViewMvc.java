package com.fukuni.mvx.screens.questionslist;

import android.view.View;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.ObservableViewMvc;
import com.fukuni.mvx.screens.common.ViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}

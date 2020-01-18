package com.fukuni.mvx.screens.questionslist;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.views.ObservableViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}

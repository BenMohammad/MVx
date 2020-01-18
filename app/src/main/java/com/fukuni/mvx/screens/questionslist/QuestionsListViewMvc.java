package com.fukuni.mvx.screens.questionslist;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.views.ObservableViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {

    void showProgress();
    void hideProgress();

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
}

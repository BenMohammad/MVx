package com.fukuni.mvx.screens.questionslist;

import android.database.ContentObservable;
import android.view.View;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.ObservableViewMvc;
import com.fukuni.mvx.screens.common.ViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {

    void showProgress();
    void hideProgress();

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);
}

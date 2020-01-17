package com.fukuni.mvx.screens.questionslist;

import android.view.View;

import com.fukuni.mvx.questions.Question;

public interface QuestionsListItemViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    View getRootview();
    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    void bindQuestion(Question question);
}

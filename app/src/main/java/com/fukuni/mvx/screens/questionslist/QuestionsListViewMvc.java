package com.fukuni.mvx.screens.questionslist;

import android.view.View;

import com.fukuni.mvx.questions.Question;

import java.util.List;

public interface QuestionsListViewMvc {

    public interface Listener {
        void onQuestionCLicked(Question question);
    }

    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    View getRootview();
    void bindQuestions(List<Question> questions);
}

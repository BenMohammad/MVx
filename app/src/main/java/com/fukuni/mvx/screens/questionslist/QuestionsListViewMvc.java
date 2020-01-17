package com.fukuni.mvx.screens.questionslist;

import android.view.View;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.ViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ViewMvc {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    void bindQuestions(List<Question> questions);
}

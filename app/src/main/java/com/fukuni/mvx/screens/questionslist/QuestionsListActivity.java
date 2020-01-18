package com.fukuni.mvx.screens.questionslist;

import android.os.Bundle;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.BaseActivity;
import com.fukuni.mvx.screens.questiondetails.QuestionDetailsActivity;

public class QuestionsListActivity extends BaseActivity  {

    private QuestionsListController questionsListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionsListViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        questionsListController = getCompositionRoot().getQuestionsListController();
        questionsListController.bindView(viewMvc);
        setContentView(viewMvc.getRootview());
    }

    @Override
    protected void onStart() {
        super.onStart();
        questionsListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        questionsListController.onStop();
    }


}

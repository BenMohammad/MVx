package com.fukuni.mvx.screens.questionslist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.fukuni.mvx.screens.common.controllers.BaseActivity;

public class QuestionsListActivity extends BaseActivity  {

    private QuestionsListController questionsListController;

    public static void startClearTop(Context context) {
        Intent intent = new Intent(context, QuestionsListActivity.class);
        intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }


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

    @Override
    public void onBackPressed() {
        if(!questionsListController.onBackPressed()) {
            super.onBackPressed();
        }
    }
}

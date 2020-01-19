package com.fukuni.mvx.screens.common.screennavigator;

import android.content.Context;

import com.fukuni.mvx.screens.questiondetails.QuestionDetailsActivity;
import com.fukuni.mvx.screens.questionslist.QuestionsListActivity;

public class ScreenNavigator {

    private final Context context;

    public ScreenNavigator(Context context) {
        this.context = context;
    }

    public void toDialogDetails(String id) {
        QuestionDetailsActivity.start(context, id);
    }

    public void toQuestionsListClearTop() {
        QuestionsListActivity.startClearTop(context);
    }
}

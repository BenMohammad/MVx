package com.fukuni.mvx.screens.common;

import android.content.Context;

import com.fukuni.mvx.screens.questiondetails.QuestionDetailsActivity;

public class ScreenNavigator {

    private final Context context;

    public ScreenNavigator(Context context) {
        this.context = context;
    }

    public void toDialogDetails(String id) {
        QuestionDetailsActivity.start(context, id);
    }
}

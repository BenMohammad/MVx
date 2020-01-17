package com.fukuni.mvx.screens.questiondetails;

import android.content.Context;
import android.content.Intent;

import com.fukuni.mvx.screens.common.BaseActivity;

public class QuestionDetailsActivity extends BaseActivity {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }
}

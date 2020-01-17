package com.fukuni.mvx.screens.questiondetails;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.BaseViewMvc;

public class QuestionDetailsViewMvcImpl extends BaseViewMvc implements QuestionDetailsViewMvc {

    private final TextView mTxtQuestionTitle;
    private final TextView mTxtQuestionBody;
    private final ProgressBar mProgress;

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_question_details, parent, false));
        mTxtQuestionTitle = findViewById(R.id.txt_question_title);
        mTxtQuestionBody = findViewById(R.id.txt_question_body);
        mProgress = findViewById(R.id.progress);
    }

    @Override
    public void bindQuestion(QuestionDetails questionDetails) {
        String questionTitle = questionDetails.getTitle();
        String questionBody = questionDetails.getBody();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle, Html.FROM_HTML_MODE_LEGACY));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody, Html.FROM_HTML_MODE_LEGACY));
        } else {
            mTxtQuestionTitle.setText(Html.fromHtml(questionTitle));
            mTxtQuestionBody.setText(Html.fromHtml(questionBody));
        }
    }

    @Override
    public void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }
}

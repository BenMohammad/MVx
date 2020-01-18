package com.fukuni.mvx.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fukuni.mvx.questions.FetchQuestionDetailsUseCase;
import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.BaseActivity;

public class QuestionDetailsActivity extends BaseActivity implements FetchQuestionDetailsUseCase.Listener {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }
    private FetchQuestionDetailsUseCase fetchQuestionDetailsUseCase;
    private QuestionDetailsViewMvc mViewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchQuestionDetailsUseCase = getCompositionRoot().getFetchQuestionDetailsUseCase();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);

        setContentView(mViewMvc.getRootview());
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestionDetailsUseCase.registerListener(this);
        mViewMvc.showProgress();
        fetchQuestionDetailsUseCase.fetchDetailsAndNotify(getQuestionId());
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchQuestionDetailsUseCase.unregisterListener(this);
    }

    private String getQuestionId() {
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }

    @Override
    public void onQuestionDetailsFetched(QuestionDetails details) {
        mViewMvc.hideProgress();
        mViewMvc.bindQuestion(details);
    }

    @Override
    public void onQuestionDetailsFetchedFailed() {
        mViewMvc.hideProgress();
        Toast.makeText(this, "Fetch Failed", Toast.LENGTH_SHORT).show();
    }
}

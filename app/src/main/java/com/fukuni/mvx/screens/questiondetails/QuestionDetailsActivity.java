package com.fukuni.mvx.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.fukuni.mvx.networking.QuestionDetailsResponseSchema;
import com.fukuni.mvx.networking.QuestionSchema;
import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.questions.QuestionDetails;
import com.fukuni.mvx.screens.common.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionDetailsActivity extends BaseActivity {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId) {
        Intent intent = new Intent(context, QuestionDetailsActivity.class);
        intent.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(intent);
    }

    private StackoverflowAPI mStackAPI;
    private QuestionDetailsViewMvc mViewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStackAPI = getCompositionRoot().getStackoverflowAPI();
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionDetailsViewMvc(null);

        setContentView(mViewMvc.getRootview());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.showProgress();
        fetchQuestionDetails();
    }

    private void fetchQuestionDetails() {
        mStackAPI.fetchQuestionDetails(getQuestionId())
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {
                        if(response.isSuccessful()) {
                            bindQuestionDetails(response.body().getQuestion());
                        } else {
                            networkFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {
                        networkFailed();
                    }
                });
    }

    private void networkFailed() {
        Toast.makeText(this, "Network Failed", Toast.LENGTH_SHORT).show();
    }

    private void bindQuestionDetails(QuestionSchema question) {
        mViewMvc.hideProgress();
        mViewMvc.bindQuestion(
                new QuestionDetails(
                        question.getId(),
                        question.getTitle(),
                        question.getBody()
                )
        );
    }

    private String getQuestionId() {
        return getIntent().getStringExtra(EXTRA_QUESTION_ID);
    }
}

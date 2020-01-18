package com.fukuni.mvx.questions;

import com.fukuni.mvx.networking.questions.QuestionDetailsResponseSchema;
import com.fukuni.mvx.networking.questions.QuestionSchema;
import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.screens.common.views.BaseObservableViewMvc;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchQuestionDetailsUseCase extends BaseObservableViewMvc<FetchQuestionDetailsUseCase.Listener> {

    public interface Listener {
        void onQuestionDetailsFetched(QuestionDetails details);
        void onQuestionDetailsFetchedFailed();
    }

    private final StackoverflowAPI mStackAPI;

    public FetchQuestionDetailsUseCase(StackoverflowAPI stackAPI) {
        this.mStackAPI = stackAPI;
    }

    public void fetchDetailsAndNotify(String questionId) {
        mStackAPI.fetchQuestionDetails(questionId)
                .enqueue(new Callback<QuestionDetailsResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionDetailsResponseSchema> call, Response<QuestionDetailsResponseSchema> response) {
                        if(response.isSuccessful()) {
                            notifySuccess(response.body().getQuestion());
                        } else {
                            notifyFailure();
                        }

                    }

                    @Override
                    public void onFailure(Call<QuestionDetailsResponseSchema> call, Throwable t) {
                        notifyFailure();
                    }
                });

    }

    private void notifyFailure() {
        for(Listener listener : getListeners()) {
            listener.onQuestionDetailsFetchedFailed();
        }
    }

    private void notifySuccess(QuestionSchema question) {
        for(Listener listener : getListeners()) {
            listener.onQuestionDetailsFetched(
                    new QuestionDetails(
                            question.getId(),
                            question.getTitle(),
                            question.getBody()
                    )
            );
        }
    }
}

package com.fukuni.mvx.questions;

import com.fukuni.mvx.common.Constants;
import com.fukuni.mvx.networking.questions.QuestionSchema;
import com.fukuni.mvx.networking.questions.QuestionsListResponseSchema;
import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.common.BaseObservable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FetchLastActiveQuestionsUseCase extends BaseObservable<FetchLastActiveQuestionsUseCase.Listener> {

    public interface Listener {
        void onLastActiveQuestionFetched(List<Question> questions);
        void onLastActiveQuestionFetchedFailed();
    }

    private final StackoverflowAPI mStackAPI;

    public FetchLastActiveQuestionsUseCase(StackoverflowAPI stackAPI) {
        this.mStackAPI = stackAPI;
    }

    public void fetchLastActiveQuestionsAndNotify() {
        mStackAPI.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if(response.isSuccessful()) {
                            notifySuccess(response.body().getQuestions());
                        } else {
                            notifyFailure();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                            notifyFailure();
                    }
                });
    }

    private void notifyFailure() {
        for(Listener listener : getListeners()) {
            listener.onLastActiveQuestionFetchedFailed();
        }
    }

    private void notifySuccess(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for(QuestionSchema schema : questionSchemas) {
            questions.add(new Question(schema.getId(), schema.getTitle()));
        }
        for(Listener listener : getListeners()) {
            listener.onLastActiveQuestionFetched(questions);
        }

    }


}

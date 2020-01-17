package com.fukuni.mvx.screens.questionslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.fukuni.mvx.common.Constants;
import com.fukuni.mvx.networking.QuestionSchema;
import com.fukuni.mvx.networking.QuestionsListResponseSchema;
import com.fukuni.mvx.networking.StackoverflowAPI;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionsListActivity extends BaseActivity implements QuestionsListViewMvc.Listener {

    private StackoverflowAPI mStackAPI;
    private QuestionsListViewMvc mViewMvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
                mViewMvc.registerListener(this);

        mStackAPI = getCompositionRoot().getStackoverflowAPI();

        setContentView(mViewMvc.getRootview());
    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchQuestions();
    }

    private void fetchQuestions() {
        mStackAPI.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(new Callback<QuestionsListResponseSchema>() {
                    @Override
                    public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
                        if(response.isSuccessful()) {
                            bindQuestions(response.body().getQuestions());
                        } else {
                            networkFailed();
                        }
                    }

                    @Override
                    public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
                        networkFailed();
                    }
                });
    }

    private void bindQuestions(List<QuestionSchema> questionSchemas) {
        List<Question> questions = new ArrayList<>(questionSchemas.size());
        for(QuestionSchema questionSchema : questionSchemas) {
            questions.add(new Question(questionSchema.getId(), questionSchema.getTitle()));
        }
        mViewMvc.bindQuestions(questions);
    }

    private void networkFailed() {
        Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onQuestionClicked(Question question) {
        Toast.makeText(this, question.getTitle(), Toast.LENGTH_SHORT).show();
    }
}

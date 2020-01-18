package com.fukuni.mvx.screens.questionslist;

import android.os.Bundle;
import android.widget.Toast;

import com.fukuni.mvx.questions.FetchLastActiveQuestionsUseCase;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.BaseActivity;
import com.fukuni.mvx.screens.questiondetails.QuestionDetailsActivity;

import java.util.List;

public class QuestionsListActivity extends BaseActivity implements QuestionsListViewMvc.Listener, FetchLastActiveQuestionsUseCase.Listener {



    private FetchLastActiveQuestionsUseCase fetchLastActiveQuestionsUseCase;
    private QuestionsListViewMvc mViewMvc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mViewMvc.registerListener(this);
        fetchLastActiveQuestionsUseCase = getCompositionRoot().getFetchLastActiveQuestionsUseCase();

        setContentView(mViewMvc.getRootview());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.showProgress();
        fetchLastActiveQuestionsUseCase.registerListener(this);
        fetchLastActiveQuestionsUseCase.fetchLastActiveQuestionsAndNotify();
    }

    @Override
    protected void onStop() {
        super.onStop();
        fetchLastActiveQuestionsUseCase.unregisterListener(this);
    }

    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetailsActivity.start(this, question.getId());
    }

    @Override
    public void onLastActiveQuestionFetched(List<Question> questions) {
        mViewMvc.hideProgress();
        mViewMvc.bindQuestions(questions);
    }

    @Override
    public void onLastActiveQuestionFetchedFailed() {
        mViewMvc.hideProgress();
        Toast.makeText(this, "Fetch Failed", Toast.LENGTH_SHORT).show();
    }
}

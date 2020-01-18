package com.fukuni.mvx.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.toolbar.ToolbarViewMvc;
import com.fukuni.mvx.screens.common.views.BaseObservableViewMvc;
import com.fukuni.mvx.screens.common.ViewMvcFactory;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener> implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {


    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar toolbar;

    private ProgressBar mProgress;
    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter adapter;

    public QuestionsListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory factory) {
        setRootview(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.recycler);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuestionsRecyclerAdapter(this, factory);
        mRecyclerQuestions.setAdapter(adapter);
        mProgress = findViewById(R.id.progress);
        toolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = factory.getToolbarViewMvc(toolbar);
        mToolbarViewMvc.setTitle(getString(R.string.questions_list_toolbar_title));
        toolbar.addView(mToolbarViewMvc.getRootview());
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        adapter.bindQuestions(questions);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for(Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
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

package com.fukuni.mvx.screens.questionslist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.BaseObservableViewMvc;
import com.fukuni.mvx.screens.common.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener> implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {


    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter adapter;
    private final List<Listener> mListeners = new ArrayList<>(1);

    public QuestionsListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory factory) {
        setRootview(inflater.inflate(R.layout.layout_questions_list, parent, false));
        mRecyclerQuestions = findViewById(R.id.recycler);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuestionsRecyclerAdapter(this, factory);
        mRecyclerQuestions.setAdapter(adapter);
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        adapter.bindQuestions(questions);
    }

    @Override
    public void onQuestionClicked(Question question) {
        for(Listener listener : mListeners) {
            listener.onQuestionClicked(question);
        }
    }
}

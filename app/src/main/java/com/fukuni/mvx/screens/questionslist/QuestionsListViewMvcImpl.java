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

import java.util.ArrayList;
import java.util.List;

public class QuestionsListViewMvcImpl implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {


    private RecyclerView mRecyclerQuestions;
    private QuestionsRecyclerAdapter adapter;

    private final View mRootView;
    private final List<Listener> mListeners = new ArrayList<>(1);

    public QuestionsListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_questions_list, parent, false);
        mRecyclerQuestions = findViewById(R.id.recycler);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new QuestionsRecyclerAdapter(inflater, this);
        mRecyclerQuestions.setAdapter(adapter);
    }

    private Context getContext() {
        return getRootview().getContext();
    }

    private <T extends View> T findViewById(int id) {
        return getRootview().findViewById(id);
    }


    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public View getRootview() {
        return mRootView;
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

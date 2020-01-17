package com.fukuni.mvx.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImpl extends BaseViewMvc implements QuestionsListItemViewMvc{

    private final TextView mTxtTitle;
    private final List<Listener> mListeners = new ArrayList<>(1);
    private Question mQuestion;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater , @Nullable ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtTitle = findViewById(R.id.txt_title);
        getRootview().setOnClickListener(v -> {
            for(Listener listener : mListeners) {
                listener.onQuestionClicked(mQuestion);
            }
        });
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
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtTitle.setText(question.getTitle());
    }

}

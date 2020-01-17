package com.fukuni.mvx.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionsListItemViewMvcImpl implements QuestionsListItemViewMvc {

    private final View mRootView;
    private final TextView mTxtTitle;
    private final List<Listener> mListeners = new ArrayList<>(1);
    private Question mQuestion;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater , @Nullable ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_question_list_item, parent, false);
        mTxtTitle = findViewById(R.id.txt_title);
        getRootview().setOnClickListener(v -> {
            for(Listener listener : mListeners) {
                listener.onQuestionClicked(mQuestion);
            }
        });
    }

    private <T extends View> T findViewById(int id) {
        return getRootview().findViewById(id);
    }

    @Override
    public View getRootview() {
        return mRootView;
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

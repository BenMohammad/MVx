package com.fukuni.mvx.screens.questionslist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.fukuni.mvx.R;
import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.views.BaseObservableViewMvc;

public class QuestionsListItemViewMvcImpl extends BaseObservableViewMvc<QuestionsListItemViewMvc.Listener> implements QuestionsListItemViewMvc{

    private final TextView mTxtTitle;private Question mQuestion;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater , @Nullable ViewGroup parent) {
        setRootview(inflater.inflate(R.layout.layout_question_list_item, parent, false));
        mTxtTitle = findViewById(R.id.txt_title);
        getRootview().setOnClickListener(v -> {
            for(Listener listener : getListeners()) {
                listener.onQuestionClicked(mQuestion);
            }
        });
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtTitle.setText(question.getTitle());
    }

}

package com.fukuni.mvx.screens.questionslist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fukuni.mvx.questions.Question;
import com.fukuni.mvx.screens.common.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;

public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.MyViewHolder> implements QuestionsListItemViewMvc.Listener {


    public interface Listener {
        void onQuestionClicked(Question question);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final QuestionsListItemViewMvc mViewMvc;

        public MyViewHolder(QuestionsListItemViewMvc viewMvc) {
            super(viewMvc.getRootview());
            this.mViewMvc = viewMvc;
        }

    }

    private final Listener mListener;
    private List<Question> mQuestions = new ArrayList<>();
    private final ViewMvcFactory mFactory;

    public QuestionsRecyclerAdapter(Listener listener, ViewMvcFactory factory) {
        this.mListener = listener;
        this.mFactory = factory;
    }

    public void bindQuestions(List<Question> questions) {
        mQuestions = new ArrayList<>(questions);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        QuestionsListItemViewMvc viewMvc = mFactory.getQuestionsListItemViewMvc(parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mViewMvc.bindQuestion(mQuestions.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuestions.size();
    }

    @Override
    public void onQuestionClicked(Question question) {
        mListener.onQuestionClicked(question);
    }
}

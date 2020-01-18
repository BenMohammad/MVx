package com.fukuni.mvx.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.fukuni.mvx.screens.common.toolbar.ToolbarViewMvc;
import com.fukuni.mvx.screens.questiondetails.QuestionDetailsViewMvc;
import com.fukuni.mvx.screens.questiondetails.QuestionDetailsViewMvcImpl;
import com.fukuni.mvx.screens.questionslist.QuestionsListItemViewMvc;
import com.fukuni.mvx.screens.questionslist.QuestionsListItemViewMvcImpl;
import com.fukuni.mvx.screens.questionslist.QuestionsListViewMvc;
import com.fukuni.mvx.screens.questionslist.QuestionsListViewMvcImpl;

public class ViewMvcFactory {

    private final LayoutInflater inflater;

    public ViewMvcFactory(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public QuestionsListViewMvc getQuestionsListViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListViewMvcImpl(inflater, parent, this);
    }

    public QuestionsListItemViewMvc getQuestionsListItemViewMvc(@Nullable ViewGroup parent) {
        return new QuestionsListItemViewMvcImpl(inflater, parent);
    }

    public QuestionDetailsViewMvc getQuestionDetailsViewMvc(@Nullable ViewGroup parent) {
        return new QuestionDetailsViewMvcImpl(inflater, parent);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(inflater, parent);
    }
}

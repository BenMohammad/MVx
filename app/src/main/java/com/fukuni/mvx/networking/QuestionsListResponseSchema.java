package com.fukuni.mvx.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuestionsListResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionsListResponseSchema(List<QuestionSchema> questions) {
        this.mQuestions = questions;
    }

    public List<QuestionSchema> getQuestions() {
        return mQuestions;
    }
}

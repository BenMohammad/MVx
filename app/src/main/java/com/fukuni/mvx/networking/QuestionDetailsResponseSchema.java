package com.fukuni.mvx.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class QuestionDetailsResponseSchema {

    @SerializedName("items")
    private final List<QuestionSchema> mQuestions;

    public QuestionDetailsResponseSchema(QuestionSchema questions) {
        this.mQuestions = Collections.singletonList(questions);
    }

    public QuestionSchema getQuestion() {
        return mQuestions.get(0);
    }
}

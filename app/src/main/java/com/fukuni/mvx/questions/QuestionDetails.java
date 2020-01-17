package com.fukuni.mvx.questions;

public class QuestionDetails {

    private final String mId;
    private final String mTitle;
    private final String mBody;

    public QuestionDetails(String id, String title, String body) {
        this.mId = id;
        this.mTitle = title;
        this.mBody = body;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getBody() {
        return mBody;
    }
}

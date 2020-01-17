package com.fukuni.mvx.networking;

import com.google.gson.annotations.SerializedName;

public class QuestionSchema {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("question_id")
    private final String mId;

    @SerializedName("body")
    private final String mBody;

    @SerializedName("owner")
    private final UserSchema mOwner;

    public QuestionSchema(String title, String id, String body, UserSchema owner) {
        this.mTitle = title;
        this.mId = id;
        this.mBody = body;
        this.mOwner = owner;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }

    public String getBody() {
        return mBody;
    }

    public UserSchema getOwner() {
        return mOwner;
    }
}

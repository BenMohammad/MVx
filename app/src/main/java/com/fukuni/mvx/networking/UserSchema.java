package com.fukuni.mvx.networking;

import com.google.gson.annotations.SerializedName;

public class UserSchema {

    @SerializedName("display_name")
    private final String mUserName;

    @SerializedName("profile_image")
    private final String mProfileImage;

    public UserSchema(String userName, String profileImage) {
        this.mUserName = userName;
        this.mProfileImage = profileImage;
    }

    public String getUserName() {
        return mUserName;
    }

    public String getProfileImage() {
        return mProfileImage;
    }
}

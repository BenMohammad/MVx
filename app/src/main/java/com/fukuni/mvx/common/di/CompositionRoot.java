package com.fukuni.mvx.common.di;

import com.fukuni.mvx.common.Constants;
import com.fukuni.mvx.networking.StackoverflowAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

    private Retrofit getRetrofit() {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        return mRetrofit;
    }

    public StackoverflowAPI getStackoverflowAPI() {
        return getRetrofit().create(StackoverflowAPI.class);
    }
}

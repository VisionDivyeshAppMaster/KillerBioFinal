package com.hashtag.hashtaggenrator.hashtagforinstagram.freehashtag.hasham.Retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface api {

    @GET("/bins/1blgzu")
    Call<JSONResponse> getJSON();
}

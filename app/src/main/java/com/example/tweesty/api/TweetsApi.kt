package com.example.tweesty.api

import com.example.tweesty.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsApi {

    @GET("v3/b/665cac05acd3cb34a851af00?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String):Response<List<TweetListItem>>

    @GET("v3/b/665cac05acd3cb34a851af00?meta=false")
    @Headers("X-JSON-Path:\$..category")
    suspend fun getCategorys():Response<List<String>>
}
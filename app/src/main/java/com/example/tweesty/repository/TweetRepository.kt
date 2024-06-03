package com.example.tweesty.repository

import com.example.tweesty.api.TweetsApi
import com.example.tweesty.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val api: TweetsApi) {

    private val _categorys = MutableStateFlow<List<String>>(emptyList())
    val categoreys : StateFlow<List<String>>
        get() = _categorys

    private val _tweets = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweets : StateFlow<List<TweetListItem>>
        get() = _tweets

    suspend fun getCategorys(){
        val response = api.getCategorys()
        if(response.isSuccessful && response.body() != null){
            _categorys.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category:String){

        val filter = "$..[?(@.category==\"${category}\")]"
        val response = api.getTweets(filter)
        if(response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }


}
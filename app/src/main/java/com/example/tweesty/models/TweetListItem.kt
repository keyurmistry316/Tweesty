package com.example.tweesty.models


import com.google.gson.annotations.SerializedName

data class TweetListItem(
    @SerializedName("category")
    val category: String?,
    @SerializedName("content")
    val content: String?
)
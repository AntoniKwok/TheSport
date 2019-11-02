package com.antoni.wijaya.thesport.model.event

import com.google.gson.annotations.SerializedName

data class SearchResult(

    @SerializedName("event")
    val listSearched: List<EventValue> = arrayListOf()
)

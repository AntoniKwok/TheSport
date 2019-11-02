package com.antoni.wijaya.thesport.model.match

import com.google.gson.annotations.SerializedName

data class MatchResult(

    @SerializedName("events")
    val listMatches: List<MatchValue> = arrayListOf()
)

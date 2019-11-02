package com.antoni.wijaya.thesport.model.event

import com.google.gson.annotations.SerializedName

data class EventResult(

    @SerializedName("events")
    val listMatches: List<EventValue> = arrayListOf()
)

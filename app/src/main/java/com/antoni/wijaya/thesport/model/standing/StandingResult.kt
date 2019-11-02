package com.antoni.wijaya.thesport.model.standing

import com.google.gson.annotations.SerializedName

data class StandingResult (
    @SerializedName("table")
    val listStandings: List<StandingValue> = arrayListOf()
)
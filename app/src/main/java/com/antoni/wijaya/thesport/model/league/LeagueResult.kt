package com.antoni.wijaya.thesport.model.league

import com.google.gson.annotations.SerializedName

data class LeagueResult(

    @SerializedName("leagues")
    val leagues: List<LeagueValue> = arrayListOf()
)
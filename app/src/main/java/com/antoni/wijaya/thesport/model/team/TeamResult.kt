package com.antoni.wijaya.thesport.model.team

import com.google.gson.annotations.SerializedName

data class TeamResult(

    @SerializedName("teams")
    val teams: List<TeamValue> = arrayListOf()

)
package com.antoni.wijaya.thesport.model.league

import com.google.gson.annotations.SerializedName

data class LeagueValue(

    @SerializedName("idLeague")
    val id: String,

    @SerializedName("strLeague")
    val name: String,

    @SerializedName("strDescriptionEN")
    val desc: String,

    @SerializedName("strBadge")
    val imageUrl: String

)
package com.antoni.wijaya.thesport.model.team

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamValue(

    @SerializedName("idTeam")
    val id: String,

    @SerializedName("strTeam")
    val name: String,

    @SerializedName("strStadium")
    val stadium: String,

    @SerializedName("strTeamBadge")
    val imageUrl: String,

    @SerializedName("strDescriptionEN")
    val desc: String,

    @SerializedName("strAlternate")
    val alias: String

) : Parcelable
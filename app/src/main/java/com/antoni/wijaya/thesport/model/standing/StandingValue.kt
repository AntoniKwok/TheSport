package com.antoni.wijaya.thesport.model.standing

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class StandingValue(

    @SerializedName("teamid")
    val teamId: String,
    @SerializedName("name")
    val clubName: String,
    @SerializedName("played")
    val clubPlayed: Int,
    @SerializedName("goalsfor")
    val clubGoalsFor: Int,
    @SerializedName("goalsagainst")
    val clubGoalsAgainst: Int,
    @SerializedName("goalsdifference")
    val clubGoalsDiff: Int,
    @SerializedName("win")
    val clubWon: Int,
    @SerializedName("draw")
    val clubDrawn: Int,
    @SerializedName("loss")
    val clubLost: Int,
    @SerializedName("total")
    val clubTotalPoint: Int

) : Parcelable
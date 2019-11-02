package com.antoni.wijaya.thesport.model.match

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchValue(
    @SerializedName("idEvent")
    val matchId: String,
    @SerializedName("strEvent")
    val matchName: String,
    @SerializedName("strTime")
    val matchTime: String,
    @SerializedName("dateEvent")
    val matchDate: String,
    @SerializedName("strSeason")
    val season: String,
    @SerializedName("idHomeTeam")
    val homeTeamId: String,
    @SerializedName("strHomeTeam")
    val homeTeamName: String,
    @SerializedName("intHomeScore")
    val homeTeamScore: String,
    @SerializedName("strHomeGoalDetails")
    val homeTeamGoal: String,
    @SerializedName("strHomeFormation")
    val homeTeamFormation: String,
    @SerializedName("intHomeShots")
    val homeTeamShots: String,
    @SerializedName("strHomeRedCards")
    val homeTeamRedCard: String,
    @SerializedName("strHomeYellowCards")
    val homeTeamYellowCard: String,
    @SerializedName("idAwayTeam")
    val awayTeamId: String,
    @SerializedName("strAwayTeam")
    val awayTeamName: String,
    @SerializedName("intAwayScore")
    val awayTeamScore: String,
    @SerializedName("strAwayGoalDetails")
    val awayTeamGoal: String,
    @SerializedName("strAwayFormation")
    val awayTeamFormation: String,
    @SerializedName("intAwayShots")
    val awayTeamShots: String,
    @SerializedName("strAwayRedCards")
    val awayTeamRedCard: String,
    @SerializedName("strAwayYellowCards")
    val awayTeamYellowCard: String,
    @SerializedName("intSpectators")
    val eventSpectator: String,
    @SerializedName("strSport")
    val strSport: String
) : Parcelable
package com.antoni.wijaya.thesport.utils.api

import com.antoni.wijaya.thesport.BuildConfig

object SportApi {

    fun getDetailLeague(id: String): String {
        return BuildConfig.BASE_URL + "/lookupleague.php?id=" + id
    }

    fun getListTeam(id: String): String {
        return BuildConfig.BASE_URL + "/lookup_all_teams.php?id=" + id
    }

    fun getListNextMatch(id: String): String {
        return BuildConfig.BASE_URL + "/eventsnextleague.php?id=" + id
    }

    fun getListPrevMatch(id: String): String {
        return BuildConfig.BASE_URL + "/eventspastleague.php?id=" + id
    }

    fun getDetailMatch(id: String): String {
        return BuildConfig.BASE_URL + "/lookupevent.php?id=" + id
    }

    fun getDetailTeam(id: String): String {
        return BuildConfig.BASE_URL + "/lookupteam.php?id=" + id
    }

    fun getSearchMatch(data: String): String {
        return BuildConfig.BASE_URL + "/searchevents.php?e=" + data
    }

    fun getStandingData(id: String): String {
        return BuildConfig.BASE_URL + "/lookuptable.php?l=" + id
    }

    fun getSearchTeam(data: String): String {
        return BuildConfig.BASE_URL + "/searchteams.php?t=" + data
    }


}
package com.antoni.wijaya.thesport.ui.match

import android.content.Context
import com.antoni.wijaya.thesport.model.event.EventResult
import com.antoni.wijaya.thesport.model.event.EventValue
import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch
import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.db.database
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.db.insert

class DetailMatchPresenter(
    private val view: DetailMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getMatchData(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getDetailMatch(id)).await(),
                EventResult::class.java
            )
            view.showDetailMatchData(data.listMatches)
        }
    }

    fun getHomeTeamLogo(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getDetailTeam(id)).await(),
                TeamResult::class.java
            )
            view.loadHomeTeamLogo(data.teams)
        }
    }

    fun getAwayTeamLogo(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getDetailTeam(id)).await(),
                TeamResult::class.java
            )
            view.loadAwayTeamLogo(data.teams)
        }
    }

    fun addToFavorite(match : EventValue, ctx : Context){
        ctx.database.use {
            insert(
                FavoriteMatch.TABLE_FAVORITE_MATCH,
                FavoriteMatch.MATCH_ID to match.matchId,
                FavoriteMatch.MATCH_NAME to match.matchName,
                FavoriteMatch.MATCH_DATE to match.matchDate,
                FavoriteMatch.MATCH_TIME to match.matchTime,
                FavoriteMatch.HOME_TEAM_NAME to match.homeTeamName,
                FavoriteMatch.AWAY_TEAM_NAME to match.awayTeamName,
                FavoriteMatch.HOME_TEAM_SCORE to match.homeTeamScore,
                FavoriteMatch.AWAY_TEAM_SCORE to match.awayTeamScore
            )
        }
    }

}
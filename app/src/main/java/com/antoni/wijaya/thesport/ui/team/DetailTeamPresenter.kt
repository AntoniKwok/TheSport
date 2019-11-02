package com.antoni.wijaya.thesport.ui.team

import android.content.Context
import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam
import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.db.database
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.db.insert

class DetailTeamPresenter(
    private val view: DetailTeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getDetailData(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getDetailTeam(id)).await(),
                TeamResult::class.java
            )

            view.getTeamData(data.teams)

        }
    }

    fun addToFavorite(team : TeamValue, ctx : Context){
        ctx.database.use {
            insert(
                FavoriteTeam.TABLE_FAVORITE_TEAM,
                FavoriteTeam.TEAM_ID to team.id,
                FavoriteTeam.TEAM_NAME to team.name,
                FavoriteTeam.TEAM_STADIUM to team.stadium,
                FavoriteTeam.TEAM_IMAGE_URL to team.imageUrl
            )
        }
    }
}
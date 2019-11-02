package com.antoni.wijaya.thesport.ui.favorite.fragment.team

import android.content.Context
import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam
import com.antoni.wijaya.thesport.utils.db.database
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteTeamPresenter(
    private val dataView: FavoriteTeamView,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getFavoriteTeamData(ctx: Context) {
        GlobalScope.launch(context.main) {
            ctx.database.use {
                val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
                val favorite = result.parseList(classParser<FavoriteTeam>())
                dataView.showFavoriteData(favorite)
            }
        }
    }


}
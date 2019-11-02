package com.antoni.wijaya.thesport.ui.favorite.fragment.match

import android.content.Context
import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.antoni.wijaya.thesport.utils.db.database
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteMatchPresenter(
    private val dataView: FavoriteMatchView,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {
    fun getFavoriteMatchData(ctx: Context) {
        GlobalScope.launch(context.main) {
            ctx.database.use {
                val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
                val favorite = result.parseList(classParser<FavoriteMatch>())
                dataView.showFavoriteData(favorite)
            }
        }
    }


}
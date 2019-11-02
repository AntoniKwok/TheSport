package com.antoni.wijaya.thesport.ui.detail.fragment.info

import com.antoni.wijaya.thesport.model.league.LeagueResult
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class InfoLeaguePresenter(
    private val view: InfoLeagueView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getMatchDetailData(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getDetailLeague(id)).await(),
                LeagueResult::class.java
            )

            view.showDetailData(data.leagues)

        }
    }

}
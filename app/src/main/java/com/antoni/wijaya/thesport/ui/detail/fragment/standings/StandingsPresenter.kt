package com.antoni.wijaya.thesport.ui.detail.fragment.standings

import com.antoni.wijaya.thesport.model.standing.StandingResult
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class StandingsPresenter(
    private val view: StandingsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getStandingsData(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getStandingData(id)).await(),
                StandingResult::class.java
            )

            view.showStandingList(data.listStandings)


        }
    }

}
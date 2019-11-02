package com.antoni.wijaya.thesport.ui.detail.fragment.teams

import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getTeamData(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getListTeam(id)).await(),
                TeamResult::class.java
            )

            view.showTeamList(data.teams)


        }
    }

}
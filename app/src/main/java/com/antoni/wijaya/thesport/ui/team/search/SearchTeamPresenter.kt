package com.antoni.wijaya.thesport.ui.team.search

import com.antoni.wijaya.thesport.model.team.TeamResult
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchTeamPresenter(
    private val teamView: SearchTeamView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getTeamData(str: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getSearchTeam(str)).await(),
                TeamResult::class.java
            )
            val filteredArrayList = arrayListOf<TeamValue>()
            if (!data.teams.isNullOrEmpty())
                for (i in data.teams.indices)
                    filteredArrayList.add(data.teams[i])

            teamView.showSearchedTeamData(filteredArrayList)
        }
    }

}
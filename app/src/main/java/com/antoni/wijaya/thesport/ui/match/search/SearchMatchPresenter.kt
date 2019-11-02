package com.antoni.wijaya.thesport.ui.match.search

import com.antoni.wijaya.thesport.model.event.EventValue
import com.antoni.wijaya.thesport.model.event.SearchResult
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchMatchPresenter(
    private val matchView: SearchMatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getMatchData(str: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getSearchMatch(str)).await(),
                SearchResult::class.java
            )
            val filteredArrayList = arrayListOf<EventValue>()
            if (!data.listSearched.isNullOrEmpty())
                for (i in data.listSearched.indices)
                    if (data.listSearched[i].strSport == "Soccer")
                        filteredArrayList.add(data.listSearched[i])

            matchView.showSearchData(filteredArrayList)
        }
    }

}
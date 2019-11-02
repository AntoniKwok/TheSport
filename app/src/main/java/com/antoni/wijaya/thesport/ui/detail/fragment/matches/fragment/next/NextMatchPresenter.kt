package com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.next

import com.antoni.wijaya.thesport.model.match.MatchResult
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.MatchView
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.api.SportApi
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NextMatchPresenter(
    private val view: MatchView,
    private val apiRepository: ApiRepository,
    private val gson: Gson,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getListMatches(id: String) {
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.doAsyncRequestAsync(SportApi.getListNextMatch(id)).await(),
                MatchResult::class.java
            )
            view.showMatchData(data.listMatches)
        }
    }

}
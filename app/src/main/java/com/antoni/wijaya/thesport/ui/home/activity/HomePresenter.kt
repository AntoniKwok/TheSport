package com.antoni.wijaya.thesport.ui.home.activity

import com.antoni.wijaya.thesport.ui.home.HomeView
import com.antoni.wijaya.thesport.utils.provider.CoroutineContextProvider
import com.antoni.wijaya.thesport.utils.DataDummy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePresenter(
    private val view: HomeView,
    private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getLeagueData() {
        GlobalScope.launch(context.main) {
            view.showListLeague(DataDummy.generateDummyLeague())
        }
    }

}
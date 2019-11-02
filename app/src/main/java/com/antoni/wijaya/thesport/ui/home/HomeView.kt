package com.antoni.wijaya.thesport.ui.home

import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity

interface HomeView {
    fun showListLeague(data: List<LeagueDummyEntity>)
}
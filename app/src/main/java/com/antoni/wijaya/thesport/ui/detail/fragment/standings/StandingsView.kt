package com.antoni.wijaya.thesport.ui.detail.fragment.standings

import com.antoni.wijaya.thesport.model.standing.StandingValue

interface StandingsView {
    fun showStandingList(data: List<StandingValue>)
}
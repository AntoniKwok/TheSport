package com.antoni.wijaya.thesport.ui.match

import com.antoni.wijaya.thesport.model.event.EventValue
import com.antoni.wijaya.thesport.model.team.TeamValue

interface DetailMatchView {
    fun showDetailMatchData(data: List<EventValue>)
    fun loadHomeTeamLogo(data : List<TeamValue>)
    fun loadAwayTeamLogo(data : List<TeamValue>)
}
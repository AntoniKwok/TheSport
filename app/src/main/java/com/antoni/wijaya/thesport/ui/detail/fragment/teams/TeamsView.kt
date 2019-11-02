package com.antoni.wijaya.thesport.ui.detail.fragment.teams

import com.antoni.wijaya.thesport.model.team.TeamValue

interface TeamsView {
    fun showTeamList(data: List<TeamValue>)
}
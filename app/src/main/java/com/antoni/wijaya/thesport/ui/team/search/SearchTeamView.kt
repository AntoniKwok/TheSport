package com.antoni.wijaya.thesport.ui.team.search

import com.antoni.wijaya.thesport.model.team.TeamValue

interface SearchTeamView {
    fun showSearchedTeamData(data: List<TeamValue>)
}
package com.antoni.wijaya.thesport.ui.team

import com.antoni.wijaya.thesport.model.team.TeamValue

interface DetailTeamView {
    fun getTeamData(data: List<TeamValue>)
}
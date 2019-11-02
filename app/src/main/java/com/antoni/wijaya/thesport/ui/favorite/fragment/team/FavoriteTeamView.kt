package com.antoni.wijaya.thesport.ui.favorite.fragment.team

import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam

interface FavoriteTeamView {
    fun showFavoriteData(data: List<FavoriteTeam>)
}
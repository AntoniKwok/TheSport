package com.antoni.wijaya.thesport.ui.favorite.fragment.match

import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch

interface FavoriteMatchView {
    fun showFavoriteData(data: List<FavoriteMatch>)
}
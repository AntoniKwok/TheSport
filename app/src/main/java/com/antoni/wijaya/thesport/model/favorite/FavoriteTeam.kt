package com.antoni.wijaya.thesport.model.favorite

data class FavoriteTeam(
    val id: Long?,
    val teamId: String?,
    val teamName: String?,
    val teamStadium: String?,
    val teamImageUrl: String?
) {

    companion object {
        const val TABLE_FAVORITE_TEAM: String = "TABLE_FAVORITE_TEAM"
        const val ID: String = "ID_"
        const val TEAM_ID: String = "TEAM_ID"
        const val TEAM_NAME: String = "TEAM_NAME"
        const val TEAM_STADIUM: String = "TEAM_STADIUM"
        const val TEAM_IMAGE_URL: String = "TEAM_IMAGE_URL"
    }

}
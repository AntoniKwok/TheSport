package com.antoni.wijaya.thesport.model.favorite

data class FavoriteMatch(
    val id: Long?,
    val matchId: String?,
    val matchName: String?,
    val matchDate: String?,
    val matchTime: String?,
    val homeTeamName: String?,
    val awayTeamName: String?,
    val homeTeamScore: String?,
    val awayTeamScore: String?
) {

    companion object {
        const val TABLE_FAVORITE_MATCH: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val MATCH_NAME: String = "MATCH_NAME"
        const val MATCH_DATE: String = "MATCH_DATE"
        const val MATCH_TIME: String = "MATCH_TIME"
        const val HOME_TEAM_NAME: String = "HOME_TEAM_NAME"
        const val AWAY_TEAM_NAME: String = "AWAY_TEAM_NAME"
        const val HOME_TEAM_SCORE: String = "HOME_TEAM_SCORE"
        const val AWAY_TEAM_SCORE: String = "AWAY_TEAM_SCORE"

    }

}
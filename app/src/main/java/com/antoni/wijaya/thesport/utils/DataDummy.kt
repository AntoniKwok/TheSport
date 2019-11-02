package com.antoni.wijaya.thesport.utils

import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity

class DataDummy {

    companion object {

        fun generateDummyLeague(): ArrayList<LeagueDummyEntity> {
            val leagues = ArrayList<LeagueDummyEntity>()

            leagues.add(
                LeagueDummyEntity(
                    "4328",
                    "English Premier League",
                    R.drawable.premier
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4334",
                    "French Ligue 1",
                    R.drawable.french_ligue_1
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4331",
                    "German Bundesliga",
                    R.drawable.german_bundesliga
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4332",
                    "Italian Serie A",
                    R.drawable.italian_serie_a
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4335",
                    "Spanish La Liga",
                    R.drawable.spanish_la_liga
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4346",
                    "American Mayor League",
                    R.drawable.american_mayor_league
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4344",
                    "Portugeuese Premiera Liga",
                    R.drawable.portugeuese_premiera_liga
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4356",
                    "Australian A League",
                    R.drawable.australian_a_league
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4330",
                    "Scotish Premier League",
                    R.drawable.scotish_premier_league
                )
            )

            leagues.add(
                LeagueDummyEntity(
                    "4396",
                    "English League 1",
                    R.drawable.english_league_1
                )
            )


            return leagues
        }

    }

}
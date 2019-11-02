package com.antoni.wijaya.thesport.ui.detail.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.ui.detail.fragment.info.InfoLeagueFragment
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.MatchesFragment
import com.antoni.wijaya.thesport.ui.detail.fragment.standings.StandingsFragment
import com.antoni.wijaya.thesport.ui.detail.fragment.teams.TeamsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailLeagueActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LEAGUE = "extra_league"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        loadFragment(InfoLeagueFragment.newInstance())
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        val league = intent.getParcelableExtra<LeagueDummyEntity>(EXTRA_LEAGUE)

        val actionBar = supportActionBar
        actionBar?.title = league?.name

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_league_info -> loadFragment(InfoLeagueFragment.newInstance())
                R.id.navigation_match -> loadFragment(MatchesFragment.newInstance())
                R.id.navigation_team -> loadFragment(TeamsFragment.newInstance())
                R.id.navigation_standing -> loadFragment(StandingsFragment.newInstance())
            }
            true
        }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
            return true
        }
        return false
    }
}

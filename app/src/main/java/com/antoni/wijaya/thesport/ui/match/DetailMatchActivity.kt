package com.antoni.wijaya.thesport.ui.match

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.event.EventValue
import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.db.database
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.onRefresh

class DetailMatchActivity : AppCompatActivity(), DetailMatchView {

    private var isFav: Boolean = false
    private lateinit var presenter: DetailMatchPresenter
    private lateinit var match: EventValue
    private var menuItem: Menu? = null
    private lateinit var idMatch: String

    companion object {
        const val EXTRA_MATCH = "match"
        const val EXTRA_MATCH_NAME = "match_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        showLoading(true)
        val match = intent.getStringExtra(EXTRA_MATCH)
        idMatch = match

        val request = ApiRepository()
        val gson = Gson()

        if (match != null) {
            checkFavorite()
            presenter = DetailMatchPresenter(this, request, gson)
            presenter.getMatchData(match)
        }
        swipe_refresh.onRefresh {
            presenter.getMatchData(match)
        }
        supportActionBar?.title = intent.getStringExtra(EXTRA_MATCH_NAME)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_match_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btn_add_favorite -> {
                if (isFav) removeFromFavorite()
                else addToFav()

                isFav = !isFav
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addToFav() {
        try {
            presenter.addToFavorite(match, applicationContext)
            swipe_refresh.snackbar("Added to Favorite").show()
        } catch (e: SQLiteConstraintException) {
            swipe_refresh.snackbar(e.localizedMessage).show()
        }
    }

    private fun checkFavorite() {
        database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
                .whereArgs(
                    "(MATCH_ID = {id})",
                    "id" to idMatch
                )
            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (favorite.isNotEmpty()) isFav = true
        }
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            layout_detail.visibility = View.GONE
            card_view.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            layout_detail.visibility = View.VISIBLE
            card_view.visibility = View.VISIBLE
        }
    }

    private fun setFavorite() {
        if (isFav)
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_star_white_24dp)
        else
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_star_border_white_24dp)
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(
                    FavoriteMatch.TABLE_FAVORITE_MATCH, "(MATCH_ID = {id})",
                    "id" to match.matchId
                )
            }
            swipe_refresh.snackbar("Removed from favorite").show()
        } catch (e: SQLiteConstraintException) {
            swipe_refresh.snackbar(e.localizedMessage).show()
        }
    }

    override fun showDetailMatchData(data: List<EventValue>) {
        match = data[0]
        presenter.getHomeTeamLogo(data[0].homeTeamId)
        presenter.getAwayTeamLogo(data[0].awayTeamId)
        txt_home_team_name.text = match.homeTeamName
        txt_away_team_name.text = match.awayTeamName

        txt_home_score.text = match.homeTeamScore
        txt_away_score.text = match.awayTeamScore

        txt_spectators.text = match.eventSpectator
        txt_match_name.text = match.matchName
        txt_match_date.text = match.matchDate
        txt_match_time.text = match.matchTime

        txt_home_formation.text = match.homeTeamFormation
        txt_away_formation.text = match.awayTeamFormation

        txt_home_shots.text = match.homeTeamShots
        txt_away_shots.text = match.awayTeamShots

        txt_home_yellow_card.text = match.homeTeamYellowCard
        txt_away_yellow_card.text = match.awayTeamYellowCard

        txt_home_red_card.text = match.homeTeamRedCard
        txt_away_red_card.text = match.awayTeamRedCard

        txt_home_goals.text = match.homeTeamGoal
        txt_away_goals.text = match.awayTeamGoal
        swipe_refresh.isRefreshing = false
        showLoading(false)
    }

    override fun loadHomeTeamLogo(data: List<TeamValue>) {
        Picasso.get().load(data[0].imageUrl).into(img_home_team_poster)
    }

    override fun loadAwayTeamLogo(data: List<TeamValue>) {
        Picasso.get().load(data[0].imageUrl).into(img_away_team_poster)
    }
}

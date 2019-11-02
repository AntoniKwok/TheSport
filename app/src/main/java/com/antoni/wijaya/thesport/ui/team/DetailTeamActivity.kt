package com.antoni.wijaya.thesport.ui.team

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.antoni.wijaya.thesport.utils.db.database
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.onRefresh

class DetailTeamActivity : AppCompatActivity(), DetailTeamView {

    companion object {
        const val EXTRA_TEAM = "extra_team"
        const val EXTRA_TEAM_NAME = "extra_team_name"
    }

    private var isFav: Boolean = false
    private lateinit var presenter: DetailTeamPresenter
    private lateinit var idTeam: String
    private lateinit var team: TeamValue
    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        val intentData = intent?.getStringExtra(EXTRA_TEAM)
        val name = intent?.getStringExtra(EXTRA_TEAM_NAME)

        val request = ApiRepository()
        val gson = Gson()
        if (intentData != null) {
            idTeam = intentData
            checkFavorite()
            presenter = DetailTeamPresenter(this, request, gson)
            presenter.getDetailData(intentData)
        }

        swipe_refresh.onRefresh {
            presenter.getDetailData(idTeam)
        }

        supportActionBar?.title = intent.getStringExtra(name)
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

    override fun getTeamData(data: List<TeamValue>) {
        team = data[0]
        txt_team_title.text = data[0].name
        txt_alias.text = data[0].alias
        txt_stadium.text = data[0].stadium
        txt_team_desc.text = data[0].desc
        Picasso.get().load(data[0].imageUrl).into(img_team_poster)
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            detail_team_layout.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            detail_team_layout.visibility = View.VISIBLE
        }
    }

    private fun addToFav() {
        try {
            presenter.addToFavorite(team, this)
            swipe_refresh.snackbar("Added to Favorite").show()
        } catch (e: SQLiteConstraintException) {
            swipe_refresh.snackbar(e.localizedMessage).show()
        }
    }

    private fun checkFavorite() {
        database.use {
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
                .whereArgs(
                    "(TEAM_ID = {id})",
                    "id" to idTeam
                )
            val favorite = result.parseList(classParser<FavoriteTeam>())
            if (favorite.isNotEmpty()) isFav = true
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
                    FavoriteTeam.TABLE_FAVORITE_TEAM, "(TEAM_ID = {id})",
                    "id" to team.id
                )
            }
            swipe_refresh.snackbar("Removed from favorite").show()
        } catch (e: SQLiteConstraintException) {
            swipe_refresh.snackbar(e.localizedMessage).show()
        }
    }


}

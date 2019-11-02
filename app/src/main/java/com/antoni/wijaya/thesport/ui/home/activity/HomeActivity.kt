package com.antoni.wijaya.thesport.ui.home.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.ui.detail.activity.DetailLeagueActivity
import com.antoni.wijaya.thesport.ui.favorite.FavoriteActivity
import com.antoni.wijaya.thesport.ui.home.HomeView
import com.antoni.wijaya.thesport.ui.home.adapter.HomeAdapter
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity(), HomeView {

    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
        presenter.getLeagueData()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu_favorite, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.btn_favorite_menu -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun showListLeague(data: List<LeagueDummyEntity>) {
        rv_league.layoutManager = LinearLayoutManager(this)
        rv_league.adapter = HomeAdapter(data) {
            startActivity<DetailLeagueActivity>(DetailLeagueActivity.EXTRA_LEAGUE to it)
        }
    }

}

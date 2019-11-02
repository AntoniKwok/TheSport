package com.antoni.wijaya.thesport.ui.team.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.ui.detail.fragment.teams.TeamAdapter
import com.antoni.wijaya.thesport.ui.team.DetailTeamActivity
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_search_team.*
import org.jetbrains.anko.startActivity

class SearchTeamActivity : AppCompatActivity(), SearchTeamView {

    private lateinit var teamPresenter: SearchTeamPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_team)

        showLoading(true)

        val request = ApiRepository()
        val gson = Gson()
        teamPresenter = SearchTeamPresenter(this, request, gson)
        teamPresenter.getTeamData("arsenal")

        icon_back.setOnClickListener {
            finish()
        }

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        search_view?.setSearchableInfo(searchManager.getSearchableInfo(this.componentName))
        search_view?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                var searchText = "arsenal"
                if (query != "")
                    searchText = query.toString()

                teamPresenter.getTeamData(searchText)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                var searchText = "arsenal"
                if (query != "")
                    searchText = query.toString()

                teamPresenter.getTeamData(searchText)
                return false
            }
        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            search_layout.visibility = View.GONE
            rv_search_result.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            search_layout.visibility = View.VISIBLE
            rv_search_result.visibility = View.VISIBLE
        }
    }

    override fun showSearchedTeamData(data: List<TeamValue>) {
        showLoading(true)
        val adapter = TeamAdapter(data as ArrayList<TeamValue>) {
            startActivity<DetailTeamActivity>(
                DetailTeamActivity.EXTRA_TEAM to it.id,
                DetailTeamActivity.EXTRA_TEAM_NAME to it.name
            )
        }
        adapter.notifyDataSetChanged()
        rv_search_result.layoutManager = LinearLayoutManager(this)
        rv_search_result.adapter = adapter



        showLoading(false)
        if (data.isEmpty()) {
            txt_match_not_found.visibility = View.VISIBLE
            rv_search_result.visibility = View.GONE
        } else {
            txt_match_not_found.visibility = View.GONE
            rv_search_result.visibility = View.VISIBLE
        }
    }
}

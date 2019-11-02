package com.antoni.wijaya.thesport.ui.detail.fragment.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.antoni.wijaya.thesport.ui.detail.activity.DetailLeagueActivity
import com.antoni.wijaya.thesport.ui.team.DetailTeamActivity
import com.antoni.wijaya.thesport.ui.team.search.SearchTeamActivity
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_teams.*
import kotlinx.android.synthetic.main.fragment_teams.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.startActivity

class TeamsFragment : Fragment(), TeamsView {

    companion object {
        fun newInstance(): TeamsFragment {
            return TeamsFragment()
        }
    }

    private lateinit var presenter: TeamsPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val intentData =
            activity?.intent?.getParcelableExtra<LeagueDummyEntity>(DetailLeagueActivity.EXTRA_LEAGUE)
        showLoading(true)
        val request = ApiRepository()
        val gson = Gson()
        if (intentData != null) {
            presenter = TeamsPresenter(this, request, gson)
            presenter.getTeamData(intentData.id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.icon_back.setOnClickListener {
            activity?.finish()
        }

        view.icon_search.setOnClickListener {
            activity?.startActivity<SearchTeamActivity>()
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            rv_teams.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            rv_teams.visibility = View.VISIBLE
        }
    }

    override fun showTeamList(data: List<TeamValue>) {
        val adapter = TeamAdapter(data as ArrayList<TeamValue>) {
            startActivity<DetailTeamActivity>(
                DetailTeamActivity.EXTRA_TEAM to it.id,
                DetailTeamActivity.EXTRA_TEAM_NAME to it.name
            )
        }
        adapter.notifyDataSetChanged()
        rv_teams.layoutManager = LinearLayoutManager(context)
        rv_teams.adapter = adapter
        showLoading(false)
    }
}
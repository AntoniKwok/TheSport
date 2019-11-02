package com.antoni.wijaya.thesport.ui.detail.fragment.standings


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.model.standing.StandingValue
import com.antoni.wijaya.thesport.ui.detail.activity.DetailLeagueActivity
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_standings.*
import kotlinx.android.synthetic.main.fragment_standings.view.*

/**
 * A simple [Fragment] subclass.
 */
class StandingsFragment : Fragment(), StandingsView {

    companion object {
        fun newInstance(): StandingsFragment {
            return StandingsFragment()
        }
    }

    private lateinit var presenter : StandingsPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val intentData =
            activity?.intent?.getParcelableExtra<LeagueDummyEntity>(DetailLeagueActivity.EXTRA_LEAGUE)
        showLoading(true)
        val request = ApiRepository()
        val gson = Gson()
        if (intentData != null) {
            presenter = StandingsPresenter(this, request, gson)
            presenter.getStandingsData(intentData.id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.icon_back.setOnClickListener {
            activity?.finish()
        }
    }

    override fun showStandingList(data: List<StandingValue>) {
        val adapter = StandingsAdapter(data as ArrayList<StandingValue>)
        adapter.notifyDataSetChanged()
        view?.rv_standings?.layoutManager = LinearLayoutManager(context)
        view?.rv_standings?.adapter = adapter
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            rv_standings.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            rv_standings.visibility = View.VISIBLE
        }
    }


}

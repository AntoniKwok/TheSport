package com.antoni.wijaya.thesport.ui.detail.fragment.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.model.league.LeagueValue
import com.antoni.wijaya.thesport.ui.detail.activity.DetailLeagueActivity
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_info_league.*
import kotlinx.android.synthetic.main.fragment_info_league.view.*


class InfoLeagueFragment : Fragment(),
    InfoLeagueView {

    companion object {

        fun newInstance(): InfoLeagueFragment {
            return InfoLeagueFragment()
        }

    }

    private lateinit var presenter: InfoLeaguePresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val intentData =
            activity?.intent?.getParcelableExtra<LeagueDummyEntity>(DetailLeagueActivity.EXTRA_LEAGUE)
        showLoading(true)
        val request = ApiRepository()
        val gson = Gson()

        if (intentData != null) {
            presenter = InfoLeaguePresenter(this, request, gson)
            presenter.getMatchDetailData(intentData.id)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_info_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.icon_back.setOnClickListener {
            activity?.finish()
        }
    }


    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            constraint_layout.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            constraint_layout.visibility = View.VISIBLE
        }
    }


    override fun showDetailData(data: List<LeagueValue>) {
        Picasso.get().load(data[0].imageUrl).into(img_league_poster)
        txt_league_desc.text = data[0].desc
        txt_league_title.text = data[0].name
        showLoading(false)
    }
}
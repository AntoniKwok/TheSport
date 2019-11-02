package com.antoni.wijaya.thesport.ui.detail.fragment.matches

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.antoni.wijaya.thesport.ui.detail.activity.DetailLeagueActivity
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.adapter.TabMatchAdapter
import com.antoni.wijaya.thesport.ui.match.search.SearchMatchActivity
import kotlinx.android.synthetic.main.fragment_matches.view.*
import org.jetbrains.anko.support.v4.startActivity

class MatchesFragment : Fragment() {

    companion object {
        fun newInstance(): MatchesFragment {
            return MatchesFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intentData = activity?.intent?.getParcelableExtra<LeagueDummyEntity>(
            DetailLeagueActivity.EXTRA_LEAGUE
        )
        val fragmentAdapter =
            activity?.supportFragmentManager?.let {
                intentData?.id?.let { it1 ->
                    TabMatchAdapter(
                        it,
                        it1
                    )
                }
            }
        view.view_pager.adapter = fragmentAdapter
        view.tabs_type.setupWithViewPager(view.view_pager)

        view.icon_search.setOnClickListener {
            startActivity<SearchMatchActivity>()
        }

        view.icon_back.setOnClickListener {
            activity?.finish()
        }
    }


}
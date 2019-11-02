package com.antoni.wijaya.thesport.ui.favorite.fragment.match


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch
import com.antoni.wijaya.thesport.ui.match.DetailMatchActivity
import kotlinx.android.synthetic.main.fragment_favorite_match.*
import kotlinx.android.synthetic.main.fragment_favorite_match.view.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class FavoriteMatchFragment : Fragment(), FavoriteMatchView {

    companion object {
        fun newInstance(): FavoriteMatchFragment {
            return FavoriteMatchFragment()
        }
    }

    private lateinit var presenter: FavoriteMatchPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)

        presenter = FavoriteMatchPresenter(this)

        getFavoriteData()

        view.swipe_refresh.onRefresh {
            getFavoriteData()
        }
    }

    private fun getFavoriteData() {
        activity?.applicationContext?.let { presenter.getFavoriteMatchData(it) }
    }

    override fun onResume() {
        super.onResume()
        getFavoriteData()
    }

    override fun showFavoriteData(data: List<FavoriteMatch>) {
        val adapter = FavoriteMatchAdapter(data) {
            startActivity<DetailMatchActivity>(DetailMatchActivity.EXTRA_MATCH to it.matchId,
                DetailMatchActivity.EXTRA_MATCH_NAME to it.matchName)
        }
        adapter.notifyDataSetChanged()
        rv_favorites.layoutManager = LinearLayoutManager(activity)
        rv_favorites.adapter = adapter
        swipe_refresh.isRefreshing = false
        showLoading(false)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            rv_favorites.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            rv_favorites.visibility = View.VISIBLE
        }
    }


}

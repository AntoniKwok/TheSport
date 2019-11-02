package com.antoni.wijaya.thesport.ui.favorite.fragment.team


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam
import com.antoni.wijaya.thesport.ui.team.DetailTeamActivity
import kotlinx.android.synthetic.main.fragment_favorite_team.*
import kotlinx.android.synthetic.main.fragment_favorite_team.view.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class FavoriteTeamFragment : Fragment(), FavoriteTeamView {

    companion object {
        fun newInstance(): FavoriteTeamFragment {
            return FavoriteTeamFragment()
        }
    }

    private lateinit var presenter: FavoriteTeamPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)

        presenter = FavoriteTeamPresenter(this)

        getFavoriteData()

        view.swipe_refresh.onRefresh {
            getFavoriteData()
        }
    }

    private fun getFavoriteData() {
        activity?.applicationContext?.let { presenter.getFavoriteTeamData(it) }
    }

    override fun onResume() {
        super.onResume()
        getFavoriteData()
    }

    override fun showFavoriteData(data: List<FavoriteTeam>) {
        val adapter = FavoriteTeamAdapter(data) {
            startActivity<DetailTeamActivity>(DetailTeamActivity.EXTRA_TEAM to it.teamId,
                DetailTeamActivity.EXTRA_TEAM_NAME to it.teamName)
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


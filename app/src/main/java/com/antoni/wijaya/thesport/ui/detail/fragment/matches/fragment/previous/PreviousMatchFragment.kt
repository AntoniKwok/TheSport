package com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.previous


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.match.MatchValue
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.MatchView
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.MatchesAdapter
import com.antoni.wijaya.thesport.ui.match.DetailMatchActivity
import com.antoni.wijaya.thesport.utils.api.ApiRepository
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_previous_match.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class PreviousMatchFragment : Fragment(), MatchView {

    private lateinit var presenter: PreviousMatchPresenter

    companion object {
        const val EXTRA_ID = "id"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_previous_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        val id = arguments?.getString(EXTRA_ID)
        val request = ApiRepository()
        val gson = Gson()
        if (id != null) {

            presenter = PreviousMatchPresenter(this, request, gson)
            presenter.getListMatches(id)

        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progress_bar.visibility = View.VISIBLE
            rv_prev_matches.visibility = View.GONE
        } else {
            progress_bar.visibility = View.GONE
            rv_prev_matches.visibility = View.VISIBLE
        }
    }

    override fun showMatchData(data: List<MatchValue>) {
        val adapter = MatchesAdapter(
            data
        ) {
            startActivity<DetailMatchActivity>(
                DetailMatchActivity.EXTRA_MATCH to it.matchId,
                DetailMatchActivity.EXTRA_MATCH_NAME to it.matchName
            )
        }
        adapter.notifyDataSetChanged()
        rv_prev_matches.layoutManager = LinearLayoutManager(context)
        rv_prev_matches.adapter = adapter
        showLoading(false)
    }


}

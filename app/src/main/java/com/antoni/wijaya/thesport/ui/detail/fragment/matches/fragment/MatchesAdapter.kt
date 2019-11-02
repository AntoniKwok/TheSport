package com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.match.MatchValue
import kotlinx.android.synthetic.main.item_match.view.*

class MatchesAdapter(
    private val matches: List<MatchValue>,
    private val listener: (MatchValue) -> Unit
) : RecyclerView.Adapter<MatchesAdapter.MatchesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchesViewHolder(view)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        val match = matches[position]
        holder.bindItem(match)
        holder.itemView.setOnClickListener {
            listener(match)
        }

    }


    class MatchesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(
            eventValue: MatchValue
        ) {
            itemView.txt_match_name.text = eventValue.matchName
            itemView.txt_match_date.text = eventValue.matchDate
            itemView.txt_match_time.text = eventValue.matchTime
            itemView.txt_home_team_name.text = eventValue.homeTeamName
            itemView.txt_home_score.text = eventValue.homeTeamScore

            itemView.txt_away_team_name.text = eventValue.awayTeamName
            itemView.txt_away_score.text = eventValue.awayTeamScore

        }

    }
}
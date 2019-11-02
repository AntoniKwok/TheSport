package com.antoni.wijaya.thesport.ui.match.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.event.EventValue
import kotlinx.android.synthetic.main.item_match.view.*

class SearchMatchAdapter(
    private val matches: List<EventValue>,
    private val listener: (EventValue) -> Unit
) : RecyclerView.Adapter<SearchMatchAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val match = matches[position]
        holder.bindItem(match)
        holder.itemView.setOnClickListener {
            listener(match)
        }
    }

    class SearchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(
            eventValue: EventValue
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
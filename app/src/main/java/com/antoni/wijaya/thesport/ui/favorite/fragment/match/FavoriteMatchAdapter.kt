package com.antoni.wijaya.thesport.ui.favorite.fragment.match

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.favorite.FavoriteMatch
import kotlinx.android.synthetic.main.item_match.view.*

class FavoriteMatchAdapter(
    private val favorites: List<FavoriteMatch>,
    private val listener: (FavoriteMatch) -> Unit
) : RecyclerView.Adapter<FavoriteMatchAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return FavoriteViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = favorites.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorite = favorites[position]
        holder.bindItem(favorite)
        holder.itemView.setOnClickListener {
            listener(favorite)
        }
    }

    class FavoriteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(favorite: FavoriteMatch) {
            itemView.txt_match_name.text = favorite.matchName
            itemView.txt_match_date.text = favorite.matchDate
            itemView.txt_match_time.text = favorite.matchTime
            itemView.txt_away_team_name.text = favorite.awayTeamName
            itemView.txt_home_team_name.text = favorite.homeTeamName
            itemView.txt_home_score.text = favorite.homeTeamScore
            itemView.txt_away_score.text = favorite.awayTeamScore
        }
    }
}
package com.antoni.wijaya.thesport.ui.favorite.fragment.team

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.favorite.FavoriteTeam
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_team.view.*

class FavoriteTeamAdapter(
    private val favorites: List<FavoriteTeam>,
    private val listener: (FavoriteTeam) -> Unit
) : RecyclerView.Adapter<FavoriteTeamAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
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

        fun bindItem(favorite: FavoriteTeam) {
            itemView.txt_name.text = favorite.teamName
            itemView.txt_stadium.text = favorite.teamStadium
            Picasso.get().load(favorite.teamImageUrl).into(itemView.img_team)
        }
    }
}
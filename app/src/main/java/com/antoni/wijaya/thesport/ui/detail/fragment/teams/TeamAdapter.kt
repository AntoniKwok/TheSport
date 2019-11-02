package com.antoni.wijaya.thesport.ui.detail.fragment.teams

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.team.TeamValue
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter(
    private val teams: ArrayList<TeamValue>,
    private val listener: (TeamValue) -> Unit
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.bindItem(team)
        holder.itemView.setOnClickListener {
            listener(team)
        }
    }

    class TeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(team: TeamValue) {
            Picasso.get().load(team.imageUrl).into(itemView.img_team)
            itemView.txt_name.text = team.name
            itemView.txt_stadium.text = team.stadium
        }
    }
}
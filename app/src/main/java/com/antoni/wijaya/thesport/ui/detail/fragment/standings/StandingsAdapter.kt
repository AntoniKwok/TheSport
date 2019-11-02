package com.antoni.wijaya.thesport.ui.detail.fragment.standings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.standing.StandingValue
import kotlinx.android.synthetic.main.list_item_standing.view.*

class StandingsAdapter(
    private val standings: ArrayList<StandingValue>
) : RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_standing, parent, false)
        return StandingsViewHolder(view)
    }

    override fun getItemCount(): Int = standings.size

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        val standingValue = standings[position]
        holder.bindItem(standingValue)
    }

    class StandingsViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bindItem(standingValue: StandingValue){
            itemView.txt_club.text = standingValue.clubName
            itemView.txt_played.text = standingValue.clubPlayed.toString()
            itemView.txt_won.text = standingValue.clubWon.toString()
            itemView.txt_drawn.text = standingValue.clubDrawn.toString()
            itemView.txt_lost.text = standingValue.clubLost.toString()
            itemView.txt_goal_for.text = standingValue.clubGoalsFor.toString()
            itemView.txt_goal_again.text = standingValue.clubGoalsAgainst.toString()
            itemView.txt_goal_diff.text = standingValue.clubGoalsDiff.toString()
            itemView.txt_points.text = standingValue.clubTotalPoint.toString()
        }
    }
}
package com.antoni.wijaya.thesport.home.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.home.ui.LeagueUI
import com.antoni.wijaya.thesport.model.League
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find

class HomeAdapter(var list: ArrayList<League> = arrayListOf()) :
    RecyclerView.Adapter<HomeAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(LeagueUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = list[position]
        Log.wtf("Value", league.name)
        holder.leagueTitle.text = league.name
        Picasso.get().load(league.image).into(holder.leagueImage)

    }


    class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var leagueTitle : TextView = itemView.findViewById(LeagueUI.name_id)
        var leagueImage : ImageView = itemView.find(LeagueUI.image_id)
    }
}
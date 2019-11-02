package com.antoni.wijaya.thesport.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.model.league.LeagueDummyEntity
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_league.*

class HomeAdapter(
    private var list: List<LeagueDummyEntity> = arrayListOf(),
    private val listener: (LeagueDummyEntity) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder =
        LeagueViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_league,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = list[position]
        holder.bindItem(league)
        holder.itemView.setOnClickListener {
            listener(league)
        }
    }

    class LeagueViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(
        containerView!!
    ), LayoutContainer {

        fun bindItem(leagueDummy: LeagueDummyEntity) {
            txt_league.text = leagueDummy.name
            leagueDummy.image.let { Picasso.get().load(it).fit().into(img_league) }

        }
    }
}
package com.antoni.wijaya.thesport.ui.favorite.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.antoni.wijaya.thesport.ui.favorite.fragment.match.FavoriteMatchFragment
import com.antoni.wijaya.thesport.ui.favorite.fragment.team.FavoriteTeamFragment

class TabFavoriteAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                val frg =
                    FavoriteMatchFragment.newInstance()
                frg
            }
            else -> {
                val frg =
                    FavoriteTeamFragment.newInstance()
                frg
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Match"
            else -> "Team"
        }
    }

}
package com.antoni.wijaya.thesport.ui.detail.fragment.matches.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.next.NextMatchFragment
import com.antoni.wijaya.thesport.ui.detail.fragment.matches.fragment.previous.PreviousMatchFragment

class TabMatchAdapter(
    fm: FragmentManager,
    val id: String
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                val frg =
                    PreviousMatchFragment()
                val bundle = Bundle()
                bundle.putString(NextMatchFragment.EXTRA_ID, id)
                frg.arguments = bundle
                frg
            }
            else -> {
                val frg =
                    NextMatchFragment()
                val bundle = Bundle()
                bundle.putString(NextMatchFragment.EXTRA_ID, id)
                frg.arguments = bundle
                frg
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Previous Match"
            else -> "Next Match"
        }
    }

}

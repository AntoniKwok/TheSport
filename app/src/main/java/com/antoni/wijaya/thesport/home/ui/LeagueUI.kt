package com.antoni.wijaya.thesport.home.ui

import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class LeagueUI : AnkoComponent<ViewGroup> {

    companion object {
        val image_id = 1
        val name_id = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        linearLayout {
            imageView {
                id = image_id

            }.lparams(width= matchParent) {
                padding = dip(20)
                margin = dip(15)
            }
            textView {
                id = name_id
            }
        }
    }

}
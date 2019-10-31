package com.antoni.wijaya.thesport.home.ui

import android.view.View
import com.antoni.wijaya.thesport.home.activity.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainUI : AnkoComponent<MainActivity>{

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        verticalLayout{
            textView{
                hint = "Test"
            }
            recyclerView {
                id = rv_id

            }.lparams(width= matchParent, height = matchParent){
                padding = dip(20)
            }
        }
    }

    companion object {
        val rv_id = 1
        val nameId = 2
        val descId = 3
    }


}
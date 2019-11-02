package com.antoni.wijaya.thesport.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.ui.favorite.adapter.TabFavoriteAdapter
import com.antoni.wijaya.thesport.ui.favorite.fragment.match.FavoriteMatchPresenter
import kotlinx.android.synthetic.main.activity_favorite.*

class FavoriteActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val fragmentAdapter = TabFavoriteAdapter(supportFragmentManager)
        view_pager.adapter = fragmentAdapter
        tabs_type.setupWithViewPager(view_pager)


        supportActionBar?.title = "Favorite"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }



    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }




}

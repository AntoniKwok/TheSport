package com.antoni.wijaya.thesport.home.activity

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antoni.wijaya.thesport.R
import com.antoni.wijaya.thesport.home.adapter.HomeAdapter
import com.antoni.wijaya.thesport.home.ui.MainUI
import com.antoni.wijaya.thesport.model.League
import org.jetbrains.anko.AnkoContext

class MainActivity : AppCompatActivity() {

    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var adapter: HomeAdapter
    private var league = arrayListOf<League>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MainUI().createView(AnkoContext.create(applicationContext, this)))

        val rvLeague : RecyclerView = findViewById(MainUI.rv_id)
        rvLeague.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter(league)

        prepare()
        addItem()

        rvLeague.adapter = adapter
    }


    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_desc)
        dataPhoto = resources.obtainTypedArray(R.array.data_image)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val data = League(
                dataName[position],
                dataDescription[position],
                dataPhoto.getResourceId(position, -1)
            )
            league.add(data)
            Log.wtf("MainActivity", "sd" + league.size)
        }
        adapter.list = league
    }



}

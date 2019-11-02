package com.antoni.wijaya.thesport.utils.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseHelper(ctx : Context) : ManagedSQLiteOpenHelper(ctx, "Favorite.db", null, 1){

    companion object{
        private var instance: DatabaseHelper? = null

        fun getInstance(ctx : Context): DatabaseHelper? {
            if(instance == null){
                instance =
                    DatabaseHelper(ctx.applicationContext)
            }
            return instance
        }
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.createTable("TABLE_FAVORITE_MATCH", true,
            "ID_" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "MATCH_ID" to TEXT + UNIQUE,
            "MATCH_NAME" to TEXT,
            "MATCH_DATE" to TEXT,
            "MATCH_TIME" to TEXT,
            "HOME_TEAM_NAME" to TEXT,
            "AWAY_TEAM_NAME" to TEXT,
            "HOME_TEAM_SCORE" to TEXT,
            "AWAY_TEAM_SCORE" to TEXT
            )
        p0?.createTable("TABLE_FAVORITE_TEAM", true,
            "ID_" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            "TEAM_ID" to TEXT + UNIQUE,
            "TEAM_NAME" to TEXT,
            "TEAM_STADIUM" to TEXT,
            "TEAM_IMAGE_URL" to TEXT)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.dropTable("TABLE_FAVORITE_MATCH", true)
        p0?.dropTable("TABLE_FAVORITE_TEAM", true)
    }

}

val Context.database: DatabaseHelper?
    get() = DatabaseHelper.getInstance(
        applicationContext
    )
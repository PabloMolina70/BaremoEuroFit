package com.example.baremoeurofitpablomolina

import android.app.Application
import android.content.Context
import androidx.room.Room

class MyApplication : Application() {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "app_database")
            .build()
    }
}
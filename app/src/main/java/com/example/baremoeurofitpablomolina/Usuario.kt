package com.example.baremoeurofitpablomolina

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val password: String
)

package com.example.baremoeurofitpablomolina

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {
    @Insert
    suspend fun insert(user: Usuario)

    @Query("SELECT * FROM user_table WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUserByEmailAndPassword(email: String, password: String): Usuario?
}
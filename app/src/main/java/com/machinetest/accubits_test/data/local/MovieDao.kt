package com.machinetest.accubits_test.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.machinetest.accubits_test.data.entities.Movies


@Dao
interface MovieDao {

    @Query("SELECT * FROM movies")
    fun getAllMovies() : LiveData<List<Movies>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(characters: List<Movies>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(character: Movies)
}
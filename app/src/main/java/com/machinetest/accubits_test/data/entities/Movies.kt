package com.machinetest.accubits_test.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class Movies(

    @PrimaryKey
    val id: Int,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int,
   // val backdrop_path: String
)
package com.machinetest.accubits_test.data.repository

import com.machinetest.accubits_test.data.local.MovieDao
import com.machinetest.accubits_test.data.remote.MovieRemoteDataSource
import com.machinetest.accubits_test.utils.performGetOperation
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource,
    private val localDataSource: MovieDao
) {

    fun getMovies() = performGetOperation(
        databaseQuery = { localDataSource.getAllMovies() },
        networkCall = { remoteDataSource.getMovies() },
        saveCallResult = { localDataSource.insertAllMovies(it.results) }
    )
}
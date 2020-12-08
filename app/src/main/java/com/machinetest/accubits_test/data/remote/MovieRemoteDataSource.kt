package com.machinetest.accubits_test.data.remote

import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService
): BaseDataSource() {

    suspend fun getMovies() = getResult {
        movieService.getAllMovies("en-Us","1","IN|US","2|3")
    }
}
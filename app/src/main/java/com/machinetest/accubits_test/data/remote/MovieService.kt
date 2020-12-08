package com.machinetest.accubits_test.data.remote

import com.machinetest.accubits_test.data.entities.MovieResponse
import com.machinetest.accubits_test.data.entities.Movies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("upcoming?api_key=9c0523bff54071c4fb4b716a950231b9")
    suspend fun getAllMovies(@Query("language") lang:String,
                             @Query("page") page:String,
                             @Query("region") region:String,
                             @Query("with_release_type") releaseDate:String) : Response<MovieResponse>

}
package com.machinetest.accubits_test.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.machinetest.accubits_test.data.repository.MovieRepository

class MovieViewModel @ViewModelInject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    val movies = repository.getMovies()
}

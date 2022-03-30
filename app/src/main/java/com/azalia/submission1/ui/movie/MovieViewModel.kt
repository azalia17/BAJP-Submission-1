package com.azalia.submission1.ui.movie

import androidx.lifecycle.ViewModel
import com.azalia.submission1.data.movie.MovieEntity
import com.azalia.submission1.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovies(): List<MovieEntity> = DataDummy.getMovies()
}
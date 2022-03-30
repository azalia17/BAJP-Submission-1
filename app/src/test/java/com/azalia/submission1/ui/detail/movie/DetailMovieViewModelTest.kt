package com.azalia.submission1.ui.detail.movie

import com.azalia.submission1.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.getMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setup() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovies() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.quotes, movieEntity.quotes)
        assertEquals(dummyMovie.ratings, movieEntity.ratings)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.rate, movieEntity.rate)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.status, movieEntity.status)
        assertEquals(dummyMovie.language, movieEntity.language)
        assertEquals(dummyMovie.budget, movieEntity.budget)
        assertEquals(dummyMovie.revenue, movieEntity.revenue)
    }
}
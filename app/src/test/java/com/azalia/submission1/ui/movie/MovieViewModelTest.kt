package com.azalia.submission1.ui.movie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieViewModelTest{
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setup() {
        viewModel = MovieViewModel()
    }

    @Test
    fun testGetMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(18, movieEntities.size)
    }
}
package com.azalia.submission1.ui.detail.tvshow

import com.azalia.submission1.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest{
    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.getTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setup() {
        viewModel = DetailTvShowViewModel()
        viewModel.selectedShow(tvShowId)
    }

    @Test
    fun getTvShows() {
        viewModel.selectedShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.imagePath, tvShowEntity.imagePath)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.quotes, tvShowEntity.quotes)
        assertEquals(dummyTvShow.ratings, tvShowEntity.ratings)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
        assertEquals(dummyTvShow.rate, tvShowEntity.rate)
        assertEquals(dummyTvShow.duration, tvShowEntity.duration)
        assertEquals(dummyTvShow.status, tvShowEntity.status)
        assertEquals(dummyTvShow.network, tvShowEntity.network)
        assertEquals(dummyTvShow.type, tvShowEntity.type)
        assertEquals(dummyTvShow.language, tvShowEntity.language)
    }
}
package com.azalia.submission1.ui.tvshow

import androidx.lifecycle.ViewModel
import com.azalia.submission1.data.tvshow.TvShowEntity
import com.azalia.submission1.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShows(): List<TvShowEntity> = DataDummy.getTvShows()
}
package com.azalia.submission1.ui.detail.tvshow

import androidx.lifecycle.ViewModel
import com.azalia.submission1.data.tvshow.TvShowEntity
import com.azalia.submission1.utils.DataDummy

class DetailTvShowViewModel : ViewModel(){
    private lateinit var tvShowId: String

    fun selectedShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getShow() : TvShowEntity {
        lateinit var tvShow: TvShowEntity
        val tvShowEntities = DataDummy.getTvShows()
        for (tvShowEntity in tvShowEntities) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow
    }
}
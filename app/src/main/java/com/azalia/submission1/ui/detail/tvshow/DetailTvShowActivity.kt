package com.azalia.submission1.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.azalia.submission1.R
import com.azalia.submission1.data.tvshow.TvShowEntity
import com.azalia.submission1.databinding.ActivityDetailTvShowBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailTvShowActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var detailTvShowActivity: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailTvShowActivity = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(detailTvShowActivity.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getString(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.selectedShow(tvShowId)
                populateTvShow(viewModel.getShow() as TvShowEntity)
            }
        }
    }

    private fun populateTvShow(tvShowEntity: TvShowEntity) {
        detailTvShowActivity.tvTitle.text = tvShowEntity.title
        detailTvShowActivity.tvGenre.text = tvShowEntity.genre
        detailTvShowActivity.tvDuration.text = tvShowEntity.duration
        detailTvShowActivity.tvQuotes.text = tvShowEntity.quotes
        detailTvShowActivity.tvOverview.text = tvShowEntity.overview
        detailTvShowActivity.tvRate.text = tvShowEntity.rate
        detailTvShowActivity.tvRating.text = tvShowEntity.ratings
        detailTvShowActivity.tvStatus.text = tvShowEntity.status
        detailTvShowActivity.tvNetwork.text = tvShowEntity.network
        detailTvShowActivity.tvType.text = tvShowEntity.type
        detailTvShowActivity.tvLanguage.text = tvShowEntity.language

        Glide.with(this)
            .load(tvShowEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailTvShowActivity.imagePoster)

        supportActionBar?.title = detailTvShowActivity.tvTitle.text
    }
}
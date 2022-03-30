package com.azalia.submission1.ui.detail.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.azalia.submission1.R
import com.azalia.submission1.data.movie.MovieEntity
import com.azalia.submission1.databinding.ActivityDetailMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var detailMovieActivityBinding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailMovieActivityBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(detailMovieActivityBinding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie() as MovieEntity)
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailMovieActivityBinding.tvTitle.text = movieEntity.title
        detailMovieActivityBinding.tvDate.text = movieEntity.release
        detailMovieActivityBinding.tvGenre.text = movieEntity.genre
        detailMovieActivityBinding.tvDuration.text = movieEntity.duration
        detailMovieActivityBinding.tvQuotes.text = movieEntity.quotes
        detailMovieActivityBinding.tvRate.text = movieEntity.rate
        detailMovieActivityBinding.tvRating.text = movieEntity.ratings
        detailMovieActivityBinding.tvOverview.text = movieEntity.overview
        detailMovieActivityBinding.tvStatus.text = movieEntity.status
        detailMovieActivityBinding.tvBudget.text = movieEntity.budget
        detailMovieActivityBinding.tvLanguage.text = movieEntity.language
        detailMovieActivityBinding.tvRevenue.text = movieEntity.revenue

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(detailMovieActivityBinding.imagePoster)

        supportActionBar?.title = detailMovieActivityBinding.tvTitle.text
    }
}
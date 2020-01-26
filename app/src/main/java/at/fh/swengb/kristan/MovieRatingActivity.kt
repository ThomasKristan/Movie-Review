package at.fh.swengb.kristan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rating.*


class MovieRatingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val movieId = intent.getStringExtra(MovieDetailActivity.EXTRA_MOVIE_ID_DETAILS)
        if (movieId == null){
            finish()
        } else {
            MovieRepository.movieById(movieId,
                success = { movie_rating_header.text = it.title},
                error = { Log.e("API_CALL", it)})

            rate_movie.setOnClickListener {
                Toast.makeText(this, getString(R.string.rating_saved), Toast.LENGTH_SHORT).show()
                val newReview = Review(
                    movie_rating_bar.rating.toDouble(),
                    movie_feedback.text.toString()
                )

                MovieRepository.rateMovie( movieId, newReview,
                    success = {
                        setResult(Activity.RESULT_OK)
                        finish()},
                    error = {
                        Log.e("API_CALL", it)})

            /*val newRating = Review(movie_rating_bar.rating.toDouble(), movie_feedback.text.toString())
                MovieRepository.rateMovie(movieId, newRating)*/

            }
        }
    }
}

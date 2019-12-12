package at.fh.swengb.kristan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movie_rating.*


class MovieRatingActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val movieId = intent.getStringExtra(MovieDetailsActivity.EXTRA_DETAILS_ID)
        if (movieId == null){
            finish()
        } else {
            movie_rating_header.text = MovieRepository.movieById(movieId)?.title

            rate_movie.setOnClickListener {
                Toast.makeText(this, "Rating saved!", Toast.LENGTH_SHORT).show()
                val newRating = Review(movie_rating_bar.rating.toDouble(), movie_feedback.text.toString())
                MovieRepository.rateMovie(movieId, newRating)
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}

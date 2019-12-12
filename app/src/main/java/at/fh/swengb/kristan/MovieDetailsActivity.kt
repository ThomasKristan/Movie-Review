package at.fh.swengb.kristan


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.fh.swengb.kristan.MainActivity.Companion.EXTRA_MOVIE_ID
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    companion object {
        val EXTRA_DETAILS_ID = "DETAILS_ID_EXTRA"
        val REQUEST_REVIEW = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REVIEW && resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)
        if (movieId == null) {
            finish()
        } else {
            movie_details_director.text = MovieRepository.movieById(movieId.toString())?.director?.name
            movie_details_plot.text = MovieRepository.movieById(movieId.toString())?.plot
            movie_details_header.text = MovieRepository.movieById(movieId.toString())?.title
            movie_details_genre.text = MovieRepository.movieById(movieId.toString())?.genre?.description
            movie_details_release.text = MovieRepository.movieById(movieId.toString())?.release
            movie_details_actor.text = MovieRepository.movieById(movieId.toString())?.actors?.joinToString { it.name }

            var average = 0.0
            if (MovieRepository.movieById(movieId.toString())?.reviews!!.isNotEmpty()) {
                average = MovieRepository.movieById(movieId.toString())!!.reviewAverage()
            }
            movie_details_rating_bar.rating = average.toFloat()
            movie_details_avg_rating_value.text = average.toString()
            var ratingCount = MovieRepository.movieById(movieId.toString())?.reviews?.count().toString()
            movie_details_rating_count.text = " ($ratingCount)"

            open_rating.setOnClickListener {
                val intent = Intent(this, MovieRatingActivity::class.java)
                intent.putExtra(EXTRA_DETAILS_ID, movieId)
                startActivityForResult(intent, REQUEST_REVIEW)
            }
        }
    }
}

package at.fh.swengb.kristan


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import at.fh.swengb.kristan.MainActivity.Companion.EXTRA_MOVIE_ID
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailActivity : AppCompatActivity() {
    companion object {
        val EXTRA_MOVIE_ID_DETAILS = "DETAILS_ID_EXTRA"
        val REQUEST_REVIEW = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REVIEW && resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieId = intent.getStringExtra(MainActivity.EXTRA_MOVIE_ID)
        if (movieId == null) {
            finish()
        } else {
            outputMovieDetails(movieId)
            //TODO Open next Activity
            open_rating.setOnClickListener {
                val intent = Intent(this, MovieRatingActivity::class.java)

                intent.putExtra(EXTRA_MOVIE_ID_DETAILS, movieId)
                startActivityForResult(intent, REQUEST_REVIEW)
            }
        }
    }

    private fun outputMovieDetails(id: String){
        MovieRepository.movieById(id,
            success = { val movie = it
                if(movie == null){
                    finish()
                } else {
                    movie_details_director.text = movie.director.name
                    movie_details_plot.text = movie.plot
                    movie_details_title.text = movie.title
                    movie_details_genre.text = movie.genres.joinToString { it }
                    movie_details_release.text = movie.release
                    movie_details_actor.text = movie.actors.joinToString { it.name }
                    movie_details_rating_bar.rating = movie.reviewAverage().toFloat()
                    movie_details_avg_rating_value.text = movie.reviewAverage().toString()
                    val count = movie.reviews.count().toString()
                    movie_details_rating_count.text = " ($count)"

                    Glide
                        .with(movie_details_image_poster)
                        .load(movie.posterImagePath)
                        .into(movie_details_image_poster)

                    Glide
                        .with(movie_details_image_backdrop)
                        .load(movie.backdropImagePath)
                        .into(movie_details_image_backdrop)
                }
            },
            error = { Log.e("API_CALL", it)})
    }
}

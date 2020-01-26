package at.fh.swengb.kristan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
    }

    val movieAdapter = MovieAdapter() {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(EXTRA_MOVIE_ID, it.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //movieAdapter.updateList(MovieRepository.movieList())
        //movie_recycler_view.layoutManager = LinearLayoutManager(this)
        movie_recycler_view.layoutManager = GridLayoutManager(this, 3)
        movie_recycler_view.setHasFixedSize(true)
        movie_recycler_view.adapter = movieAdapter
        MovieRepository.movieList(
            success = {
                //success
                movieAdapter.updateList(it)
            },
            error = {
                //error
                Log.e("API_CALL", it)
            }
        )
    }
}
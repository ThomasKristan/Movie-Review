package at.fh.swengb.kristan

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val REQUEST_DETAILS = 1
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_DETAILS && resultCode == Activity.RESULT_OK){
            movieAdapter.updateList(MovieRepository.moviesList())
        }
    }
    val movieAdapter = MovieAdapter() {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(EXTRA_MOVIE_ID, it.id)
        startActivityForResult(intent, REQUEST_DETAILS)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieAdapter.updateList(MovieRepository.moviesList())
        movie_recycler_view.layoutManager = LinearLayoutManager(this)
        movie_recycler_view.adapter = movieAdapter
    }
}
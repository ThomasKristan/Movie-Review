package at.fh.swengb.kristan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_movie_details.view.*
import kotlinx.android.synthetic.main.item_main.view.*

class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {
    private var movieList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_main, parent, false)
        return MovieViewHolder(movieItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bindItem(movie)
    }

    open fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }
}
class MovieViewHolder(itemView: View, val clickListener: (movie: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_main_name.text = movie.title
        itemView.item_main_actor.text = movie.actors[0].name
        itemView.item_main_director.text = movie.director.name
        itemView.item_main_year.text = movie.release.drop(6)
        var average = 0.0
        if (movie.reviews.isNotEmpty()) {
            average = movie.reviewAverage()
        }
        itemView.item_main_avg_rating_bar.rating = average.toFloat()
        itemView.item_main_avg_rating_value.text = average.toString()
        var movieCount = (movie.reviews.count().toString())
        itemView.item_main_rating_count.text = " ($movieCount)"


        itemView.setOnClickListener {
            clickListener(movie)
        }
    }
}

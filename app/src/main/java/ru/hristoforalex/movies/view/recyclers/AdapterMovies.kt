package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Movie

class AdapterMovies(
        private val movies: List<Movie>,
        private val clickListener: OnMovieItemClicked?
) : RecyclerView.Adapter<ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        val holder = ViewHolderMovie(view)
        view.setOnClickListener {
            clickListener?.openDetailFragments(movies[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemCount(): Int = movies.size

    private fun getItem(position: Int) = movies[position]
}

class ViewHolderMovie(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    private val poster = viewItem.findViewById<ImageView>(R.id.iv_poster)
    private val minimumAge = viewItem.findViewById<TextView>(R.id.tv_age)
    private val title = viewItem.findViewById<TextView>(R.id.tv_title)
    private val runtime = viewItem.findViewById<TextView>(R.id.tv_runtime)
    private val genres = viewItem.findViewById<TextView>(R.id.tv_genre)
    private val rating = viewItem.findViewById<RatingBar>(R.id.ratingBar)
    private val reviewsCount = viewItem.findViewById<TextView>(R.id.tv_countOfReview)
    private val cornerRadius = 60.0f

    fun onBind(movie: Movie) {
        Glide.with(itemView.context)
                .load(movie.poster)
                .transform(
                    GranularRoundedCorners(
                        cornerRadius, cornerRadius, 0f, 0f))
                .into(poster)

        minimumAge.text = movie.minimumAge.toString() + "+"
        title.text = movie.title
        runtime.text = movie.runtime.toString()
        genres.text = movie.genres.joinToString(", ") { genre -> genre.name }
        reviewsCount.text = movie.numberOfRatings.toString()
        rating.rating = movie.ratings
        runtime.text = movie.runtime.toString() + " min"
    }

}

interface OnMovieItemClicked {
    fun openDetailFragments(movie: Movie)
}



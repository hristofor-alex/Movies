package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.hristoforalex.movies.OnMovieItemClicked
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.model.Movie

class AdapterMovies(
    private val movies: List<Movie>,
    private val clickListener: OnMovieItemClicked?
) : RecyclerView.Adapter<ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_movie, parent, false)
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



package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Movie

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

class ViewHolderMovie(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
    private val poster = viewItem.findViewById<ImageView>(R.id.iv_image)
    private val minimumAge = viewItem.findViewById<TextView>(R.id.tv_age)
    private val title = viewItem.findViewById<TextView>(R.id.tv_movieName)
    private val runtime = viewItem.findViewById<TextView>(R.id.tv_time)
    private val genres = viewItem.findViewById<TextView>(R.id.tv_category)
    private val starOne = viewItem.findViewById<ImageView>(R.id.star_one)
    private val starTwo = viewItem.findViewById<ImageView>(R.id.star_two)
    private val starThree = viewItem.findViewById<ImageView>(R.id.star_three)
    private val starFour = viewItem.findViewById<ImageView>(R.id.star_four)
    private val starFive = viewItem.findViewById<ImageView>(R.id.star_five)
    private val reviewsCount = viewItem.findViewById<TextView>(R.id.tv_countOfReview)

    fun onBind(movie: Movie) {
        Glide.with(itemView.context)
            .load(movie.poster)
            .into(poster)
        minimumAge.text = movie.minimumAge.toString()
        title.text = movie.title
        runtime.setText(movie.runtime)
        genres.text = movie.genres.joinToString(", ") { genre -> genre.name }
        reviewsCount.setText(movie.numberOfRatings)

//        when (movie.stars) {
//            1 -> {
//                starOne.setImageResource(R.drawable.fill_star_mini)
//                starTwo.setImageResource(R.drawable.empty_star)
//                starThree.setImageResource(R.drawable.empty_star)
//                starFour.setImageResource(R.drawable.empty_star)
//                starFive.setImageResource(R.drawable.empty_star)
//            }
//            2 -> {
//                starOne.setImageResource(R.drawable.fill_star_mini)
//                starTwo.setImageResource(R.drawable.fill_star_mini)
//                starThree.setImageResource(R.drawable.empty_star_mini)
//                starFour.setImageResource(R.drawable.empty_star_mini)
//                starFive.setImageResource(R.drawable.empty_star_mini)
//            }
//            3 -> {
//                starOne.setImageResource(R.drawable.fill_star_mini)
//                starTwo.setImageResource(R.drawable.fill_star_mini)
//                starThree.setImageResource(R.drawable.fill_star_mini)
//                starFour.setImageResource(R.drawable.empty_star_mini)
//                starFive.setImageResource(R.drawable.empty_star_mini)
//            }
//            4 -> {
//                starOne.setImageResource(R.drawable.fill_star_mini)
//                starTwo.setImageResource(R.drawable.fill_star_mini)
//                starThree.setImageResource(R.drawable.fill_star_mini)
//                starFour.setImageResource(R.drawable.fill_star_mini)
//                starFive.setImageResource(R.drawable.empty_star_mini)
//            }
//            5 -> {
//                starOne.setImageResource(R.drawable.fill_star_mini)
//                starTwo.setImageResource(R.drawable.fill_star_mini)
//                starThree.setImageResource(R.drawable.fill_star_mini)
//                starFour.setImageResource(R.drawable.fill_star_mini)
//                starFive.setImageResource(R.drawable.fill_star_mini)
//            }
//        }


    }

}

interface OnMovieItemClicked {
    fun openDetailFragments(movie: Movie)
}



package ru.hristoforalex.movies.view.movieDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Actor
import ru.hristoforalex.movies.data.Movie
import ru.hristoforalex.movies.view.FragmentBackListener
import ru.hristoforalex.movies.view.recyclers.AdapterActors

class FragmentMovieDetails : Fragment() {
    private var clickListener: FragmentBackListener? = null
    private lateinit var actorRecycler: RecyclerView
    private lateinit var movie: Movie
    private lateinit var actors: List<Actor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movie = arguments?.getParcelable("movie") ?: throw NullPointerException()
        actors = movie.actors
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movies_details, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton = view.findViewById<Button>(R.id.b_back)
        val backdrop = view.findViewById<ImageView>(R.id.iv_poster)
        val minimumAge = view.findViewById<TextView>(R.id.tv_age)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val genres = view.findViewById<TextView>(R.id.tv_genre)
        val rating = view.findViewById<RatingBar>(R.id.ratingBar)
        val reviews = view.findViewById<TextView>(R.id.tv_countOfReview)
        val overview = view.findViewById<TextView>(R.id.tv_overview)

        Glide.with(view.context)
                .load(movie.backdrop)
                .transform(CenterCrop())
                //   .load(R.drawable.ic_main_gradient)
                .into(backdrop)
        minimumAge.text = movie.minimumAge.toString() + "+"
        title.text = movie.title
        genres.text = movie.genres.joinToString(", ") { genre -> genre.name }
        rating.rating = movie.ratings / 2
        reviews.text = movie.numberOfRatings.toString()
        overview.text = movie.overview


        actorRecycler = view.findViewById(R.id.rv_actor_list)
        actorRecycler?.adapter = AdapterActors(actors)
        actorRecycler?.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        actorRecycler?.setHasFixedSize(true)

        backButton.setOnClickListener {
            clickListener?.back()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBackListener) clickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    companion object {
        fun newInstance(movie: Movie): FragmentMovieDetails {
            val args = Bundle()
            args.putParcelable("movie", movie)
            val fragment = FragmentMovieDetails()
            fragment.arguments = args
            return fragment
        }
    }
}
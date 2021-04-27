package ru.hristoforalex.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Actor
import ru.hristoforalex.movies.data.Movie
import ru.hristoforalex.movies.view.recyclers.AdapterActors

class FragmentMovieDetails : Fragment() {

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
        val poster = view.findViewById<ImageView>(R.id.iv_poster)
        val minimumAge = view.findViewById<TextView>(R.id.tv_age)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val genre = view.findViewById<TextView>(R.id.tv_genre)
        val ratingBar = view.findViewById<TextView>(R.id.ratingBar)
        val reviews = view.findViewById<TextView>(R.id.tv_countOfReview)
        val overview = view.findViewById<TextView>(R.id.tv_overview)


        actorRecycler = view.findViewById(R.id.rv_actor_list)
        actorRecycler?.adapter = AdapterActors(actors)
        actorRecycler?.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        actorRecycler?.setHasFixedSize(true)
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
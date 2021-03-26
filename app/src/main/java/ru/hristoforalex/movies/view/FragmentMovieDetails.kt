package ru.hristoforalex.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.hristoforalex.movies.OnMovieItemClicked
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.DataSource
import ru.hristoforalex.movies.model.Movie
import ru.hristoforalex.movies.view.recyclers.AdapterActors

class FragmentMovieDetails : Fragment() {

    private var actorRecycler: RecyclerView? = null
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movie = arguments?.getParcelable("movie")
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

        actorRecycler = view.findViewById(R.id.rv_actor_list)
        actorRecycler?.adapter = AdapterActors(DataSource.actors)
        actorRecycler?.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        actorRecycler?.setHasFixedSize(true)

        // для панятия как делать передачу данных по клику  
        val image = view.findViewById<ImageView>(R.id.iv_image)
        movie?.let { image.setImageResource(it.image) }

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
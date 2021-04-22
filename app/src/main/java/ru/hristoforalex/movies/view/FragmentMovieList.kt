package ru.hristoforalex.movies.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Movie
import ru.hristoforalex.movies.data.loadMovies
import ru.hristoforalex.movies.view.recyclers.AdapterMovies
import ru.hristoforalex.movies.view.recyclers.OnMovieItemClicked

class FragmentMovieList : Fragment() {

    private lateinit var movieRecycler: RecyclerView
    private var clickListener: OnMovieItemClicked? = null
    private lateinit var movies: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            movies = loadMovies(requireContext())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieRecycler = view.findViewById(R.id.rv_movie_list)
        movieRecycler?.adapter = AdapterMovies(movies, object : OnMovieItemClicked {
            override fun openDetailFragments(movie: Movie) {
                requireFragmentManager().beginTransaction().apply {
                    replace(R.id.container, FragmentMovieDetails.newInstance(movie))
                        .addToBackStack(null)
                        .commit()
                }
            }
        })

        movieRecycler?.layoutManager = GridLayoutManager(requireContext(), 2)
        movieRecycler?.setHasFixedSize(true)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieItemClicked) clickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }

    companion object {
        fun newInstance() = FragmentMovieList()
    }
}
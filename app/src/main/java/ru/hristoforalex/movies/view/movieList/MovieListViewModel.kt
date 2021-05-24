package ru.hristoforalex.movies.view.movieList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.hristoforalex.movies.data.Movie

class MovieListViewModel : ViewModel() {

    private lateinit var _mutableMovies: MutableLiveData<List<Movie>>
    val movie: LiveData<List<Movie>> = _mutableMovies

//    init {
//        _mutableMovies = loadData()
//
//    }
//
//    fun loadData(): MutableLiveData<List<Movie>> {
//        //    viewModelScope.launch { loadMovies() }
//        return
//    }
}
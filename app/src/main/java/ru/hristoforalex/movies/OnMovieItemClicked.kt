package ru.hristoforalex.movies

import ru.hristoforalex.movies.model.Movie

interface OnMovieItemClicked {
    fun openDetailFragments(movie: Movie)
}
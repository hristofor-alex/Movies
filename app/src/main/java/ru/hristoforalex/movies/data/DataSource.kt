package ru.hristoforalex.movies.data

import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.model.Actor
import ru.hristoforalex.movies.model.Movie

object DataSource {
    val actors = listOf(
        Actor(
            R.drawable.robert,
            R.string.robert_downey_jr
        ),
        Actor(
            R.drawable.evans,
            R.string.chris_evans
        ),
        Actor(
            R.drawable.ruffalo,
            R.string.mark_ruffalo
        ),
        Actor(
            R.drawable.hewmsworth,
            R.string.chris_hemsworth
        ),
        Actor(
            R.drawable.robert,
            R.string.robert_downey_jr
        ),
        Actor(
            R.drawable.evans,
            R.string.chris_evans
        ),
        Actor(
            R.drawable.ruffalo,
            R.string.mark_ruffalo
        ),
        Actor(
            R.drawable.hewmsworth,
            R.string.chris_hemsworth
        )
    )
    val movies = listOf(
        Movie(
            R.drawable.avengers_end_game,
            false,
            13,
            4,
            category = "Action, Adventure, Drama",
            reviews = "125 Reviews",
            name = "Avengers: End Game",
            time = "137 min"
        ),
        Movie(
            R.drawable.tenet,
            true,
            16,
            5,
            category = "Action, Sci-Fi, Thriller ",
            reviews = "98 Reviews",
            name = "Tenet",
            time = "97 min"
        ),
        Movie(
            R.drawable.black_widow,
            false,
            13,
            4,
            category = "Action, Adventure, Sci-Fi",
            reviews = "38 Reviews",
            name = "Black Widow",
            time = "102 min"
        ),
        Movie(
            R.drawable.wonder_women,
            false,
            16,
            5,
            category = "Action, Adventure, Fantasy",
            reviews = "74 Reviews",
            name = "Wonder Woman 1984",
            time = "120 min"
        ),

        Movie(
            R.drawable.avengers_end_game,
            false,
            13,
            4,
            category = "Action, Adventure, Drama",
            reviews = "125 Reviews",
            name = "Avengers: End Game",
            time = "137 min"
        ),
        Movie(
            R.drawable.tenet,
            true,
            16,
            5,
            category = "Action, Sci-Fi, Thriller ",
            reviews = "98 Reviews",
            name = "Tenet",
            time = "97 min"
        ),
        Movie(
            R.drawable.black_widow,
            false,
            13,
            4,
            category = "Action, Adventure, Sci-Fi",
            reviews = "38 Reviews",
            name = "Black Widow",
            time = "102 min"
        ),
        Movie(
            R.drawable.wonder_women,
            false,
            16,
            5,
            category = "Action, Adventure, Fantasy",
            reviews = "74 Reviews",
            name = "Wonder Woman 1984",
            time = "120 min"
        )
    )
}
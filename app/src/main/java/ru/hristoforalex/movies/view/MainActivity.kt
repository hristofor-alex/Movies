package ru.hristoforalex.movies.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.hristoforalex.movies.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                add(R.id.container, FragmentMovieList())
                    .commit()
            }
        }
    }
}

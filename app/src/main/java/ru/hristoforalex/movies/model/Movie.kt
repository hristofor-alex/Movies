package ru.hristoforalex.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    val image: Int,
    val like: Boolean,
    val age: String,
    val stars : Int,
    val category: String,
    val reviews: String,
    val name: String,
    val time: String
) : Parcelable
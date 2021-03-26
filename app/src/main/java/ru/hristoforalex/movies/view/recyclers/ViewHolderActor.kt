package ru.hristoforalex.movies.view.recyclers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.model.Actor

class ViewHolderActor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val actorIcon = itemView.findViewById<ImageView>(R.id.iv_actor_icon)
    val actorName = itemView.findViewById<TextView>(R.id.tv_actor_name)

    fun onBind(data: Actor) {
        actorIcon.setImageResource(data.icon)
        actorName.setText(data.name)
    }
}
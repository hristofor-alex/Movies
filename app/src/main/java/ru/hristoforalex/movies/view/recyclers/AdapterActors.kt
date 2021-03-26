package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.model.Actor

class AdapterActors(
    private val actors: List<Actor>
) : RecyclerView.Adapter<ViewHolderActor>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderActor {
        return ViewHolderActor(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_actor, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderActor, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    private fun getItem(position: Int): Actor = actors[position]
}
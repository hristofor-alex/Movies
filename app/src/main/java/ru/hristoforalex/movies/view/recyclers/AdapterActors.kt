package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

class ViewHolderActor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val actorIcon = itemView.findViewById<ImageView>(R.id.iv_actor_icon)
    val actorName = itemView.findViewById<TextView>(R.id.tv_actor_name)

    fun onBind(data: Actor) {
        actorIcon.setImageResource(data.icon)
        actorName.setText(data.name)
    }
}
package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Actor

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
    val picture = itemView.findViewById<ImageView>(R.id.iv_actor_icon)
    val name = itemView.findViewById<TextView>(R.id.tv_actor_name)

    fun onBind(data: Actor) {
        Glide.with(itemView.context)
            .load(data.picture)
            .into(picture)
        name.text = data.name
    }
}
package ru.hristoforalex.movies.view.recyclers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import ru.hristoforalex.movies.R
import ru.hristoforalex.movies.data.Actor

class AdapterActors(
        private val actors: List<Actor>
) : RecyclerView.Adapter<ViewHolderActor>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderActor {
        return when (viewType) {
            VIEW_TYPE_ACTORS ->
                ViewHolderActorData(LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_actor, parent, false))

            else -> ViewHolderActorEmpty(LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_actor_empty, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (actors.size) {
            0 -> VIEW_TYPE_EMPTY
            else -> VIEW_TYPE_ACTORS
        }
    }

    override fun onBindViewHolder(holder: ViewHolderActor, position: Int) {
        when (holder) {
            is ViewHolderActorData -> {
                holder.onBind(getItem(position))
            }
            is ViewHolderActorEmpty -> {
                {/* nothing to bind */ }
            }
        }

    }

    // пока не написал эту логику не работала подмена layout -ов
    // не могу понять как оно работает и где использует еденицу
    override fun getItemCount(): Int = when (actors.size) {
        0 -> 1
        else -> actors.size
    }

    private fun getItem(position: Int): Actor = actors[position]
}

abstract class ViewHolderActor(itemView: View) : RecyclerView.ViewHolder(itemView)

class ViewHolderActorEmpty(itemView: View) : ViewHolderActor(itemView)

class ViewHolderActorData(itemView: View) : ViewHolderActor(itemView) {
    val picture = itemView.findViewById<ImageView>(R.id.iv_actor_icon)
    val name = itemView.findViewById<TextView>(R.id.tv_actor_name)

    fun onBind(data: Actor) {

        val cornerRadius = 30
        val imageOption = RequestOptions()
                .transform(
                        CenterCrop(),
                        RoundedCorners(cornerRadius)
                )

        Glide.with(itemView.context)
                .load(data.picture)
                .apply(imageOption)
                .into(picture)

        name.text = data.name
    }
}


private const val VIEW_TYPE_EMPTY = 0
private const val VIEW_TYPE_ACTORS = 1

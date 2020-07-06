package com.prasan.applegames.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.prasan.applegames.R
import com.prasan.applegames.model.GameResponse
import com.prasan.applegames.ui.detail.GameDetailActivity

class GameAdapter(private val layoutManager: StaggeredGridLayoutManager? = null) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {


    private var entries: List<GameResponse.Entry> = ArrayList()

    enum class ViewType {
        SMALL,
        DETAILED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            ViewType.DETAILED.ordinal -> DetailedViewHolder(parent)
            else ->SimpleViewHolder(parent)
        }
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(layoutManager?.spanCount == 1 ) ViewType.DETAILED.ordinal
        else ViewType.SMALL.ordinal
    }

    fun setEntries(entries:List<GameResponse.Entry>){
        this.entries = entries
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(entries[position])
        holder.itemView.setOnClickListener{
            val context: Context = it!!.context
            val intent = Intent(context, GameDetailActivity::class.java)
            val game:GameResponse.Entry = entries[position]
            intent.putExtra("gameInfo",game)
            context.startActivity(intent)
        }
    }

     open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(game: GameResponse.Entry) {
            val entryImage = itemView.findViewById(R.id.game_image) as ImageView
            val gameName = itemView.findViewById(R.id.game_name) as TextView
            val gameArtist = itemView.findViewById(R.id.game_artist) as TextView
            val imageUrl = game.image[0].label
            Glide.with(itemView)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(entryImage)
            gameName.text = game.name.label
            gameArtist.text = game.artist.label
        }
    }
}
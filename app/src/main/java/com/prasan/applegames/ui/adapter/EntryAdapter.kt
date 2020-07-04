package com.prasan.applegames.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prasan.applegames.R
import com.prasan.applegames.model.Entry

class EntryAdapter : RecyclerView.Adapter<EntryAdapter.ViewHolder>() {

    private var entries: List<Entry> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.entry_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    fun setEntries(entries:List<Entry>){
        this.entries = entries
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(entries[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(entry: Entry) {
            val entryImage = itemView.findViewById(R.id.game_image) as ImageView
            val entryName = itemView.findViewById(R.id.game_name) as TextView
            val entryPrice = itemView.findViewById(R.id.game_price) as TextView
            val url = entry.image[adapterPosition].label
            Glide.with(itemView).load(url).into(entryImage)

        }
    }
}
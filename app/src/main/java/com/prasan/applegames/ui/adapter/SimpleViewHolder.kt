package com.prasan.applegames.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prasan.applegames.R

class SimpleViewHolder(itemView: View) : GameAdapter.ViewHolder(itemView) {

    constructor(parent: ViewGroup)
            : this(LayoutInflater.from(parent.context).inflate(R.layout.entry_item_grid, parent, false))
}
package com.example.mylistcats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mylistcats.model.Cat
import kotlin.properties.Delegates

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>(), Filterable {
    var item: List<Cat> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var catitem: List<Cat> by Delegates.observable(emptyList()) { _, old, new -> if (old != new) notifyDataSetChanged() }
    var filterItem = ArrayList<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        return CatsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cats, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val cat = item[position]
        holder.bind(cat)

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

}

class CatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Cat) {

        val text = itemView.findViewById<TextView>(R.id.textView)
        text.text = item.name
    }

}

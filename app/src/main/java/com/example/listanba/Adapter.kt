package com.example.listanba

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (val context: Context) : ListAdapter<Nba, Adapter.ViewHolder>(DiffCallBack){

    lateinit var onItemClickListener: (Nba) -> Unit
    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreElem: TextView = view.findViewById(R.id.item_name)
        val logoElem: ImageView = view.findViewById(R.id.item_logo)
        val staduimElem: TextView = view.findViewById(R.id.item_stadium)
        val titlesElem: TextView = view.findViewById(R.id.item_titles)
        val conferenceElem: ImageView = view.findViewById(R.id.item_conf)


        fun bind (equipo: Nba) {
            nombreElem.text=equipo.name
            staduimElem.text=equipo.stadiumName.toString()
            titlesElem.text=equipo.titles.toString()

            Glide.with(context).load(equipo.logo).into(logoElem)

            val imageConf = when(equipo.conferencia){
                Conferencias.ESTE -> R.drawable.este
                else -> R.drawable.oeste
            }
            conferenceElem.setImageResource(imageConf)

            view.setOnClickListener() {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Nba>() {
        override fun areItemsTheSame(oldItem: Nba, newItem: Nba): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Nba, newItem: Nba): Boolean {
            return oldItem == newItem
        }
    }
}
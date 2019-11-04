package com.limpatprananda.plugin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.limpatprananda.plugin.recyclerview.databinding.ListItemBinding


class ListAdapter(private val list: List<Movie>) :
    RecyclerView.Adapter<ListAdapter.MovieViewHolder>(){

    private lateinit var parentContext: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        parentContext = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val view = ListItemBinding.inflate(inflater)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ListAdapter.MovieViewHolder, position: Int) {
        holder.bind(list.get(position))
        holder.itemView.setOnClickListener {
            list.get(position).showToast(parentContext)
        }
    }

    inner class MovieViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.movie = movie
            binding.executePendingBindings()
        }
    }
}

data class Movie(
    val title: String,
    val year: Int
){
    fun showToast(context: Context){
        Toast.makeText(context, "Clicked : " + title, Toast.LENGTH_SHORT).show()
    }
}
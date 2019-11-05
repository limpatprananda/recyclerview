package com.limpatprananda.plugin.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.limpatprananda.plugin.recyclerview.databinding.ListItemBinding

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Movie>?){
    val adapter = recyclerView.adapter as ListMovieAdapter
    adapter.submitList(data)
}

class ListMovieAdapter() : ListAdapter<Movie, ListMovieAdapter.MovieViewHolder>(DiffCallback)
{
    companion object DiffCallback : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ListItemBinding.inflate(inflater)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(movie: Movie){
            binding.movie = movie
            binding.executePendingBindings()
        }
    }
}


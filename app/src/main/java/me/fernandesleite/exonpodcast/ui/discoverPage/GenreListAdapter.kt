package me.fernandesleite.exonpodcast.ui.discoverPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.fernandesleite.exonpodcast.databinding.ItemListPodcastGenreBinding

class GenreListAdapter: ListAdapter<Genre, GenreListAdapter.GenreViewHolder>(DiffCallback) {
    class GenreViewHolder(private val binding: ItemListPodcastGenreBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(genres: Genre){
            binding.genre = genres
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(ItemListPodcastGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = getItem(position)
        holder.bind(genre)
    }
}
package me.fernandesleite.exonpodcast.ui.discoverPage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.fernandesleite.exonpodcast.databinding.ItemListDiscoverPodcastBinding
import me.fernandesleite.exonpodcast.network.models.ITunesRSS

class DiscoverListAdapter : ListAdapter<ITunesRSS.Feed.ResultsRSS, DiscoverListAdapter.PodcastViewHolder>(DiffCallback){
    class PodcastViewHolder(private val binding: ItemListDiscoverPodcastBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(results: ITunesRSS.Feed.ResultsRSS) {
            binding.podcast = results
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ITunesRSS.Feed.ResultsRSS>() {
        override fun areItemsTheSame(
            oldItem: ITunesRSS.Feed.ResultsRSS,
            newItem: ITunesRSS.Feed.ResultsRSS
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: ITunesRSS.Feed.ResultsRSS,
            newItem: ITunesRSS.Feed.ResultsRSS
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        return PodcastViewHolder(ItemListDiscoverPodcastBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        val podcast = getItem(position)
        holder.bind(podcast)
    }

}
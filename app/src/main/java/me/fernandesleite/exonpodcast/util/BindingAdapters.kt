package me.fernandesleite.exonpodcast.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import me.fernandesleite.exonpodcast.network.models.ITunesRSS
import me.fernandesleite.exonpodcast.network.models.ITunesSearch
import me.fernandesleite.exonpodcast.ui.discoverPage.DiscoverListAdapter



@BindingAdapter("list_podcasts")
fun bindTopPodcasts(recyclerView: RecyclerView, data: List<ITunesRSS.Feed.ResultsRSS>?){
    val adapter = recyclerView.adapter as DiscoverListAdapter
    adapter.submitList(data)
}

@BindingAdapter("artwork")
fun bindPodcastArtwork(imageView: ImageView, artworkUrl: String) {
    Glide.with(imageView.context).load(artworkUrl).into(imageView)
}

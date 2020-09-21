package me.fernandesleite.exonpodcast.discoverPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.fernandesleite.exonpodcast.repository.PodcastRepository

class DiscoverPageViewModelFactory(private val podcastRepository: PodcastRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiscoverPageViewModel::class.java)) {
            return DiscoverPageViewModel(
                podcastRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
package me.fernandesleite.exonpodcast.ui.discoverPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.fernandesleite.exonpodcast.network.models.ITunesRSS
import me.fernandesleite.exonpodcast.network.models.ITunesSearch
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject

class DiscoverPageViewModel @Inject constructor(val podcastRepository: PodcastRepository) :
    ViewModel() {

    private val _searchResults = MutableLiveData<List<ITunesSearch.Results>>()
    val ITunesSearch: LiveData<List<ITunesSearch.Results>>
        get() = _searchResults

    private val _topPodcasts = MutableLiveData<List<ITunesRSS.Feed.ResultsRSS>>()
    val topPodcasts: LiveData<List<ITunesRSS.Feed.ResultsRSS>>
        get() = _topPodcasts

    fun searchPodcast() {
        viewModelScope.launch {
            _searchResults.value = podcastRepository.getSearch()
        }
    }

    fun showTopPodcasts() {
        viewModelScope.launch {
            _topPodcasts.value = podcastRepository.getTopPodcasts()
        }
    }
}
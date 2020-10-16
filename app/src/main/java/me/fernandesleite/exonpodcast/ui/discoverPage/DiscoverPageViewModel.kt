package me.fernandesleite.exonpodcast.ui.discoverPage

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import me.fernandesleite.exonpodcast.network.models.ITunesRSS
import me.fernandesleite.exonpodcast.network.models.ITunesSearch
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import java.util.*
import javax.inject.Inject

class DiscoverPageViewModel @Inject constructor(val podcastRepository: PodcastRepository, application: Application) :
    AndroidViewModel(application) {

    private val _searchResults = MutableLiveData<List<ITunesSearch.Results>>()
    val searchResults: LiveData<List<ITunesSearch.Results>>
        get() = _searchResults

    private val _topPodcasts = MutableLiveData<List<ITunesRSS.Feed.ResultsRSS>>()
    val topPodcasts: LiveData<List<ITunesRSS.Feed.ResultsRSS>>
        get() = _topPodcasts

    private val _genres = MutableLiveData<List<Genre>>()
    val genres: LiveData<List<Genre>>
        get() = _genres

    init {
        getGenres()
    }

    fun searchPodcast(query: String) {
        viewModelScope.launch {
            _searchResults.value = podcastRepository.getSearch(query)
        }
    }

    fun showTopPodcasts() {
        viewModelScope.launch {
            _topPodcasts.value = podcastRepository.getTopPodcasts(Locale.getDefault().country)
        }
    }

    private fun getGenres() {
        viewModelScope.launch {
            _genres.value = podcastRepository.getGenres()
        }
    }
}
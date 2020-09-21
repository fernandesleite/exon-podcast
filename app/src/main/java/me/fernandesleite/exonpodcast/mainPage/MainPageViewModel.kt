package me.fernandesleite.exonpodcast.mainPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject

class MainPageViewModel @Inject constructor(val podcastRepository: PodcastRepository) :
    ViewModel() {

    private val _page = MutableLiveData<Int>()
    val page: LiveData<Int>
        get() = _page

    fun searchPodcast() {
        viewModelScope.launch {
            _page.value = podcastRepository.getSearch()
        }
    }
}
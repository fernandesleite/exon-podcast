package me.fernandesleite.exonpodcast.mainPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.fernandesleite.exonpodcast.network.podcastApi

class MainPageViewModel : ViewModel() {
    fun searchPodcast() {
        viewModelScope.launch {
            podcastApi.podcastService.getSearch("Nerdcast")
        }
    }
}
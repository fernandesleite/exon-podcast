package me.fernandesleite.exonpodcast.ui.mainPage

import androidx.lifecycle.ViewModel
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject

class MainPageViewModel @Inject constructor(val podcastRepository: PodcastRepository) :
    ViewModel() {

}
package me.fernandesleite.exonpodcast.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.fernandesleite.exonpodcast.network.ITunesApi
import javax.inject.Inject

class PodcastRepository @Inject constructor(val ITunesApi: ITunesApi) {
    suspend fun getSearch(): Int =
        withContext(Dispatchers.IO) {
            ITunesApi.getSearch("nerdcast").resultCount
        }

}
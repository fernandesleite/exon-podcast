package me.fernandesleite.exonpodcast.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.fernandesleite.exonpodcast.network.ITunesApi
import me.fernandesleite.exonpodcast.network.ITunesRSSApi
import me.fernandesleite.exonpodcast.network.models.ITunesRSS
import me.fernandesleite.exonpodcast.network.models.ITunesSearch
import me.fernandesleite.exonpodcast.persistence.AppDatabase
import javax.inject.Inject

class PodcastRepository @Inject constructor(val ITunesApi: ITunesApi, val ITunesRSSApi: ITunesRSSApi) {
    suspend fun getSearch(query: String): List<ITunesSearch.Results> =
        withContext(Dispatchers.IO) {
            ITunesApi.getSearch(query).results

        }
    suspend fun getTopPodcasts(country: String) : List<ITunesRSS.Feed.ResultsRSS> =
        withContext(Dispatchers.IO) {
            ITunesRSSApi.getTopPodcasts(country).feed.results
    }
}
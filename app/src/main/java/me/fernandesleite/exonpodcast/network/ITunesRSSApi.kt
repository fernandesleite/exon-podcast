package me.fernandesleite.exonpodcast.network

import me.fernandesleite.exonpodcast.network.models.ITunesRSS
import retrofit2.http.GET
import retrofit2.http.Path

interface ITunesRSSApi {
    @GET("{country}/podcasts/top-podcasts/all/50/explicit.json")
    suspend fun getTopPodcasts(@Path("country") country: String) : ITunesRSS
}
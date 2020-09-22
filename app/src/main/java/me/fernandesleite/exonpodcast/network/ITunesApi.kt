package me.fernandesleite.exonpodcast.network

import me.fernandesleite.exonpodcast.network.models.ITunesSearch

import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApi {
    @GET("search")
    suspend fun getSearch(@Query("term") term: String): ITunesSearch
}

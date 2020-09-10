package me.fernandesleite.exonpodcast.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import me.fernandesleite.exonpodcast.network.models.searchResults
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder().baseUrl("https://itunes.apple.com/").addConverterFactory(MoshiConverterFactory.create(moshi)).build()

interface podcastSearchService {
    @GET("search")
    suspend fun getSearch(@Query("term") term: String) : searchResults
}

object podcastApi {
    val podcastService: podcastSearchService by lazy {
        retrofit.create(podcastSearchService::class.java)
    }
}
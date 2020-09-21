package me.fernandesleite.exonpodcast.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import me.fernandesleite.exonpodcast.network.ITunesApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
class ApiModule @Inject constructor() {


    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi
    }


    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://itunes.apple.com/")
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            ).build()
        return retrofit
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ITunesApi {
        return retrofit.create(ITunesApi::class.java)
    }
}
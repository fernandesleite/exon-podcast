package me.fernandesleite.exonpodcast.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import me.fernandesleite.exonpodcast.network.ITunesApi
import me.fernandesleite.exonpodcast.network.ITunesRSSApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [ViewModelFactoryModule::class])
class ApiModule @Inject constructor() {


    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi
    }

    @Singleton
    @Provides
    @Named("itunes search")
    fun provideRetrofitSearch(moshi: Moshi): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://itunes.apple.com/")
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            ).build()
        return retrofit
    }

    @Singleton
    @Provides
    @Named("itunes top")
    fun provideRetrofit(moshi: Moshi): Retrofit {
        val retrofit = Retrofit.Builder().baseUrl("https://rss.itunes.apple.com/api/v1/")
            .addConverterFactory(
                MoshiConverterFactory.create(moshi)
            ).build()
        return retrofit
    }

    @Singleton
    @Provides
    fun provideItunesApi(@Named("itunes search") retrofit: Retrofit): ITunesApi {
        return retrofit.create(ITunesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRSSApi(@Named("itunes top") retrofit: Retrofit) : ITunesRSSApi {
        return retrofit.create(ITunesRSSApi::class.java)
    }
}
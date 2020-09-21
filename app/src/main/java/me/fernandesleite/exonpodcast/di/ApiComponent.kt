package me.fernandesleite.exonpodcast.di

import dagger.Component
import me.fernandesleite.exonpodcast.discoverPage.DiscoverPageFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(discoverPageFragment: DiscoverPageFragment)
}
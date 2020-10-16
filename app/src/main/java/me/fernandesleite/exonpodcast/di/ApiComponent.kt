package me.fernandesleite.exonpodcast.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import me.fernandesleite.exonpodcast.ui.discoverPage.DiscoverPageFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(discoverPageFragment: DiscoverPageFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApiComponent
    }
}
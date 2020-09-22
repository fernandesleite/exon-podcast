package me.fernandesleite.exonpodcast.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.fernandesleite.exonpodcast.ui.discoverPage.DiscoverPageViewModel
import me.fernandesleite.exonpodcast.util.ViewModelProviderFactory


@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DiscoverPageViewModel::class)
    abstract fun bindDiscoverPageViewModel(discoverPageViewModel: DiscoverPageViewModel?): ViewModel?
}
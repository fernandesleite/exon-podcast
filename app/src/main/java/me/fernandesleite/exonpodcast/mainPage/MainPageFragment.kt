package me.fernandesleite.exonpodcast.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.fernandesleite.exonpodcast.R
import me.fernandesleite.exonpodcast.di.DaggerApiComponent
import me.fernandesleite.exonpodcast.discoverPage.DiscoverPageViewModelFactory
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject

class MainPageFragment : Fragment() {

    companion object {
        fun newInstance() = MainPageFragment()
    }

    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
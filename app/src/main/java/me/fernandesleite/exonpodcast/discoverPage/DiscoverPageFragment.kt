package me.fernandesleite.exonpodcast.discoverPage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.fernandesleite.exonpodcast.R
import me.fernandesleite.exonpodcast.di.DaggerApiComponent
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject

class DiscoverPageFragment : Fragment() {

    companion object {
        fun newInstance() = DiscoverPageFragment()
    }

    private lateinit var viewModel: DiscoverPageViewModel
    private lateinit var viewModelFactory: DiscoverPageViewModelFactory

    @Inject
    lateinit var podcastRepository: PodcastRepository

    var apiComponent = DaggerApiComponent.create().inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelFactory =
            DiscoverPageViewModelFactory(
                podcastRepository
            )
        viewModel = ViewModelProvider(this, viewModelFactory).get(DiscoverPageViewModel::class.java)
        viewModel.searchPodcast()
        viewModel.page.observe(viewLifecycleOwner, Observer {
            Log.i("test", it.toString())
        })
    }

}
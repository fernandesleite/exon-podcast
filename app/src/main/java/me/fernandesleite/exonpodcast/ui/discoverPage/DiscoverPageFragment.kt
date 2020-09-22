package me.fernandesleite.exonpodcast.ui.discoverPage

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

    private val TAG = "DiscoverPageFragment"

    private lateinit var viewModel: DiscoverPageViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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
        viewModel = ViewModelProvider(this, viewModelFactory).get(DiscoverPageViewModel::class.java)
        viewModel.searchPodcast()
        viewModel.showTopPodcasts()
        viewModel.ITunesSearch.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it[0].toString())
        })
        viewModel.topPodcasts.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it[0].toString())
        })
    }

}
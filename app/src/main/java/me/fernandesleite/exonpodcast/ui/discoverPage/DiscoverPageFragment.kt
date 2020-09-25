package me.fernandesleite.exonpodcast.ui.discoverPage

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import me.fernandesleite.exonpodcast.databinding.DiscoverPageFragmentBinding
import me.fernandesleite.exonpodcast.di.DaggerApiComponent
import me.fernandesleite.exonpodcast.repository.PodcastRepository
import javax.inject.Inject


class DiscoverPageFragment : Fragment() {

    companion object {
        fun newInstance() = DiscoverPageFragment()
    }

    private val TAG = "DiscoverPageFragment"

    private lateinit var viewModel: DiscoverPageViewModel

    private lateinit var binding: DiscoverPageFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var podcastRepository: PodcastRepository

    var apiComponent = DaggerApiComponent.create().inject(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DiscoverPageFragmentBinding.inflate(inflater)
        binding.discoverList.layoutManager =
            GridLayoutManager(this.context, 2, GridLayoutManager.HORIZONTAL, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DiscoverPageViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.discoverList.adapter = DiscoverListAdapter()

        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                Log.i(TAG, s)
                viewModel.searchPodcast(s)

                viewModel.searchResults.observe(viewLifecycleOwner, Observer {
                    Log.i(TAG, it[0].toString())

                })
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                //my code here for search
                return false
            }
        })
        viewModel.showTopPodcasts()
        viewModel.searchResults.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it[0].toString())
        })
        viewModel.topPodcasts.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it[0].toString())
            binding.progressCircular.visibility = View.GONE
        })
    }
}
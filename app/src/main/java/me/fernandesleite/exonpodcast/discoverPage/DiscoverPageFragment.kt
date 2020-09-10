package me.fernandesleite.exonpodcast.discoverPage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.fernandesleite.exonpodcast.R

class DiscoverPageFragment : Fragment() {

    companion object {
        fun newInstance() = DiscoverPageFragment()
    }

    private lateinit var viewModel: DiscoverPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DiscoverPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
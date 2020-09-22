package me.fernandesleite.exonpodcast.ui.downloadedPage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.fernandesleite.exonpodcast.R

class DownloadedPageFragment : Fragment() {

    companion object {
        fun newInstance() = DownloadedPageFragment()
    }

    private lateinit var viewModel: DownloadedPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.downloaded_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DownloadedPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
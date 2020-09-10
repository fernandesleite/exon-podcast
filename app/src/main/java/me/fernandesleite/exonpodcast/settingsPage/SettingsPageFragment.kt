package me.fernandesleite.exonpodcast.settingsPage

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.fernandesleite.exonpodcast.R

class SettingsPageFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsPageFragment()
    }

    private lateinit var viewModel: SettingsPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.settings_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SettingsPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
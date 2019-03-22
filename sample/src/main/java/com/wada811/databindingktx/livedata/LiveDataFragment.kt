package com.wada811.databindingktx.livedata

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wada811.databinding.bind
import com.wada811.databindingktx.App
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.LiveDataFragmentBinding

class LiveDataFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = LiveDataFragment()
    }

    private val binding: LiveDataFragmentBinding by bind(R.layout.live_data_fragment)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return com.wada811.databindingktx.livedata.LiveDataViewModel() as T
            }
        }).get(com.wada811.databindingktx.livedata.LiveDataViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        App.getRefWatcher(requireContext()).watch(this)
    }
}

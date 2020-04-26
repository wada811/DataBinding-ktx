package com.wada811.databindingktx.livedata

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.LiveDataFragmentBinding

class LiveDataFragment : Fragment(R.layout.live_data_fragment) {
    private val binding: LiveDataFragmentBinding by dataBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity(), object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LiveDataViewModel() as T
            }
        }).get(LiveDataViewModel::class.java)
        binding.viewModel = viewModel
    }

    companion object {
        @JvmStatic
        fun newInstance() = LiveDataFragment()
    }
}

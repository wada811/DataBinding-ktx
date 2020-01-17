package com.wada811.databindingktx.detach

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.leakcanary.LeakCanary
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DetachFragmentBinding

class DetachFragment : Fragment(R.layout.detach_fragment) {
    private val binding: DetachFragmentBinding by dataBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text = arguments!!.getString(EXTRA_TEXT)
    }

    override fun onDestroy() {
        super.onDestroy()
        LeakCanary.installedRefWatcher().watch(this)
    }

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = DetachFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }
}

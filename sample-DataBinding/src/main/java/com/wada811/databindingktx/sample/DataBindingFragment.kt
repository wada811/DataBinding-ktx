package com.wada811.databindingktx.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.leakcanary.LeakCanary
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DataBindingFragmentBinding

class DataBindingFragment : Fragment(R.layout.data_binding_fragment) {
    private val binding: DataBindingFragmentBinding by dataBinding()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.data_binding_fragment, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        LeakCanary.installedRefWatcher().watch(this)
    }

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = DataBindingFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }
}

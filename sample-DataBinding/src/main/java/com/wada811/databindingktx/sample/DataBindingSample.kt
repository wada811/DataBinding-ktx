package com.wada811.databindingktx.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DataBindingActivityBinding
import com.wada811.databindingktx.databinding.DataBindingFragmentBinding

@SuppressLint("Registered")
class DataBindingSample {
    class DataBindingActivity : FragmentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = DataBindingUtil.setContentView<DataBindingActivityBinding>(this, R.layout.data_binding_activity)
            binding.lifecycleOwner = this
        }
    }

    class DataBindingKtxActivity : FragmentActivity(R.layout.data_binding_activity) {
        private val binding: DataBindingActivityBinding by dataBinding()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // use binding
        }
    }

    class DataBindingFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding = DataBindingUtil.inflate<DataBindingFragmentBinding>(inflater, R.layout.data_binding_fragment, container, false)
            binding.lifecycleOwner = viewLifecycleOwner
            return binding.root
        }
    }

    class DataBindingKtxFragment : Fragment(R.layout.data_binding_fragment) {
        private val binding: DataBindingFragmentBinding by dataBinding()
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            // use binding
        }
    }
}

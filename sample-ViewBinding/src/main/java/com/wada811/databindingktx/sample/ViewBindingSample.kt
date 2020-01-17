package com.wada811.databindingktx.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.wada811.databindingktx.R
import com.wada811.viewbinding.viewBinding
import com.wada811.databindingktx.databinding.ViewBindingActivityBinding
import com.wada811.databindingktx.databinding.ViewBindingFragmentBinding

@Suppress("UNUSED_VARIABLE", "LocalVariableName")
@SuppressWarnings("ALL")
class ViewBindingSample {
    class ViewBindingActivity : FragmentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ViewBindingActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }
    }

    class ViewBindingKtxActivity : FragmentActivity(R.layout.view_binding_activity) {
        private val binding by viewBinding { ViewBindingActivityBinding.bind(it) }
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // use binding
        }
    }

    class ViewBindingFragment : Fragment() {
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val binding = ViewBindingFragmentBinding.inflate(inflater, container, false)
            return binding.root
        }
    }

    class ViewBindingKtxFragment : Fragment(R.layout.view_binding_fragment) {
        private val binding by viewBinding { ViewBindingFragmentBinding.bind(it) }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.text.text = "Hello, ViewBinding!"
        }
    }
}
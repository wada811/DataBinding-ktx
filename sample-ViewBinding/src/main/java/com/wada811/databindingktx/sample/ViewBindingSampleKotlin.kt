package com.wada811.databindingktx.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.wada811.databinding.setContentView
import com.wada811.databinding.viewBinding
import com.wada811.databindingktx.databinding.ViewBindingActivityBinding
import com.wada811.databindingktx.databinding.ViewBindingFragmentBinding

@Suppress("UNUSED_VARIABLE", "LocalVariableName")
@SuppressWarnings("ALL")
class ViewBindingSampleKotlin {

    class ViewBindingActivity : FragmentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = ViewBindingActivityBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }
    }

    class TopLevelFunctionActivity : FragmentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val binding = setContentView { ViewBindingActivityBinding.inflate(it) }
        }
    }

    class DelegatedPropertyActivity : FragmentActivity() {
        private val binding by viewBinding { ViewBindingActivityBinding.inflate(it) }
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

    class DelegatedPropertyFragment : Fragment() {
    private val binding by viewBinding { inflater, container ->
        ViewBindingFragmentBinding.inflate(inflater, container, false)
    }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            return binding.root
        }
    }

}

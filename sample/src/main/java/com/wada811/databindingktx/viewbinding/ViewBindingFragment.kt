package com.wada811.databindingktx.viewbinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.ViewBindingFragmentBinding
import com.wada811.databindingktx.databinding.ViewStubBinding
import com.wada811.viewbinding.viewBinding

class ViewBindingFragment : Fragment(R.layout.view_stub) {
    private val viewStubBinding by viewBinding(ViewStubBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewStubBinding.viewStub.setOnInflateListener { stub, inflated ->
            val binding = ViewBindingFragmentBinding.bind(inflated)
            binding.text.text = requireArguments().getString(EXTRA_TEXT)
        }
        if (!viewStubBinding.viewStub.isInflated) {
            viewStubBinding.viewStub.viewStub?.inflate()
        }
    }

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = ViewBindingFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }
}

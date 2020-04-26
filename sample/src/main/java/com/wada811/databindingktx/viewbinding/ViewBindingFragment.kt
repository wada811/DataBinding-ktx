package com.wada811.databindingktx.viewbinding

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.ViewBindingFragmentBinding
import com.wada811.viewbinding.viewBinding

class ViewBindingFragment : Fragment(R.layout.view_binding_fragment) {
    private val binding by viewBinding(ViewBindingFragmentBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = requireArguments().getString(EXTRA_TEXT)
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

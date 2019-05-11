package com.wada811.databindingktx.backstack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.App
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.BackStackFragmentBinding

class BackStackFragment : Fragment() {

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = BackStackFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }

    private val binding: BackStackFragmentBinding by dataBinding(R.layout.back_stack_fragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.text = arguments!!.getString(EXTRA_TEXT)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        App.getRefWatcher(requireContext()).watch(this)
    }
}

package com.wada811.databindingktx.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wada811.databinding.bind
import com.wada811.databindingktx.App
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.ViewPagerFragmentBinding

class ViewPagerFragment : Fragment() {

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = ViewPagerFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }

    private val binding: ViewPagerFragmentBinding by bind(R.layout.view_pager_fragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.text = arguments!!.getString(EXTRA_TEXT)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        App.getRefWatcher(requireContext()).watch(this)
    }
}

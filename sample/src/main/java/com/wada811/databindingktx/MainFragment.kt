package com.wada811.databindingktx

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wada811.databinding.bind
import com.wada811.databindingktx.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }

    private val binding: MainFragmentBinding by bind(R.layout.main_fragment)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("wada811", "onCreateView: $container")
        binding.fragmentTextView.text = """
            class MainFragment : Fragment() {
                private val binding: MainFragmentBinding by bind(R.layout.main_fragment)
                override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
                    return binding.root
                }
            }
        """.trimIndent()
        return binding.root
    }
}

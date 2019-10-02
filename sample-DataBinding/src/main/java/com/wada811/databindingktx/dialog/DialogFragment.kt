package com.wada811.databindingktx.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.leakcanary.LeakCanary
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DialogFragmentBinding

class DialogFragment : androidx.fragment.app.DialogFragment() {

    companion object {
        private const val EXTRA_TEXT = "text"
        fun newInstance(text: String) = DialogFragment().also { fragment ->
            fragment.arguments = Bundle().also { bundle ->
                bundle.putString(EXTRA_TEXT, text)
            }
        }
    }

    private val binding: DialogFragmentBinding by dataBinding(R.layout.dialog_fragment)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), theme).also {
            it.setTitle(DialogFragment::class.java.simpleName)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.text = arguments!!.getString(EXTRA_TEXT)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        LeakCanary.installedRefWatcher().watch(this)
    }
}
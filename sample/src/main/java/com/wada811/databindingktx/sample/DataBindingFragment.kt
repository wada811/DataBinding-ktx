package com.wada811.databindingktx.sample

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.wada811.databindingktx.sample.databinding.DataBindingFragmentBinding
import com.wada811.databindingktx.withBinding

class DataBindingFragment : Fragment(R.layout.data_binding_fragment) {
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        withBinding<DataBindingFragmentBinding> { binding ->
            binding.textView.text = """
                withBinding<DataBindingFragmentBinding> { binding ->
                    // You can use binding
                }
            """.trimIndent()
        }
    }
}

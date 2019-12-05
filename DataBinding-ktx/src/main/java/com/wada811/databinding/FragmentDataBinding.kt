@file:JvmName("FragmentDataBinding")

package com.wada811.databinding

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

fun <T : ViewDataBinding> Fragment.dataBinding(@LayoutRes layoutResId: Int): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: inflate<T>(this@dataBinding, layoutResId).also {
                binding = it
                // viewLifecycleOwnerLiveData set value after onCreateView
                viewLifecycleOwnerLiveData.observe(this@dataBinding, object : Observer<LifecycleOwner> {
                    override fun onChanged(viewLifecycleOwner: LifecycleOwner?) {
                        // onChanged called when STARTED
                        viewLifecycleOwnerLiveData.removeObserver(this)
                        viewLifecycleOwnerLiveData.observeForever(object : Observer<LifecycleOwner> {
                            override fun onChanged(owner: LifecycleOwner?) {
                                // after onDestroyView, viewLifecycleOwnerLiveData set null in FragmentManagerImpl
                                viewLifecycleOwnerLiveData.removeObserver(this)
                                binding = null // for avoiding to leak Fragment's view
                            }
                        })
                    }
                })
            }

        private fun <T : ViewDataBinding> inflate(
            fragment: Fragment,
            layoutResId: Int,
            container: ViewGroup? = fragment.requireActivity().findViewById(fragment.id) as? ViewGroup,
            attachToParent: Boolean = false
        ): T {
            return DataBindingUtil.inflate<T>(fragment.layoutInflater, layoutResId, container, attachToParent).also {
                it.lifecycleOwner = fragment.viewLifecycleOwner
            }
        }
    }
}

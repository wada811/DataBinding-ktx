package com.wada811.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Fragment.viewBinding(): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: inflate<T>(layoutInflater, requireActivity().findViewById(id) as? ViewGroup).also {
                binding = it
                // viewLifecycleOwnerLiveData set value after onCreateView
                viewLifecycleOwnerLiveData.observe(this@viewBinding, object : Observer<LifecycleOwner> {
                    override fun onChanged(viewLifecycleOwner: LifecycleOwner?) {
                        // onChanged called when STARTED
                        viewLifecycleOwnerLiveData.removeObserver(this)
                        viewLifecycleOwnerLiveData.observeForever(object : Observer<LifecycleOwner> {
                            override fun onChanged(owner: LifecycleOwner?) {
                                if (owner == null) {
                                    // after onDestroyView, viewLifecycleOwnerLiveData set null in FragmentManagerImpl
                                    viewLifecycleOwnerLiveData.removeObserver(this)
                                    binding = null // for avoiding to leak Fragment's view
                                }
                            }
                        })
                    }
                })
            }

        private inline fun <reified T : ViewBinding> inflate(inflater: LayoutInflater, container: ViewGroup?): T {
            return T::class.java.getMethod("inflate").invoke(inflater, container, false) as T
        }
    }
}

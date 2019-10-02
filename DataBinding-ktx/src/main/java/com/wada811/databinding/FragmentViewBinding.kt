package com.wada811.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> Fragment.viewBinding(
    crossinline inflate: (inflater: LayoutInflater, container: ViewGroup?) -> T = { inflater: LayoutInflater, container: ViewGroup? ->
        T::class.java.getMethod("inflate").invoke(inflater, container, false) as T
    }
): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: inflate(
                layoutInflater,
                requireActivity().findViewById(id) as? ViewGroup
            ).also {
                binding = it
                viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    fun onDestroyView() {
                        viewLifecycleOwner.lifecycle.removeObserver(this)
                        binding = null // For Fragment's view recreation
                    }
                })
            }
    }
}

@file:JvmName("FragmentDataBinding")

package com.wada811.databinding

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

fun <T : ViewDataBinding> Fragment.dataBinding(@LayoutRes layoutResId: Int): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: inflate<T>(this@dataBinding, layoutResId).also {
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

@JvmOverloads
fun <T : ViewDataBinding> inflate(
    fragment: Fragment,
    layoutResId: Int,
    container: ViewGroup? = fragment.requireActivity().findViewById(fragment.id) as? ViewGroup,
    attachToParent: Boolean = false
): T {
    return DataBindingUtil.inflate<T>(fragment.layoutInflater, layoutResId, container, attachToParent).also {
        it.lifecycleOwner = fragment.viewLifecycleOwner
    }
}

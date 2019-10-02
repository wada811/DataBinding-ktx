@file:JvmName("ActivityViewBinding")

package com.wada811.databinding

import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> FragmentActivity.viewBinding(inflate: (inflater: LayoutInflater) -> T): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: setContentView(inflate).also {
                binding = it
            }
    }
}

fun <T : ViewBinding> FragmentActivity.setContentView(inflate: (inflater: LayoutInflater) -> T): T {
    return inflate(layoutInflater).also {
        setContentView(it.root)
    }
}

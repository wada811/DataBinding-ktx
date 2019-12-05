@file:JvmName("ActivityViewBinding")

package com.wada811.databinding

import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

inline fun <reified T : ViewBinding> FragmentActivity.viewBinding(): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: setContentView<T>(this@viewBinding).also {
                binding = it
            }

        private inline fun <reified T : ViewBinding> setContentView(fragmentActivity: FragmentActivity): T {
            return inflate<T>(fragmentActivity.layoutInflater).also {
                fragmentActivity.setContentView(it.root)
            }
        }

        private inline fun <reified T : ViewBinding> inflate(inflater: LayoutInflater): T {
            return T::class.java.getMethod("inflate").invoke(inflater) as T
        }
    }
}

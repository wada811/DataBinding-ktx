@file:JvmName("ActivityDataBinding")

package com.wada811.databinding

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity

fun <T : ViewDataBinding> FragmentActivity.dataBinding(@LayoutRes layoutResId: Int): Lazy<T> {
    return object : Lazy<T> {
        private var binding: T? = null
        override fun isInitialized(): Boolean = binding != null
        override val value: T
            get() = binding ?: setContentView<T>(this@dataBinding, layoutResId).also {
                binding = it
            }

        private fun <T : ViewDataBinding> setContentView(activity: FragmentActivity, layoutResId: Int): T {
            return DataBindingUtil.inflate<T>(activity.layoutInflater, layoutResId, null, false).also {
                // On Android 8, DataBindingUtil.setContentView will crash sometimes.
                // https://stackoverflow.com/questions/50060653/app-crashing-when-using-android-data-binding-on-android-8
                activity.setContentView(it.root)
                it.lifecycleOwner = activity
            }
        }
    }
}

@file:JvmName("ActivityViewBinding")

package com.wada811.viewbinding

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

fun <T : ViewBinding> FragmentActivity.viewBinding(bind: (View) -> T): Lazy<T> = object : Lazy<T> {
    private var binding: T? = null
    override fun isInitialized(): Boolean = binding != null
    override val value: T
        get() = binding ?: bind(getContentView()).also {
            binding = it
        }

    private fun FragmentActivity.getContentView(): View {
        return checkNotNull(findViewById<ViewGroup>(android.R.id.content).getChildAt(0)) {
            "Call setContentView or Use Activity's secondary constructor passing layout res id."
        }
    }
}

package com.wada811.databinding

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityBindingDelegate<T : ViewDataBinding>
internal constructor(
    @LayoutRes private val layoutResId: Int
) : ReadOnlyProperty<FragmentActivity, T> {
    private var binding: T? = null
    override operator fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T =
        binding ?: DataBindingUtil.setContentView<T>(thisRef, layoutResId)
            .also { it.lifecycleOwner = thisRef }
            .also { binding = it }
}

fun <T : ViewDataBinding> FragmentActivity.bind(@LayoutRes layoutResId: Int): ActivityBindingDelegate<T> =
    ActivityBindingDelegate(layoutResId)

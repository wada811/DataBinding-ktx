package com.wada811.databinding

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityBindingDelegate<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : ReadOnlyProperty<Activity, T> {
    private var cached: T? = null
    override operator fun getValue(thisRef: Activity, property: KProperty<*>): T =
        cached ?: DataBindingUtil.setContentView<T>(thisRef, layoutResId).also { cached = it }
}

fun <T : ViewDataBinding> Activity.bind(@LayoutRes layoutResId: Int): ActivityBindingDelegate<T> =
    ActivityBindingDelegate(layoutResId)

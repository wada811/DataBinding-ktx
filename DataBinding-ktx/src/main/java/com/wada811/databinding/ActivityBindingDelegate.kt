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
        binding ?: DataBindingUtil.inflate<T>(
            thisRef.layoutInflater,
            layoutResId,
            null,
            false
        ).also {
            // On Android 8, DataBindingUtil.setContentView will crash sometimes.
            // https://stackoverflow.com/questions/50060653/app-crashing-when-using-android-data-binding-on-android-8
            thisRef.setContentView(it.root)
            it.lifecycleOwner = thisRef
            binding = it
        }
}

@Suppress("unused")
fun <T : ViewDataBinding> FragmentActivity.dataBinding(@LayoutRes layoutResId: Int): ActivityBindingDelegate<T> =
    ActivityBindingDelegate(layoutResId)

package com.wada811.databinding

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBindingDelegate<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : ReadOnlyProperty<Fragment, T> {
    private var cached: T? = null
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T =
        cached ?: DataBindingUtil.inflate<T>(
            thisRef.layoutInflater,
            layoutResId,
            thisRef.requireActivity().findViewById(thisRef.id) as? ViewGroup,
            false
        ).also { cached = it }
}

fun <T : ViewDataBinding> Fragment.bind(@LayoutRes layoutResId: Int): FragmentBindingDelegate<T> =
    FragmentBindingDelegate(layoutResId)

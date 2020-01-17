package com.wada811.viewbinding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T : ViewBinding> Fragment.viewBinding(bind: (View) -> T): ReadOnlyProperty<Fragment, T> = object : ReadOnlyProperty<Fragment, T> {
    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        (requireView().getTag(property.name.hashCode()) as? T)?.let { return it }
        return bind(requireView()).also {
            requireView().setTag(property.name.hashCode(), it)
        }
    }
}


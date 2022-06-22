@file:JvmName("FragmentDataBinding")

package com.wada811.databinding

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Deprecated("Use withBinding", level = DeprecationLevel.WARNING)
fun <T : ViewDataBinding> Fragment.dataBinding(): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        @Suppress("UNCHECKED_CAST")
        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            (requireView().getTag(R.id.data_binding_tag) as? T)?.let { return it }
            return bind<T>(requireView()).also {
                it.lifecycleOwner = thisRef.viewLifecycleOwner
                it.root.setTag(R.id.data_binding_tag, it)
            }
        }

        private fun <T : ViewDataBinding> bind(view: View): T = DataBindingUtil.bind(view)!!
    }
}

fun <T : ViewDataBinding> Fragment.withBinding(withBinding: (binding: T) -> Unit) {
    view?.let { view ->
        val binding = DataBindingUtil.bind<T>(view)!!.also {
            it.lifecycleOwner = viewLifecycleOwner
        }
        withBinding(binding)
    }
}


package com.wada811.databinding

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBindingDelegate<T : ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        if (binding != null) {
            return binding!!
        }
        binding = DataBindingUtil.inflate(
            thisRef.layoutInflater,
            layoutResId,
            thisRef.requireActivity().findViewById(thisRef.id) as? ViewGroup,
            false
        )
        binding!!.lifecycleOwner = thisRef
        thisRef.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onViewCreated() {
                thisRef.lifecycle.removeObserver(this)
                thisRef.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    fun onDestroyView() {
                        thisRef.viewLifecycleOwner.lifecycle.removeObserver(this)
                        binding = null
                    }
                })
            }
        })
        return binding!!
    }
}

fun <T : ViewDataBinding> Fragment.bind(@LayoutRes layoutResId: Int): FragmentBindingDelegate<T> =
    FragmentBindingDelegate(layoutResId)

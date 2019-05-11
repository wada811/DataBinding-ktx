package com.wada811.databinding

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityBindingDelegate<T : ViewDataBinding>
internal constructor(
    activity: FragmentActivity,
    @LayoutRes private val layoutResId: Int
) : ReadOnlyProperty<FragmentActivity, T> {
    init {
        activity.lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                activity.lifecycle.removeObserver(this)
                binding.executePendingBindings() // initialize binding after onCreate unless initialized
            }
        })
    }

    private val binding: T by lazy(LazyThreadSafetyMode.NONE) {
        DataBindingUtil.setContentView<T>(activity, layoutResId).also { it.lifecycleOwner = activity }
    }

    override operator fun getValue(thisRef: FragmentActivity, property: KProperty<*>): T = binding
}

fun <T : ViewDataBinding> FragmentActivity.dataBinding(@LayoutRes layoutResId: Int): ActivityBindingDelegate<T> =
    ActivityBindingDelegate(this, layoutResId)

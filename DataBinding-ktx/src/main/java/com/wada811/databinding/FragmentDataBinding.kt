@file:JvmName("FragmentDataBinding")

package com.wada811.databinding

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.wada811.databindingktx.dataBinding
import com.wada811.databindingktx.withBinding
import kotlin.properties.ReadOnlyProperty

@Deprecated("Import com.wada811.databindingktx", ReplaceWith("dataBinding()", "com.wada811.databindingktx.dataBinding"))
fun <T : ViewDataBinding> Fragment.dataBinding(): ReadOnlyProperty<Fragment, T> = this.dataBinding()

@Deprecated("Import com.wada811.databindingktx", ReplaceWith("withBinding<T>(bind)", "com.wada811.databindingktx.withBinding"))
fun <T : ViewDataBinding> Fragment.withBinding(bind: (binding: T) -> Unit) = this.withBinding(bind)


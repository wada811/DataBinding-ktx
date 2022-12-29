@file:JvmName("ActivityDataBinding")

package com.wada811.databinding

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import com.wada811.databindingktx.dataBinding
import com.wada811.databindingktx.withBinding

@Deprecated("Import com.wada811.databindingktx", ReplaceWith("dataBinding()", "com.wada811.databindingktx.dataBinding"))
fun <T : ViewDataBinding> FragmentActivity.dataBinding(): Lazy<T> = this.dataBinding()

@Deprecated("Import com.wada811.databindingktx", ReplaceWith("withBinding<T>(bind)", "com.wada811.databindingktx.withBinding"))
fun <T : ViewDataBinding> FragmentActivity.withBinding(bind: (binding: T) -> Unit) = this.withBinding(bind)


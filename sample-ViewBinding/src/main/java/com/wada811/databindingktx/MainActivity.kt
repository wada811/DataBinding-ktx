package com.wada811.databindingktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.databinding.MainActivityBinding
import com.wada811.databindingktx.databinding.SampleListItemBinding
import com.wada811.databindingktx.sample.ViewBindingActivity

class MainActivity : AppCompatActivity() {

    enum class Samples(private val clazz: Class<out Activity>) {
        ViewBinding(ViewBindingActivity::class.java),
        ;

        fun createIntent(context: Context) = Intent(context, clazz)
    }

    private val binding: MainActivityBinding by dataBinding(R.layout.main_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Samples.values().forEach { sample ->
            val itemBinding = DataBindingUtil.inflate<SampleListItemBinding>(
                layoutInflater,
                R.layout.sample_list_item,
                binding.container,
                false
            )
            itemBinding.viewModel = sample
            itemBinding.root.setOnClickListener {
                startActivity(sample.createIntent(this@MainActivity))
            }
            binding.container.addView(itemBinding.root)
        }
    }
}

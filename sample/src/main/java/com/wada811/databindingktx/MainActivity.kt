package com.wada811.databindingktx

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.backstack.BackStackActivity
import com.wada811.databindingktx.databinding.MainActivityBinding
import com.wada811.databindingktx.databinding.SampleListItemBinding
import com.wada811.databindingktx.detach.DetachActivity
import com.wada811.databindingktx.livedata.LiveDataActivity
import com.wada811.databindingktx.viewpager.ViewPagerActivity

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private val binding: MainActivityBinding by dataBinding()
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

    enum class Samples(private val clazz: Class<out Activity>) {
        BackStack(BackStackActivity::class.java),
        Detach(DetachActivity::class.java),
        LiveData(LiveDataActivity::class.java),
        ViewPager(ViewPagerActivity::class.java),
        ViewBinding(ViewPagerActivity::class.java),
        ;

        fun createIntent(context: Context) = Intent(context, clazz)
    }
}

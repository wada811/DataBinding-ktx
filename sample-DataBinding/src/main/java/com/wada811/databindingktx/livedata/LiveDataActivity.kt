package com.wada811.databindingktx.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.LiveDataActivityBinding

class LiveDataActivity : AppCompatActivity(R.layout.live_data_activity) {
    private val binding: LiveDataActivityBinding by dataBinding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LiveDataViewModel() as T
            }
        }).get(LiveDataViewModel::class.java)
        binding.detachAttachButton.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.fragment)!!
            if (fragment.isDetached) {
                binding.detachAttachButton.text = "Detach"
                supportFragmentManager.beginTransaction()
                    .attach(fragment)
                    .commit()
            } else {
                binding.detachAttachButton.text = "Attach"
                supportFragmentManager.beginTransaction()
                    .detach(fragment)
                    .commit()
            }
        }
        binding.minusButton.setOnClickListener {
            viewModel.minus()
        }
        binding.plusButton.setOnClickListener {
            viewModel.plus()
        }
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, LiveDataFragment.newInstance())
                .commit()
        }
    }
}

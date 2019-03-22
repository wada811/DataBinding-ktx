package com.wada811.databindingktx.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wada811.databinding.bind
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.LiveDataActivityBinding

class LiveDataActivity : AppCompatActivity() {

    private val binding: LiveDataActivityBinding by bind(R.layout.live_data_activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return LiveDataViewModel() as T
            }
        }).get(LiveDataViewModel::class.java)
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

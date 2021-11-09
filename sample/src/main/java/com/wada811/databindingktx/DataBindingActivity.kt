package com.wada811.databindingktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.withBinding
import com.wada811.databindingktx.databinding.DataBindingActivityBinding

class DataBindingActivity : AppCompatActivity(R.layout.data_binding_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        withBinding<DataBindingActivityBinding> { binding ->
            binding.text = """
                withBinding<DataBindingActivityBinding> { binding ->
                    // You can use binding
                }
            """.trimIndent()
            supportFragmentManager.beginTransaction()
                .replace(binding.fragment.id, DataBindingFragment())
                .commit()
        }
    }
}

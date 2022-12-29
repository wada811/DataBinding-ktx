package com.wada811.databindingktx.sample

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databindingktx.sample.databinding.DataBindingActivityBinding
import com.wada811.databindingktx.withBinding

class DataBindingActivity : AppCompatActivity(R.layout.data_binding_activity) {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        withBinding<DataBindingActivityBinding> { binding ->
            binding.textView.text = """
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

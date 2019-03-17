package com.wada811.databindingktx

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.bind
import com.wada811.databindingktx.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by bind(R.layout.main_activity)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activityTextView.text = """
            class MainActivity : AppCompatActivity() {
                private val binding: MainActivityBinding by bind(R.layout.main_activity)
            }
        """.trimIndent()
        supportFragmentManager.beginTransaction()
            .replace(R.id.MainFragment, MainFragment.newInstance())
            .commit()
        binding.viewPager.adapter = MainPagerAdapter(supportFragmentManager)
    }
}

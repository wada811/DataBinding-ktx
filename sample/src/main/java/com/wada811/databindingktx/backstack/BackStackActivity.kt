package com.wada811.databindingktx.backstack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.bind
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.BackStackActivityBinding

class BackStackActivity : AppCompatActivity() {

    private val binding: BackStackActivityBinding by bind(R.layout.back_stack_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.addButton.setOnClickListener {
            val text = "${supportFragmentManager.backStackEntryCount + 1}"
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, BackStackFragment.newInstance(text), text)
                .addToBackStack(text)
                .commit()
        }
        binding.popButton.setOnClickListener {
            supportFragmentManager.popBackStack()
        }
        if (savedInstanceState == null) {
            val text = "${supportFragmentManager.backStackEntryCount}"
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, BackStackFragment.newInstance(text), text)
                .commit()
        }
    }
}

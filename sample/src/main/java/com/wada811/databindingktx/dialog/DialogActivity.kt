package com.wada811.databindingktx.dialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.bind
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DialogActivityBinding

class DialogActivity : AppCompatActivity() {
    private val binding: DialogActivityBinding by bind(R.layout.dialog_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var count = 0
        binding.dialogButton.setOnClickListener {
            DialogFragment.newInstance("${++count}")
                .show(supportFragmentManager, DialogFragment::class.java.simpleName)
        }
    }
}
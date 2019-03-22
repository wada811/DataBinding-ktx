package com.wada811.databindingktx.detach

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wada811.databinding.bind
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.DetachActivityBinding

class DetachActivity : AppCompatActivity() {

    private val binding: DetachActivityBinding by bind(R.layout.detach_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        if (savedInstanceState == null) {
            val text = "Fragment is attached."
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, DetachFragment.newInstance(text), text)
                .commit()
        }
    }
}

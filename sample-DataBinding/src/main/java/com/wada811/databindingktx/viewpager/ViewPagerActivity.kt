package com.wada811.databindingktx.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.wada811.databinding.dataBinding
import com.wada811.databindingktx.R
import com.wada811.databindingktx.databinding.ViewPagerActivityBinding

class ViewPagerActivity : AppCompatActivity() {

    private val binding: ViewPagerActivityBinding by dataBinding(R.layout.view_pager_activity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.prevButton.setOnClickListener {
            binding.viewPager.currentItem -= if (binding.viewPager.currentItem == 0) 0 else 1

        }
        binding.nextButton.setOnClickListener {
            binding.viewPager.currentItem += if (binding.viewPager.currentItem == 9) 0 else 1
        }
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                binding.prevButton.isEnabled = binding.viewPager.currentItem != 0
                binding.nextButton.isEnabled = binding.viewPager.currentItem != 9
            }
        })
        binding.prevButton.isEnabled = false
    }

    class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int = 10
        override fun getItem(position: Int): Fragment = ViewPagerFragment.newInstance("$position")
    }
}

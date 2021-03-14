package com.cainiao5.viewpager2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cainiao5.viewpager2.R
import com.cainiao5.viewpager2.databinding.ActivityMainBinding
import com.cainiao5.viewpager2.view.fragment.RotateFragment
import com.cainiao5.viewpager2.view.fragment.ScaleFragment
import com.cainiao5.viewpager2.view.fragment.TranslateFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.internal.bind.ObjectTypeAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        with(binding) {

            val viewPagerAdapter=object:FragmentStateAdapter(this@MainActivity){
                override fun getItemCount(): Int {
                    return 3
                }

                override fun createFragment(position: Int): Fragment {
                    return when(position){
                        0->ScaleFragment()
                        1->RotateFragment()
                        else->TranslateFragment()
                    }
                }
            }

            mainViewPager.adapter=viewPagerAdapter


            //A mediator to link a TabLayout with a ViewPager2
            TabLayoutMediator(mainTabLayout,mainViewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Scale"
                    1 -> tab.text = "Rotate"
                    else->tab.text="Translate"
                }
            }.attach()

        }
    }
}
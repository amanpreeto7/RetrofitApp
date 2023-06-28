package com.o7solutions.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout : TabLayout
    var fragments = ArrayList<Fragment>()
    lateinit var adapter : ViewPagerAdapter
    var title = listOf("Upcoming","Cancelled","Completed")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.viewPager)

        tabLayout = findViewById(R.id.tabLayout)
        fragments.add(FirstFragment())
        fragments.add(FirstFragment())
        fragments.add(FirstFragment.newInstance("Third ", "Third"))
        adapter = ViewPagerAdapter(this, fragments)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout,viewPager) {tab,position->
            tab.text = title[position]
        }.attach()

    }
}
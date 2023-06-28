package com.o7solutions.retrofitapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @Author: 017
 * @Date: 28/06/23
 * @Time: 1:49 pm
 */
class ViewPagerAdapter(var fragment : FragmentActivity, var fragments : ArrayList<Fragment>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
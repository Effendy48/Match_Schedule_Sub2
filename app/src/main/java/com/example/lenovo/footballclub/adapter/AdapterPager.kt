package com.example.lenovo.footballclub.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.lenovo.footballclub.FragmentNext
import com.example.lenovo.footballclub.FragmentPast

class AdapterPager(fm: FragmentManager) :  FragmentPagerAdapter(fm) {
    override fun getItem(position: Int) : Fragment? = when(position){
        0 -> FragmentPast.newInstance()
        1 -> FragmentNext.newInstance()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when(position) {
        0 -> "Last Match"
        1 -> "Next Match"
        else-> ""

    }
    override fun getCount(): Int = 2
}
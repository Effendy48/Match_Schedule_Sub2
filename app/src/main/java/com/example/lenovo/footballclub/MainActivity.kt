package com.example.lenovo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager

import com.example.lenovo.footballclub.adapter.AdapterPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        val tabLayout : TabLayout = findViewById(R.id.tab_layout)

        val viewPager : ViewPager = findViewById(R.id.view_pager)
        val adapater = AdapterPager(supportFragmentManager)

        viewPager.adapter = adapater
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

        })
    }
    private fun initToolbar(){

        supportActionBar!!.title = "Football Club "
    }


}

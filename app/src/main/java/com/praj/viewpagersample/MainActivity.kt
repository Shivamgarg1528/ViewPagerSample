package com.praj.viewpagersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.praj.viewpagersample.ui.main.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view_pager.adapter = MainPagerAdapter(this, supportFragmentManager)
        view_pager.offscreenPageLimit = 3
        tabs.setupWithViewPager(view_pager)
    }

    companion object {
        val TAG = MainActivity::class.java.name
    }
}
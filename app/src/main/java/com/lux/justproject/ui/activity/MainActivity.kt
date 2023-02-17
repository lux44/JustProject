package com.lux.justproject.ui.activity

import com.lux.justproject.R
import com.lux.justproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val TAG: String = MainActivity::class.java.simpleName
    override val layoutResID: Int
        get() = R.layout.activity_main

    override fun afterOnCreate() {

    }

}
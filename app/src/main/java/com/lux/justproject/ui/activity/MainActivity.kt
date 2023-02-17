package com.lux.justproject.ui.activity

import android.view.animation.AnimationUtils
import com.lux.justproject.R
import com.lux.justproject.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val TAG: String = MainActivity::class.java.simpleName
    override val layoutResID: Int
        get() = R.layout.activity_main

    private val heartAni by lazy { AnimationUtils.loadAnimation(this@MainActivity,R.anim.logo) }


    override fun afterOnCreate() {
        bind{

        }
    }

}
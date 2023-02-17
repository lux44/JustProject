package com.lux.justproject.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lux.justproject.etc.SharedPreferences
import java.util.logging.Logger

abstract class BaseActivity<VDB : ViewDataBinding> :AppCompatActivity(){
    abstract val TAG: String
    abstract val layoutResID: Int
    open lateinit var activityBinder: VDB

    var lastFragmentInfo : String = ""
    val prefer by lazy { SharedPreferences.getInstance(packageName,this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinder = DataBindingUtil.setContentView(this, layoutResID)
        activityBinder.lifecycleOwner = this


        afterOnCreate()
    }

    abstract fun afterOnCreate()

    fun bind(block:VDB.()->Unit){
        activityBinder.apply(block)
    }
}
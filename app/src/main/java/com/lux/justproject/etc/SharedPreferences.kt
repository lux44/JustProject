package com.lux.justproject.etc

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferences private constructor(){
    companion object {

        @Volatile private var instance: com.lux.justproject.etc.SharedPreferences? = null
        private lateinit var pref: SharedPreferences

        @JvmStatic fun getInstance(packageName: String, context: Context): com.lux.justproject.etc.SharedPreferences =
            instance ?: synchronized(this) {
                instance ?: SharedPreferences().also {
                    instance = it
                    pref = context.getSharedPreferences(packageName, Activity.MODE_PRIVATE)
                }
            }
    }

    fun put(key: String, value: String){
        pref.edit().apply{
            putString(key, value)
            apply()
        }
    }

    fun put(key: String, value: Int){
        pref.edit().apply{
            putInt(key, value)
            apply()
        }
    }

    fun put(key: String, value: Boolean){
        pref.edit().apply{
            putBoolean(key, value)
            apply()
        }
    }

    fun put(key: String, value: Float){
        pref.edit().apply{
            putFloat(key, value)
            apply()
        }
    }

    fun put(key: String, value: Long){
        pref.edit().apply{
            putLong(key, value)
            apply()
        }
    }

    fun put(key: String, value: MutableSet<String>?){
        pref.edit().apply{
            putStringSet(key, value)
            apply()
        }
    }

    fun get(key: String, default: Boolean) = pref.getBoolean(key, default)
    fun get(key: String, default: Int) = pref.getInt(key, default)
    fun get(key: String, default: Long) = pref.getLong(key, default)
    fun get(key: String, default: String) = pref.getString(key, default)
    fun get(key: String, default: MutableSet<String>?) = pref.getStringSet(key, default)
    fun get(key: String, default: Float) = pref.getFloat(key, default)

    fun removePref(key: String){
        pref.edit().apply{
            remove(key)
            apply()
        }
    }

    fun contains(key: String) = pref.contains(key)
}
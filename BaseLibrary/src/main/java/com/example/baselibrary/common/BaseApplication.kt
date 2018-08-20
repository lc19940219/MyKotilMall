package com.example.baselibrary.common

import android.app.Application
import android.content.Context
import com.example.baselibrary.injection.compontent.AppCompontent
import com.example.baselibrary.injection.compontent.DaggerAppCompontent
import com.example.baselibrary.injection.module.AppModule

/**
 * Created by lc on 2018/8/10.
 */
class BaseApplication : Application() {
    lateinit var appCompontent: AppCompontent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context = this
    }

    companion object {
        lateinit var context: Context
    }

    private fun initAppInjection() {
        appCompontent = DaggerAppCompontent.builder().appModule(AppModule(this)).build()
    }
}
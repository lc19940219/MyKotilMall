package com.example.baselibrary.injection.compontent

import android.content.Context
import com.example.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by lc on 2018/8/10.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppCompontent {
    fun context(): Context
}
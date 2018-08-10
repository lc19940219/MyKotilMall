package com.example.baselibrary.injection.compontent

import android.app.Activity
import android.content.Context
import com.example.baselibrary.injection.ActivityScope
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by lc on 2018/8/10.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppCompontent::class),
        modules = arrayOf(ActivityModule::class, LifeModule::class))
interface ActivityCompontent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}
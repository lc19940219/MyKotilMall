package com.example.baselibrary.injection.compontent

import android.app.Activity
import com.example.baselibrary.injection.ActivityScope
import com.example.baselibrary.injection.module.ActivityModule
import dagger.Component

/**
 * Created by lc on 2018/8/10.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppCompontent::class), modules = arrayOf(ActivityModule::class))
interface ActivityCompontent {
    fun activity(): Activity
}
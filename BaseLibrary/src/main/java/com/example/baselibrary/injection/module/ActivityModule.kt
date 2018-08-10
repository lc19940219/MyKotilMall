package com.example.baselibrary.injection.module

import android.app.Activity
import com.example.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by lc on 2018/8/10.
 */
@Module
class ActivityModule(private val activity: Activity) {
    @ActivityScope
    @Provides
    fun providesActivity(): Activity {
        return activity
    }


}
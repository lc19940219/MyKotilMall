package com.example.baselibrary.injection.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by lc on 2018/8/10.
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}
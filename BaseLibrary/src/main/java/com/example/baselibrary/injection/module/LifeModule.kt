package com.example.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by lc on 2018/8/10.
 */
@Module
class LifeModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifeProvides(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}
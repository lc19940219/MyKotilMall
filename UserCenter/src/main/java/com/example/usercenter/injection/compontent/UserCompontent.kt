package com.example.usercenter.injection.compontent

import com.example.usercenter.injection.moudle.UserModule
import com.example.usercenter.ui.activity.RegistActivity
import dagger.Component

/**
 * Created by lc on 2018/8/8.
 */
@Component(modules = arrayOf(UserModule::class))
interface UserCompontent {

    fun inject(activity: RegistActivity)
}
package com.example.usercenter.injection.compontent

import com.example.baselibrary.injection.PerComponentScope
import com.example.baselibrary.injection.compontent.ActivityCompontent
import com.example.usercenter.injection.moudle.UserModule
import com.example.usercenter.ui.activity.RegistActivity
import dagger.Component

/**
 * Created by lc on 2018/8/8.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityCompontent::class), modules = arrayOf(UserModule::class))
interface UserCompontent {

    fun inject(activity: RegistActivity)
}
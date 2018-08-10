package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.compontent.ActivityCompontent
import com.example.baselibrary.injection.compontent.DaggerActivityCompontent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeModule
import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.precenter.view.BaseView
import javax.inject.Inject

/**
 * Created by lc on 2018/8/6.
 */
open class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var presenter: T

    lateinit var activityCompontent: ActivityCompontent
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
    }

    private fun initActivityInjection() {
        activityCompontent = DaggerActivityCompontent.builder()
                .appCompontent((application as BaseApplication).appCompontent)
                .activityModule(ActivityModule(this)).lifeModule(LifeModule(this)).build()

    }
}
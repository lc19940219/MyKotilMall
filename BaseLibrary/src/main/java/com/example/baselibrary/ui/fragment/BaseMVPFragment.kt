package com.example.baselibrary.ui.fragment

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.compontent.ActivityCompontent
import com.example.baselibrary.injection.compontent.DaggerActivityCompontent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeModule
import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.precenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by lc on 2018/8/6.
 */
open abstract class BaseMVPFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {
    @Inject
    lateinit var presenter: T

    lateinit var activityCompontent: ActivityCompontent
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text:String) {
        toast(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()
        initActivityInjection()
    }

    abstract fun initComponent()
    private fun initActivityInjection() {
        activityCompontent = DaggerActivityCompontent.builder()
                .appCompontent((activity!!.application as BaseApplication).appCompontent)
                .activityModule(ActivityModule(activity!!)).lifeModule(LifeModule(this)).build()

    }
}
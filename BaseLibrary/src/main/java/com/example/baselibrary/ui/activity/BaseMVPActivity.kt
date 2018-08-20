package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.injection.compontent.ActivityCompontent
import com.example.baselibrary.injection.compontent.DaggerActivityCompontent
import com.example.baselibrary.injection.module.ActivityModule
import com.example.baselibrary.injection.module.LifeModule
import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.precenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by lc on 2018/8/6.
 */
open abstract class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var presenter: T
    private lateinit var mLoadingProgressBar: ProgressLoading
    lateinit var activityCompontent: ActivityCompontent
    override fun showLoading() {
        mLoadingProgressBar.showLoading()
    }

    override fun hideLoading() {
        mLoadingProgressBar.dismiss()
    }

    override fun onError(text: String) {
        toast(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()
        initComponent()
        mLoadingProgressBar = ProgressLoading.create(this)
    }

    abstract fun initComponent()
    private fun initActivityInjection() {
        activityCompontent = DaggerActivityCompontent.builder()
                .appCompontent((application as BaseApplication).appCompontent)
                .activityModule(ActivityModule(this)).lifeModule(LifeModule(this)).build()

    }
}
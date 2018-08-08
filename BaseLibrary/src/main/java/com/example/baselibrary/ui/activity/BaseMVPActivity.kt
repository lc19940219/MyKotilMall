package com.example.baselibrary.ui.activity

import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.precenter.view.BaseView
import javax.inject.Inject

/**
 * Created by lc on 2018/8/6.
 */
open class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var presenter: T
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }
}
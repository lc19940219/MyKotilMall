package com.example.baselibrary.precenter

import com.example.baselibrary.precenter.view.BaseView

/**
 * Created by lc on 2018/8/6.
 */
open class BasePresenter<T : BaseView> {
    lateinit var mView: T
}
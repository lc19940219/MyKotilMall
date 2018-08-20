package com.example.baselibrary.precenter.view

/**
 * Created by lc on 2018/8/6.
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(text: String)
}
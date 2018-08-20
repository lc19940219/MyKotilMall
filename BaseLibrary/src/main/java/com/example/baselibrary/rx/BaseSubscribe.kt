package com.example.baselibrary.rx

import com.example.baselibrary.precenter.view.BaseView
import rx.Subscriber

/**
 * Created by lc on 2018/8/7.
 */
open class BaseSubscribe<T>(val baseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {


    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }

}
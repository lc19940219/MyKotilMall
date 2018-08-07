package com.example.baselibrary.rx

import rx.Subscriber

/**
 * Created by lc on 2018/8/7.
 */
open class BaseSubscribe<T> : Subscriber<T>() {
    override fun onNext(t: T) {


    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }

}
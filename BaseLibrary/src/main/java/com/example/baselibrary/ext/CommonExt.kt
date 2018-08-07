package com.example.baselibrary.ext

import com.example.baselibrary.rx.BaseSubscribe
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by lc on 2018/8/7.
 */

    fun <T> Observable<T>.execute(subscriber: BaseSubscribe<T>) {
        this.subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)

    }

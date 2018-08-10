package com.example.baselibrary.ext

import com.example.baselibrary.rx.BaseSubscribe
import com.trello.rxlifecycle.LifecycleProvider
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by lc on 2018/8/7.
 */

fun <T> Observable<T>.execute(subscriber: BaseSubscribe<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.subscribeOn(rx.schedulers.Schedulers.io())
            .compose(lifecycleProvider.bindToLifecycle())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(subscriber)

}

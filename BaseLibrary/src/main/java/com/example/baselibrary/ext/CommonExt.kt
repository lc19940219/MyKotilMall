package com.example.baselibrary.ext

import android.view.View
import com.example.baselibrary.date.protocol.BaseResp
import com.example.baselibrary.rx.BaseFunc
import com.example.baselibrary.rx.BaseFuncToBoolean
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

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
    return this.flatMap(BaseFunc())

}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncToBoolean())

}

/*
  扩展点击事件
*/
fun View.click(listener: View.OnClickListener) {
    setOnClickListener(listener)

}

/*
    扩展点击事件，参数为方法
 */
fun View.click(method: () -> Unit) {
    setOnClickListener { method() }

}
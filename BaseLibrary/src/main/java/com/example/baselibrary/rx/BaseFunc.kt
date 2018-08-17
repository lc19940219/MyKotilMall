package com.example.baselibrary.rx

import com.example.baselibrary.date.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by lc on 2018/8/17.
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }

}
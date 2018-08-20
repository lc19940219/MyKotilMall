package com.example.baselibrary.rx

import com.example.baselibrary.date.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by lc on 2018/8/17.
 */
class BaseFuncToBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {
    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != 0) {
//            return Observable.error(BaseException(t.status, t.message))
            return Observable.just(false)
        }
        return Observable.just(true)
    }

}
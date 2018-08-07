package com.example.usercenter.service.impl

import com.example.usercenter.service.UserService
import rx.Observable

/**
 * Created by lc on 2018/8/7.
 */
 class UserServiceImp : UserService {
    override fun login(mobile: String, pwd: String, pushId: String): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }

}
package com.example.usercenter.service.impl

import com.example.baselibrary.date.protocol.BaseResp
import com.example.baselibrary.rx.BaseException
import com.example.usercenter.respository.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * Created by lc on 2018/8/7.
 */
class UserServiceImp @Inject constructor() : UserService {
   @Inject
    lateinit var userRepository: UserRepository
    override fun login(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return Observable.just(true)
    }

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
//        val userRepository = UserRepository()
        return userRepository.regist(mobile, pwd, verifyCode).flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
            override fun call(t: BaseResp<String>): Observable<Boolean> {
                if (t.status != 0) {
                    return Observable.error(BaseException(t.status, t.message))
                }
                return Observable.just(true)
            }

        })
    }

}
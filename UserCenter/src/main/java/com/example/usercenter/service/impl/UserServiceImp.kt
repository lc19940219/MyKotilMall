package com.example.usercenter.service.impl

import com.example.baselibrary.ext.convertBoolean
import com.example.usercenter.respository.UserRepository
import com.example.usercenter.service.UserService
import rx.Observable
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
        return userRepository.regist(mobile, pwd, verifyCode)
                .convertBoolean()
    }

}
package com.example.usercenter.service

import rx.Observable


/**
 * Created by lc on 2018/8/7.
 */
interface UserService {
    //用户注册
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean>

}
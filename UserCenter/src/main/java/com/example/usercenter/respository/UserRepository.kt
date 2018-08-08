package com.example.usercenter.respository

import com.example.baselibrary.date.net.RetrofitFactory
import com.example.baselibrary.date.protocol.BaseResp
import com.example.usercenter.api.UserApi
import com.example.usercenter.protocal.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * Created by lc on 2018/8/8.
 */
class UserRepository @Inject constructor() {

    fun regist(mobile: String, pwd: String, verifyCode: String): Observable<BaseResp<String>> {
        return RetrofitFactory.instances.createService(UserApi::class.java)
                .register(RegisterReq(mobile, pwd, verifyCode))

    }
}
package com.example.usercenter.api

import com.example.baselibrary.date.protocol.BaseResp
import com.example.usercenter.protocal.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by lc on 2018/8/8.
 */
interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}
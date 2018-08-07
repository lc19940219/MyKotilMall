package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscribe
import com.example.usercenter.presenter.view.RegistView
import com.example.usercenter.service.impl.UserServiceImp

/**
 * Created by lc on 2018/8/6.
 */
class RegistPresenter : BasePresenter<RegistView>() {

    fun regist(mobile: String, verifyCode: String, pwd: String) {

        var userService = UserServiceImp()
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscribe<Boolean>() {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        mView.onRegistResult(t)
                    }
                })


    }
}
package com.example.usercenter.presenter

import com.example.baselibrary.ext.execute
import com.example.baselibrary.precenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscribe
import com.example.usercenter.presenter.view.RegistView
import com.example.usercenter.service.impl.UserServiceImp
import javax.inject.Inject

/**
 * Created by lc on 2018/8/6.
 */
class RegistPresenter @Inject constructor() : BasePresenter<RegistView>() {
    @Inject
    lateinit var userService: UserServiceImp

    fun regist(mobile: String, verifyCode: String, pwd: String) {

//        var userService = UserServiceImp()
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        userService.register(mobile, pwd, verifyCode)
                .execute(object : BaseSubscribe<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if (t) {
                            mView.onRegistResult("注册成功")
                        } else {
                            mView.onRegistResult("注册失败")
                        }

                    }
                }, lifecycleProvider)


    }
}
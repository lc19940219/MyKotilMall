package com.example.usercenter.presenter

import com.example.baselibrary.precenter.BasePresenter
import com.example.usercenter.presenter.view.RegistView
import com.example.usercenter.service.impl.UserServiceImp
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by lc on 2018/8/6.
 */
class RegistPresenter : BasePresenter<RegistView>() {

    fun regist(mobile: String, verifyCode: String, pwd: String) {

        var userService = UserServiceImp()
        userService.register(mobile, pwd, verifyCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegistResult(t)

                    }

                    override fun onCompleted() {
                    }

                    override fun onError(e: Throwable?) {
                    }

                })

    }
}
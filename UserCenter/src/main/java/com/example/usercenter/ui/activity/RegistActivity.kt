package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.ui.activity.BaseMVPActivity
import com.example.usercenter.R
import com.example.usercenter.injection.compontent.DaggerUserCompontent
import com.example.usercenter.injection.moudle.UserModule
import com.example.usercenter.presenter.RegistPresenter
import com.example.usercenter.presenter.view.RegistView
import kotlinx.android.synthetic.main.activity_regist.*
import org.jetbrains.anko.toast

class RegistActivity : BaseMVPActivity<RegistPresenter>(), RegistView {
    override fun onRegistResult(isok: Boolean) {
        if (isok) {
            toast("成功")
        } else {
            toast("失败")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        // presenter = RegistPresenter()

        initInjection()

        mRegistBtn.setOnClickListener {
            presenter.regist(mMobile.toString(),
                    mVerifyCode.toString(),
                    mPw.toString())

//            presenter.regist("123456",
//                    "123456",
//                    "123456")
        }

    }

    private fun initInjection() {
        DaggerUserCompontent.builder().userModule(UserModule()).build().inject(this)
        presenter.mView = this
    }
}

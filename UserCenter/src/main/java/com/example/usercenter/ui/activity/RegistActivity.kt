package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.ext.click
import com.example.baselibrary.ui.activity.BaseMVPActivity
import com.example.usercenter.R
import com.example.usercenter.injection.compontent.DaggerUserCompontent
import com.example.usercenter.injection.moudle.UserModule
import com.example.usercenter.presenter.RegistPresenter
import com.example.usercenter.presenter.view.RegistView
import kotlinx.android.synthetic.main.activity_regist.*
import org.jetbrains.anko.toast

class RegistActivity : BaseMVPActivity<RegistPresenter>(), RegistView {
    override fun initComponent() {
        DaggerUserCompontent.builder()
                .activityCompontent(activityCompontent)
                .userModule(UserModule())
                .build().inject(this)
        presenter.mView = this
    }

    override fun onRegistResult(isok: String) {
        toast(isok)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)

        mRegistBtn.click {
            presenter.regist(mMobile.toString(),
                    mVerifyCode.toString(),
                    mPw.toString())
        }
    }


}

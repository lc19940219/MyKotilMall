package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.AppManager
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

    private var pressTime: Long = 0

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
            presenter.regist(mMobile.text.toString(),
                    mVerifyCode.text.toString(),
                    mPw.text.toString())
        }
        verifybutton.click { verifybutton.requestSendVerifyNumber() }

    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()

        if (time - pressTime > 2000) {
            toast("再按一次退出")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

}

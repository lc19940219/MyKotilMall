package com.example.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.example.baselibrary.common.AppManager
import com.example.baselibrary.ext.click
import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMVPActivity
import com.example.usercenter.R
import com.example.usercenter.injection.compontent.DaggerUserCompontent
import com.example.usercenter.injection.moudle.UserModule
import com.example.usercenter.presenter.RegistPresenter
import com.example.usercenter.presenter.view.RegistView
import kotlinx.android.synthetic.main.activity_regist.*
import org.jetbrains.anko.toast

class RegistActivity : BaseMVPActivity<RegistPresenter>(), RegistView, View.OnClickListener {
    override fun onClick(v: View) {
        when (v.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                toast("发送验证成功")
            }
            R.id.mRegisterBtn -> {
                presenter.regist(mMobileEt.text.toString(),  mVerifyCodeEt.text.toString(),mPwdEt.text.toString())
            }
        }
    }

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
        initview()


    }

    private fun initview() {

        mRegisterBtn.enable(mMobileEt, { isBtnEnable() })
        mRegisterBtn.enable(mVerifyCodeEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdEt, { isBtnEnable() })
        mRegisterBtn.enable(mPwdConfirmEt, { isBtnEnable() })

        mVerifyCodeBtn.click(this)
        mRegisterBtn.click(this)

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

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }
}

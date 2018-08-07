package com.example.usercenter.ui.activity

import android.os.Bundle
import com.example.baselibrary.ui.activity.BaseMVPActivity
import com.example.usercenter.R
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
        presenter = RegistPresenter()
        presenter.mView = this
        mRegistBtn.setOnClickListener {
            presenter.regist("123", "123","13")
        }

    }
}

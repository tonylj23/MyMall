package com.lj.usercenter.ui.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lj.baselibrary.ext.onClick
import com.lj.baselibrary.injection.component.ActivityComponent
import com.lj.baselibrary.ui.activity.BaseMvpActivity
import com.lj.baselibrary.wdigets.VerifyButton
import com.lj.usercenter.R
import com.lj.usercenter.injection.component.DaggerUserComponent
import com.lj.usercenter.injection.module.UserModule
import com.lj.usercenter.presenter.RegisterPresenter
import com.lj.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity:BaseMvpActivity<RegisterPresenter>(),RegisterView {
    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView=this
    }

    override fun onRegisterResult(result: Boolean) {

        toast("注册成功::${result.toString()}")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mRegisterBtn.onClick{ mPresenter.register(mobileTxt.text.toString(),mPwd.text.toString(),mCode.text.toString()) }
        verifyButton.setOnVerifyBtnClick(object :VerifyButton.OnVerifyBtnClick{
            override fun onClick() {
                toast("点击获取验证码")
            }
        })
        verifyButton.onClick {
            verifyButton.requestSendVerifyNumber()
        }

    }

}
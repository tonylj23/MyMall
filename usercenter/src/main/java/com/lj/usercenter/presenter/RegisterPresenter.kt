package com.lj.usercenter.presenter

import com.lj.baselibrary.ext.execute
import com.lj.baselibrary.presenter.BasePresenter
import com.lj.baselibrary.rx.BaseSubscriber
import com.lj.usercenter.presenter.view.RegisterView
import com.lj.usercenter.service.impl.UserServiceImpl
import javax.inject.Inject

class RegisterPresenter @Inject constructor():BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserServiceImpl

    fun register(mobile:String,password:String,verifyCode:String){
        if(!checkNetWork()){
            mView.onError("网络不可用")
            return
        }
        mView.showLoading()
        userService.register(mobile,verifyCode,password)
            .execute(object :BaseSubscriber<Boolean>(mView){
                override fun onNext(t: Boolean) {
                    super.onNext(t)
                    mView.onRegisterResult(t)
                }

                override fun onError(e: Throwable?) {
                    super.onError(e)
                }
            },lifecycleProvider)
//        userService.register(mobile,verifyCode,password)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(object :Subscriber<Boolean>(){
//                override fun onNext(t: Boolean?) {
////                    mView.onRegisterResult(true)
//                }
//
//                override fun onCompleted() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onError(e: Throwable?) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//            })

    }
}
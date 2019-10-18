package com.lj.baselibrary.rx

import com.lj.baselibrary.presenter.view.BaseView
import rx.Subscriber

open class BaseSubscriber<T>(val baseView:BaseView):Subscriber<T>() {
    override fun onNext(t: T) {


    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }

}
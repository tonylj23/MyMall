package com.lj.baselibrary.presenter

import android.content.Context
import com.lj.baselibrary.presenter.view.BaseView
import com.lj.baselibrary.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T:BaseView> {
    lateinit var mView:T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork():Boolean{
        return NetWorkUtils.isNetWorkAvailable(context)
    }
}
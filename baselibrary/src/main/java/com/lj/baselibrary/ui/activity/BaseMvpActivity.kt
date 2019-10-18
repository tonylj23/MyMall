package com.lj.baselibrary.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.lj.baselibrary.common.BaseApplication
import com.lj.baselibrary.injection.component.ActivityComponent
import com.lj.baselibrary.injection.component.AppComponent
import com.lj.baselibrary.injection.component.DaggerActivityComponent
import com.lj.baselibrary.injection.module.ActivityModule
import com.lj.baselibrary.injection.module.LifecycleProviderModule
import com.lj.baselibrary.presenter.BasePresenter
import com.lj.baselibrary.presenter.view.BaseView
import com.lj.baselibrary.wdigets.ProgressDialog
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(),BaseView{
    override fun showLoading() {
        loadingProgressDialog.showLoading()
    }

    override fun hideLoading() {
        loadingProgressDialog.hideLoading()
    }

    override fun onError(msg:String) {
        toast(msg)
    }
    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent:ActivityComponent
    lateinit var loadingProgressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        loadingProgressDialog= ProgressDialog.create(this)

    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
            .activityModule(
                ActivityModule(this)
            ).lifecycleProviderModule(LifecycleProviderModule(this)).build()
    }

}

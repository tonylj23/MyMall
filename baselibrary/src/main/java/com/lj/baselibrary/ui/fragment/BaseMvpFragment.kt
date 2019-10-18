package com.lj.baselibrary.ui.fragment

import android.os.Bundle
import com.lj.baselibrary.common.BaseApplication
import com.lj.baselibrary.injection.component.ActivityComponent
import com.lj.baselibrary.injection.component.DaggerActivityComponent
import com.lj.baselibrary.injection.module.ActivityModule
import com.lj.baselibrary.injection.module.LifecycleProviderModule
import com.lj.baselibrary.presenter.BasePresenter
import com.lj.baselibrary.presenter.view.BaseView
import javax.inject.Inject

abstract class BaseMvpFragment<T: BasePresenter<*>>: BaseFragment(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(msg:String) {
    }
    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectComponent()
        initActivityInjection()
    }

    abstract fun injectComponent()

    private fun initActivityInjection() {
        activity?.let {
            activityComponent = DaggerActivityComponent.builder().appComponent((it.application as BaseApplication).appComponent)
                .activityModule(
                    ActivityModule(it)
                ).lifecycleProviderModule(LifecycleProviderModule(this)).build()
        }

    }

}
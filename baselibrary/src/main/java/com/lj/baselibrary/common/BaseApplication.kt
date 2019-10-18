package com.lj.baselibrary.common

import android.app.Application
import android.content.Context
import com.lj.baselibrary.injection.component.AppComponent
import com.lj.baselibrary.injection.component.DaggerAppComponent
import com.lj.baselibrary.injection.module.AppModule

class BaseApplication:Application() {

    lateinit var appComponent:AppComponent
    override fun onCreate() {
        super.onCreate()

        initInjection()

        context=this
    }

    private fun initInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
    companion object{
        lateinit var context:Context
    }
}
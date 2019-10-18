package com.lj.baselibrary.injection.component

import android.content.Context
import com.lj.baselibrary.injection.module.AppModule
import com.lj.baselibrary.injection.module.LifecycleProviderModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,LifecycleProviderModule::class))
interface AppComponent {
    fun context():Context
}
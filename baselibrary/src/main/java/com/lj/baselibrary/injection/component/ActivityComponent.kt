package com.lj.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.lj.baselibrary.injection.ActivityScope
import com.lj.baselibrary.injection.module.ActivityModule
import com.lj.baselibrary.injection.module.AppModule
import com.lj.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent {
    fun activity():Activity
    fun context():Context
    fun lifecycleProvider():LifecycleProvider<*>

}
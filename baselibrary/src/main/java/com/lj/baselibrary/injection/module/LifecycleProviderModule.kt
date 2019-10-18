package com.lj.baselibrary.injection.module

import android.app.Activity
import android.content.Context
import com.lj.baselibrary.common.BaseApplication
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @Provides
    fun providesLifecycle():LifecycleProvider<*>{
        return lifecycleProvider
    }
}
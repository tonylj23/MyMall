package com.lj.usercenter.injection.component

import com.lj.baselibrary.injection.component.ActivityComponent
import com.lj.baselibrary.injection.module.PerComponentScope
import com.lj.usercenter.injection.module.UserModule
import com.lj.usercenter.ui.activity.RegisterActivity
import dagger.Component

@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity:RegisterActivity)
}
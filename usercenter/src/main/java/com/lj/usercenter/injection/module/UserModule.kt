package com.lj.usercenter.injection.module

import com.lj.usercenter.service.UserService
import com.lj.usercenter.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {
    @Provides
    fun providesUserService(service: UserServiceImpl):UserService{
        return service
    }
}
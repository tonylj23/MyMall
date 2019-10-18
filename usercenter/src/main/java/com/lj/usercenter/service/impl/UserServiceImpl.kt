package com.lj.usercenter.service.impl

import com.lj.baselibrary.data.protocol.BaseResp
import com.lj.baselibrary.ext.BaseException
import com.lj.baselibrary.ext.BaseFunBoolean
import com.lj.baselibrary.ext.convertBoolean
import com.lj.usercenter.data.repository.UserRepository
import com.lj.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

class UserServiceImpl @Inject constructor(): UserService {
    @Inject
    lateinit var userRepository :UserRepository
    override fun register(mobile: String, userPwd: String, verifyCode: String): Observable<Boolean> {


       return userRepository.register(mobile, userPwd, verifyCode).convertBoolean()
    }
}
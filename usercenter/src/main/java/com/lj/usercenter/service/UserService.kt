package com.lj.usercenter.service

import rx.Observable

interface UserService {
    fun register(mobile:String,code:String,password:String): Observable<Boolean>
}
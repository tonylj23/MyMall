package com.lj.usercenter.data.repository

import com.lj.baselibrary.data.net.RetrofitFactory
import com.lj.baselibrary.data.protocol.BaseResp
import com.lj.usercenter.data.api.UserApi
import com.lj.usercenter.data.protocol.RegisterReq
import retrofit2.Response
import rx.Observable
import javax.inject.Inject

class UserRepository @Inject constructor(){
    fun register(mobile:String,pwd:String,code:String):Observable<BaseResp<String>>{
        return  RetrofitFactory.retrofitFactory.create(UserApi::class.java)
            .register(RegisterReq(mobile,pwd,code))
    }
}
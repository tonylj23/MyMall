package com.lj.usercenter.data.api

import com.lj.baselibrary.data.protocol.BaseResp
import com.lj.usercenter.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserApi {
    @POST("userCenter/register")
    fun register(@Body req: RegisterReq):Observable<BaseResp<String>>
}
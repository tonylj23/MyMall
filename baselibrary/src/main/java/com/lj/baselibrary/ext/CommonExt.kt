package com.lj.baselibrary.ext

import android.view.View
import com.lj.baselibrary.data.protocol.BaseResp
import com.lj.baselibrary.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import com.trello.rxlifecycle.kotlin.bindToLifecycle
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun <T> Observable<T>.execute(subscriber : BaseSubscriber<T>,lifecycleProvider: LifecycleProvider<*>){

    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}

fun View.onClick(listener:View.OnClickListener){
    setOnClickListener(listener)
}

fun View.onClick(method:()->Unit){
    this.setOnClickListener{method()}
}

fun <T> Observable<BaseResp<T>>.convert():Observable<T>{
    return this.flatMap(BaseFun())
}

fun <T> Observable<BaseResp<T>>.convertBoolean():Observable<Boolean>{
    return this.flatMap(BaseFunBoolean())
}
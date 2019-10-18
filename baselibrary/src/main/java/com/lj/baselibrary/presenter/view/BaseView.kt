package com.lj.baselibrary.presenter.view

interface BaseView{
    fun showLoading()
    fun hideLoading()
    fun onError(msg:String)
}
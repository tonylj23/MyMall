package com.lj.baselibrary.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.lj.baselibrary.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import org.jetbrains.anko.toast

open class BaseActivity:RxAppCompatActivity() {


    private var pressTime:Long=0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.appManagerIntence.addActivity(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.appManagerIntence.finishActivity(this)
    }

    override fun onBackPressed() {
        var curTime=System.currentTimeMillis()
        if(curTime-pressTime>2000){
            toast("再按一次退出应用")
            pressTime=curTime
        }else{
            AppManager.appManagerIntence.exitApp(this)
        }
    }
}
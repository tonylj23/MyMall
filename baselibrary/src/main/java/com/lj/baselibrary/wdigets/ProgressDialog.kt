package com.lj.baselibrary.wdigets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.lj.baselibrary.R
import org.jetbrains.anko.find

class ProgressDialog private constructor(context: Context, themeResId: Int) : Dialog(context, themeResId) {


    companion object{
        lateinit var myProgressDialog:ProgressDialog
        lateinit var animDrawable:AnimationDrawable
        fun create(context: Context):ProgressDialog{
            myProgressDialog= ProgressDialog(context, R.style.LightProgressDialog)
            myProgressDialog.setContentView(R.layout.progress_dialog)
            myProgressDialog.setCanceledOnTouchOutside(false)
            myProgressDialog.setCancelable(true)
            myProgressDialog.window.attributes.gravity=Gravity.CENTER

            val la= myProgressDialog.window.attributes
            la.dimAmount=0.2f
            myProgressDialog.window.attributes=la

            val imageView = myProgressDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = imageView.background as AnimationDrawable

            return myProgressDialog
        }



    }

    fun showLoading(){
        super.show()
        animDrawable?.start()
    }
    fun hideLoading(){
        super.hide()
        animDrawable?.stop()
    }


}
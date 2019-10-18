package com.lj.baselibrary.wdigets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.lj.baselibrary.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

class HeaderBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var showBack=true
    var leftText:String?=null
    var rightText:String?=null
    init {
        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.HeaderBar)
        showBack = typedArray.getBoolean(R.styleable.HeaderBar_isShowBack, true)
        leftText = typedArray.getString(R.styleable.HeaderBar_leftText)
        rightText = typedArray.getString(R.styleable.HeaderBar_rightText)
        typedArray.recycle()
        initViews()
    }

    private fun initViews(){
        View.inflate(context,R.layout.layout_header_bar,this)

        mLeftIv.visibility=if(showBack) View.VISIBLE else View.GONE

        leftText?.let {
            mTitleTv.text=it
        }
        rightText?.let {
            mRightTv.text=it
            mRightTv.visibility= View.VISIBLE
        }
    }

}
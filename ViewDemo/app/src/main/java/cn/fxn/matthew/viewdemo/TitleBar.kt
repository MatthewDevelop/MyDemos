package cn.fxn.matthew.viewdemo

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

/**
 * @author:Matthew
 * @date:2018/7/19
 * @email:guocheng0816@163.com
 * @func:
 */
class TitleBar : RelativeLayout {

    private lateinit var typedArray: TypedArray
    private var mLeftTextColor: Int = 0
    private var mLeftBackground: Drawable? = null
    private var mLeftText: String = ""
    private var mRightTextColor: Int = 0
    private var mRightBackground: Drawable? = null
    private var mRightText: String = ""
    private var mTitleText: String = ""
    private var mTitleTextColor: Int = 0
    private var mTitleTextSize: Float = 0f
    private lateinit var mLeftButton: Button
    private lateinit var mRightButton: Button
    private lateinit var mTitleTextView: TextView
    private lateinit var mLeftParams: RelativeLayout.LayoutParams
    private lateinit var mRightParams: RelativeLayout.LayoutParams
    private lateinit var mTitleParams: RelativeLayout.LayoutParams
    private var mTitleBarClickListener: TitleBarClickListener? = null

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs(context, attrs)
        initView(context)
    }


    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initAttrs(context, attrs)
        initView(context)
    }


    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        //将xml中定义的属性存储到typeArray中
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar)
        //从typeArray取出对应的属性值
        mLeftTextColor = typedArray.getColor(R.styleable.TitleBar_leftTextColor, 0)
        mLeftBackground = typedArray.getDrawable(R.styleable.TitleBar_leftBackground)
        mLeftText = typedArray.getString(R.styleable.TitleBar_leftText)
        mRightTextColor = typedArray.getColor(R.styleable.TitleBar_rightTextColor, 0)
        mRightBackground = typedArray.getDrawable(R.styleable.TitleBar_rightBackground)
        mRightText = typedArray.getString(R.styleable.TitleBar_rightText)
        mTitleText = typedArray.getString(R.styleable.TitleBar_titleText)
        System.out.println("----->$mTitleText")
        mTitleTextColor = typedArray.getColor(R.styleable.TitleBar_titleTextColor, 0)
        System.out.println("----->$mTitleTextColor")
        //getDimension取到的是px值,直接设置textSize会导致字体放大
        mTitleTextSize = typedArray.getDimension(R.styleable.TitleBar_titleTextSize, 0f)
        System.out.println("----->$mTitleTextSize")
        typedArray.recycle()
    }

    private fun initView(context: Context) {
        mLeftButton = Button(context)
        mRightButton = Button(context)
        mTitleTextView = TextView(context)

        //为创建的组件赋值
        mLeftButton.text = mLeftText
        mLeftButton.setTextColor(mLeftTextColor)
        mRightButton.text = mRightText
        mRightButton.setTextColor(mRightTextColor)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mLeftButton.background = mLeftBackground
            mRightButton.background = mRightBackground
        }

        mTitleTextView.text = mTitleText
//        mTitleTextView!!.textSize = mTitleTextSize  默认设置textSize是按照sp为单位来设置的
        mTitleTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTitleTextSize)
        mTitleTextView.setTextColor(mTitleTextColor)
        mTitleTextView.gravity = Gravity.CENTER

        //为组件元素设置响应的布局元素
        mLeftParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE)
        addView(mLeftButton, mLeftParams)

        mRightParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE)
        addView(mRightButton, mRightParams)

        mTitleParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE)
        addView(mTitleTextView, mTitleParams)

        mLeftButton.setOnClickListener { let { mTitleBarClickListener?.leftClick() } }
        mRightButton.setOnClickListener { let { mTitleBarClickListener?.rightClick() } }
    }

    /**
     *设置点击事件
     */
    fun setOnTitleBarClickListener(titleBarClickListener: TitleBarClickListener) {
        mTitleBarClickListener = titleBarClickListener
    }

    /**
     * 点击事件回调接口
     */
    interface TitleBarClickListener {
        abstract fun leftClick()
        abstract fun rightClick()
    }

    /**
     * 设置按钮可见性
     */
    fun setButtonVisiable(id: Int, flag: Boolean) {
        if (flag) {
            if (id == 0) {
                mLeftButton.visibility = View.VISIBLE
            } else {
                mRightButton.visibility = View.VISIBLE
            }
        } else {
            if (id == 0) {
                mLeftButton.visibility = View.GONE
            } else {
                mRightButton.visibility = View.GONE
            }
        }
    }


}
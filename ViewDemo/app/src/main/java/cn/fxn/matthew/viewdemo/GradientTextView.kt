package cn.fxn.matthew.viewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet

/**
 * @author:Matthew
 * @date:2018/7/18
 * @email:guocheng0816@163.com
 * @func:
 */
class GradientTextView : android.support.v7.widget.AppCompatTextView {
    private var viewWidth = 0
    private var mPaint: Paint? = null
    private var mLinearGradient: LinearGradient? = null
    private var mMatrix: Matrix? = null
    private var mTranslate: Int = 0


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (viewWidth == 0) {
            viewWidth = measuredWidth
            if (viewWidth > 0) {
                mPaint = paint
                mLinearGradient = LinearGradient(0f,  0f,
                        viewWidth.toFloat(),0f,
                        intArrayOf(Color.BLUE, Color.GREEN,Color.RED, Color.BLUE),
                        /*floatArrayOf(0f,0.3f,1.0f,1.5f)*/null, Shader.TileMode.CLAMP)
                mPaint!!.shader = mLinearGradient
                mMatrix = Matrix()
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mLinearGradient != null) {
            mTranslate += viewWidth / 6
            if (mTranslate > 2 * viewWidth) {
                mTranslate = -viewWidth
            }
            mMatrix!!.setTranslate(mTranslate.toFloat(), 0f)
            mLinearGradient!!.setLocalMatrix(mMatrix)
            postInvalidateDelayed(100)
        }
    }
}

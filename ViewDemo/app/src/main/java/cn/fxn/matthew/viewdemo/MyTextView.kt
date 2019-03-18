package cn.fxn.matthew.viewdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

/**
 * @author:Matthew
 * @date:2018/7/18
 * @email:guocheng0816@163.com
 * @func:
 */
class MyTextView : android.support.v7.widget.AppCompatTextView {

    private var paint1: Paint = Paint()
    private var paint2: Paint = Paint()

    constructor(context: Context) : super(context) {
        paint1.color = resources.getColor(android.R.color.holo_blue_light)
        paint1.style = Paint.Style.FILL
        paint2.color = Color.YELLOW
        paint2.style = Paint.Style.FILL
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        paint1.color = resources.getColor(android.R.color.holo_blue_light)
        paint1.style = Paint.Style.FILL
        paint2.color = Color.YELLOW
        paint2.style = Paint.Style.FILL
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        paint1.color = resources.getColor(android.R.color.holo_blue_light)
        paint1.style=Paint.Style.FILL
        paint2.color=Color.YELLOW
        paint2.style=Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawRect(0F,0F, measuredWidth.toFloat(), measuredHeight.toFloat(),paint1)
        canvas?.drawRect(10F,10F,measuredWidth.toFloat()-10,measuredHeight.toFloat()-10,paint2)
        canvas?.save()
        canvas?.translate(10F,0F)
        super.onDraw(canvas)
        canvas?.restore()
    }
}

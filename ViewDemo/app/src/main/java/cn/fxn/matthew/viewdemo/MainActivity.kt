package cn.fxn.matthew.viewdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.fxn.matthew.viewdemo.extensions.ctx
import kotlinx.android.synthetic.main.top_bar.*

class MainActivity : AppCompatActivity() {

//    private lateinit var mTitleBar: TitleBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//       mTitleBar=findViewById(R.id.top_bar)
        top_bar.setOnTitleBarClickListener(object :TitleBar.TitleBarClickListener{
            override fun leftClick() {
                //do nothing
            }

            override fun rightClick() {
                val intent= Intent()
                intent.setClass(top_bar.ctx,WeatherActivity::class.java)
                startActivity(intent)
            }

        } )
    }
}

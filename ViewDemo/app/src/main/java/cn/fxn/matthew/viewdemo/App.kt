package cn.fxn.matthew.viewdemo

import android.app.Application
import kotlin.properties.Delegates

/**
 * @author:Matthew
 * @date:2018/7/25
 * @email:guocheng0816@163.com
 * @func:
 */
class App : Application() {
    companion object {
        //        private var instance: Application? = null
//        fun instance() = instance!!
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
package cn.fxn.matthew.viewdemo

import android.util.Log
import cn.fxn.matthew.viewdemo.data.server.ForeCastResult
import com.google.gson.Gson
import java.net.URL

/**
 * @author:Matthew
 * @date:2018/7/24
 * @email:guocheng0816@163.com
 * @func:
 */
class ForecastRequest(val zipCode:String){

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
        "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }
    fun execute(): ForeCastResult {
        val forecastJsonString= URL(COMPLETE_URL+zipCode).readText()
        Log.e(javaClass.name,forecastJsonString)
        return Gson().fromJson(forecastJsonString, ForeCastResult::class.java)
    }
}
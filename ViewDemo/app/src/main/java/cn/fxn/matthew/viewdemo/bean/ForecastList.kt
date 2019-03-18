package cn.fxn.matthew.viewdemo.bean

/**
 * @author:Matthew
 * @date:2018/7/24
 * @email:guocheng0816@163.com
 * @func:
 */

data class ForecastList(val _id: Long, val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {

    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size(): Int = dailyForecast.size
}
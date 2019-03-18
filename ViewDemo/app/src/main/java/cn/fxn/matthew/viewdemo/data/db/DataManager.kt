package cn.fxn.matthew.viewdemo.data.db

import cn.fxn.matthew.viewdemo.bean.Forecast
import cn.fxn.matthew.viewdemo.bean.ForecastList

/**
 * @author:Matthew
 * @date:2018/7/27
 * @email:guocheng0816@163.com
 * @func:
 */
class DataManager {
    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(
            dayForecast) {
        Forecast(date, description, high, low, iconUrl)
    }


    fun convertFromDomain(forecastList: ForecastList) = with(forecastList) {
        val daily = dailyForecast.map {
            convertDayFromDomain(_id, it)
        }
        CityForecast(_id, city, country, daily)
    }

    private fun convertDayFromDomain(id: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, id)
    }
}
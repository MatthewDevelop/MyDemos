package cn.fxn.matthew.viewdemo

import cn.fxn.matthew.viewdemo.data.server.ForeCastResult
import cn.fxn.matthew.viewdemo.bean.Forecast as ModelForecast
import cn.fxn.matthew.viewdemo.bean.ForecastList
import cn.fxn.matthew.viewdemo.data.server.ForecastDetail
import java.text.DateFormat
import java.util.*

class ForecastDataManager {

    fun convertFromDataModel(zipCode:Long,forecast: ForeCastResult): ForecastList {
        return ForecastList(zipCode,forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<ForecastDetail>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecastDetail: ForecastDetail):
            ModelForecast {
        return ModelForecast(forecastDetail.dt,
                forecastDetail.weather[0].description, forecastDetail.temp.max.toInt(),
                forecastDetail.temp.min.toInt(),generateIconUrl(forecastDetail.weather[0].icon))
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}
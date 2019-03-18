package cn.fxn.matthew.viewdemo.data.db

/**
 * @author:Matthew
 * @date:2018/8/2
 * @email:guocheng0816@163.com
 * @func:
 */
object DayForecastTable {
    val NAME = "DayForecast"
    val ID = "_id"
    val DATE = "date"
    val DESCRIPTION = "description"
    val HIGH = "high"
    val LOW = "low"
    val ICON_URL = "iconUrl"
    val CITY_ID = "cityId"
}

object CityForecastTable {
    val NAME = "CityForecast"
    val ID = "_id"
    val CITY = "city"
    val COUNTYR = "country"
}
package cn.fxn.matthew.viewdemo.data.db

import cn.fxn.matthew.viewdemo.bean.ForecastList
import cn.fxn.matthew.viewdemo.extensions.clear
import cn.fxn.matthew.viewdemo.extensions.parseList
import cn.fxn.matthew.viewdemo.extensions.parseOpt
import org.jetbrains.anko.db.select


/**
 * @author:Matthew
 * @date:2018/7/26
 * @email:guocheng0816@163.com
 * @func:
 */
class ForecastDb(val forecastDbHelper: ForecastDbHelper = ForecastDbHelper.instance,
                 val dataManager: DataManager = DataManager()) {
    fun requestForecastByZipCode(zipCode: Long, date: Long) = forecastDbHelper.use {
        val dailyRequest = "${DayForecastTable.CITY_ID}=? AND ${DayForecastTable.DATE}>=?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(), date.toString())
                .parseList { DayForecast(HashMap(it)) }

        val city = select(CityForecastTable.NAME)
                .whereSimple("${CityForecastTable.ID}=?", zipCode.toString())
                .parseOpt { CityForecast(HashMap(it), dailyForecast) }

        if (city != null) dataManager.convertToDomain(city) else null
    }

    fun saveForecast(forecastList: ForecastList) = forecastDbHelper.use {
        clear(DayForecastTable.NAME)
        clear(CityForecastTable.NAME)
        with(dataManager.convertFromDomain(forecastList)){

        }
    }
}
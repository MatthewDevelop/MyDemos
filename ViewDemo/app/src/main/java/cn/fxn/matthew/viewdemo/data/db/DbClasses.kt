package cn.fxn.matthew.viewdemo.data.db


/**
 * @author:Matthew
 * @date:2018/8/2
 * @email:guocheng0816@163.com
 * @func:
 */
class CityForecast(var map: MutableMap<String, Any?>, var dailyForecast: List<DayForecast>) {
    var _id: Long by map
    var city: String by map
    var country: String by map

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>)
            : this(HashMap(), dailyForecast) {
        this._id = id
        this.city = city
        this.country = country
        this.dailyForecast = dailyForecast
    }
}

class DayForecast(map: MutableMap<String, Any?>) {
    var id: Long by map
    var date: Long by map
    var description: String by map
    var high: Int by map
    var low: Int by map
    var iconUrl: String by map
    var cityId: Long by map

    constructor(date: Long, description: String, high: Int, low: Int, iconUrl: String, cityId: Long)
            : this(HashMap()) {
        this.date = date
        this.description = description
        this.high = high
        this.low = low
        this.iconUrl = iconUrl
        this.cityId = cityId
    }
}
package cn.fxn.matthew.viewdemo.data.server

/**
 * @author:Matthew
 * @date:2018/8/2
 * @email:guocheng0816@163.com
 * @func:
 */
data class Temperature(val day: Float, val min: Float,
                       val max: Float, val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)

data class ForecastDetail(val dt: Long, val temp: Temperature, val pressure: Float,
                          val humidity: Int, val weather: List<Weather>,
                          val speed: Float, val deg: Int, val clouds: Int,
                          val rain: Float)

data class Coordinates(val lon: Float, val lat: Float)

data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)

data class ForeCastResult(val city: City, val list: List<ForecastDetail>)
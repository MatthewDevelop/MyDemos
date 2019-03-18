package cn.fxn.matthew.viewdemo.bean

data class Forecast(val date: Long, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)
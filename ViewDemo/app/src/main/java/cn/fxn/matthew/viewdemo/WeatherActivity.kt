package cn.fxn.matthew.viewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.fxn.matthew.viewdemo.bean.Forecast
import kotlinx.android.synthetic.main.item_forecast.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_weather.*

/**
 * @author:Matthew
 * @date:2018/7/21
 * @email:guocheng0816@163.com
 * @func:
 */
class WeatherActivity : AppCompatActivity() {

    /*private val weatherList = listOf("Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
//        val forecastList = findViewById<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        doAsync {
            val result = RequestForecastListCommand("94043").execute()
            uiThread {
                forecastList.adapter = ForecastListAdapter(result /*object : ForecastListAdapter.OnItemClickListener {
                    override fun invoke(forecast: Forecast) {
                        toast(forecast.date)
                    }
                }*/) { toast(it.date) }
            }
        }
    }


}
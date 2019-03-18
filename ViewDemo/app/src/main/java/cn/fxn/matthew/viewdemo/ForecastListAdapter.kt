package cn.fxn.matthew.viewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.fxn.matthew.viewdemo.bean.Forecast
import cn.fxn.matthew.viewdemo.bean.ForecastList
import cn.fxn.matthew.viewdemo.extensions.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * @author:Matthew
 * @date:2018/7/21
 * @email:guocheng0816@163.com
 * @func:
 */
class ForecastListAdapter(private val weekForecast: ForecastList, /*private val itemClickListener: OnItemClickListener*/
                          private val itemClickListener: (Forecast) -> Unit) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    /*interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }*/

    class ViewHolder(val view: View, /*val itemClickListener: OnItemClickListener*/
                     private val itemClickListener: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = date
                itemView.description.text = description
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
                itemView.setOnClickListener {
                    itemClickListener(forecast)
                }
            }
        }

    }
}

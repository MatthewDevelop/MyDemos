package cn.fxn.matthew.viewdemo

import cn.fxn.matthew.viewdemo.bean.ForecastList

/**
 * @author:Matthew
 * @date:2018/7/24
 * @email:guocheng0816@163.com
 * @func:
 */
class RequestForecastListCommand(private val zipCode: String) : Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataManager().convertFromDataModel(forecastRequest.execute())
    }

}
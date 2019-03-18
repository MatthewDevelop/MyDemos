package cn.fxn.matthew.viewdemo.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import cn.fxn.matthew.viewdemo.App
import org.jetbrains.anko.db.*

/**
 * @author:Matthew
 * @date:2018/7/26
 * @email:guocheng0816@163.com
 * @func:
 */
class ForecastDbHelper(context: Context=App.instance) : ManagedSQLiteOpenHelper(context,
        DB_NAME, null, DB_VERSION) {

    companion object {
        const val DB_NAME = "forecast.db"
        const val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(CityForecastTable.NAME, true,
                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
                Pair(CityForecastTable.COUNTYR, TEXT),
                Pair(CityForecastTable.COUNTYR, TEXT))
        db?.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.NAME to TEXT,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.HIGH to TEXT,
                DayForecastTable.LOW to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CityForecastTable.NAME, true)
        db?.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }


}
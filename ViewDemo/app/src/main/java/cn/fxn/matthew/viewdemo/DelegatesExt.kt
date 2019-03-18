package cn.fxn.matthew.viewdemo

import kotlin.properties.ReadWriteProperty

/**
 * @author:Matthew
 * @date:2018/7/25
 * @email:guocheng0816@163.com
 * @func:
 */
object DelegatesExt {

    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

}
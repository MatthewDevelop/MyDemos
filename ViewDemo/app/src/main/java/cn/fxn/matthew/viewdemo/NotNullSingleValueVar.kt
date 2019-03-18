package cn.fxn.matthew.viewdemo

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author:Matthew
 * @date:2018/7/25
 * @email:guocheng0816@163.com
 * @func:自定义委托,被委托对象只能被初始化一次
 */
class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not init")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException("already init")
    }

}
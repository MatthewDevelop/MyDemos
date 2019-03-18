package cn.fxn.matthew.viewdemo

/**
 * @author:Matthew
 * @date:2018/7/24
 * @email:guocheng0816@163.com
 * @func:
 */
public interface Command<T>{
    fun execute():T
}
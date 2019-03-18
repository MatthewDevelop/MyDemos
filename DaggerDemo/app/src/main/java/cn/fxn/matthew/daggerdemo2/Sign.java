package cn.fxn.matthew.daggerdemo2;

import javax.inject.Qualifier;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/21 13:51
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Qualifier
public @interface Sign {
    String value() default "";
}

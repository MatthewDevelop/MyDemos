package cn.fxn.matthew.daggerdemo2;

import dagger.Component;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 10:12
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Component(modules = FatherModule.class)
public interface FatherComponent {
    Father offerFather();
}

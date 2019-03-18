package cn.fxn.matthew.daggerdemo2;

import dagger.Component;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 10:14
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Component(modules = ChildModule.class, dependencies = FatherComponent.class)
public interface ChildComponent {
    void inject(MainActivity activity);
}

package cn.fxn.matthew.daggerdemo3;

import dagger.Component;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 11:09
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Component(modules = FatherModule.class)
public interface FatherComponent {
//    ChildComponent.Builder buildChildComponent();
    ChildComponent buildChildComponent();
}

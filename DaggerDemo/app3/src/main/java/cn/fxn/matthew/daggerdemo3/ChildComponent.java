package cn.fxn.matthew.daggerdemo3;

import dagger.Subcomponent;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 11:09
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Subcomponent(modules = ChildModule.class)
public interface ChildComponent {
    void inject(MainActivity activity);

//    @Subcomponent.Builder
//    interface Builder {
//        ChildComponent build();
//        如果ChildModule构造方法有参数则需要这样
//        Builder createChildModule(ChildModule childModule);
//    }
}

package cn.fxn.matthew.daggerdemo2;

import dagger.Component;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/21 10:52
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@SignLocal
@Component(modules = ParkingModule.class)
public interface ParkingComponent {
    void inject(MainActivity activity);
}

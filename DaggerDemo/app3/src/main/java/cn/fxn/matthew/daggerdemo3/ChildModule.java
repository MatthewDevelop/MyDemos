package cn.fxn.matthew.daggerdemo3;

import dagger.Module;
import dagger.Provides;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 11:10
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Module
public class ChildModule {

    @Provides
    public Child provideChild(Father father) {
        return new Child(father);
    }

}

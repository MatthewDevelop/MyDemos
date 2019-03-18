package cn.fxn.matthew.daggerdemo2;

import dagger.Module;
import dagger.Provides;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 10:15
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Module
public class ChildModule {

    @Provides
    public Child provideChild(Father father){
        return new Child(father);
    }
}

package cn.fxn.matthew.daggerdemo3;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 11:08
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
//subcomponents这个不写好像也没有问题
//@Module(subcomponents = ChildComponent.class)
@Module
public class FatherModule {
    private static final String TAG = "FatherModule";
    @Provides
    Father provideFather() {
        Log.e(TAG, "provideFather: " );
        return new Father();
    }
}

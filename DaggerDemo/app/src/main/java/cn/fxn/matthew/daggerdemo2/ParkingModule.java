package cn.fxn.matthew.daggerdemo2;

import dagger.Module;
import dagger.Provides;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/21 11:05
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@Module
public class ParkingModule {

//    String driver;

//    public ParkingModule(String driver) {
//        this.driver = driver;
//    }

    public ParkingModule() {
    }

    @Provides
    public String provideDriver() {
        return "老王";
    }

    /*@Sign("noDriver")
    @Provides
    public Bus provideBus() {
        return new Bus();
    }

    @SignLocal
    @Sign("hasDriver")
    @Provides
    public Bus busHasDriver(@Sign("lw") String driver) {
        return new Bus(driver);
    }

    @Sign("lw")
    @Provides
    public String provideDriverName() {
        return "老王";
    }*/
}

package cn.fxn.matthew.daggerdemo2;

import javax.inject.Inject;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/21 10:51
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
@SignLocal
public class Bus {

    String driver;


//    @Sign("hasDriver")
    @Inject
    public Bus(String driver) {
        this.driver = driver;
    }

//    @Sign("noDriver")
//    @Inject
    public Bus() {
    }

//    @Override
//    public String toString() {
//        return "Bus{" +
//                "driver='" + driver + '\'' +
//                '}';
//    }
}

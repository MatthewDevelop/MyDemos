package cn.fxn.matthew.daggerdemo3;

import android.util.Log;

/**
 * Author:Matthew
 * <p>
 * Date:2018/11/22 10:13
 * <p>
 * Email:guocheng0816@163.com
 * <p>
 * Desc:
 */
public class Child {
    private static final String TAG = "Child";
    public Child(Father father) {
        Log.e(TAG, "Child: "+(father==null) );
    }
}

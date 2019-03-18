package com.foxconn.matthew.jstoandroiddemo;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * 权限相关的工具类
 *
 * @author:Matthew
 * @date:2018/2/9
 * @email:guocheng0816@163.com
 */

public class PermissionUtil {
    Context mContext;
    static PermissionUtil mPermissionUtil;

    /**
     * 获取工具类对象
     *
     * @param context
     * @return
     */
    public static PermissionUtil getInstance(Context context) {
        if (mPermissionUtil == null) {
            mPermissionUtil = new PermissionUtil(context);
        }
        return mPermissionUtil;
    }

    /**
     * 构造方法
     *
     * @param context
     */
    private PermissionUtil(Context context) {
        mContext = context;
    }

    /**
     * 判断权限集合
     *
     * @param permissions
     * @return
     */
    public boolean lacksPermissions(String... permissions) {
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断缺少的某种权限
     *
     * @param permission
     * @return
     */
    private boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED;
    }

    private void requestPermission(Activity activity, int resquestCode, String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, resquestCode);
    }

    private void requestPermission(Activity activity, int resquestCode, String... permissions) {
        ActivityCompat.requestPermissions(activity, permissions, resquestCode);
    }

}

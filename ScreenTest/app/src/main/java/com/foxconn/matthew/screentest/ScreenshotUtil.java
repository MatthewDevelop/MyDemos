package com.foxconn.matthew.screentest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.security.auth.login.LoginException;

/**
 * @author:Matthew
 * @date:2018/2/2
 * @email:guocheng0816@163.com
 */

public class ScreenshotUtil {
    private static final String TAG = "ScreenshotUtil";

    /**
     * 进行截取屏幕
     *
     * @param pActivity
     * @return bitmap
     */
    public static Bitmap takeScreenShot(Activity pActivity) {
        Bitmap bitmap = null;
        View view = pActivity.getWindow().getDecorView();
        // 设置是否可以进行绘图缓存
        view.setDrawingCacheEnabled(true);
        // 如果绘图缓存无法，强制构建绘图缓存
        view.buildDrawingCache();
        // 返回这个缓存视图
        bitmap = view.getDrawingCache();

        // 获取状态栏高度
        Rect frame = new Rect();
        // 测量屏幕宽和高
        view.getWindowVisibleDisplayFrame(frame);
        int stautsHeight = frame.top;
        Log.d("jiangqq", "状态栏的高度为:" + stautsHeight);

        int width = pActivity.getWindowManager().getDefaultDisplay().getWidth();
        int height = pActivity.getWindowManager().getDefaultDisplay().getHeight();
        // 根据坐标点和需要的宽和高创建bitmap
        bitmap = Bitmap.createBitmap(bitmap, 0, stautsHeight, width, height - stautsHeight);
        return bitmap;
    }

    /**
     * 获取整个窗口的截图
     *
     * @param context
     * @return
     */
    @SuppressLint("NewApi")
    private static boolean captureScreen(Activity context,String path) {
        View cv = context.getWindow().getDecorView();

        cv.setDrawingCacheEnabled(true);
        cv.buildDrawingCache();
        Bitmap bmp = cv.getDrawingCache();
        //cv.destroyDrawingCache();
        if (bmp == null) {
            Log.e(TAG, "captureScreen: ");
            return false;
        }

        bmp.setHasAlpha(false);
        bmp.prepareToDraw();
        boolean isSuccess=savePic(bmp,path);
        cv.destroyDrawingCache();
        return isSuccess;
    }

    /**
     * 保存图片到sdcard中
     *
     * @param pBitmap
     */
    private static boolean savePic(Bitmap pBitmap, String strName) {
        Log.e(TAG, "savePic: " + (pBitmap == null));
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strName);
            Log.e(TAG, "savePic: "+(fos==null) );
            if (null != fos) {
                pBitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
                Log.e(TAG, "savePic: compress finish" );
                fos.flush();
                Log.e(TAG, "savePic: flush finish" );
                fos.close();
                Log.e(TAG, "savePic: close finish" );
                return true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void screenCap() {
        try {
            Process sh = Runtime.getRuntime().exec("screencap -p /sdcard/screen.png");
//            OutputStream os = sh.getOutputStream();
            //os.write("/system/bin/screencap -p /sdcard/screen.png".getBytes());
//            os.flush();
//            os.close();
            sh.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 截图
     *
     * @param pActivity
     * @return 截图并且保存sdcard成功返回true，否则返回false
     */
    public static boolean shotBitmap(Activity pActivity) {

        return captureScreen(pActivity, "sdcard/" + System.currentTimeMillis() + ".png");
    }
}

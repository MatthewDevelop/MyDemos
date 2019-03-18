package com.foxconn.matthew.screentest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*File file=new File("/sdcard");
		if(file.isDirectory()){
			File[] files=file.listFiles();
			for (File fileItem :files
					) {
				if(fileItem.isFile()&&fileItem.getName().endsWith(".png")){
					fileItem.delete();
				}
			}
		}*/
    }

    public void onClick(View view) {
        //boolean isSuccess=ScreenshotUtil.shotBitmap(this);
        //Log.e(TAG, "onClick: "+isSuccess );
        ScreenshotUtil.screenCap();
    }
}

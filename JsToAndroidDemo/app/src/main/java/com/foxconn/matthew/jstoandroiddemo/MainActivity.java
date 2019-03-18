package com.foxconn.matthew.jstoandroiddemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;
    private String fileFullName;
    private boolean fromTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.web);
        mWebView.loadUrl("file:/sdcard/JsToAndroid.html");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JsToAndroid(), "hello");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop()");
    }

    /**
     * Android调用JS
     *
     * @param view
     */
    public void loadTrue(View view) {
        mWebView.loadUrl("javascript:android(true)");
    }

    public void loadFalse(View view) {
        mWebView.loadUrl("javascript:android(false)");
    }

    /*
     * 调用摄像头的方法
     */
    public void takePhoto(String filename) {
        System.out.println("----start to take photo2 ----");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_MEDIA_TITLE, "TakePhoto");
//判断是否有SD卡
        String sdDir = null;
        boolean isSDcardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (isSDcardExist) {
            sdDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            sdDir = Environment.getRootDirectory().getAbsolutePath();
        }
//确定相片保存路径
        String targetDir = sdDir + "/" + "webview_camera";
        File file = new File(targetDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        fileFullName = targetDir + "/" + filename;
        System.out.println("----taking photo fileFullName: " + fileFullName);
//初始化并调用摄像头
        intent.putExtra(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(fileFullName)));
        startActivityForResult(intent, 1);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     * 重写些方法，判断是否从摄像Activity返回的webview activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("----requestCode: " + requestCode + "; resultCode " + resultCode + "; fileFullName: " + fileFullName);
        if (fromTakePhoto && requestCode == 1 && resultCode == -1) {
            mWebView.loadUrl("javascript:wave2('" + fileFullName + "')");
        } else {
            mWebView.loadUrl("javascript:wave2('Please take your photo')");
        }
        fromTakePhoto = false;
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * JS调用Android
     */
    class JsToAndroid {
        @JavascriptInterface
        public void showAndroid() {
            Toast.makeText(MainActivity.this, "js调用了android的方法", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void camera() {
            fromTakePhoto = true;
            //调用 启用摄像头的自定义方法
            takePhoto("testimg" + Math.random() * 1000 + 1 + ".jpg");
            System.out.println("========fileFullName: " + fileFullName);
        }
    }
}

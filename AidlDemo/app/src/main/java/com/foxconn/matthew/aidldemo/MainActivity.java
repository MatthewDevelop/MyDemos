package com.foxconn.matthew.aidldemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";

    private BookManager mBookManager = null;

    private boolean isBond = false;

    private List<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!isBond) {
            attemptToBond();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isBond) {
            unbindService(mConnection);
            isBond = false;
        }
    }


    public void addBook(View view) {
        if (!isBond) {
            attemptToBond();
            Toast.makeText(this, "尚未连接，正在尝试连接", Toast.LENGTH_SHORT).show();
        }
        if (mBookManager == null) {
            return;
        }
        Book book = new Book();
        book.setName("第一行代码");
        book.setPrice(99);
        try {
            mBookManager.addBook(book);
            Log.e(TAG, "onClick: " + book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addBookIn(View view) {
        if (!isBond) {
            attemptToBond();
            Toast.makeText(this, "尚未连接，正在尝试连接", Toast.LENGTH_SHORT).show();
        }
        if (mBookManager == null) {
            return;
        }
        Book book = new Book();
        book.setName("第一行代码   in");
        book.setPrice(99);
        try {
            Book retrunBook=mBookManager.addBookIn(book);
//            Log.e(TAG, "onClick: " + retrunBook.toString());
            Log.e(TAG, "onClick: " + book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addBookOut(View view) {
        if (!isBond) {
            attemptToBond();
            Toast.makeText(this, "尚未连接，正在尝试连接", Toast.LENGTH_SHORT).show();
        }
        if (mBookManager == null) {
            return;
        }
        Book book = new Book();
        book.setName("第一行代码   out");
        book.setPrice(99);
        try {
            Book retrunBook=mBookManager.addBookOut(book);
//            Log.e(TAG, "onClick: " + retrunBook.toString());
            Log.e(TAG, "onClick: " + book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void addBookInOut(View view) {
        if (!isBond) {
            attemptToBond();
            Toast.makeText(this, "尚未连接，正在尝试连接", Toast.LENGTH_SHORT).show();
        }
        if (mBookManager == null) {
            return;
        }
        Book book = new Book();
        book.setName("第一行代码   in out");
        book.setPrice(99);
        try {
            Book retrunBook=mBookManager.addBookInout(book);
//            Log.e(TAG, "onClick: " + retrunBook.toString());
            Log.e(TAG, "onClick: " + book.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void attemptToBond() {
        Intent intent = new Intent();
        intent.setAction("com.foxconn.matthew.aidldemoserver");
        intent.setPackage("com.foxconn.matthew.aidldemoserver");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceConnected: ");
            mBookManager = BookManager.Stub.asInterface(service);
            isBond = true;
            if (mBookManager != null) {
                try {
                    mBookList = mBookManager.getbooks();
                    Log.e(TAG, "onServiceConnected: " + mBookList.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected: ");
            isBond = false;
        }
    };


}

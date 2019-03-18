package com.foxconn.matthew.aidldemoserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.foxconn.matthew.aidldemo.Book;
import com.foxconn.matthew.aidldemo.BookManager;

import java.util.ArrayList;
import java.util.List;

public class AIDLService extends Service {

    private static final String TAG = "AIDLService";

    private List<Book> mBookList = new ArrayList<>();

    /**
     * aidl生成的bookManager
     */
    private BookManager.Stub mBookManager = new BookManager.Stub() {
        @Override
        public List<Book> getbooks() throws RemoteException {
            synchronized (this) {
                if (mBookList != null) {
                    return mBookList;
                }
            }
            return new ArrayList<>();
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (mBookList == null) {
                    mBookList = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in In");
                    book = new Book();
                }
                //尝试修改book的参数，主要是为了观察其到客户端的反馈
                book.setPrice(2333);
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBookList.toString());
            }
        }

        @Override
        public Book addBookIn(Book book) throws RemoteException {
            synchronized (this) {
                if (mBookList == null) {
                    mBookList = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in In");
                    book = new Book();
                }
                //尝试修改book的参数，主要是为了观察其到客户端的反馈
                book.setPrice(2333);
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBookList.toString());
                return book;
            }
        }

        @Override
        public Book addBookOut(Book book) throws RemoteException {
            synchronized (this) {
                if (mBookList == null) {
                    mBookList = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in In");
                    book = new Book();
                }
                //尝试修改book的参数，主要是为了观察其到客户端的反馈
                book.setPrice(2333);
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBookList.toString());
                return book;
            }
        }

        @Override
        public Book addBookInout(Book book) throws RemoteException {
            synchronized (this) {
                if (mBookList == null) {
                    mBookList = new ArrayList<>();
                }
                if (book == null) {
                    Log.e(TAG, "Book is null in In");
                    book = new Book();
                }
                //尝试修改book的参数，主要是为了观察其到客户端的反馈
                book.setPrice(2333);
                if (!mBookList.contains(book)) {
                    mBookList.add(book);
                }
                //打印mBooks列表，观察客户端传过来的值
                Log.e(TAG, "invoking addBooks() method , now the list is : " + mBookList.toString());
                return book;
            }
        }


    };

    public AIDLService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Book book=new Book();
        book.setName("JAVA编程思想");
        book.setPrice(99);
        mBookList.add(book);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e(TAG, "onBind: "+intent.toString() );
        return mBookManager;
    }
}

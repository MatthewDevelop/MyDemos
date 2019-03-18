package com.foxconn.matthew.keyboarddemo;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * @author:Matthew
 * @date:2018/4/9
 * @email:guocheng0816@163.com
 */
public class KeyboardUtil {
    private static final String TAG = "KeyboardUtil";
    //键值
    private static final int SYMBOL_CODE = -7;//符号键盘
    private static final int ELLIPSES_CODE = -8;//省略号
    private static final int CHINESE_HORIZONTAL_LINE_CODE = -9;//中文横线
    private static final int SMILING_FACE_CODE = -10;//笑脸
    private static final int LEFT_CODE = -11;//中文横线
    private static final int RIGHT_CODE = -12;//中文横线
    private static final int HEE_CODE = -13;//哈哈
    private static final int AWKWARD_CODE = -14;//尴尬
    private static KeyboardUtil mInstance;
    private static boolean isShow = false;
    //键盘状态
    private static boolean isNumber = false;
    private static boolean isLetter = false;
    private static boolean isSymbol = false;
    private static boolean isUpper;
    private KeyboardView mKeyboardView;
    //键盘布局
    private Keyboard mKeyboardNumber;
    private Keyboard mKeyboardLetter;
    private Keyboard mKeyboardSymbol;
    private ViewGroup mRootView;
    private EditText mEditText;
    private KeyboardView.OnKeyboardActionListener listener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void onPress(int primaryCode) {

        }

        @Override
        public void onRelease(int primaryCode) {

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = mEditText.getText();
            int start = mEditText.getSelectionStart();
            switch (primaryCode) {
                case Keyboard.KEYCODE_CANCEL:
                    hideKeyBoard();
                    break;
                case Keyboard.KEYCODE_DELETE:
                    if (editable != null && editable.length() > 0) {
                        if (start > 0) {
                            editable.delete(start - 1, start);
                        }
                    }
                    break;
                case Keyboard.KEYCODE_SHIFT:
                    isUpper = !isUpper;
                    mKeyboardLetter.setShifted(isUpper);
                    mKeyboardView.invalidateAllKeys();
                    break;
                case SYMBOL_CODE:
                    if (isSymbol) {
                        isSymbol = false;
                        mKeyboardView.setKeyboard(mKeyboardNumber);
                    } else {
                        isSymbol = true;
                        mKeyboardView.setKeyboard(mKeyboardSymbol);
                    }
                    break;
                case Keyboard.KEYCODE_MODE_CHANGE:
                    if (isNumber) {
                        isNumber = false;
                        mKeyboardView.setKeyboard(mKeyboardLetter);
                    } else {
                        isNumber = true;
                        mKeyboardView.setKeyboard(mKeyboardNumber);
                    }
                    break;
                case LEFT_CODE:
                    if (start > 0) {
                        mEditText.setSelection(start - 1);
                    }
                    break;
                case RIGHT_CODE:
                    if (start < mEditText.length()) {
                        mEditText.setSelection(start + 1);
                    }
                    break;
                case ELLIPSES_CODE:
                    editable.insert(start, "...");
                    break;
                case CHINESE_HORIZONTAL_LINE_CODE:
                    editable.insert(start, "-");
                    break;
                case SMILING_FACE_CODE:
                    editable.insert(start, "^_^");
                    break;
                case HEE_CODE:
                    editable.insert(start, "^o^");
                    break;
                case AWKWARD_CODE:
                    editable.insert(start, ">_<");
                    break;
                default:
                    String str = Character.toString((char) primaryCode);
                    if (isWord(str)) {
                        if (isUpper) {
                            str = str.toUpperCase();
                        } else {
                            str = str.toLowerCase();
                        }
                    }
                    editable.insert(start, str);
                    break;
            }
        }

        @Override
        public void onText(CharSequence text) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }
    };

    private KeyboardUtil(Activity activity, EditText editText) {
        this.mEditText = editText;
        mKeyboardNumber = new Keyboard(activity, R.xml.number);
        mKeyboardLetter = new Keyboard(activity, R.xml.letter);
        mKeyboardSymbol = new Keyboard(activity, R.xml.symbol);

        mKeyboardView = new KeyboardView(activity, null);

        mKeyboardView.setKeyboard(mKeyboardLetter);
        mKeyboardView.setEnabled(true);
        mKeyboardView.setPreviewEnabled(false);
        mKeyboardView.setOnKeyboardActionListener(listener);

        mRootView = (ViewGroup) ((ViewGroup) (activity.findViewById(android.R.id.content))).getChildAt(0);
    }

    public static KeyboardUtil getInstance(Activity activity, EditText editText) {
        if (mInstance == null) {
            mInstance = new KeyboardUtil(activity, editText);
        }
        mInstance.mEditText = editText;
        return mInstance;
    }

    private void hideKeyBoard() {
        if (mRootView != null && mKeyboardView != null && isShow) {
            isShow = false;
            mRootView.removeView(mKeyboardView);
        }
        mInstance = null;
    }

    public void showKeyBoard() {
        Log.e(TAG, "showKeyBoard: " + isShow);
        if (!isShow) {
            Log.e(TAG, "showKeyBoard: ----->inner");
            RelativeLayout.LayoutParams layoutParams =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT
                            , RelativeLayout.LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
            mRootView.addView(mKeyboardView, layoutParams);
            isShow = true;
        }
    }

    private boolean isWord(String str) {
        return str.matches("[a-zA-Z]");
    }
}

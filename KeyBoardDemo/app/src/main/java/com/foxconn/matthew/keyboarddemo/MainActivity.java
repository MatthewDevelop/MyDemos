package com.foxconn.matthew.keyboarddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

/**
 * @author Matthew
 */
public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText=findViewById(R.id.editText);
        mEditText.setInputType(InputType.TYPE_NULL);
        mEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KeyboardUtil.getInstance(MainActivity.this,mEditText).showKeyBoard();
            }
        });
    }
}
